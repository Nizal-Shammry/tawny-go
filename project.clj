(defproject tawny-go "1.0.0-SNAPSHOT"
  :description "A mavenized version of GO"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [uk.org.russet/tawny-owl "2.0.0-SNAPSHOT"]]
  :jvm-opts ["-Xmx1000m"]
  :main tawny-go.core
  )
