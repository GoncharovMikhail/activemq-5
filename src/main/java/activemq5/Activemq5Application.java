package activemq5;

import activemq5.entity.PersonEntity;
import activemq5.messaging.dispatcher.DispatcherService;
import activemq5.service.generator.RandomGenerator;
import activemq5.service.person.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
@RequiredArgsConstructor
@Slf4j
public class Activemq5Application {
    private final PersonService personService;
    private final RandomGenerator<PersonEntity> personEntityRandomGenerator;
    private final DispatcherService dispatcherService;

    @Scheduled(fixedDelay = 1000L)
    public void addPersons() {
        final PersonEntity personEntity = personEntityRandomGenerator.generateRandom();
        personService.save(personEntity);
        dispatcherService.sendMsg("Created person with id: " + personEntity.getId());
        log.info("Saved new person: {}", personEntity);
    }

    public static void main(String[] args) {
        SpringApplication.run(Activemq5Application.class, args);
    }
}
