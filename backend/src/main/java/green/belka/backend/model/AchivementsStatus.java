package green.belka.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "achivement_status")
public class AchivementsStatus {

    @Getter
    @Setter

    @Id
    @Column(name = "achivements_status_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne(optional=false, mappedBy="status")
    private Long achivementStatusId;

    @Column(name = "achivement_status")
    private String status;
}