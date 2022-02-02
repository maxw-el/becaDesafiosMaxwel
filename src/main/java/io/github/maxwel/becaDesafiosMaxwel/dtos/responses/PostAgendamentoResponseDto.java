package io.github.maxwel.becaDesafiosMaxwel.dtos.responses;

import io.github.maxwel.becaDesafiosMaxwel.domains.Servico;

public class PostAgendamentoResponseDto {

    private Servico servico;
    private String horario;
    private String mensagem;

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
