package com.app.cliente.examen.service;

import com.app.cliente.examen.model.Cliente;

import java.util.List;

public interface ClienteService {
    Cliente save(Cliente c);
    Cliente update(Cliente c);
    List<Cliente> findAll();

    Cliente findById(Long id);
    void deleteById(Long id);
    void deleteProce(Long id);

}
