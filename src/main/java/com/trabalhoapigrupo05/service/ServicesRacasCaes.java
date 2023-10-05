package com.trabalhoapigrupo05.service;

import java.util.InputMismatchException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhoapigrupo05.model.RacasCaes;
import com.trabalhoapigrupo05.repository.RepositoryRacasCaes;

@Service
public class ServicesRacasCaes {
    
    @Autowired
    private RepositoryRacasCaes repositoryRacasCaes;

    // chamou o método listaRacas do Repository
    public List<RacasCaes> listaRacas() {
        return repositoryRacasCaes.listaRacas();
    }

    // chamou o método buscarId do Repository
    public RacasCaes buscarId(long id) {
        return repositoryRacasCaes.buscarId(id);
    }

    // chamou o método adcionaRaca do Repository
    public RacasCaes adicionaRaca(RacasCaes racasCaes) {
        return repositoryRacasCaes.adicionaRaca(racasCaes);
    }

    // chamou o método alterarCaes do Repository
    public RacasCaes alterarCaes(long id, RacasCaes racasCaes) {

        RacasCaes caoEncontrado = repositoryRacasCaes.buscarId(id);

        if (caoEncontrado == null) {
            throw new InputMismatchException("não foi possivel atualizar a raça do cão com o id " + id);
        }

        racasCaes.setId(id); 

        return repositoryRacasCaes.alterarCaes(racasCaes);
    }

    // chamou o método adotaRaça do Repository
    public void adotaRaca(long id) {
        repositoryRacasCaes.adotaRaca(id);
    }
}
