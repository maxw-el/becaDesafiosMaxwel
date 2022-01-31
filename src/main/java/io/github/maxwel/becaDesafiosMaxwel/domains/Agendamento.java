package io.github.maxwel.becaDesafiosMaxwel.domains;

import javax.persistence.*;

@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Servico servico;

    private String horario;

    @OneToOne
    private Cliente cliente;

    public Agendamento() {

    }

    public Agendamento(Long id, Servico servico, String horario, Cliente cliente) {
        this.id = id;
        this.servico = servico;
        this.horario = horario;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
