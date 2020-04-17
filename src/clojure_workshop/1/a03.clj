(defn meditate
  [s calmness-level]
  (println "Clojure Meditate v2.0")
  (cond
    (< calmness-level 5)    (str (clojure.string/upper-case s) ", I TELL YA!")
    (<= 5 calmness-level 9) (clojure.string/capitalize s)
    (= calmness-level 10)   (clojure.string/reverse s)))
