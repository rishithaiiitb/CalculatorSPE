FROM openjdk:17
ADD ./target/CalculatorMP-1.0-SNAPSHOT-jar-with-dependencies.jar ./
WORKDIR ./
CMD ["java", "-jar", "CalculatorMP-1.0-SNAPSHOT-jar-with-dependencies.jar"]

