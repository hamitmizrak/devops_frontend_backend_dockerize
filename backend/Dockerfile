# JDK Sürümünü
FROM openjdk:17

# Bilgilendirme
LABEL maintainer="hamitmizrak@gmail.com"

# Çevresel Değişkenler
ENV APP_NAME="Spring Boot Backend Application"
ENV APP_VERSION="V1.0.0"
ENV APP_PORT="http://localhost:4444"
ENV APP_YEAR="2024"

# Print Echo 
RUN echo "App Name: $APP_NAME"
RUN echo "App Version: $APP_VERSION"
RUN echo "App Port: $APP_PORT"
RUN echo "App Year: $APP_YEAR"

# Linux Directory
WORKDIR /var/www/html

# Localdeki Dosyaları Yukarıda oluşturduğumuz dizin içine gönder
COPY . /var/www/html

# Persist Data (Veri Kalıcığı için)
VOLUME /tmp

# Projenin Sağlık Kontrolünü sağlamak
HEALTHCHECK --interval=60s --timeout=5s --start-period=5s --retries=3 \
    CMD wget --quiet --tries=1 --spider http://localhost:4444 || exit 1 -f http://localhost:4444/actuator/health || exit 1

# Port
EXPOSE 4444 

# JAR FILE (Değişkeni Oluştur)
ARG JAR_FILE= /target/*.war

# Proje İsmini Ekle 
ADD ${JAR_FILE} blog_react

# Entry point
ENTRYPOINT [ "java","-jar","/blog_react" ]