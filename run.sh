javac -d out $(find src -name "*.java")
java -cp out ru.clevertec.check.CheckRunnerR 10-3 2-5 1-10 discountCard=2 balanceDebitCard=110.1111

