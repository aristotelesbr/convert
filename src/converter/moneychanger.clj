(ns converter.moneychanger
  (:require [clj-http.client :as http-client]
            [cheshire.core :refer [parse-string]]
            [dotenv :refer [env]]))

(def api-secret-key (env :API_KEY))

(def api-url
  "https://free.currencyconverterapi.com/api/v6/convert")

(defn- parameterize-currency
  "Given two args, A and B parameterize must be return 'A_B' data"
  [from to]
  (str from "_" to))

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn get-quote
  [from to]
  (let [currency (parameterize-currency from to)]
    (-> (:body (http-client/get api-url
                                {:query-params {"q" currency "apiKey" api-secret-key}}))
        (parse-string)
        (get-in ["results" currency "val"]))))