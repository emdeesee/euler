(ns euler.util
  (:require [clojure.math.numeric-tower :as math]))

(def fib-seq
  (lazy-cat [1 1] (map + (rest fib-seq) fib-seq)))

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

(defn prime-factors
  "Find the prime factors of n"
  [n]
  (->> (gen-primes)
       (take-while #(<= % (math/sqrt n)))
       (filter #(zero? (rem n %)))))

(defn gcd
  [a b]
  (if (zero? b)
    a
    (recur b (rem a b))))

(defn lcm
  [a b]
  (/ (math/abs (* a b)) (gcd a b)))
