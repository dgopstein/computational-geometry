(defn traverse [v]
	(if (not (marked? v))
		(let [e             (incident-edge v)
			  traverse-dest (comp traverse origin next)]
	  		(process v)
			(traverse-dest e)
			(traverse-dest (next (twin e)))
			(doseq (inner-components (incident-face e)) traverse-dest))))

