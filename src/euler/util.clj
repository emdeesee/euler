(ns euler.util
  (:require [clojure.math.numeric-tower :as math]))

(def fib-seq
  (lazy-cat [1 1] (map + (rest fib-seq) fib-seq)))

(def triangular-seq
  (lazy-cat [1] (map + triangular-seq (drop 2 (range)))))

(defn gen-primes
  "Generate an infinite, lazy sequence of prime numbers"
  []
  (letfn [(reinsert [table x prime]
            (update-in table [(+ prime x)] conj prime))
          (step [table d]
            (if-let [factors (get table d)]
              (recur (reduce #(reinsert %1 d %2) (dissoc table d) factors)
                     (inc d))
              (lazy-seq (cons d (step (assoc table (* d d) (list d))
                                      (inc d))))))]
    (step {} 2)))

(def primes-seq (gen-primes))

(defn prime-factorization
  "Find the prime factorization of n"
  ([n] (prime-factorization n primes-seq))
  ([n primes]
   (let [p (first primes)]
     (cond
       (> (* p p) n) (list n)
       (zero? (rem n p)) (cons p
                               (lazy-seq
                                (prime-factorization (/ n p) primes)))
       :else (recur n (next primes))))))

(defn prime-factors
  "Find the prime factors of n"
  [n]
  (into #{} (prime-factorization n)))

(defn gcd
  [a b & others]
  (cond
    (and (zero? b) (nil? others)) (math/abs a)
    (zero? b) (recur a (first others) (next others))
    :else (recur b (rem a b) others)))

(defn lcm
  [a b & others]
  (if (nil? others)
    (/ (math/abs (* a b)) (gcd a b))
    (recur (lcm a b) (first others) (next others))))
