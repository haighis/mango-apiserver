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
- Run Mango Platform API Server `mvn spring-boot:run`
- Insert Mango Platform Default Data by performing a empty POST request to `http://localhost:7878/api/setup/`
- Install Mango Platform CLI `npm install -g mango-platform-cli`
- Run `mango-cli setup`, create an account by registering `mango-cli register`, login `mango-cli login`
