package green.belka.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Setter
    @Getter

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne(optional=false, mappedBy="role")
    private Long RoleId;

    @Column(name = "role")
    private Long role;

}