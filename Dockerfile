FROM openjdk:jre-alpine
WORKDIR /workspace
COPY /target/product-service-1.0.0.jar /workspace/product-service.jar
COPY /starter.sh /workspace/starter.sh
EXPOSE 9000
RUN apk add curl
RUN apk add --update --no-cache netcat-openbsd
RUN ["chmod", "+x", "/workspace/starter.sh"]
ENTRYPOINT ["sh","/workspace/starter.sh"]