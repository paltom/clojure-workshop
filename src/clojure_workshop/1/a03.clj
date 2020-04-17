(defn meditate
  [s calmness-level]
  (println "Clojure Meditate v2.0")
  (if (< calmness-level 5)
    (str (clojure.string/upper-case s) ", I TELL YA!")
    (if (<= 5 calmness-level 9)
      (clojure.string/capitalize s)
      (if (= calmness-level 10)
        (clojure.string/reverse s)))))
