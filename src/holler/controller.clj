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

(defn sms-handler []
  (twilio/with-auth "AC35f6287a66262b0d8d5497bce88b3121" "3b09a1f7e1effc8bb5ae547c7fb2a50c"
  (twilio/send-sms
    {:From "+6579997809"
     :To "+7149040147"
     :Body "Hello world"})))

(defroutes routes
  (GET "/" [] (index))
  (POST "/post" request (sms-handler)))
