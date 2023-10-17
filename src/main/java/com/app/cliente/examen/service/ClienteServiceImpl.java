package com.app.cliente.examen.service;

import com.app.cliente.examen.model.Cliente;
import com.app.cliente.examen.repository.ClienteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClienteServiceImpl implements  ClienteService{


    private final ClienteRepo clienteRepo;
    @Override
    public Cliente save(Cliente c) {
        return clienteRepo.save(c);
    }

    @Override
    public Cliente update(Cliente c) {
        return clienteRepo.save(c);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepo.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return clienteRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        clienteRepo.deleteById(id);
    }

    @Override
    public void deleteProce(Long id) {
    clienteRepo.deleteProce(id);
    }
}
