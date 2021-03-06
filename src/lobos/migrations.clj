(comment "This file defines migrations for the Holler database. 
         To Run the migrations open the REPL and run:
         (use 'lobos.core 'lobos.connectivity 'lobos.migration 'lobos.migrations)
         (open-global hollerdb)
         (migrate)
         ")
(ns lobos.migrations
  ;; exclude some clojure built-in symbols so we can use the lobos' symbols
  (:refer-clojure :exclude [alter drop
                            bigint boolean char double float time])
  (:import (java.io FileReader File) (java.net URI))
  ;; use only defmigration macro from lobos
  (:use (lobos [migration :only [defmigration]]
          core
          schema))
  
  (:require [clojure.string :as str]))

;;; Defines the database for lobos migrations

;;;http://pupeno.com/2011/08/20/how-to-use-lobos-with-heroku/
(defn heroku-db
  "Generate the db map according to Heroku environment when available."
  []
  (when (System/getenv "DATABASE_URL")
    (let [url (URI. (System/getenv "DATABASE_URL"))
          host (.getHost url)
          port (if (pos? (.getPort url)) (.getPort url) 5432)
          path (.getPath url)]
      (merge
       {:subname (str "//" host ":" port path)}
       (when-let [user-info (.getUserInfo url)]
         {:user (first (str/split user-info #":"))
          :password (second (str/split user-info #":"))})))))
 
(def hollerdb
  (merge 
    {:classname "org.postgresql.Driver"
     :subprotocol "postgresql"
     :subname "//localhost:5432/hollerdb"
    } (heroku-db)))

(defmigration add-hollers-table
  (up [] (create hollerdb
            (table :hollers (integer :id :primary-key)
              (varchar :content 160)
              (timestamp :created (default (now))))))

  (down [] (drop (table :hollers))))
