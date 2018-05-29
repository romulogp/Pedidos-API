package com.hustik.pedidosapi.repositories;

import com.hustik.pedidosapi.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rômulo Göelzer Portolann
 */
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
