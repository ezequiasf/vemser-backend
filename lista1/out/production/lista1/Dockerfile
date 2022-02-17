FROM adoptopenjdk/openjdk11
COPY . /src/
WORKDIR /src/imagedock/
RUN ["javac", "App.java"]
CMD ["java", "App"]