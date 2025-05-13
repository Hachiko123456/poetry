# 使用 JDK 8 官方镜像
FROM eclipse-temurin:8-jdk-alpine

# 安装 Maven 3.5
RUN apk add --no-cache curl tar && \
    MAVEN_VERSION=3.5.4 && \
    curl -fsSL https://archive.apache.org/dist/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz | tar -xzf - -C /opt && \
    mv /opt/apache-maven-${MAVEN_VERSION} /opt/maven && \
    ln -s /opt/maven/bin/mvn /usr/bin/mvn

# 设置工作目录
WORKDIR /app

# 复制整个项目（包括父pom和子模块）
COPY . .

# 多阶段构建优化
RUN mvn clean package -pl poetry-start -am -DskipTests

# 暴露端口
EXPOSE 8080

# 指定启动模块的jar包
ENTRYPOINT ["java","-jar","/app/poetry-start/target/*.jar"]