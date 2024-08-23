# 빌드 단계
FROM maven:3.8.8-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# 실행 단계
FROM openjdk:17-jdk-slim
WORKDIR /app

# 빌드된 JAR 파일 복사
COPY --from=builder /app/target/*.jar /app/app.jar

# wait-for-it.sh 스크립트 복사 및 실행 권한 부여
COPY wait-for-it.sh /app/wait-for-it.sh
RUN chmod +x /app/wait-for-it.sh

# 포트 노출
EXPOSE 8080

# wait-for-it.sh 스크립트를 이용한 애플리케이션 실행
ENTRYPOINT ["/app/wait-for-it.sh", "db:5432", "--", "java", "-jar", "/app/app.jar"]
