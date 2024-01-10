package personal.proyect.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import personal.proyect.Entities.NotaCredito;
import personal.proyect.Repository.BaseRepository;
import personal.proyect.Repository.NotaCreditoRepository;

import java.util.Date;
import java.util.List;

@Service
public class NotaCreditoServiceImpl extends BaseServiceImpl<NotaCredito,Long> implements NotaCreditoService{
    @Autowired
    private NotaCreditoRepository notacreditoRepository;
    public NotaCreditoServiceImpl(BaseRepository<NotaCredito, Long> baseRepository, NotaCreditoRepository notacreditoRepository) {
        super(baseRepository);
        this.notacreditoRepository = notacreditoRepository;
    }

    @Override
    public Page<NotaCredito> searchRangoImporteNC(int rangoBase,
                                                  int rangoAlto,
                                                  Pageable pageable) throws Exception {
        try {
            Page<NotaCredito> notaCreditos = notacreditoRepository.searchRangoImporteNC(rangoBase,rangoAlto,pageable);
            return notaCreditos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<NotaCredito> searchImporteNC(@Param("importe") int importe,
                                      Pageable pageable) throws Exception {
        try {
            Page<NotaCredito> notaCreditos = notacreditoRepository.searchImporteNC(importe,pageable);
            return notaCreditos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Page<NotaCredito> searchNotaCredito(@Param("fechaNotaCredito") @DateTimeFormat Date fechaNotaCredito,
                                        Pageable pageable)throws Exception {
        try {
            Page<NotaCredito> notaCreditos = notacreditoRepository.searchNotaCredito(fechaNotaCredito,pageable);
            return notaCreditos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }



}
