package ugtsic.sesaprn.testedesenv.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ugtsic.sesaprn.testedesenv.models.Curriculo;
import ugtsic.sesaprn.testedesenv.repositories.CurriculoRepository;

@Service
public class CurriculoService {

    @Autowired
    private CurriculoRepository curriculoRepository;


    public void saveCurriculum(Curriculo curriculo) {
        curriculoRepository.save(curriculo);
    }


}
