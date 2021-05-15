package activemq5.repository;

import activemq5.entity.PersonEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Set;

public interface PersonRepository extends MongoRepository<PersonEntity, String> {
    Set<PersonEntity> findByNameLikeIgnoreCase(String nameLike);
}
