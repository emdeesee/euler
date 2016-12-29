(ns euler.problem-012
  (:require [euler.util :as util]))


(defn number-of-divisors [n]
  (->> n
       util/prime-factorization
       frequencies
       vals
       (map inc)
       (reduce *)))

(defn solution
  []
  (first (drop-while #(< (number-of-divisors %) 500) util/triangular-seq)))
