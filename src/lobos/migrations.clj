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
  ;; use only defmigration macro from lobos
  (:use (lobos [migration :only [defmigration]]
          core
          schema)))

;;; Defines the database for lobos migrations
(def hollerdb
  {:classname "org.postgresql.Driver"
   :subprotocol "postgresql"
   :subname "//localhost:5432/hollerdb"
  })

(defmigration add-hollers-table
  (up [] (create hollerdb
            (table :hollers (integer :id :primary-key)
              (varchar :content 160)
              (timestamp :created (default (now))))))

  (down [] (drop (table :hollers))))
