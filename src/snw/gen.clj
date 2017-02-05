(ns snw.gen
  (:require [clojure.data.generators :as g]
            [snw.data :as data]))

(defn roll
  ([d] (g/uniform 1 (inc d)))
  ([n d] (->> (repeatedly #(roll d))
              (take n)
              (apply +))))

(defn- random-class []
  (:name (g/rand-nth data/classes)))

(defn roll-stats []
  (zipmap data/stats (repeatedly #(roll 3 6))))

(defn good-stats? [primes stats]
  (let [prime-vals (vals (select-keys stats primes))]
    (every? #(>= % 13) prime-vals)))

(defn roll-good-stats [char]
  (let [primes (get-in char [:class :prime-attrs])
        stats (->> (repeatedly roll-stats)
                   (filter #(good-stats? primes %))
                   (first))]
    (assoc char :stats stats)))

(defn- health-at-level
  [{:keys [hd start-hd hd-until extra-hp] :as health} level]
  (let [hd-level (dec (min hd-until level))
        hp-level (max 0 (- level hd-until))
        hds (+ start-hd hd-level)
        hps (+ (* hp-level extra-hp)
               (roll hds hd))]
    {:hd hds
     :hp hps}))

(defn hd&hp
  "Calculates the character's HD and then rolls HP"
  [{{health :health} :class
    level :level
    :as char}]
  (merge char (health-at-level health level)))

(defn- select-n-distinct [n v]
  (loop [s (sorted-set)]
    (if (= n (count s))
      s
      (recur (conj s (g/rand-nth v))))))

(defn- select-spell-set [levels list]
  (into {}
        (map-indexed (fn [i n]
                       (let [level (inc i)
                             spells (get list level)]
                         [level (select-n-distinct n spells)]))
                     levels)))

(defn- choose-spells* [{:keys [class level]}]
  (into {} (for [[type levels] (:spells class)
                 :let [list (type data/spells)
                       levels (get levels level)
                       set  (select-spell-set levels list)]]
             [type set])))

(defn choose-spells [char]
  (assoc char :spells (choose-spells* char)))

(defn- lookup-class [{:keys [class]
                      :as char}]
  (assoc char :class (data/name->class class)))

(defn generate-char [& {:keys [class level]
                        :or {class (random-class)
                             level (g/uniform 1 22)}}]
  (->> {:class class
        :level level}
       (lookup-class)
       (roll-good-stats)
       (hd&hp)
       (choose-spells)))
