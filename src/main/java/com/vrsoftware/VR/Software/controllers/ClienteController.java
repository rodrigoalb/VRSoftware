package com.vrsoftware.VR.Software.controllers;

import com.vrsoftware.VR.Software.dto.ClienteDTO;
import com.vrsoftware.VR.Software.entities.Cliente;
import com.vrsoftware.VR.Software.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public List<ClienteDTO> findAll(){
        List<ClienteDTO> list = service.findAll();

        return list;
    }

    @GetMapping(value = "/{id}")
    public ClienteDTO findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Cliente> insert(@Valid @RequestBody Cliente cli){
        cli = service.insert(cli);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cli.getId()).toUri();

        return ResponseEntity.created(uri).body(cli);
    }

    @PutMapping(value = "/{id}")
    public ClienteDTO update(@PathVariable Long id, @Valid @RequestBody ClienteDTO dto){
        return service.update(id, dto);
    }

    @DeleteMapping (value = "/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}