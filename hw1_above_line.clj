(defn test-line [f]
  (let [res (map (fn [arg] [(apply f (first arg)) (last arg)])
    '(
      [[[1 0] [2 1] [3 2]] false]
      [[[1 0] [2 1] [2 1]] false]
      [[[1 0] [2 1] [1.5 0.5]] false]
      [[[1 0] [2 1] [1 0.5]] false]
      [[[1 0] [2 1] [1 1.5]] true]
      [[[1 0] [2 1] [0 -1.5]] false]
      [[[1 0] [2 1] [0 -0.5]] true]
    )
    )]

    (if (every? = res)
      (prn "Success!")
      (do (prn "Failure!" (prn res))))))

(defn pt-sub [[ax ay] [bx by]] [(- bx ax) (- by ay)])

(defn left-of-line? [a b c]
  (let [diff (pt-sub (pt-sub a b) (pt-sub a c))]
    (prn "diff" diff)
    (> 0 (first diff))))
  
(defn above-line? [a b c]
  (let [[ax ay]    a
        [cx cy]    c
        slope (apply / (pt-sub a b))
        y-off (- 0 (* slope ax))]
    (> cy (+ (* slope cx) y-off))))
  
(def main (test-line above-line?))

