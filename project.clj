(defproject holler "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.3.1"]
                 [de.ubercode.clostache/clostache "1.3.1"]
                 [postgresql "9.1-901.jdbc4"]
                 [org.clojure/java.jdbc "0.2.3"]
                 [lobos "1.0.0-beta1"]
                 [korma "0.3.0-RC5"]
                 [ring "1.3.2"]
                 [ring/ring-defaults "0.1.3"]]
  :main holler.core)
