package personal.proyect.Entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@MappedSuperclass
//Esta anotacion nos permite crear clases base, de las cuales nuestras entidades pueden heredar distintas propiedades
//@Inheritance --> permite mapear las gerencias dentro de la db
//@MappedSuperclass --> solo modela la herencia dentro de POO(desde la db esta herencia es invisible)
//Las propiedades heredadas se copian a la tabla de la entidad mapeada
//favorece la reutilizacion de codigo
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Base implements Serializable {
    //cuando cada entidad herede a base tambien implementa serializable

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
}
