(def weapon-damage {:fists 10.0
                    :staff 35.0
                    :sword 100.0
                    :cast-iron-saucepan 150.0})

(defn strike
  ([target weapon]
   (let [points (weapon weapon-damage)]
      (if (= :gnomes (:camp target))
        (update target :health + points)
        (update target :health - points)))))

(def enemy {:name "Zulkaz"
            :health 250
            :camp :trolls})

(strike enemy :sword)

(def ally {:name "Carla"
           :health 80
           :camp :gnomes})
(strike ally :staff)

(defn strike
  ([target weapon]
   (let [points (weapon weapon-damage)]
    (if (= :gnomes (:camp target))
      (update target :health + points)
      (let [armor (or (:armor target) 0)
            damage (* points (- 1 armor))]
        (update target :health - damage))))))

(strike enemy :cast-iron-saucepan)
  
(def enemy {:name "Zulkaz"
            :health 250
            :armor 0.8
            :camp :trolls})
(strike enemy :cast-iron-saucepan)

(defn strike
  "With one argument, strike a target with a default :fists `weapon`.
  With two arguments, strike a target with `weapon`.
  Strike will heal a target that belongs to the gnomes camp."
  ([target]
   (strike target :fists))
  ([{:keys [camp armor] :or {armor 0} :as target} weapon]
   (let [points (weapon weapon-damage)]
    (if (= :gnomes camp)    
      (update target :health + points)
      (let [damage (* points (- 1 armor))]
        (update target :health - damage))))))

(strike enemy)
(strike enemy :cast-iron-saucepan)
(strike ally :staff)
