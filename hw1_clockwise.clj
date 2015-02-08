(defn clockwise? [p q r]
  (cond
    (left-of?  p q) (below-line? (line p q) r)
    (right-of? p q) (above-line? (line p q) r)

    ; the first two points are vertical
    (below-line? (line q r) p) (left-of?  p r)
    (above-line? (line q r) p) (right-of? p r)))