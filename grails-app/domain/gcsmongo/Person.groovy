package gcsmongo

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.bson.types.ObjectId

@ToString(includeNames = true)
@EqualsAndHashCode(includes = "name")
class Person {

    static mapWith = "mongo"
    static constraints = {
    }

    ObjectId id
    String name
    Integer carsOwned
}
