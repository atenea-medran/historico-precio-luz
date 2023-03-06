FROM openjdk:11
EXPOSE 8080:8080
RUN mkdir /app
COPY ./build/libs/kwh.jar /app/kwh.jar
ENTRYPOINT ["java","-jar","/app/kwh.jar"]