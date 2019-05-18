package green.belka.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "achievements")
public class Achievement {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

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
