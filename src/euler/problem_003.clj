(ns euler.problem-003
  (:require [euler.util :refer [prime-factors]]))

(defn solution
  []
  (apply max (prime-factors 600851475143)))
