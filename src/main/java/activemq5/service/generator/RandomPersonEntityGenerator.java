package activemq5.service.generator;

import activemq5.entity.PersonEntity;
import org.springframework.stereotype.Service;

import static java.util.UUID.randomUUID;

@Service
public class RandomPersonEntityGenerator implements RandomGenerator<PersonEntity> {

    @Override
    public PersonEntity generateRandom() {
        return PersonEntity.builder()
            .id(randomUUID().toString())
            .name(randomUUID().toString())
            .surname(randomUUID().toString())
            .patronymic(randomUUID().toString())
            .build();
    }
}
