# 使用 JDK 8 官方镜像
FROM eclipse-temurin:8-jdk-alpine

RUN sed -i 's/dl-cdn.alpinelinux.org/mirrors.cloud.tencent.com/g' /etc/apk/repositories

# 安装 Maven 3.9（清华源）
RUN apk add --no-cache curl tar && \
    MAVEN_VERSION=3.9.4 && \
    curl -fsSL https://mirrors.tuna.tsinghua.edu.cn/apache/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz | tar -xzf - -C /opt && \
    mv /opt/apache-maven-${MAVEN_VERSION} /opt/maven && \
    ln -s /opt/maven/bin/mvn /usr/bin/mvn

# 配置腾讯云镜像源（已修复转义问题）
RUN mkdir -p /usr/share/maven/ref && \
    echo '<?xml version="1.0" encoding="UTF-8"?> \
    <settings xmlns="http://maven.apache.org/SETTINGS/1.0.0" \
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" \
        xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd"> \
        <mirrors> \
            <mirror> \
                <id>tencent</id> \
                <name>Tencent Cloud Mirror</name> \
                <url>https://mirrors.cloud.tencent.com/nexus/repository/maven-public/</url> \
                <mirrorOf>*</mirrorOf> \
            </mirror> \
        </mirrors> \
    </settings>' > /usr/share/maven/ref/settings.xml

# 设置工作目录
WORKDIR /app

# 复制项目
COPY . .

# 使用腾讯云镜像构建
RUN mvn -s /usr/share/maven/ref/settings.xml clean package -pl poetry-start -am -DskipTests

# 暴露端口
EXPOSE 8080

# 启动命令
ENTRYPOINT ["java","-jar","/app/poetry-start/target/poetry-start-1.0.jar"]