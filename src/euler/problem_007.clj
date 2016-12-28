(ns euler.problem-007
  (:require [euler.util :refer [gen-primes]]))

(defn solution []
  (nth (gen-primes) 10000))
