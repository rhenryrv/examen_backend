package com.app.cliente.examen.repository;

import com.app.cliente.examen.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClienteRepo extends JpaRepository<Cliente,Long> {
    @Modifying
    @Query(value = "CALL delete_cliente(:id)", nativeQuery = true)
    void deleteProce(@Param("id") Long id);
}
