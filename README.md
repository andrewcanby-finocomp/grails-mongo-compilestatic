# `@GrailsCompileStatic` issue with Mongo Gorm

Static type checking is causing compilation issues with projects using Mongo GORM. When the `@GrailsCompileStatic` is removed, the code compiles and runs correctly.

This exact code works with `@GrailsCompileStatic` in Grails 4.0.13 (see the `grails4` branch)

```
❯ ./gradlew clean build

> Task :compileGroovy
startup failed:
/projects/gcsmongo/grails-app/services/gcsmongo/PersonService.groovy: 24: [Static type checking] - Cannot call com.mongodb.client.MongoCollection <org.bson.Document>#aggregate(java.util.List <? extends java.util.Map <java.lang.String, java.lang.Object>>) with arguments [java.util.List <org.bson.conversions.Bson>] 
 @ line 24, column 54.
    = Person.collection.aggregate([
                                 ^

/projects/gcsmongo/grails-app/services/gcsmongo/PersonService.groovy: 24: [Static type checking] - Cannot find matching method java.lang.Object#first(). Please check if the declared type is correct and if the method exists.
 @ line 24, column 27.
           Document result = Person.collection.aggregate([
                             ^

2 errors
```

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
