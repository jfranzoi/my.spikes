#!/usr/bin/env bash

[[ "$SKIP_BUILD" == "true" ]] || npm run build
docker compose -f docker/compose.yml up --build --remove-orphans