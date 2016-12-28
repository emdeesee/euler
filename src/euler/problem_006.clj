(ns euler.problem-006)

(defn solution []
  (letfn [(sq [x] (* x x))]
    (-
     (sq (reduce + (range 1 101)))
     (reduce #(+ % (sq %2)) 0 (range 1 101)))))
