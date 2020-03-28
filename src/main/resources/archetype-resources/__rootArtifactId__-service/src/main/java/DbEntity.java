package $package;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class DbEntity {

    @Id
    private Long id;
    private String name;
}