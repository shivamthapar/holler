(ns holler.models
  (:require [lobos.migrations :as lobos])
  (:use korma.db
        korma.core))

(defdb hollerdb (postgres lobos/hollerdb))

(defentity hollers)

(defn all
  []
  (select hollers))

(defn create
  [holler]
  (let [id (count (select hollers))]
    (insert hollers (values {:id id, :content (:content holler)})))) 
