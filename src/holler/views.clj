(ns holler.views
  (:require [clojure.string :as str]
            [clostache.parser :as clostache]))

(defn read-template [template-name]
  (slurp (clojure.java.io/resource (str "templates/" template-name ".mustache"))))

(defn render-template [template-file params]
  (clostache/render (read-template template-file) params))

(defn index [hollers]
  (render-template "index" {:content (count hollers)}))
