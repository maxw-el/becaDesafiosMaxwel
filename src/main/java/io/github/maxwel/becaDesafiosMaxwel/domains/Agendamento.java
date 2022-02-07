package io.github.maxwel.becaDesafiosMaxwel.domains;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Servico servico;

    private String horario;

    @OneToOne
    private Cliente cliente;
}
