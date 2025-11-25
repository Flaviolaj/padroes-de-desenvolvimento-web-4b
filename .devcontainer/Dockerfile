FROM ubuntu:24.04

ENV DEBIAN_FRONTEND=noninteractive

RUN apt-get update && apt-get install -y curl \
    && curl -fsSL https://deb.nodesource.com/setup_20.x | bash - \
    && apt-get update && apt-get install -y \
        git \
        git-lfs \
        openjdk-21-jdk \
        maven \
        mysql-server \
        nodejs \
    && rm -rf /var/lib/apt/lists/*

# Copy custom Maven settings to ensure Quarkus plugin prefix is recognized
COPY settings.xml /root/.m2/settings.xml

RUN echo "CREATE USER 'flavio'@'localhost' IDENTIFIED BY 'Ju0.1.1000'; \
          GRANT ALL PRIVILEGES ON *.* TO 'flavio'@'localhost' WITH GRANT OPTION; \
          CREATE DATABASE projeto; \
          FLUSH PRIVILEGES;" > /tmp/script.sql

RUN service mysql start && \
    sleep 5 && \
    mysql -uroot < /tmp/script.sql && \
    service mysql stop

WORKDIR /workspaces

CMD [ "bash" ]
 