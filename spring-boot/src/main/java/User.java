import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.util.Date;

@Entity
class User {
    @Id
    @GeneratedValue
    Long id;

    String username;
    String firstName;
    String lastName;
    Date createdDate;
    Date lastAccessed;

}