(defproject euler "0.1.0-SNAPSHOT"
  :description "Solutions to Project Euler problems"
  :url ""
  :license {:name "BSD3"
            :url "http://opensource.org/licenses/BSD-3-Clause"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/math.numeric-tower "0.0.4"]]
  :main ^:skip-aot euler.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
