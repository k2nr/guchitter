(ns guchitter.controllers.guchi
  (:use [compojure.core :only [defroutes GET POST]])
  (:require [clojure.string :as string]
            [ring.util.response :as ring]
            [guchitter.views.guchi :as view]
            [guchitter.models.guchi :as model]))

(defn index []
  (view/index (model/get-all)))

(defn create [params]
  (let [guchi (:guchi params)]
    (when-not (string/blank? guchi)
      (model/create guchi)))
  (ring/redirect "/"))

(defroutes routes
  (GET "/" [] (index))
  (POST "/" {params :params} (create params)))

