docker build -t murillo/followupdb ./database
docker run -p 5433:5432 --name murillo-db -d murillo/followupdb

mvn clean package

docker build -t murillo/followupapp .
docker run -p 8082:8080 --name murillo-app --link murillo-db:database -d murillo/followupapp
