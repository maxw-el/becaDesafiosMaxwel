package io.github.maxwel.becaDesafiosMaxwel.controllers;

import io.github.maxwel.becaDesafiosMaxwel.domains.Servico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servico")
public class ServicoController {


    @Operation(summary = "Cria um serviço pela id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Serviço criado.",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<Servico> criar(@RequestBody Servico servico) {
        servico.setId(2);

        return ResponseEntity.created(null).body(servico);
    }

    @Operation(summary = "Deleta um serviço pela id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Serviço deletado.",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request",
                    content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Integer id) {

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Atualiza um serviço pela id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Serviço atualizado.",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request",
                    content = @Content)
    })
    @PatchMapping("/{id}")
    public ResponseEntity<Servico> atualizar(@RequestBody Servico servico, @PathVariable Integer id) {
        servico.setId(id);

        return ResponseEntity.ok(servico);
    }

    @Operation(summary = "Obtém um serviço pela id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Ok",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Servico> obter(@PathVariable Integer id) {
        Servico servico = new Servico();
        servico.setId(id);
        servico.setNome("Manicure");
        servico.setPreco(15.00);

        return ResponseEntity.ok(servico);
    }

    @Operation(summary = "Obtém uma lista de serviços.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Ok.",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request",
                    content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<Servico>> listar() {
        Servico servico = new Servico();
        servico.setId(3);
        servico.setNome("Manicure");
        servico.setPreco(15.00);

        return ResponseEntity.ok(
                List.of(
                        servico
                )
        );
    }
}
