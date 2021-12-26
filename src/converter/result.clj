(ns converter.result)

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn format-output
  [quote from to]
  (str "1 " from " equals to " quote " in " to))