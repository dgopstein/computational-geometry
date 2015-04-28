(defn build-x-range-tree [p]
  (let [t-assoc (bst-by y-coord p)]
    (if (= 1 (size p)) (leaf t-assoc (first p))

        (let [[p1 p2]
                (cond (mod depth 3)
                    0 (split-vertical p)
                    1 (split-horizontal p)
                    2 (split-diagonal p))]

                (tree (build-kd-tree p1 (inc depth))
                      (build-kd-tree p2 (inc depth)))))))
