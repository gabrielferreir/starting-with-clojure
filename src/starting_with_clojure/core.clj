(ns starting-with-clojure.core
  (:gen-class))

(def total-de-vidas 3)
(def palavra-secreta "SANTOS")
(defn perdeu [] (println "Você perdeu"))
(defn ganhou [] (println "Você ganhou"))

(defn letras-faltantes [palavra acertos]
  (remove (fn [letra] (contains? acertos (str letra))) palavra)
  )

(defn acertou-a-palavra-toda? [palavra acertos]
  (empty? (letras-faltantes palavra acertos))
  )

(defn le-letra! [] (read-line))

(defn acertou? [chute palavra]
  (.contains palavra chute)
  )

(defn imprime [vidas palavra acertos]
  (println "Vidas: " vidas)
  ;(println "Palavra: " palavra)
  ;(println "Palavra: " palavra
  (doseq [letra (seq palavra)]
    (if (contains? acertos (str letra))
      (print letra " ")
      (print "_" " ")
      )
    )
  (println))

(defn jogo [vidas palavra acertos]
  (imprime vidas palavra acertos)
  (cond
    (= vidas 0) (perdeu)
    (acertou-a-palavra-toda? palavra acertos) (ganhou)
    :else
    (let [chute (le-letra!)]
      (if (acertou? chute palavra)
        (do
          (println "Você acertou essa letra")
          (recur vidas palavra (conj acertos chute)))
        (do
          (println "Você errou essa letra")
          (recur (dec vidas) palavra acertos))
        )
      )
    )
  )

(defn comeca []
  (jogo total-de-vidas palavra-secreta #{})
  )

(defn -main [& args]
  (comeca))
