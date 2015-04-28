(def test-pts [[1 1] [4 2] [2 3] [6 5] [3 6] [7 7]])

(defn value [node] (nth node 0))
(defn children [node] (nth node 1))
(defn x [pt] (nth pt 0))
(defn y [pt] (nth pt 1))
(defn dominates? [a b] (or (> (x a) (x b)) (> (y a) (y b))))

(defn insert [tree pt]
  (if (dominates? (value tree) pt)
    

(defn draw [pts]
  (doseq [[x y] pts]
    (prn (str "(x:" x ", y:" y ")"))))

(draw test-pts)


