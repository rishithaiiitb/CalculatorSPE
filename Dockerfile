FROM openjdk:17
ADD ./target/CalculatorMP-1.0-SNAPSHOT-shaded.jar ./
WORKDIR ./
CMD ["java", "-jar", "CalculatorMP-1.0-SNAPSHOT-shaded.jar"]
