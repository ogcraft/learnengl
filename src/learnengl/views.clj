(ns learnengl.views
  (:use [hiccup core page form])
  (:require
   [learnengl.utils :as utils]))

(defn header []
  [:div.navbar.navbar-inverse.navbar-fixed-top
   [:div.navbar-inner
    [:div.container
     [:a.brand {:href "/"} "Learn English"]
     [:div.nav-collapse.collapse
      [:ul.nav
       [:li.active [:a {:href "/"} "Home"]]
       [:li.active [:a {:href "/about"} "About"]]]]]]])

(defn template [& body]
  (html5
   [:head
    [:title "Learn English"]
    [:meta {:name "viewport"
            :content "width=device-width, initial-scale=1.0"}]
    (include-css "/css/bootstrap.min.css")
    (include-css "test1.css")
    (include-js "http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js")
    (include-js "script.js")]
   [:body {:style "padding-top:60px;"}
    (header)
    [:div.container
     body]]))

(defn index-page []
  (template
   [:div {:class "hero-unit"}
    [:h1 "Learn English Demo"]
    [:p "Welcome to the Learn English Demo!"]]

   [:div {:class "well"}
    [:p
     [:h3 "Original text"]
     [:hr]
     [:p (str utils/text1)]
     [:hr]
     [:h3 "Translated text"]
     [:hr]
	;	<textarea id="src-text" rows="10" cols="50">
     (text-area {:rows "10"} "src-text"
                (utils/translation-pairs-to-string
                 (utils/translate-text utils/ignored-words "en" "he" utils/text1)))
     [:hr]
     [:div {:id "out-text"}]
     [:hr]
     [:h3 "Known words"]
     [:ol {:id "known-words"}]]]))

(defn about-page []
  (template
   [:div {:class "well"}
    [:h1 "About Learn English:"]
    "TBD "]))
