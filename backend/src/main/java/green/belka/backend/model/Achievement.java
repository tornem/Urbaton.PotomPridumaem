package green.belka.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "achievement")
public class Achievement {

    @Setter
    @Getter

    @Id
    @Column(name = "achivement_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne(optional=false, mappedBy="achivement")
    private Long achivementId;

    @Column(name = "name")
	private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "value")
    private Long value;

	@Column(name = "author_id")
    @OneToOne(optional = false, mappedBy="id")
    private User author;

    @Column(name = "limit")
    private Long limit;

    @Column(name = "create_date")
    private LocalDate createDate;

    @PreUpdate
    protected void onUpdate() {
        createDate = LocalDate.now();
    }

    @Column(name = "finish_date")
    private LocalDate finishDate;
//    @PreUpdate
//    protected void onUpdate() {
//        finishDate = new LocalDate();
//    }
}