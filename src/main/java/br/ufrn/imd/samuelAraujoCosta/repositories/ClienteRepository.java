package br.ufrn.imd.samuelAraujoCosta.repositories;

import br.ufrn.imd.samuelAraujoCosta.model.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
}