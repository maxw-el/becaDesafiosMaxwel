package io.github.maxwel.becaDesafiosMaxwel;

public class Agendamento {

    Integer id;
    Servico servico;
    String horario;
    Cliente cliente;

    public Agendamento(Servico servico, String horario, Cliente cliente) {
        this.servico = servico;
        this.cliente = cliente;
        this.horario = horario;
    }


    public Servico getServico() {
        return servico;
    }

    public String getHorario() {
        return horario;
    }

    public Cliente getCliente() {
        return cliente;
    }


}
