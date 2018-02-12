(ns discord-clojurebot.utils-test
  (:require [clojure.test :refer :all]
            [discord-clojurebot.utils :refer :all]))

(deftest left-pad-test
  (testing "Pads with leading spaces"
    (is (= (left-pad 5 "foo") "  foo")))
  (testing "Pads with supplied character to the specified length"
    (is (= (left-pad "x" 5 "foo") "xxfoo")))
  (testing "Throws if padding character is a multi-character string"
    (is (thrown-with-msg? Exception
                          #"Padding character should be a single character"
                          (left-pad "foo" 5 "bar"))))
  (testing "Throws if padding character is an empty string"
    (is (thrown-with-msg? Exception
                          #"Padding character should be a single character"
                          (left-pad "" 5 "bar")))))
