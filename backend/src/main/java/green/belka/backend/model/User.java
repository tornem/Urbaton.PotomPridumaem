package green.belka.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
    @OneToMany
    private Set<Achievement> achievements;

    @Setter
    @Getter
    private Role role;

    @Getter
    @Setter
    private String nickname;


}