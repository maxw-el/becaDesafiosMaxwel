package io.github.maxwel.becaDesafiosMaxwel.domains;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @Setter
    private Servico servico;

    @Setter
    private String horario;

    @OneToOne
    @Setter
    private Cliente cliente;
}
