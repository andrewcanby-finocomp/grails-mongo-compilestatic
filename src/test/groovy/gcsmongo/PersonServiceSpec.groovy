package gcsmongo


import grails.test.mongodb.MongoSpec
import grails.testing.services.ServiceUnitTest

class PersonServiceSpec extends MongoSpec implements ServiceUnitTest<PersonService> {

    def "Test can find the number of cars for a person"() {
        given:
        new Person(name: "Test 1", carsOwned: 9).save(flush: true, failOnError: true)
        new Person(name: "Test 2", carsOwned: 4).save(flush: true, failOnError: true)

        when: "Finding their cars"
        int numCars = service.findCarsForPerson("Test 1")

        then: "The right number is returned"
        numCars == 9

        cleanup:
        Person.all.each {
            it.delete()
        }
    }
}
