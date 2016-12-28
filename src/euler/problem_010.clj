(ns euler.problem-010
  (:require [euler.util :refer [gen-primes]]))

(defn solution
  []
  (reduce + (take-while #(< % 2000000) (gen-primes))))

