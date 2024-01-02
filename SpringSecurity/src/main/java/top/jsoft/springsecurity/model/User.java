package top.jsoft.springsecurity.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * @author psygrammator
 */
@Entity
@Table(name="users")
@NoArgsConstructor
@Data
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String status;
    private String username;
    private String password;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_roles",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id"))
    private List<Role> roles;
}