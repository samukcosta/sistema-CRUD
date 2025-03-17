package br.ufrn.imd.samuelAraujoCosta.repositories;

import br.ufrn.imd.samuelAraujoCosta.model.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
}