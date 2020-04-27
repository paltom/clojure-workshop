(def player {:name "Lea"
             :health 200
             :position {:x 10
                        :y 10
                        :facing :north}})

(defmulti move #(:facing (:position %)))

(ns-unmap 'user 'move)

(defmulti move (comp :facing :position))
(defmethod move :north
  [entity]
  (update-in entity [:position :y] inc))
       
(move player)
(defmethod move :south
  [entity]
  (update-in entity [:position :y] dec))
(defmethod move :west
  [entity]
  (update-in entity [:position :x] inc))
(defmethod move :east
  [entity]
  (update-in entity [:position :x] dec))

(move {:position {:x 10 :y 10 :facing :west}})
(move {:position {:x 10 :y 10 :facing :south}})
(move {:position {:x 10 :y 10 :facing :east}})

(defmethod move :default [entity] entity)

(move {:position {:x 10 :y 10 :facing :wall}})
