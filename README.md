# shadow-hc-ot

A reproduction of a shadow-cljs compiler error:

```
[:app] Compiling ...
[:app] Build failure:
Closure compilation failed with 1 errors
--- node_modules/@opentelemetry/sdk-metrics/build/src/aggregator/ExponentialHistogram.js:42
Illegal variable reference before declaration: startTime
```

when trying to follow Honeycomb's [Getting started](https://github.com/honeycombio/honeycomb-opentelemetry-web?tab=readme-ov-file#getting-started) instructions for their opentelemetry web wrapper.

## Reproduction steps

Run the following command in this repo after cloning:

```
shadow-cljs watch app
```

## Recreating this repo

Create folder and add shadow-cljs.edn

```clojure
{:source-paths ["src"]
 :dev-http {8000 "public"}
 :builds {:app {:modules {:main {:entries [town.lilac.ot-example]}}
                :output-dir "public/js"
                :asset-path "js"
                :target :browser}}}
```

Install shadow-cljs

```
npm i shadow-cljs
```

Install OpenTelemetry and Honeycomb's web wrapper

```
npm install @honeycombio/opentelemetry-web @opentelemetry/auto-instrumentations-web
```

Create a file that requires the following

```clojure
(ns town.lilac.ot-example
  (:require
    ["@honeycombio/opentelemetry-web" :refer [HoneycombWebSDK WebVitalsInstrumentation]]
    ["@opentelemetry/auto-instrumentations-web" :refer [getWebAutoInstrumentations]]))
```
