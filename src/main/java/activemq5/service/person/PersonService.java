package activemq5.service.person;

import activemq5.entity.PersonEntity;

import java.util.List;
import java.util.Set;

public interface PersonService {
    PersonEntity save(PersonEntity personEntity);

    List<PersonEntity> findAll();

    Set<PersonEntity> findAllByNameLikeIgnoreCase(String nameLike);

    void deleteById(String id);
}
