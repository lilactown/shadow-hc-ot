(ns town.lilac.ot-example
  (:require
    ["@honeycombio/opentelemetry-web" :refer [HoneycombWebSDK WebVitalsInstrumentation]]
    ["@opentelemetry/auto-instrumentations-web" :refer [getWebAutoInstrumentations]]))
