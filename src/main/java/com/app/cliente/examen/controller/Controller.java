package com.app.cliente.examen.controller;

import com.app.cliente.examen.dto.ClienteDto;
import com.app.cliente.examen.model.Cliente;
import com.app.cliente.examen.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/clientes")
public class Controller {

  private final ClienteService clienteService;
  private final ModelMapper mapper;
    @GetMapping
    public ResponseEntity<?> findAll() throws Exception {

        List<ClienteDto> clienteDtoList= clienteService.findAll().stream().map(p -> mapper.map(
                p, ClienteDto.class)).collect(Collectors.toList());
        return new ResponseEntity<>(clienteDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> findById(@PathVariable Long id) throws Exception {
        Cliente cliente = clienteService.findById(id);
        if( cliente == null){

            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);

        }
        ClienteDto  clienteDto= mapper.map(cliente, ClienteDto.class);

        return new ResponseEntity<>(clienteDto,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClienteDto> save(@RequestBody ClienteDto clienteDto) throws Exception {
        Cliente cliente =mapper.map(clienteDto, Cliente.class);

        return  new ResponseEntity<>(mapper.map(clienteService.save(cliente),ClienteDto.class),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update( @RequestBody ClienteDto clienteDto) throws Exception {
        Cliente obj=clienteService.findById(clienteDto.getId());
        if(obj == null){
            return new ResponseEntity<>("Cliente no encontrado: ",HttpStatus.NO_CONTENT);
        }

        Cliente cliente =mapper.map( clienteDto, Cliente.class);
        return  new ResponseEntity<>(mapper.map(clienteService.save(cliente),ClienteDto.class),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete( @PathVariable("id") Long id) throws Exception {
        Cliente cliente = clienteService.findById(id);
        if(cliente == null){
            return new ResponseEntity<>("Clienteo no encontrado: " + id,HttpStatus.NO_CONTENT);
        }
        clienteService.deleteById(id);
        return new ResponseEntity<>("Eliminado", HttpStatus.NO_CONTENT) ;
    }

}
