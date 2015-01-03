(ns holler.controller
  (:require [compojure.core :refer [defroutes GET POST]]
           [clojure.string :as str]
           [ring.util.response :as ring]
           [holler.views :as view]
           [holler.models :as model]))

(defn index []
  (view/index))

(defroutes routes
  (GET "/" [] (index)))
