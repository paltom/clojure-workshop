(def walking-speed 4.0)
(def driving-speed 70.0)

(def london {:lat 51.507351 :lon -0.127758})
(def manchester {:lat 53.480759 :lon -2.242631})

(defn distance
  [{lat1 :lat lon1 :lon}
   {lat2 :lat lon2 :lon}]
  (let [lat-diff (- lat2 lat1)
        lon-diff (- lon2 lon1)
        lat-diff-sq (* lat-diff lat-diff)
        lon-diff-sq (* lon-diff lon-diff)
        lon-coeff (Math/cos (Math/toRadians lat1))]
    (* 110.25 (Math/sqrt
                 (+ lat-diff-sq (* lon-coeff lon-diff-sq))))))

(defmulti itinerary :transport)
(defmethod itinerary :walking
  [{:keys [from to]}]
  (let [distance (distance from to)
        duration (/ distance walking-speed)]
    {:cost 0
     :distance distance
     :duration duration}))
(def vehicle-cost-fn {:sporche (* 0.12 1.5)
                      :tayato (* 0.07 1.5)
                      :sleta (* 0.2 0.1)})
(defmethod itinerary :driving
  [{:keys [from to vehicle]}]
  (let [distance (distance from to)
        duration (/ distance driving-speed)  
        cost (* distance (vehicle-cost-fn vehicle))]        
    {:cost cost
     :distance distance
     :duration duration}))

(itinerary {:from london :to manchester :transport :walking})
(itinerary {:from london :to manchester :transport :driving :vehicle :tayato})
