package top.jsoft.springsecurity.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author psygrammator
 */
@Entity
@Table(name="roles")
@NoArgsConstructor
@Data
@ToString
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

}