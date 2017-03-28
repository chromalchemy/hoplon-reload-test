(set-env!
  :dependencies
    '[[adzerk/boot-cljs          "1.7.48-5"]
      ; [adzerk/boot-reload        "0.5.1"]
      [adzerk/boot-reload        "0.4.13"]
      [hoplon/hoplon             "6.0.0-alpha17"]
      [org.clojure/clojure       "1.8.0"]
      [org.clojure/clojurescript "1.9.494"]
      [pandeiro/boot-http        "0.7.6"]
      [org.clojure/tools.nrepl "0.2.12"]
      [hoplon/ui "0.2.1-SNAPSHOT"]]

  :source-paths #{"src"})

(require
  '[adzerk.boot-cljs         :refer [cljs]]
  '[adzerk.boot-reload       :refer [reload]]
  '[hoplon.boot-hoplon       :refer [hoplon prerender]]
  '[pandeiro.boot-http :refer [serve]])




(deftask dev
  "Build reload-test for local development."
  []
  (comp
    (watch)
    (speak)
    (hoplon)
    (reload)
    (cljs :optimizations :none)
          ; :source-map true
          ; :compiler-options
          ;   {
          ;     :language-in :ecmascript5
          ;     :parallel-build true})
    (serve :port 8000
          :reload true)))
    ; (target :dir #{"target"})))
