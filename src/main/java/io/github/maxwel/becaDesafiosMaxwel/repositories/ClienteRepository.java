package io.github.maxwel.becaDesafiosMaxwel.repositories;

import io.github.maxwel.becaDesafiosMaxwel.domains.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

}
