# README #
###### Nome: CBYK - Contas a Pagar  
### Descrição

Aplicação responsável por realizar as funções de CRUDs do Contas A Pagar  

### Tecnologias

- Java 17
- Spring Boot 3
- PostgreSQL
- Flywaydb
- Docker
- Docker Compose

### File = Dockerfile
#### Comandos de exemplo para geração/publicação da imagem do Docker:

A aplicação possui o arquivo Dockerfile e docker-compose.yml na raiz do projeto.  

Para subir todos os contêineres do projeto, use este comando:  

```bash
docker-compose up -d
```

Para parar todos os contêineres em execução, use este comando:  

```bash
docker-compose down
```

### Swagger

Acesso ao documento Swagger com a lista de recursos que estão disponíveis na API REST  

Caminho local da sua máquina:  
[Link 1](http://localhost:8083/cbyk/v3/api-docs)  
[Link 2](http://localhost:8083/swagger-ui/index.html)  

### Actuator

O Actuator fornece um endpoint /actuator/health que exibe informações sobre a saúde do aplicativo.  

Caminho local da sua máquina: [Link](http://localhost:8083/actuator/health)  

## Spring Security

A aplicação possui dois usuários configurados para acesso, são eles:  

Usuário/Senha: user/password  
Usuário/Senha: admin/admin  

Observação: está fixo no código.  


##
### Atualizações

###### Versão 1.0.0 (21/11/2024)
Versão inicial do projeto.  

###### Próxima versão
...  
  