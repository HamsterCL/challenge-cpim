package cl.cpim.prueba.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @Pattern(regexp="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message="El formato del correo no es válido")
    @NotBlank(message = "El correo es obligatorio")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$",
            message = "La contraseña debe tener al menos 8 caracteres, incluir una letra mayúscula y un número"
    )
    private String password;
    private LocalDateTime created;
    private LocalDateTime modified;
    private LocalDateTime lastLogin;
    private String token;
    private boolean isActive;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @NotNull(message = "La lista de teléfonos no puede ser nula")
    @Size(min = 1, message = "Debe incluir al menos un teléfono")
    private List<Phone> phones;

}
