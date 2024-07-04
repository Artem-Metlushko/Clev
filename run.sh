javac -d out $(find src -name "*.java")
java -cp out ru.clevertec.check.CheckRunner 1-3 2-5 1-1 discountCard=1 balanceDebitCard=100
