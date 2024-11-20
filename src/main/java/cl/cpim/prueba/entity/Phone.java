package cl.cpim.prueba.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "phones")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "El número de teléfono es obligatorio")
    private String number;

    @NotBlank(message = "El código de ciudad es obligatorio")
    private String citycode;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    private String contrycode;

}