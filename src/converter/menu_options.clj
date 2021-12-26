(ns converter.menu-options
  (:require [clojure.tools.cli :refer [parse-opts]]))

(def options
  [["-f" "--from currency base" "currency base to converter" :default "eur"]
   ["-t" "--to destination currency" "currency we want to know the value"]])

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn get-options
  [args]
  (:options (parse-opts args options)))