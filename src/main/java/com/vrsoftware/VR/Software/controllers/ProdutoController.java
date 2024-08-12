package com.vrsoftware.VR.Software.controllers;

import com.vrsoftware.VR.Software.dto.ProdutoDTO;
import com.vrsoftware.VR.Software.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<ProdutoDTO> findAll(){
        List<ProdutoDTO> list = service.findAll();

        return list;
    }

    @GetMapping(value = "/{id}")
    public ProdutoDTO findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> insert(@Valid @RequestBody ProdutoDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ProdutoDTO update(@PathVariable Long id, @Valid @RequestBody ProdutoDTO dto){
        return service.update(id, dto);
    }

    @DeleteMapping (value = "/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}