package personal.proyect.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import personal.proyect.Entities.Base;


import java.io.Serializable;
import java.util.List;

public interface BaseService <E extends Base,ID extends Serializable>{
    //Provee metodos genericos que pueden ser implementados por las entidades de tipo E que extienden de una clase Base
    //Este servicio maneja un crud basico

    List<E> findAll() throws Exception;
    //Metodo que devuelve todas las entidades

    Page<E> findAll(Pageable pageable) throws Exception;
    //Metodo que devuelve todas las entidades paginadas

    E findById(ID id) throws Exception;
    //Metodo que busca las entidades por el ID

    E save(E entity) throws Exception;
    //Metodo que guarda las entidades

    E update(ID id, E entity) throws Exception;
    //Metodo que actualiza las entidades

    boolean delete(ID id) throws Exception;
}
