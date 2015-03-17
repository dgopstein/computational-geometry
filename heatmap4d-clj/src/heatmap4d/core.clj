(ns heatmap4d.core
  (:require  [clojure.math.numeric-tower :as math]))

(use 'mikera.image.core)
(use 'mikera.image.colours)

(def img-size 32)

(def get-pixel-array #(partition img-size (get-pixels %)))

; https://github.com/clojure/math.numeric-tower
(defn sqr
  "Uses the numeric tower expt to square a number"
   [x]
      (math/expt x 2))

(defn euclidean-squared-distance
  "Computes the Euclidean squared distance between two sequences"
  [a b]
    (reduce + (map (comp sqr -) a b)))

(defn euclidean-distance
   "Computes the Euclidean distance between two sequences"
   [a b]
     (math/sqrt (euclidean-squared-distance a b)))

(defn max-elems [n lst] (take n (sort lst)))

(defn heatmap4d-index
    "Bruteforce heatmap, serves as a comparison point for other implementations"
    [img points]

    (let [height img-size ; get this info from the image!
          width img-size ; get this info from the image!
          d 3
          pixel-array (get-pixel-array img)]

      (doseq [[start-x start-y end-x end-y] points
              ^ints x1 (map int (range width))
              ^ints y1 (map int (range height))
              ^ints x2 (map int (range width))
              ^ints y2 (map int (range height)) ]

        (let [dist (euclidean-distance [start-x start-y end-x end-y] [x1 y1 x2 y2])]
          (prn (map type [x1 y1 x2 y2]))
          (prn (map type pixel-array))
          (prn (map type (- d dist)))
          (if (<= dist d)
             (aset pixel-array x1 y1 x2 y2 (- d dist)))))

  ;(max-elems 10 pixel-array)
  
   (set-pixels (flatten pixel-array))))

;; create a new image
(def bi (new-image img-size img-size))

;; gets the pixels of the image, as an int array
(def pixels (get-pixels bi))


(defn -main
  "Application entry point"
   [& args]

  (heatmap4d-index bi [[1 2 3 4] [11 12 13 14] [21 22 23 24] [31 32 33 34] [41 42 43 44]])

  ;; view our new work of art
  ;; the zoom function will automatically interpolate the pixel values
  (show bi :zoom 10.0 :title "Isn't it beautiful?"))

