package personal.proyect.Entities;

import jakarta.persistence.*;
import lombok.*;
import personal.proyect.Enums.Rol;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Usuario", uniqueConstraints = {@UniqueConstraint(columnNames = {"username", "email"})})
public class Usuario extends Base {

    @Basic
    @Column(nullable = false, name = "username")
    private String username;
    @Column(nullable = false, name = "password")
    private String password;
    @Column(nullable = false, name = "email")
    private String email;
    @Column(nullable = false, name = "nombre")
    private String firstname;
    @Column(nullable = false, name = "apellido")
    private String lastname;
    @Enumerated(EnumType.STRING)
    Rol rol;
}