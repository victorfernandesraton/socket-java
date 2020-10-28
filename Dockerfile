FROM openjdk:latest
COPY ./out/artifacts/tcp_server_jar/ /tmp
WORKDIR /tmp
CMD ls
ENTRYPOINT ["java","-jar", "tcp-server.jar"]