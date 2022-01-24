package io.github.maxwel.becaDesafiosMaxwel.controllers;

import io.github.maxwel.becaDesafiosMaxwel.domains.Cliente;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Operation(summary = "Cria um cliente pelo cpf.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Cliente criado.",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente) {
        cliente.setCpf("xxx xxx xxx xx");

        return ResponseEntity.created(null).body(cliente);
    }

    @Operation(summary = "Deleta um cliente pelo cpf.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Cliente deletado.",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request",
                    content = @Content)
    })
    @DeleteMapping("/{cpf}")
    public ResponseEntity deletar(@PathVariable String cpf) {

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Atualiza um cliente pelo cpf.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Cliente atualizado.",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request",
                    content = @Content)
    })
    @PatchMapping("/{cpf}")
    public ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente, @PathVariable String cpf) {
        cliente.setCpf(cpf);

        return ResponseEntity.ok(cliente);
    }

    @Operation(summary = "Obtém um cliente pelo cpf.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Ok",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request",
                    content = @Content)
    })
    @GetMapping("/{cpf}")
    public ResponseEntity<Cliente> obter(@PathVariable String cpf) {
        Cliente cliente = new Cliente();
        cliente.setCpf(cpf);
        cliente.setNome("Dayse Dourado");

        return ResponseEntity.ok(cliente);
    }

    @Operation(summary = "Obtém uma lista de clientes.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Ok.",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request",
                    content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        Cliente cliente = new Cliente();
        cliente.setCpf("xxx xxx xxx xx");
        cliente.setNome("Dayse Dourado");

        return ResponseEntity.ok(
                List.of(
                        cliente
                )
        );
    }
}
