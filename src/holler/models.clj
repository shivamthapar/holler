(ns holler.models
  (:use korma.db
        korma.core))

(defdb hollerdb
  (postgres {:classname "org.postgresql.Driver"
   :subprotocol "postgresql"
   :subname "//localhost:5432/hollerdb"
   :user "holler"
   :password "holler_pw"
  }))

(defentity hollers)

(defn all
  []
  (select hollers))
