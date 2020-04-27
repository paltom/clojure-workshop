(map (fn [i] (* i 10)) [1 2 3 4 5])

(map count ["Let's" "measure" "word" "length" "now"])
(map (fn [w] (str w ": " (count w))) ["Let's" "measure" "word" "length" "now"])
