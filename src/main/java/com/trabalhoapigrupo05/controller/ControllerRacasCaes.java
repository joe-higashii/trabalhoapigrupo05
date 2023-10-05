package com.trabalhoapigrupo05.controller;

import java.util.InputMismatchException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalhoapigrupo05.model.RacasCaes;
import com.trabalhoapigrupo05.service.ServicesRacasCaes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/racas-caes")
@Tag(name = "/api/racas-caes")
public class ControllerRacasCaes {

    @Autowired
    private ServicesRacasCaes servicesRacasCaes;


    //-------------------------- Metodo listaRacas ------------------------------------ 
    @GetMapping
    @Operation(summary = "Lista todos os cães")
    //#region ApiResponses'a
    @ApiResponses(value = {

        @ApiResponse(responseCode = "200", description = "Todos os cães foram encontrados."),
        @ApiResponse(responseCode = "404", description = "Não foi possivel encontrar a lista."),
        @ApiResponse(responseCode = "500", description = "Erro ao localizar a lista."),
        @ApiResponse(responseCode = "504", description = "Tempo Limite esgotado.")

    })
    //#endregion
    public ResponseEntity<List<RacasCaes>> listaRacas() {

        return ResponseEntity.ok(servicesRacasCaes.listaRacas());
    }

    //-------------------------- Metodo buscarId ------------------------------------ 
    @GetMapping("/{id}")
    @Operation(summary = "Busca um cão pelo id")
    //#region ApiResponses'a
    @ApiResponses(value = {

        @ApiResponse(responseCode = "200", description = "O cão foi encontrado com sucesso."),
        @ApiResponse(responseCode = "400", description = "O id informado não existe."),
        @ApiResponse(responseCode = "404", description = "Não foi possivel encontrar o cão."),
        @ApiResponse(responseCode = "500", description = "Erro ao localizar o cão."),
        @ApiResponse(responseCode = "504", description = "Tempo Limite esgotado.")

    })
    //#endregion
    public ResponseEntity<RacasCaes> buscarId(@PathVariable long id) {

        RacasCaes caoEncontrado = servicesRacasCaes.buscarId(id);

        if (caoEncontrado == null) {
            throw new InputMismatchException("Não foi possivel encontrar o id");
        }

        return ResponseEntity.ok(servicesRacasCaes.buscarId(id));
    }

    //-------------------------- Metodo adicionaRaca ------------------------------------ 
    @PostMapping
    @Operation(summary = "Adiciona um cão a lista de cães")
    //#region ApiResponses'a
    @ApiResponses(value = {

        @ApiResponse(responseCode = "200", description = "O cão foi adicionado com sucesso."),
        @ApiResponse(responseCode = "404", description = "Não foi possivel adicionar o cão."),
        @ApiResponse(responseCode = "500", description = "Erro ao adicionar o cão."),
        @ApiResponse(responseCode = "504", description = "Tempo Limite esgotado.")

    })
    //#endregion
    public ResponseEntity<RacasCaes> adicionaRaca(@RequestBody RacasCaes racasCaes) {

        servicesRacasCaes.adicionaRaca(racasCaes);
        return new ResponseEntity<>(racasCaes, HttpStatus.CREATED);
    }

    //-------------------------- Metodo alterarCaes ------------------------------------ 
    @PutMapping("/{id}")
    @Operation(summary = "Altera os dados do cão informado")
    //#region ApiResponses'a
    @ApiResponses(value = {

        @ApiResponse(responseCode = "200", description = "O cão foi atualizado com sucesso."),
        @ApiResponse(responseCode = "400", description = "O id informado não existe."),
        @ApiResponse(responseCode = "404", description = "Não foi possivel atualizar o cão."),
        @ApiResponse(responseCode = "500", description = "Erro ao atualizar o cão."),
        @ApiResponse(responseCode = "504", description = "Tempo Limite esgotado.")

    })
    //#endregion
    public ResponseEntity<RacasCaes> alterarCaes(@PathVariable long id, @RequestBody RacasCaes racasCaes) {

        RacasCaes racasCaesAtualizado = servicesRacasCaes.alterarCaes(id, racasCaes);
        return ResponseEntity.ok(racasCaesAtualizado);
    }

    //-------------------------- Metodo adotaRaca ------------------------------------ 
    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um cão da lista de cães")
    //#region ApiResponses'a
    @ApiResponses(value = {

        @ApiResponse(responseCode = "200", description = "O cão foi adotado com sucesso."),
        @ApiResponse(responseCode = "400", description = "O id informado não existe."),
        @ApiResponse(responseCode = "404", description = "Não foi possivel adotar o cão."),
        @ApiResponse(responseCode = "500", description = "Erro ao adotar o cão."),
        @ApiResponse(responseCode = "504", description = "Tempo Limite esgotado.")

    })
    //#endregion
    public ResponseEntity<RacasCaes> adotaRaca(@PathVariable long id) {

        servicesRacasCaes.adotaRaca(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
