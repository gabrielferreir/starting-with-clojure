(ns starting-with-clojure.core
  (:gen-class))

(def total-de-vidas 6)

(defn perdeu [] (print "Você perdeu"))
(defn perdeu [] (print "Você ganhou"))

(defn jogo [vidas palavra acertos]
  (if (= vidas 0)
    (perdeu)
    (if (acertou-a-palavra-toda? palavra acertos)
        (ganhou)
        (print "Chute uma palavra")
    )
  )
)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
