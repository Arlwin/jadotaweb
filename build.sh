#!/bin/sh

# Build Vue
cd frontend
npm run build

# Copy to Springboot
cd ..
cp -r frontend/dist/* backend/src/main/resources/static/.

# Build gradle
# cd backend
# ./gradlew build --no-daemon