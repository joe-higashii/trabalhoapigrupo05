package com.trabalhoapigrupo05.trabalhoapigrupo05.service.serviceRacasCaes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhoapigrupo05.trabalhoapigrupo05.model.racasCaes.RacasCaes;
import com.trabalhoapigrupo05.trabalhoapigrupo05.repository.repositoryRacasCaes.RepositoryRacasCaes;

@Service
public class ServicesRacasCaes {
    
    @Autowired
    private RepositoryRacasCaes repositoryRacasCaes;

    // chamou o método listaRacas do Repository
    public List<RacasCaes> listaRacas() {
        return repositoryRacasCaes.listaRacas();
    }

    // chamou o método adcionaRaca do Repository
    public RacasCaes adicionaRaca(RacasCaes racasCaes) {
        return repositoryRacasCaes.adicionaRaca(racasCaes);
    }

    // chamou o método adotaRaça do Repository
    public void adotaRaca(long id) {
        repositoryRacasCaes.adotaRaca(id);
    }
}
