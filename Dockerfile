FROM openjdk:latest
COPY ./out/artifacts/tcp_server/ /tmp
WORKDIR /tmp
ENTRYPOINT ["java","-jar", "tcp-server.jar"]
EXPOSE 8080
