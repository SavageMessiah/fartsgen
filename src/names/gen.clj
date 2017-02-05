(ns names.gen
  (:require [clojure.data.generators :as g]
            [clojure.set :as set]
            [clojure.string :as str]))

(defn same-weight [weight vs]
  (->> vs
       (map (fn [l] [l weight]))
       (into {})))

(def vowels (merge (same-weight 10 [\a \e \i \o \u])
                   {\y 5}))

(def consonants (merge (same-weight
                        10
                        [\b \c \d \f \g \h \j \k \l \m \n \p \r \s \t \v])
                       {\w 5 \x 5 \y 5 \z 5 \q 1}))

(def useful-bits (same-weight 8 ["st" "ch" "pl" "th" "sh" "ph"]))

(def beginnings (merge (same-weight 8 ["kr" "qu" "bl" "cl" "kl" "wh" "cr" "gr"])
                       (dissoc consonants \q)
                       useful-bits))

(def endings (merge (same-weight 8
                                 ["ck" "bble" "pple" "gh" "rg" "nge" "rl" "lly" "rt" "mp"
                                  "nkle" "pp" "ff" "ss" "tl" "tt" "ng" "nt" "pe" "lk" "lb"
                                  "ry"])
                    (dissoc consonants \c)
                    useful-bits))

(def middles (merge vowels
                    {"oo" 5 "ee" 5 "oi" 5 "ei" 5 "ou" 5}))

(defn name-part []
  (let [middle-length (g/uniform 0 3)
        bit-sets (-> [beginnings middles]
                     (into (->> (repeat [beginnings middles])
                                (take middle-length)
                                (apply concat)
                                vec))
                     (conj endings))
        bits (map g/weighted bit-sets)]
    (str/capitalize (apply str bits))))

(defn title []
  (g/rand-nth ["El" "El Jefe" "Sir" "Lord" "Col." "The"]))

(defn weird-joiner []
  (g/weighted {"von" 1
               "van der" 1
               "van" 1
               "bin" 1
               "de" 1}))

(defn a-name []
  (g/weighted {(g/tuple name-part weird-joiner name-part) 2
               (g/tuple name-part name-part name-part) 2
               (g/tuple name-part) 2
               (g/tuple name-part name-part) 4}))

(defn suffix []
  (let [suffix-gen (fn [] (rand-nth ["of" "the"]))]
    (g/tuple suffix-gen name-part)))

(defn full-name []
  (->> (g/weighted {(g/tuple title a-name) 1
                    (g/tuple title a-name suffix) 1
                    (g/tuple a-name suffix) 1
                    a-name 4})
       flatten
       (str/join " ")))
