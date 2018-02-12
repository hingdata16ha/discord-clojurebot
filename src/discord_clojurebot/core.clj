(ns discord-clojurebot.core
  (:gen-class)
  (:require [clj-discord.core :as discord]
            [clj-left-pad.core :refer [left-pad]]
            [clojure.data.json :as json]))

            
(defonce secrets (json/read-str (slurp "secrets.json") :key-fn keyword))

(defn get-calendar []
  (slurp
    (str "https://hogskole-romres.ist-asp.com/WebUntis/Ical.do?school=HIOA&id=" (:userid secrets) "&token="
         (:calendar-token secrets))))

(defn d100 [type data]
  (discord/answer-command
    data
    "!d100"
    (str "Here you are a random number between 1 and 100: " (+ (rand-int 100) 1))))

(defn ping [type data]
  (discord/answer-command data "!ping" (str "pong!")))

; (defn timeplan [type data]
  ; (discord/answer-command ))

(defn explode-to-digits [number] (seq (str number)))

(defn log-event [type data] 
  (println "\nReceived: " type " -> " data))

(defn get-date []
  (let [now (java.time.LocalDateTime/now)]
    (str
      (.getYear now) "-"
      (let [month (.getMonthValue now)]
        (if (<= (count (explode-to-digits month)) 1)
          (str 0 month)
          (str month)))
      "-"
      (.getDayOfMonth now))))

(defn -main [& args]
  (println (get-calendar)))
  ; (discord/connect {:token (:bot-token secrets)
  ;                   :functions {"MESSAGE_CREATE" [d100 ping]}}))
