package com.hustik.pedidosapi.repositories;

import com.hustik.pedidosapi.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rômulo Göelzer Portolann
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
