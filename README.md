# `@GrailsCompileStatic` issue with Mongo Gorm

## Steps

### Grails 4
1. Start a mongodb for test
   ```shell
   docker run -it -p 27017:27017 --rm --name test-mongo mongo:latest
   ```
2. Checkout the `grails4` branch
   ```shell
   git checkout grails4
   ```
3. Compile the project
4. Run the test in `PersonServiceSpec`

### Grails 5
1. Start a mongodb for test
   ```shell
   docker run -it -p 27017:27017 --rm --name test-mongo mongo:latest
   ```
2. Checkout the `grails5` branch
   ```shell
   git checkout grails5
   ```
3. Compile the project - ERROR
4. Comment out `@GrailsCompileStatic` in `PersonService`
5. Compile the project
6. Run the test in `PersonServiceSpec`
