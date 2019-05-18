package entity;

@Entity
@Table(name = "role")
public class Role {

    @Setter
    @Getter

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = IDENTITY)
    @OneToOne(optional=false, mappedBy="role")
    private Long RoleId;

    @Column(name = "role")
    private Long role;

}