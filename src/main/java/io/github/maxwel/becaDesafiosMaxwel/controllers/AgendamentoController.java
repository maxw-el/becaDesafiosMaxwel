package io.github.maxwel.becaDesafiosMaxwel.controllers;

import io.github.maxwel.becaDesafiosMaxwel.domains.Agendamento;
import io.github.maxwel.becaDesafiosMaxwel.domains.Cliente;
import io.github.maxwel.becaDesafiosMaxwel.domains.Servico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

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
        agendamento.setId(2);

        return ResponseEntity.created(null).body(agendamento);
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
        agendamento.setId(id);

        return ResponseEntity.ok(agendamento);
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
        Servico servico = new Servico();
        servico.setId(3);
        servico.setNome("Manicure");
        servico.setPreco(15.00);

        Cliente cliente = new Cliente();
        cliente.setCpf("xxx xxx xxx xx");
        cliente.setNome("Dayse Dourado");

        Agendamento agendamento = new Agendamento();
        agendamento.setId(id);
        agendamento.setServico(servico);
        agendamento.setHorario("23/01 às 10h");
        agendamento.setCliente(cliente);

        return ResponseEntity.ok(agendamento);
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
        Servico servico = new Servico();
        servico.setId(3);
        servico.setNome("Manicure");
        servico.setPreco(15.00);

        Cliente cliente = new Cliente();
        cliente.setCpf("xxx xxx xxx xx");
        cliente.setNome("Dayse Dourado");

        Agendamento agendamento = new Agendamento();
        agendamento.setId(1);
        agendamento.setServico(servico);
        agendamento.setHorario("23/01 às 10h");
        agendamento.setCliente(cliente);

        return ResponseEntity.ok(
                List.of(
                        agendamento
                )
        );
    }
}
