(ns holler.controller
  (:use korma.core)
  (:require [compojure.core :refer [defroutes GET POST]]
           [clojure.string :as str]
           [ring.util.response :as ring]
           [ring.middleware.params :only [wrap-params]]
           [holler.views :as view]
           [holler.models :as model]
           [twilio.core :as twilio]))

(defn index []
  (view/index (model/all)))

(defn sms-handler [req]
  (model/create {:content (:Body (:params req))}))

(defroutes routes
  (GET "/" [] (index))
  (POST "/post" request (sms-handler request)))
