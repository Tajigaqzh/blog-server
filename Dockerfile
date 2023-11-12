# jre17
FROM joengenduvel/jre17
LABEL org.opencontainers.image.authors="201267151@qq.com"
ADD blog-server-1.0.jar blog.jar
EXPOSE 8080
ENTRYPOINT ["java" ,"-jar","blog.jar"]