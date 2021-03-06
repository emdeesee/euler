(ns euler.problem-009)

(defn solution
  []
  (for [a (range 1 500) b (range (inc a) (- 1000 a))
        :let [c? (- 1000 (+ a b))]
        :when (= (* c? c?) (+ (* a a) (* b b)))]
    (* a b c?)))
