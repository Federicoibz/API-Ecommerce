package personal.proyect.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import personal.proyect.Entities.UnidadMedida;
import personal.proyect.Repository.BaseRepository;
import personal.proyect.Repository.UnidadMedidaRepository;

import java.util.List;

@Service
public class UnidadMedidaServiceImpl extends BaseServiceImpl<UnidadMedida, Long> implements UnidadMedidaService{

    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;

    public UnidadMedidaServiceImpl(BaseRepository<UnidadMedida, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<UnidadMedida> search(String filtro) throws Exception {
        try {
            //List<UnidadMedida> unidadesmedida = unidadmedidaRepository.findByDenominacionContaining(filtro, filtro);
            //List<UnidadMedida> unidadesmedida = unidadmedidaRepository.search(filtro);
            List<UnidadMedida> unidadesmedida = unidadMedidaRepository.searchNativo(filtro);

            return unidadesmedida;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<UnidadMedida> search(String filtro, Pageable pageable) throws Exception {
        try {
            //Page<UnidadMedida> unidadesmedida = unidadmedidaRepository.findByDenominacionContaining(filtro, filtro, pageable);
            //Page<UnidadMedida> unidadesmedida = unidadmedidaRepository.search(filtro, pageable);
            Page<UnidadMedida> unidadesmedida = unidadMedidaRepository.searchNativo(filtro, pageable);

            return unidadesmedida;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
