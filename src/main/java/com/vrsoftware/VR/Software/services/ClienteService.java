package com.vrsoftware.VR.Software.services;

import com.vrsoftware.VR.Software.dto.ClienteDTO;
import com.vrsoftware.VR.Software.entities.Cliente;
import com.vrsoftware.VR.Software.repositories.ClienteRepository;
import com.vrsoftware.VR.Software.services.Exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    public List<ClienteDTO> findAll(){
        List<Cliente> listCliente = clienteRepository.findAll();

        return listCliente.stream().map(x -> new ClienteDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public ClienteDTO findById(Long id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
        ClienteDTO dto =new ClienteDTO(cliente);

        return dto;
    }

    @Transactional(readOnly = false)
    public Cliente insert(Cliente cli) {
        Cliente cliente = new Cliente();
        cliente.setNome(cli.getNome());
        cliente.setLimiteCompra(cli.getLimiteCompra());
        cliente.setFechamentoFatura(cli.getFechamentoFatura());

        cliente = clienteRepository.save(cliente);
        return new Cliente(cliente);
    }

    @Transactional(readOnly = false)
    public ClienteDTO update(Long id, ClienteDTO dto) {
        try{

            Cliente cliente = clienteRepository.getReferenceById(id);
            cliente.setNome(dto.getNome());
            cliente.setLimiteCompra(dto.getLimiteCompra());
            cliente.setFechamentoFatura(dto.getFechamentoFatura());

            cliente = clienteRepository.save(cliente);
            return new ClienteDTO(cliente);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Cliente não encontrado ou inexistente");
        }

    }

    @Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        if (!clienteRepository.existsById(id)){
            throw new ResourceNotFoundException("Elemento não encontrado ou inexistente!");
        }

        clienteRepository.deleteById(id);
    }

}