package entity;

@Entity
@Table(name = "result")
public class Result {

    @Getter
    @Setter

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = IDENTITY)
    @OneToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name="userId")
    private Long userId;

    @Column(name = "achivement")
    @OneToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name="achivementId")
    private Long achivement;

	@Column(name = "status")
	@OneToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name="achivementStatusId")
    private Long status;
}