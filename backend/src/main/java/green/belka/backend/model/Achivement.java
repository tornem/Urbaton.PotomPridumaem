package entity;

@Entity
@Table(name = "achivement")
public class UserInformations {

    @Setter
    @Getter

    @Id
    @Column(name = "achivement_id")
    @GeneratedValue(strategy = IDENTITY)
    @OneToOne(optional=false, mappedBy="achivement")
    private Long achivementId;

    @Column(name = "name")
	private String name;

    @Column(name = "discription")
    private String discription;

    @Column(name = "value")
    private Long value;

	@Column(name = "author_id")
    @OneToOne(optional = false, mappedBy="id")
    private User author;

    @Column(name = "limit")
    private Long limit;

    @Column(name = "create_date")
    private Data createDate;
    @PreUpdate
    protected void onUpdate() {
        createDate = new Date();
    }

    @Column(name = "finish_date")
    private Data finishDate;
    @PreUpdate
    protected void onUpdate() {
        finishDate = new Date();
    }
}