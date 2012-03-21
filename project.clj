(defproject guchitter "1.0.0-SNAPSHOT"
  :description "guchitter World App"
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [org.clojure/clojure-contrib "1.2.0"]
                 [postgresql "9.1-901.jdbc4"]
                 [org.clojure/java.jdbc "0.1.1"]
                 [compojure "1.0.1"]
                 [hiccup "0.3.8"]
                 [ring/ring-jetty-adapter "1.1.0-SNAPSHOT"]
                 [ring/ring-devel "1.1.0-SNAPSHOT"]
                ]
  :main guchitter.core)
