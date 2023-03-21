# Mango Platform API Server

## Running
`mvn spring-boot:run`

## Swagger UI
http://localhost:7878/swagger-ui/index.html

## Swagger API Docs
http://localhost:7878/v3/api-docs


  https://www.baeldung.com/spring-boot-rest-client-swagger-codegen
  https://www.mailslurp.com/blog/generate-and-publish-java-openapi-client-with-gradle/


  https://www.baeldung.com/spring-boot-rest-client-swagger-codegen#generate-rest-client-with-openapi-generator

  https://medium.com/javarevisited/generate-api-client-with-openapi-codegen-763e3f2f8703


java -jar openapi-generator-cli.jar generate \
  -i http://petstore.swagger.io/v2/swagger.json \
  --api-package com.baeldung.petstore.client.api \
  --model-package com.baeldung.petstore.client.model \
  --invoker-package com.baeldung.petstore.client.invoker \
  --group-id com.baeldung \
  --artifact-id spring-openapi-generator-api-client \
  --artifact-version 0.0.1-SNAPSHOT \
  -g java \
  -p java8=true \
  --library resttemplate \
  -o spring-openapi-generator-api-client

# Generate Java Client

java -jar openapi-generator-cli.jar generate \
  -i books.json \
  --api-package com.baeldung.petstore.client.api \
  --model-package com.baeldung.petstore.client.model \
  --invoker-package com.baeldung.petstore.client.invoker \
  --group-id com.baeldung \
  --artifact-id spring-openapi-generator-api-client \
  --artifact-version 0.0.1-SNAPSHOT \
  -g java \
  -p java8=true \
  --library resttemplate \
  -o spring-openapi-generator-api-client

# Generate JavaScript Client
npx openapi-generator --input apps.json --outputDir apps-js-client

  java -jar swagger-codegen-cli-2.3.1.jar generate \
  -i swagger.yaml \
  --api-package com.howtodoinjava.example.employee.api \
  --model-package com.howtodoinjava.example.employee.model \
  --group-id com.howtodoinjava.example \
  --artifact-id spring-swagger-codegen-employee \
  --artifact-version 0.0.1-SNAPSHOT \
  -l spring \
  -o spring-swagger-codegen-employee

