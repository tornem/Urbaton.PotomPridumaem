package entity;

@Entity
@Table(name = "user_informations")
public class UserInformations {

	@Setter
	@Getter

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = IDENTITY)
    @OneToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name="userId")
    private Long userId;

    @Column(name = "username")
	@Setter
    @Getter
    private String username;

    @Column(name = "first_name")
    @Setter
    @Getter
    private String firstName;

	@Column(name = "last_name")
    @Setter
    @Getter
    private String lastName;    

}