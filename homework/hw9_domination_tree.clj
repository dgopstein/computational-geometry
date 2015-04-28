(def test-pts '((1 1) (4 2) (2 3) (6 5) (3 6) (7 7)))

(def draw [pts]
  (doseq [[x y]] (println (str "(x:" x ", y:" y ")"))))

(draw test-pts)
