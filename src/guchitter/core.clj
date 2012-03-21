(ns guchitter.core
  (:use
    [compojure.core :only [defroutes]]
    [compojure.route :only  [not-found files resources]]
    [ring.adapter.jetty :only [run-jetty]]
    [ring.middleware.reload]
    )
  (require [compojure.handler :as handler]
           [guchitter.views.layout :as layout]
           [guchitter.controllers.guchi :as controller]))

(defroutes main-routes
  controller/routes
  (files "/")
  (resources "/")
  (not-found (layout/not-found))) ;not-foundを通すと文字化けする

(defn start [port app]
  (run-jetty app {:port port :join? false}))

(def application (handler/site main-routes))

(defn -main []
  (let [port (Integer/parseInt (System/getenv "PORT"))]
    (start port application)))

(defn -dev-main []
  (let [dev-app (-> application
                  (wrap-reload '[guchitter.core
                                 guchitter.views
                                 guchitter.models
                                 guchitter.controllers]))
        port 8080]
    (start port dev-app)))

