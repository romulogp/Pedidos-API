package com.hustik.pedidosapi.repositories;

import com.hustik.pedidosapi.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rômulo Göelzer Portolann
 */
@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
