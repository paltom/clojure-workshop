(defn encode-letter
  [s x]
  (let [code-char (int (first s))
        code-added (+ x code-char)
        code (Math/pow code-added 2)]
    (str "#" (int code))))

(defn encode
  [s]
  (let [number-of-words (count (clojure.string/split s #" "))]
    (clojure.string/replace s #"\w" (fn [s] (encode-letter s number-of-words)))))

(defn decode-letter
  [x y]
  (let [number (Integer/parseInt (subs x 1))
        letter (char (- (Math/sqrt number) y))]
    (str letter)))

(defn decode
  [s]
  (let [number-of-words (count (clojure.string/split s #" "))]
    (clojure.string/replace s #"\#\d+" (fn [s] (decode-letter s number-of-words)))))
