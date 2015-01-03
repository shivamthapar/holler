(ns holler.controller
  (:use korma.core)
  (:require [compojure.core :refer [defroutes GET POST]]
           [clojure.string :as str]
           [ring.util.response :as ring]
           [holler.views :as view]
           [holler.models :as model]))

(defn index []
  (view/index (model/all)))

(defroutes routes
  (GET "/" [] (index)))
