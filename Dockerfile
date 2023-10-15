FROM vegardit/graalvm-maven:latest-java21 as build
LABEL authors="fethiyildiz"

RUN mkdir "app"

WORKDIR /app

COPY pom.xml pom.xml

RUN mvn dependency:go-offline -B

COPY src src

RUN mvn native:compile -Pnative -DskipTests


FROM eclipse-temurin:20.0.2_9-jre-jammy

RUN mkdir "app"

WORKDIR /app

COPY --from=build /app/target/awsnativedemo .

ENTRYPOINT ["./awsnativedemo"]