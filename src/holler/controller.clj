(ns holler.controller
  (:use korma.core [clojure.algo.generic.functor :only (fmap)])
  (:require [compojure.core :refer [defroutes GET POST]]
           [clojure.string :as str]
           [ring.util.response :as ring]
           [ring.middleware.params :only [wrap-params]]
           [holler.views :as view]
           [holler.models :as model]
           [clojure.data.json :as json]
           [twilio.core :as twilio]))

(defn index []
  (view/index (model/all)))

(defn sms-handler [req]
  (model/create {:content (:Body (:params req))}))

(defn get-hollers [] 
  (let [hollers (model/all)]
    (json/write-str {:hollers (map (fn [x] (fmap str x)) hollers)})))

(defroutes routes
  (GET "/" [] (index))
  (GET "/hollers" [] (get-hollers))
  (POST "/post" request (sms-handler request)))
