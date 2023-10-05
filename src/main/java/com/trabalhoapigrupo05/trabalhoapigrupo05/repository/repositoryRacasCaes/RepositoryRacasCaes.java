package com.trabalhoapigrupo05.trabalhoapigrupo05.repository.repositoryRacasCaes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.trabalhoapigrupo05.trabalhoapigrupo05.model.racasCaes.RacasCaes;

@Repository
public class RepositoryRacasCaes {
    
    private List<RacasCaes> RacasCaes = new ArrayList<>();

    private long ultimoId = 0;

    // metodo para listar as raças de cães disponíveis
    public List<RacasCaes> listaRacas() {
        return RacasCaes;
    }

    // método para adicionar a raca do cao a lista
    public RacasCaes adicionaRaca(RacasCaes racasCaes) {

        ultimoId++;

        racasCaes.setId(ultimoId);

        RacasCaes.add(racasCaes);

        return racasCaes;
    }

    // método para adotar o cao e remover da lista
    public void adotaRaca(long id) {
        RacasCaes.removeIf(r -> r.getId() == id);
    }
}
