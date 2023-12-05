package personal.proyect.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import personal.proyect.Entities.Base;
import personal.proyect.Repository.BaseRepository;


import java.io.Serializable;
import java.util.List;
import java.util.Optional;
public class BaseServiceImpl<E extends Base, ID extends Serializable> implements BaseService<E, ID> {
    //BaseServiceImpl --> implementa la interfaz BaseService (toma los parametros E(tipo entidad) y ID(representando el tipo de indentificador de entidad))
    //extiende o implementa los metodos declarados en BaseService


    protected BaseRepository<E,ID> baseRepository;
    //baseRepository se utliza para interactuar con los datos almacenados en la db, para hacer operaciones CRUD

    public BaseServiceImpl(BaseRepository<E, ID> baseRepository) {
        //constructor que toma baseRepository como parametro
        this.baseRepository = baseRepository;
        //cuando una instancia de BaseServiceImpl se crea, necesita un BaseRepository para trabajar
        //el constructor inicializa baseRepository con el repositorio
    }

    @Override
    //sobreescribe el metodo declarado en BaseService
    @Transactional
    //si algo en el metodo falla (varias partes) el metodo no devuelve nada
    public List<E> findAll() throws Exception {
        try {
            List<E> entities = baseRepository.findAll();
            //llama al metodo findAll de baseRepository
            //devuelve una lista de entidades
            return entities;
        } catch (Exception e) {
            //si una excepcion ocurre se agarra aca
            //La excepción se vuelve a lanzar después de envolverla en una nueva excepción con el mismo mensaje
            throw new Exception(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Page<E> findAll(Pageable pageable) throws Exception {
        try {
            Page<E> entities = baseRepository.findAll(pageable);
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E findById(ID id) throws Exception {
        try{
            //encuentra entidad por el id
            Optional<E> entityOptional = baseRepository.findById(id);
            //devuelve la entidad si se encuentra por eso es optional
            return entityOptional.get();
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E save(E entity) throws Exception {
        try{
            entity = baseRepository.save(entity);
            return entity;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E update(ID id, E entity) throws Exception {
        try{
            Optional<E> entityOptional = baseRepository.findById(id);
            E entityUpdate = entityOptional.get();
            entityUpdate = baseRepository.save(entity);
            return entityUpdate;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(ID id) throws Exception {
        try{
            if(baseRepository.existsById(id)){
                baseRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
