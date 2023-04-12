FROM gradle:jdk17-alpine
WORKDIR /payment-sync-service

COPY src /payment-sync-service/src/
COPY build.gradle .
COPY lombok.config .

RUN gradle clean build -x test

ENTRYPOINT ["java", "-jar", "./build/libs/payment-sync-service-1.0.0.jar"]