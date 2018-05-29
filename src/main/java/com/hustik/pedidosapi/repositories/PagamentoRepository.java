package com.hustik.pedidosapi.repositories;

import com.hustik.pedidosapi.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rômulo Göelzer Portolann
 */
@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

}
