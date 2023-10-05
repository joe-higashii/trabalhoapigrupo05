package com.trabalhoapigrupo05.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.trabalhoapigrupo05.model.RacasCaes;

@Repository
public class RepositoryRacasCaes {
    
    private List<RacasCaes> RacasCaes = new ArrayList<>();

    private long ultimoId = 0;

    // metodo para listar as raças de cães disponíveis
    public List<RacasCaes> listaRacas() {
        return RacasCaes;
    }

    // metodo para buscar cão por id
    public RacasCaes buscarId(long id) {

        RacasCaes caoEncontrado = null;

        for (RacasCaes racasCaes : RacasCaes) {
            if (racasCaes.getId() == id) {
                caoEncontrado = racasCaes;
            }
        }

        return caoEncontrado;
    }

    // método para adicionar a raca do cao a lista
    public RacasCaes adicionaRaca(RacasCaes racasCaes) {

        ultimoId++;

        racasCaes.setId(ultimoId);
        RacasCaes.add(racasCaes);

        return racasCaes;
    }

    // método para atualizar a raca do cao na lista
    public RacasCaes alterarCaes(RacasCaes racasCaes) {

        RacasCaes.removeIf(r -> r.getId() == racasCaes.getId());
        RacasCaes.add(racasCaes);

        return racasCaes;
    }

    // método para adotar o cao e remover da lista
    public void adotaRaca(long id) {
        RacasCaes.removeIf(r -> r.getId() == id);
    }    
}