FROM openjdk:17-alpine
	
	ENV APP_NAME food-system
	
	COPY ./target/${APP_NAME}.jar  /app/${APP_NAME}.jar

	WORKDIR /app

	CMD java -jar ${APP_NAME}.jar

	EXPOSE 8080