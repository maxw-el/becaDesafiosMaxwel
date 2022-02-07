package io.github.maxwel.becaDesafiosMaxwel.domains;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@EqualsAndHashCode
public class Cliente {

    @Id
    @CPF(message = "CPF inválido")
    private String cpf;

    @NotBlank(message = "Nome não pode ser vazio")
    @Size(max = 80, message = "O nome é muito grande")
    private String nome;

}
