javac -d out $(find src -name "*.java")
java -cp out ru.clevertec.check.CheckRunnerR 10-3 2-5 11-10 12-3 discountCard=2 balanceDebitCard=1110.1111 saveToFile=./result.csv

