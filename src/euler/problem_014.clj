(ns euler.problem-014)

(defn collatz-next [n]
  (if (even? n) (/ n 2) (inc (* 3 n))))

(defn collatz-len [n]
  (loop [n n len 1]
    (if (= n 1) len
        (recur (collatz-next n) (inc len)))))

(defn solution []
  (first
   (reduce
    (fn [[_ len :as current] n]
      (let [len' (collatz-len n)]
        (if (> len' len)
          (vector n len')
          current)))
    (vector 0 0)
    (range 2 1000000))))
