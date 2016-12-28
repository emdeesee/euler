(ns euler.problem-004)

(defn pal? [n]
  (let [s (str n)]
    (= s (apply str (reverse s)))))

(defn solution []
  (apply max
         (for [x (range 999 99 -1) y (range 999 99 -1)
               :when (pal? (* x y))] (* x y))))
