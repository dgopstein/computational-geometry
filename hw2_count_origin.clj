(defn all-edges [edges e]
    (if (contains? edges e)
        edges
        (all-edges (conj edges e) (next (twin e)))))

(defn count-origin [e] (count (all-edges #{} e)))


(defn outer-vertex? [v]
    (defn outer-edge? [e]
        (defn outer-face? [f] (nil? (outer-component f)))
        (outer-face? (incident-face e)))
    (exists? outer-edge? (all-edges (incident-edge v))))

(defn count-faces [v] (count (set (map incident-face (all-edges (incident-edge v))))))