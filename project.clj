(defproject discord-clojurebot "0.1.0-SNAPSHOT"
  :description "A Discord bot written in Clojure for use in OsloMet's HINGDATA16HA's Discord server"
  :url "http://github.com/hingdata16ha/discord-clojurebot"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot discord-clojurebot.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
