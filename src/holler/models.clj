(ns holler.models
  (:use korma.db
        korma.core))

(def hollerdb
  {:classname "org.postgresql.Driver"
   :subprotocol "postgresql"
   :subname "//localhost:5432/hollerdb"
  })

(defentity hollers)
