# Dockerfile do projeto CBYK
# Linux Alpine e Java RE 17
FROM eclipse-temurin:17-jre-alpine
# Criando variável com o caminho do jar local na aplicação
ARG JAR_FILE=target/cbyk.jar
# Copiando o jar e alterando o nome
COPY ${JAR_FILE} cbyk.jar
# Healthcheck
RUN apk --no-cache add curl
HEALTHCHECK --interval=60s --timeout=15s --retries=3 --start-period=500s \
  CMD curl -f http://localhost:8083/actuator/health || exit 1
# Criando usuário para evitar de usar o "root"
RUN addgroup -S appgroup && adduser -S appuser -G appgroup
USER appuser
# Execução da aplicação
ENTRYPOINT ["java","-jar","cbyk.jar"]