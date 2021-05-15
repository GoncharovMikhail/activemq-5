package activemq5.rest;

import activemq5.entity.PersonEntity;
import activemq5.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonManagementController {
    private final PersonService personService;

    @Autowired
    public PersonManagementController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/all")
    private ResponseEntity<List<PersonEntity>> findAll() {
        final List<PersonEntity> all = personService.findAll();
        return ResponseEntity.ok(all);
    }
}
