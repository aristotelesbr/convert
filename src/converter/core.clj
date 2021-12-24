(ns converter.core
  (:require [clojure.tools.cli :refer [parse-opts]])
  (:gen-class))

(def options
  [["-f" "--from currency base" "currency base to converter" :default "eur"]
   ["-t" "--to destination currency" "currency we want to know the value"]])

(defn -main
  "app bootstrap!"
  [& args]
  (println "we have" (count args) "args")
  (println "They are: " (:options
                         (parse-opts args options))))
