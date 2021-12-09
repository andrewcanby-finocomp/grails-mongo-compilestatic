package gcsmongo


import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.Transactional
import org.bson.Document

import static com.mongodb.client.model.Aggregates.match
import static com.mongodb.client.model.Aggregates.project
import static com.mongodb.client.model.Filters.eq
import static com.mongodb.client.model.Projections.*

@GrailsCompileStatic
@Transactional
class PersonService {

    /**
     * A ridiculously contrived example just to prove that the collection element is missing in Grails 5
     *
     * @param name
     * @return
     */
    Integer findCarsForPerson(String name) {
        Document result = Person.collection.aggregate([
                match(
                        eq('name', name)
                ),
                project(
                        fields(
                                excludeId(),
                                include("name"),
                                computed('numCars', '$carsOwned') // this is just to prove the issue..
                        )
                )
        ]).first()

        return result.get("numCars", Integer)
    }
}
