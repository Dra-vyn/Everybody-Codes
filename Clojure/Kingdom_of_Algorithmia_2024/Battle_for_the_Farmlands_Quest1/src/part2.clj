(def input
  (slurp "Kingdom_of_Algorithmia_2024/Battle_for_the_Farmlands_Quest1/data/input2.txt"))

(def potion-map {:A 0 :B 1 :C 3 :D 5})

(def creature-sets
  (map #(apply str %) (partition-all 2 input)))

(def total-potions 
  (reduce + (map (fn [creatures] (+ (reduce + (map (fn [creature] (get potion-map (keyword (str creature)) 0)) creatures)) (if (clojure.string/includes? creatures "x") 0 2))) creature-sets)))

(println total-potions)