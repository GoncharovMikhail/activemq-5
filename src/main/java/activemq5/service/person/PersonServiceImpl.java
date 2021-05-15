package activemq5.service.person;

import activemq5.entity.PersonEntity;
import activemq5.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public PersonEntity save(PersonEntity personEntity) {
        return personRepository.save(personEntity);
    }

    @Override
    public List<PersonEntity> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Set<PersonEntity> findAllByNameLikeIgnoreCase(String nameLike) {
        return personRepository.findByNameLikeIgnoreCase(nameLike);
    }

    @Override
    public void deleteById(String id) {
        personRepository.deleteById(id);
    }
}
