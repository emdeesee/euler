(ns euler.problem-012
  (:require [euler.util :refer [prime-factorization triangular-seq]]))

(defn number-of-divisors [n]
  (->> n
       prime-factorization
       frequencies
       vals
       (map inc)
       (reduce *)))

(defn solution
  []
  (first (drop-while #(< (number-of-divisors %) 500) triangular-seq)))
