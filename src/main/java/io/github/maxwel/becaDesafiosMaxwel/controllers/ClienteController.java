package io.github.maxwel.becaDesafiosMaxwel.controllers;

import io.github.maxwel.becaDesafiosMaxwel.domains.Cliente;
import io.github.maxwel.becaDesafiosMaxwel.services.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;

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
    public ResponseEntity<Cliente> criar(@RequestBody @Valid Cliente cliente) {
        Cliente clienteCriado = clienteService.criar(cliente);

       return ResponseEntity.created(null).body(clienteCriado);
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
        clienteService.deletar(cpf);

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
        Cliente clienteAtualizado = clienteService.atualizar(cliente, cpf);

        return ResponseEntity.ok(clienteAtualizado);
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
        Cliente clienteObtido = clienteService.obter(cpf);

        return ResponseEntity.ok(clienteObtido);
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
        List<Cliente> listaClientes = clienteService.listar();

        return ResponseEntity.ok(listaClientes);

    }

}
