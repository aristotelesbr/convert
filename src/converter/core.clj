(ns converter.core
  (:gen-class))

(defn- values-in [arg]
  (cond
    (.startsWith arg "--from=")
    {:from (.substring arg 7)}
    (.startsWith arg "--to")
    {:to (.substring arg 5)}
    :else {}))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "we have" (count args) "args")
  (println "They are: " (map values-in args)))
