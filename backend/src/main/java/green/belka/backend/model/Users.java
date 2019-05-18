package entity;

@Entity
@Table(name = "users")
public class User {

    @Getter
    @Setter

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = IDENTITY)
    private Long userId;

    @Column(name = "role")
    @OneToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name="roleId")
    private Role role;
}