package com.hustik.pedidosapi.repositories;

import com.hustik.pedidosapi.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rômulo Göelzer Portolann
 */
@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
