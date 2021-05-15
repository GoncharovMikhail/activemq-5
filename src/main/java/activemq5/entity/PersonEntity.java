package activemq5.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Mongo domain
 */
@Document(collection = "person")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonEntity {
    @Id
    @Field(name = "id")
    private String id;
    @Field(name = "name")
    private String name;
    @Field(name = "surname")
    private String surname;
    @Field(name = "patronymic")
    private String patronymic;
}
