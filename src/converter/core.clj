(ns converter.core
  (:require [clojure.tools.cli :refer [parse-opts]]
            [cheshire.core :refer [parse-string]]
            [clj-http.client :as http-client]
            [dotenv :refer [env]])
  (:gen-class))

(def options
  [["-f" "--from currency base" "currency base to converter" :default "eur"]
   ["-t" "--to destination currency" "currency we want to know the value"]])

(def api-secret-key  (env :API_KEY))

(def api-url
  "https://free.currencyconverterapi.com/api/v6/convert")

(defn parameterize-currency
  "Given two args, A and B parameterize must be return 'A_B' data"
  [from to]
  (str from "_" to))

(defn get-quote [from to]
           (let [currency (parameterize-currency from to)]
             (-> (:body (http-client/get api-url
                                         {:query-params {"q" currency "apiKey" api-secret-key}}))
                 (parse-string)
                 (get-in ["results" currency "val"]))))

(defn- format-output [quote from to]
  (str "1 " from " equals to " quote " in " to))

(defn -main
  "app bootstrap!"
  [& args]
  (let [{:keys [from to]} (:options
                           (parse-opts args options))]
    (-> (get-quote from to)
        (format-output from to)
        (prn))))