From eclipse-temurin:11.0.16_8-jdk
copy springbootproject-1.0.jar sbp.jar

ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.7.2/wait /wait
RUN chmod +x /wait

CMD ["java","-jar","sbp.jar"]







