(ns euler.problem-012
  (:require [euler.util :as util]))

;; This way we don't have to recalculate the prime sequence for each
;; triangular number.
(def primes (util/gen-primes))

(defn number-of-divisors [n]
  (->> n
       (#(util/prime-factorization % primes))
       frequencies
       vals
       (map inc)
       (reduce *)))

(defn solution
  []
  (first (drop-while #(< (number-of-divisors %) 500) util/triangular-seq)))
