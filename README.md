# Mango Platform API Server
Mango Platform API Server Java version. 
## Running
`mvn spring-boot:run`

## Swagger UI
http://localhost:7878/swagger-ui/index.html

## Swagger API Docs
http://localhost:7878/v3/api-docs

# Getting Started
- Create a Postgres Database called `MangoDB`
- Set a connection string at `src/main/resources/application.properties`
- Run Mango Platform API Server `mvn spring-boot:run`
- Insert Mango Platform Default Data by performing a empty POST request to `http://localhost:7878/api/setup/`
- See Mango Platform CLI for a Mango Platform API Server utility. Install Mango Platform CLI `npm install -g mango-platform-cli`
