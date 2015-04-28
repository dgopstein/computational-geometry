(defn build-kd-tree [p depth]
  (if (= 1 (size p)) (leaf (first p))

    (let [[p1 p2]
            (cond (mod depth 3)
                0 (split-vertical p)
                1 (split-horizontal p)
                2 (split-diagonal p))]

            (tree (build-kd-tree p1 (inc depth))
                  (build-kd-tree p2 (inc depth))))))

(defn polygon-contains? [vertices p]
    (and (same-side? a b p)
         (same-side? b c p)
         (same-side? c a p)))

(defn polygon-contains? [vertices p]
    (every? (fn [[a b]] same-side? a b p) (partition 2 1 vertices)))