(defn traverse [v]
	(if (not (marked? v))
		(let [e             (incident-edge v)
			  traverse-dest (comp traverse origin next)]
	  		(process v)
			(traverse-dest e)
			(traverse-dest (next (twin e)))
			(doseq (inner-components (incident-face e)) traverse-dest))))

; traverse by face
; issues with outer face
(defn traverse [v]
	(defn traverse-edges [e]
		(if (not (marked? (origin e)))
			(process (origin e))
			(traverse-face (origin (next (next (twin e)))))
			(traverse-edges (next e))))

	(defn traverse-face [face]
		(let []
			(doseq (inner-components f) traverse-face)


			))
	
	(traverse_face (incident-face (incident-edge v)))
	)