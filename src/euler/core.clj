(ns euler.core
  (:gen-class))

(set! *warn-on-reflection* true)

(defn run-solver [which]
  (let [number (.format (new java.text.DecimalFormat "000") (Integer/parseInt which))
        fn (symbol "solution")]
    (require (vector (symbol (str "euler.problem-" number))
                     :refer (vector fn)))
    (eval (list fn))))

(defn usage []
  (println "Usage: lein run [number]"))

(defn -main
  "Run solver"
  [& args]
  (if (and args (= 1 (count args)))
    (println (time (run-solver (first args))))
    (usage)))
