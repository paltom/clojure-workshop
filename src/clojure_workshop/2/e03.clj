; Sets
(def supported-currencies
  #{"Dollar" "Japanese yen" "Euro" "Indian rupee" "British pound"})

(get supported-currencies "Dollar")
(get supported-currencies "Swiss franc")

(contains? supported-currencies "Dollar")
(contains? supported-currencies "Swiss franc")

(supported-currencies "Swiss franc")

(conj supported-currencies "Monopoly Money")
supported-currencies

(conj supported-currencies "Monopoly Money" "Gold dragon" "Gil")
(disj supported-currencies "Dollar" "British pound")

; Vectors
[1 2 3]
(vector 10 15 2 15 0)
(vec #{1 2 3})
[nil :keyword "String" {:answers [:yep :nope]}]
