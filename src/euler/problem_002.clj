(ns euler.problem-002
  (:require [euler.util :refer [fib-seq]]))

(defn solution
  []
  (reduce + (filter #(zero? (rem % 2)) (take-while #(< % 4e6) fib-seq))))
