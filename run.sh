docker container stop products
docker container rm products
docker container stop productstestdb
docker container rm productstestdb
docker-compose up -d
./gradlew clean
./gradlew build
java -jar build/libs/clev-1.0-SNAPSHOT.jar 10-3 2-5 11-10 12-3 discountCard=2 balanceDebitCard=1110.1111 saveToFile=./result.csv datasource.url=jdbc:postgresql://localhost:5432/products datasource.username=postuser datasource.password=qwerty

