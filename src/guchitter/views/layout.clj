(ns guchitter.views.layout
  (:use [hiccup.core :only [html]]
        [hiccup.page-helpers :only [doctype include-css]]))

(defn common-content [title & body]
  (html
    (doctype :html5)
    [:head
     [:meta {:charset "utf-8"}]
     [:title title]
     (include-css "/css/bootstrap.css")
     (include-css "/css/guchi.css")]
    [:body
     [:div {:class "container"}
      [:div {:id "header" :class "page-header"}
       [:h1 title]]
      [:div {:id "content"} body]]]))

(defn not-found []
  (common-content "404"
                  [:div {:id "not-found"}
                   "404 Page Not Found"]))
