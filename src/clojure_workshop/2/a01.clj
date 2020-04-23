(def memory-db (atom {}))
(defn read-db
  []
  @memory-db)
(defn write-db
  [new-db]
  (reset! memory-db new-db))

(defn create-table
  [name]
  (let [db (read-db)
        new-table {:data [] :indexes {}}
        new-db (assoc db name new-table)]
    (write-db new-db)))

(defn drop-table
  [name]
  (let [db (read-db)
        new-db (dissoc db name)]
    (write-db new-db)))

(defn insert
  [table record id-key]
  (let [db (read-db)
        id-value (record id-key)
        id-key-indexes (get-in db [table :indexes id-key])]
    (if-not (contains? id-key-indexes id-value)
      (let [data [table :data]
            new-db (update-in db data conj record)
            value-index (- (count (get-in new-db data)) 1)]
        (write-db (assoc-in new-db [table :indexes id-key id-value] value-index)))
      (println (str "Record with " id-key " " id-value " already exists.\nAborting")))))

(defn select-*
  [table-name]
  (get-in (read-db) [table-name :data]))

(defn select-*-where
  [table-name field field-value]
  (let [db (read-db)
        index (get-in db [table-name :indexes field field-value])
        data (get-in db [table-name :data])]
    (get data index)))
