package com.trabalhoapi05.listaadocao.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalhoapi05.listaadocao.model.Base64FileRequest;
import com.trabalhoapi05.listaadocao.model.RacasCaes;
import com.trabalhoapi05.listaadocao.service.ServicesRacasCaes;

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
        @ApiResponse(responseCode = "400", description = "Não foi possivel encontrar o id."),
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

    // Anotação para documentar a operação da API, descrevendo o resumo e o método
    // HTTP
    @Operation(summary = "Realiza o upload de arquivos do tipo URL convertendo para base-64 no body e armazena no disco físico do servidor", method = "POST")
    // Mapeia a URL da API para manipular solicitações POST para "/upload-base64"
    @PostMapping("/upload-base64")
    public ResponseEntity<String> uploadBase64(@RequestBody Base64FileRequest base64FileRequest) {
        try {
            // Converte a URL da imagem em bytes usando Base64
            URL imageUrl = new URL(base64FileRequest.getImageUrl());
            // Abre um fluxo de entrada para a URL da imagem
            InputStream imageInputStream = imageUrl.openStream();
            // Lê os bytes da imagem e converte para Base64
            byte[] imageBytes = IOUtils.toByteArray(imageInputStream);
            String base64Data = Base64Utils.encodeToString(imageBytes);

            // Decodifica o conteúdo Base64 em bytes
            byte[] fileBytes = Base64Utils.decodeFromString(base64Data);

            // Cria o diretório de destino se não existir
            File directory = new File("C:\\tmp\\arquivo");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Cria o caminho completo para o novo arquivo
            String filePath = directory.getAbsolutePath() + File.separator + base64FileRequest.getFileName();
            // Cria um novo arquivo no caminho especificado
            File newDocument = new File(filePath);
            // Abre um fluxo de saída para o novo arquivo
            FileOutputStream fileOutputStream = new FileOutputStream(newDocument);
            // Escreve os bytes decodificados no arquivo
            fileOutputStream.write(fileBytes);
            // Fecha o fluxo de saída
            fileOutputStream.close();

            // Retorna uma resposta de sucesso com uma mensagem indicando o nome do arquivo
            // carregado
            return ResponseEntity.ok("Arquivo Base64 carregado: " + base64FileRequest.getFileName());
        } catch (IOException e) {
            // Em caso de erro, lança uma exceção RuntimeException com uma mensagem
            // personalizada
            throw new RuntimeException("Erro ao carregar arquivo Base64", e);
        }
    }

    @GetMapping("/fotos/{id}")
    @Operation(summary = "vincula a imagem ao cão")
    @ApiResponses(value = {

        @ApiResponse(responseCode = "200", description = "A foto do cão foi vinculada com sucesso."),
        @ApiResponse(responseCode = "400", description = "O id informado não existe."),
        @ApiResponse(responseCode = "404", description = "Não foi possivel vincular a foto ao cão."),
        @ApiResponse(responseCode = "500", description = "Erro ao vincular a foto ao cão."),
        @ApiResponse(responseCode = "504", description = "Tempo Limite esgotado.")

    })
    // Método que busca dados dos doguinhos com base nos parâmetros de entrada.
    public ResponseEntity<List<RacasCaes>> buscarDoguinhos(@PathVariable long id) {

        return ResponseEntity.ok(servicesRacasCaes.buscarDoguinhos(id));
    }
}
