package green.belka.backend.model;


import javax.persistence.*;

@Entity
@Table(name = "role")
public enum Role {
    ADMIN,
    USER
}