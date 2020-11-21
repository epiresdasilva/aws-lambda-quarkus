# AWS Lambda with Quarkus, GraalVM and Serverless Framework

Install Serverless Framework packages
```
npm install
```

Package lambda function using GraalVM
```
mvn clean install -Pnative -Dnative-image.docker-build=true
```

Deploy your lambda function
```
sls deploy
```
