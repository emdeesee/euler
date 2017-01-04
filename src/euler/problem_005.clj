(ns euler.problem-005
  (:require [clojure.math.numeric-tower :refer [lcm]]))

(defn solution
  []
  (reduce lcm (range 1 21)))
