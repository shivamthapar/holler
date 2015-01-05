(defproject holler "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :plugins [[lein-ring "0.8.13"]]
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.3.1"]
                 [twilio-api "1.0.0"]
                 [de.ubercode.clostache/clostache "1.3.1"]
                 [postgresql "9.1-901.jdbc4"]
                 [org.clojure/java.jdbc "0.2.3"]
                 [lobos "1.0.0-beta1"]
                 [korma "0.3.0-RC5"]
                 [ring "1.3.2"]
                 [ring/ring-defaults "0.1.3"]]
  :dev-dependencies [[ring/ring-devel "0.3.7"]]
  :ring {:handler holler.core/application}
  :main ^:skip-aot holler.core
  :uberjar-name "holler-standalone.jar"
  :profiles {:uberjar {:aot :all}})
