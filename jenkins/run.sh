[200~#!/bin/sh
# 将输出重定向到日志文件
LOGFILE=springboot-app.log
PIDFILE=springboot-app.pid

# 启动 Spring Boot 应用程序并将 PID 写入文件
nohup mvn spring-boot:run > $LOGFILE 2>&1 &
echo $! > $PIDFILE

# 检查应用程序是否成功启动
sleep 5
if [ -f "$PIDFILE" ]; then
	echo "Spring Boot application started with PID $(cat $PIDFILE)"
else
	echo "Failed to start Spring Boot application"
	exit 50
fi
