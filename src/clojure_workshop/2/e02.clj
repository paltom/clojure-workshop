; Maps
(def favorite-fruit
  {:name "Kiwi", :color "Green", :kcal_per_100g 61, :distinguish-mark "Hairy"})

(get favorite-fruit :name)
(get favorite-fruit :color)
(get favorite-fruit :taste)
(get favorite-fruit :taste "Very good 8/10")
(get favorite-fruit :kcal_per_100g 0)

(favorite-fruit :color)
(:color favorite-fruit)
(:shape favorite-fruit "egg-like")
(assoc favorite-fruit :shape "egg-like")
favorite-fruit

(assoc favorite-fruit :color "Brown")
favorite-fruit

(assoc favorite-fruit :yearly-production-in-tonnes
       {:china 2025000
        :italy 541000
        :new_zealand 412000
        :iran 311000
        :chile 225000})

(assoc favorite-fruit :kcal_per_100g (- (:kcal_per_100g favorite-fruit) 1))
(update favorite-fruit :kcal_per_100g dec)
(update favorite-fruit :kcal_per_100g - 10)

(dissoc favorite-fruit :distinguish-mark)
(dissoc favorite-fruit :kcal_per_100g :color)

; Sets
#{1 2 3 4 5}
#{:a :a :b :c}
(hash-set :a :b :c :d)
(set [:a :b :c])
(set ["No" "Copy" "Cats" "Cats" "Please"])
(sorted-set "No" "Copy" "Cats" "Cats" "Please")
