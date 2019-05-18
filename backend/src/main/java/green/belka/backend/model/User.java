package green.belka.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Getter
    @Setter

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "role")
    @OneToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name="roleId")
    private Role role;
}