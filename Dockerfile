FROM alpine/java:21-jdk

WORKDIR /app

# JDBCドライバーとJavaファイルをコピー
COPY demo /app/

# ドッカー内のコンテナ作成時に一度だけ実行
Run ./gradlew build

# コンテナ起動時に毎回実行
CMD ["java", "-jar", "build/libs/demo-0.0.2.jar"]

