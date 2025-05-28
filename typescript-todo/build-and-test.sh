#!/usr/bin/env bash

npm run build && \
npm run test && npm run test:e2e && \
npm run lint