(def base-co2 382)
(def base-year 2006)

(defn co2-estimate
  "Returns a (conservative) year's estimate of carbon dioxied parts per million in the atmosphere"
  [year]
  (let [year-diff (- year base-year)]
    (+ base-co2 (* year-diff 2))))

(co2-estimate 2050)
(co2-estimate 2006)
(co2-estimate 2020)
