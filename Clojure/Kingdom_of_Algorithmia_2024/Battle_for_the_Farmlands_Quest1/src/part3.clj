(def input (slurp "Kingdom_of_Algorithmia_2024/Battle_for_the_Farmlands_Quest1/data/input3.txt"))

(def potion-map {:A 0 :B 1 :C 3 :D 5})

(def creature-sets
  (map #(apply str %) (partition-all 3 input)))

(def total-potions
  (reduce + (map (fn [creatures] (let [base-potions
                                       (reduce +
                                               (map (fn [creature] (get potion-map (keyword (str creature)) 0)) creatures))
                                       empty-creature-count (count (re-seq #"x" creatures))
                                       extra-potions (cond
                                                       (= empty-creature-count 0) 6
                                                       (= empty-creature-count 1) 2
                                                       :else 0)]
                                   (+ base-potions extra-potions))) creature-sets)))

(println total-potions)
