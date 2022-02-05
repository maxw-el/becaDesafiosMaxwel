package io.github.maxwel.becaDesafiosMaxwel.controllers;

import io.github.maxwel.becaDesafiosMaxwel.domains.Agendamento;
import io.github.maxwel.becaDesafiosMaxwel.dtos.requests.PostAgendamentoRequestDto;
import io.github.maxwel.becaDesafiosMaxwel.dtos.responses.GetAgendamentoListarResponseDto;
import io.github.maxwel.becaDesafiosMaxwel.dtos.responses.PostAgendamentoResponseDto;
import io.github.maxwel.becaDesafiosMaxwel.services.AgendamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamento")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

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
    public ResponseEntity<PostAgendamentoResponseDto> criar(@RequestBody PostAgendamentoRequestDto postAgendamentoRequestDto) {
        PostAgendamentoResponseDto postAgendamentoResponseDto = agendamentoService.criar(postAgendamentoRequestDto);

        return ResponseEntity.created(null).body(postAgendamentoResponseDto);
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
    public ResponseEntity deletar(@PathVariable Long id) {
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
    public ResponseEntity<Agendamento> atualizar(@RequestBody Agendamento agendamento, @PathVariable Long id) {
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
    public ResponseEntity<Agendamento> obter(@PathVariable Long id) {
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
    public ResponseEntity<List<GetAgendamentoListarResponseDto>> listar() {
        List<GetAgendamentoListarResponseDto> getAgendamentoListarResponseDto = agendamentoService.listar();

        return ResponseEntity.ok(getAgendamentoListarResponseDto);
    }
}