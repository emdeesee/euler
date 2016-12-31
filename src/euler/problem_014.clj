(ns euler.problem-014)

(defn collatz-next [n]
  (if (even? n) (/ n 2) (inc (* 3 n))))

(def memo (atom {}))

(defn collatz-len [n]
  (letfn [(result [len chain]
            (apply swap! memo assoc (interleave chain (range len 0 -1)))
            len)]
    (loop [m n len 0 chain []]
      (if-let [e (find @memo m)]
        (result (+ len (val e)) (conj chain m))
        (if (= m 1)
          (result (inc len) chain)
          (recur (collatz-next m) (inc len) (conj chain m)))))))

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
