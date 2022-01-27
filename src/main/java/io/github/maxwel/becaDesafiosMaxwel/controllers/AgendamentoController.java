package io.github.maxwel.becaDesafiosMaxwel.controllers;

import io.github.maxwel.becaDesafiosMaxwel.domains.Agendamento;
import io.github.maxwel.becaDesafiosMaxwel.services.AgendamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @Operation(summary = "Cria um agendamento pela id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Agendamento criado.",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<Agendamento> criar(@RequestBody Agendamento agendamento) {
        Agendamento agendamentoCriado = agendamentoService.criar(agendamento);

        return ResponseEntity.created(null).body(agendamentoCriado);
    }

    @Operation(summary = "Deleta um agendamento pela id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Agendamento deletado.",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request",
                    content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Integer id) {
        agendamentoService.deletar(id);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Atualiza um agendamento pela id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Agendamento atualizado.",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request",
                    content = @Content)
    })
    @PatchMapping("/{id}")
    public ResponseEntity<Agendamento> atualizar(@RequestBody Agendamento agendamento, @PathVariable Integer id) {
        Agendamento agendamentoAtualizado = agendamentoService.atualizar(agendamento, id);

        return ResponseEntity.ok(agendamentoAtualizado);
    }

    @Operation(summary = "Obtém um agendamento pela id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Ok",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Agendamento> obter(@PathVariable Integer id) {
        Agendamento agendamentoObtido = agendamentoService.obter(id);

        return ResponseEntity.ok(agendamentoObtido);
    }

    @Operation(summary = "Obtém uma lista de agendamentos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Ok.",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request",
                    content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<Agendamento>> listar() {
        List<Agendamento> listaAgendamentos = agendamentoService.listar();

        return ResponseEntity.ok(listaAgendamentos);
    }
}
