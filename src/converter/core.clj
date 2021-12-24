(ns converter.core
  (:require [clojure.tools.cli :refer [parse-opts]]
            [clj-http.client :as http-client]
            [dotenv :refer [env]])
  (:gen-class))

(def api-secret-key  (env :API_KEY))

(def api-url
  "https://free.currencyconverterapi.com/api/v6/convert")

(defn parameterize-currency
  "Given two args, A and B must be parameterize to return A_B"
  [from to]
  (str from "_" to))

(def options
  [["-f" "--from currency base" "currency base to converter" :default "eur"]
   ["-t" "--to destination currency" "currency we want to know the value"]])

(defn -main
  "app bootstrap!"
  [& args]
  (let [{:keys [from to]} (:options
                           (parse-opts args options))]

    (prn "Quote: " (http-client/get api-url
                                    {:query-params {"q" (parameterize-currency from to)
                                                    "apiKey" api-secret-key}}))))