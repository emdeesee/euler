(ns euler.problem-015
  (:require [euler.util :refer [bin-coeff]]))

;; Intuitive solution
(def f
  (memoize
   (fn [x y]
     (if (some zero? [x y]) 1
         (+ (f (dec x) y) (f x (dec y)))))))

;; Researched solution
(defn g [dim]
  (bin-coeff (* 2 dim) dim))

(defn solution []
  (let [dim 20]
    ;; (f dim dim)
    (g dim)
    ))
