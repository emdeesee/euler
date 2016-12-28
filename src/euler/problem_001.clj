(ns euler.problem-001)

(defn multof? [n m]
  (zero? (rem m n)))

(defn solution
  []
  (reduce + (filter #(or (multof? 3 %) (multof? 5 %)) (range 1000))))
