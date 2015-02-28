(defproject learnengl "0.1.0-SNAPSHOT"
  :description "learngl"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.3.1"]
                 [org.clojure/clojure-contrib "1.2.0"]
                 [clj-time "0.7.0"]
                 [hiccup "1.0.5"]
                 [liberator "0.11.0"]
                 [cheshire "5.3.1"]
                 [clj-http "1.0.1"]
                 [org.apache.httpcomponents/httpclient "4.3.5"]
                 [ring/ring-defaults "0.1.2"]]
  :plugins [[lein-ring "0.8.10"]
            [cider/cider-nrepl "0.8.1"]]
  ;:ring {:handler learnengl.routes/app}
  :ring {:handler learnengl.routes/app
         :nrepl {:start? true :port 9998};:init movielexsrv.handler/init
;:destroy movielexsrv.handler/destroy
;:auto-reload? true
;:auto-refresh? true
}
  :aot
  :all
  :auto-clean false
  :profiles
  {:production
   {:ring
    {:open-browser? false, :stacktraces? false, :auto-reload? false}}
   :dev
   {:dependencies [[ring-mock "0.1.5"] [ring/ring-devel "1.2.1"]]}})
