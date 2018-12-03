(ns tawny.go
  (:refer-clojure :only [partial println])
  (:require [tawny read memorise])
  (:import [java.util.zip GZIPInputStream]))

;; version information
(clojure.core/defonce available-versions
  ^{:private true
    :doc "Map showing available Go versions. Lite provides Ids,
  name, subsets and relationships. Core provides the same features as
  Lite plus chemical data (mass, charge, formula) and
  structures (inchis, inchikeys, smiles. Full provides the same
  features as Core plus name synonyms and manually added
  cross-reference. "}
  {0, "go.owl"
   1, "go-plus.owl"
   2, "go_snippet.owl"})

;; chosen version
(clojure.core/defonce version (available-versions 0))
;; (println version)

;; ungzip file if it does not exist in resources folder
(clojure.core/when (clojure.core/not (clojure.java.io/resource version))
  (clojure.core/let
      [stream
       (GZIPInputStream.
        (clojure.java.io/input-stream
         (clojure.java.io/resource
          (clojure.core/str version ".gz"))))]
    (clojure.java.io/copy
     stream
     (clojure.java.io/file
      (clojure.core/str "./resources/" version)))))

;; TOFIX Make into function with variable location (default local
;; resource) should be able to use latest from bioontology.
;; "Reads in the go ontology from resource"
(tawny.read/defread go
  :location
  (tawny.owl/iri (clojure.java.io/resource version))
  :iri "http://purl.obolibrary.org/obo/go.owl"
  :viri "http://purl.obolibrary.org/obo/go/releases/2018-11-14/go.owl"
  :prefix "go:"
  :filter
   (partial tawny.read/iri-starts-with-filter
            "http://purl.obolibrary.org/obo/GO")
  :filter
  tawny.read/label-transform
  
  :transform
  tawny.read/exception-nil-label-transform
  )
