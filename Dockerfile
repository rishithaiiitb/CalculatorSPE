FROM openjdk:17
ADD ./target/original-CalculatorMP-1.0-SNAPSHOT.jar ./
WORKDIR ./
CMD ["java", "-jar", "original-CalculatorMP-1.0-SNAPSHOT.jar"]

