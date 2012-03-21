(ns guchitter.views.guchi
  (:use [hiccup.core :only [html h]]
        [hiccup.page-helpers :only [doctype]]
        [hiccup.form-helpers :only [form-to label text-area submit-button]])
  (:require [guchitter.views.layout :as layout]))

(defn guchi-form []
  [:div {:id "guchi-form" :class "hero-unit"}
   [:form {:method "POST" :action "/"}
    (label "guchi" "愚痴ってもいいんだよ？")
    [:textarea {:name "guchi" :id "guchi" :class "span8" :rows "4"}]
    [:input {:class "btn btn-primary btn-large btn-guchiru" :type "submit" :value "ぐちる"}]]])

(defn display-guchi [guchis]
  [:div {:id "guchi"}
   (map
     (fn [guchi] [:h2 {:class "guchi-unit"} (h (:body guchi))])
     guchis)])

(defn index [guchi]
  (layout/common-content "ぐちってー"
                         (guchi-form)
                         (display-guchi guchi)))
