(defproject tawny-go "1.0.0-SNAPSHOT"
  :description "tawny version of GO"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                [uk.org.russet/tawny-owl "2.0.0-SNAPSHOT"]]
  :main ^:skip-aot tawny-go.core
  :jvm-opts ["-Xmx1000m"])
