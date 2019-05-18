package green.belka.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    @OneToMany(cascade=CascadeType.ALL)
    private List<Achievement> achievements;

    @Setter
    @Getter
    private Role role;

    @Getter
    @Setter
    private String nickname;


}