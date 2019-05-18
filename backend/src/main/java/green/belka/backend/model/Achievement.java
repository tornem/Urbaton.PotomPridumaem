package green.belka.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "achievements")
public class Achievement {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Setter
    @Getter
    @ManyToMany(cascade=CascadeType.MERGE)
    @JoinColumn(name = "achievements")
    private List<User> users;

    @Setter
    @Getter
    private String description;

}
//	@OneToOne(optional = false, mappedBy="id")
//    private User author;

    /*
    @Setter
    @Getter
    private Long limit;

    @Setter
    @Getter
    private LocalDate createDate;

    @PreUpdate
    protected void onUpdate() {
        createDate = LocalDate.now();
    }

    @Setter
    @Getter
    private LocalDate finishDate;
    */
