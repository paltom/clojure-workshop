(def our-randoms (repeatedly (partial rand-int 100)))

(take 20 our-randoms)

(defn some-random-integers [size]
  (take size (repeatedly (fn [] (rand-int 100)))))

(some-random-integers 12)
