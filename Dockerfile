<<<<<<< HEAD
FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/stok-yonetim-1.0.0.jar app.jar
=======
FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/stok-yonetim-1.0.0.jar app.jar
>>>>>>> f2aa8e62457412b03465e858e3f3d8701e91f936
ENTRYPOINT ["java","-jar","/app.jar"] 