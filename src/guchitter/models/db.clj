(ns guchitter.models.db)

;(def my-db "postgres://localhost:5432/guchitter")
(def my-db (System/getenv "DATABASE_URL"))
