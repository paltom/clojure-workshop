(defn encode-letter
  [s]
  (let [code-char (int (first s))
        code (Math/pow code-char 2)]
    (str (int code))))

(defn encode
  [s]
  (clojure.string/replace s #"\w" encode-letter))
