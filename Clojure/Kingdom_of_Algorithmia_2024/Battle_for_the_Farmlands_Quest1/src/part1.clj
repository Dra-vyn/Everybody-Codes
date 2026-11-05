(def input (slurp "Kingdom_of_Algorithmia_2024/Battle_for_the_Farmlands_Quest1/data/input1.txt"))

(def potion-map {:A 0 :B 1 :C 3})

(def total-potions
  (->> input
       (map #(get potion-map (keyword (str %))))
       (reduce +)))

(println total-potions)