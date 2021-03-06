FROM openjdk:11-jre-slim

WORKDIR /app

COPY target/*.jar /app/livraria-online-0.0.1.jar

EXPOSE 8001

CMD java -XX:+UseContainerSupport -Xmx512m -Dserver.port=${PORT} -jar livraria-online-0.0.1.jar