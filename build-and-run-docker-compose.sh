#!/bin/bash

./gradlew clean build
docker build -t criptografia -f Dockerfile .
docker compose up -d