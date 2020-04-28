(defn our-range [limit]
  (take-while #(< % limit) 
    (iterate inc 0)))

(our-range 5)

(map #(* 10 %) (our-range 5))

(map (fn [i] (print ".") (* i 10)) (our-range 5))

(def by-ten (map (fn [i] (print ".")
                   (* i 10))
              (our-range 5)))

by-ten
