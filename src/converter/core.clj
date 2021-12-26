(ns converter.core
  (:require [converter.result :refer [format-output]]
            [converter.menu-options :refer [get-options]]
            [converter.moneychanger :refer [get-quote]]))

(defn -main
  "app bootstrap!"
  [& args]
  (let [{:keys [from to]} (get-options args)]
    (-> (get-quote from to)
        (format-output from to)
        (prn))))