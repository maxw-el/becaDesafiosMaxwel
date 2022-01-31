package io.github.maxwel.becaDesafiosMaxwel.repositories;

import io.github.maxwel.becaDesafiosMaxwel.domains.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
