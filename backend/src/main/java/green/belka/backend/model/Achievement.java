package green.belka.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "achievements")
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String name;

    private String description;

    private Long cost;

	@OneToOne(optional = false, mappedBy="id")
    private User author;

    private Long limit;

    private LocalDate createDate;

    @PreUpdate
    protected void onUpdate() {
        createDate = LocalDate.now();
    }

    private LocalDate finishDate;
}