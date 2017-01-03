(ns euler.problem-005
  (:require [euler.util :refer [lcm]]))

(defn solution
  []
  (apply lcm (range 1 21)))
