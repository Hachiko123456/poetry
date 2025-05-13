# 使用官方JDK 8镜像（Alpine轻量版）
FROM eclipse-temurin:8-jdk-alpine

# 安装Maven 3.5
RUN apk add --no-cache curl tar && \
    MAVEN_VERSION=3.5.4 && \
    curl -fsSL https://archive.apache.org/dist/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz | tar -xzf - -C /opt && \
    mv /opt/apache-maven-${MAVEN_VERSION} /opt/maven && \
    ln -s /opt/maven/bin/mvn /usr/bin/mvn

# 设置工作目录
WORKDIR /app

# 复制项目文件（利用Docker层缓存优化）
COPY pom.xml .
RUN mvn dependency:go-offline -B

# 复制源码并构建
COPY src ./src
RUN mvn clean package -DskipTests

# 设置启动命令
ENTRYPOINT ["java","-jar","/app/target/*.jar"]