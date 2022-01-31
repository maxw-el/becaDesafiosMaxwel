package io.github.maxwel.becaDesafiosMaxwel.repositories;

import io.github.maxwel.becaDesafiosMaxwel.domains.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
