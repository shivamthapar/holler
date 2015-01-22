(ns holler.controller
  (:use korma.core)
  (:require [compojure.core :refer [defroutes GET POST]]
           [clojure.string :as str]
           [ring.util.response :as ring]
           [ring.middleware.params :only [wrap-params]]
           [holler.views :as view]
           [holler.models :as model]))

(defn index []
  (view/index (model/all)))

(defn sms-handler []
  ())

(defroutes routes
  (GET "/" [] (index))
  (POST "/post" request (str request)))
