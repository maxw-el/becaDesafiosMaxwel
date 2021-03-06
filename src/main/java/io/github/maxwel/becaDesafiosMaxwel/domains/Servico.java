package io.github.maxwel.becaDesafiosMaxwel.domains;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@Data
@EqualsAndHashCode
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode ser vazio")
    @Size(max = 80, message = "O nome é muito grande")
    private String nome;

    @Min(value = 0, message = "Preco inválido")
    private Double preco;

}