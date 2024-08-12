package com.vrsoftware.VR.Software.services;

import com.vrsoftware.VR.Software.dto.ProdutoDTO;
import com.vrsoftware.VR.Software.entities.Produto;
import com.vrsoftware.VR.Software.repositories.ProdutoRepository;
import com.vrsoftware.VR.Software.services.Exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional(readOnly = true)
    public List<ProdutoDTO> findAll(){
        List<Produto> listProduto = produtoRepository.findAll();

        return listProduto.stream().map(x -> new ProdutoDTO(x)).toList();
    }

    @Transactional
    public ProdutoDTO findById(Long id){
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));
        ProdutoDTO dto =new ProdutoDTO(produto);

        return dto;
    }

    @Transactional(readOnly = false)
    public ProdutoDTO insert(ProdutoDTO dto) {
        Produto produto = new Produto();
        produto.setDescricao(dto.getDescricao());
        produto.setPreco(dto.getPreco());

        produto = produtoRepository.save(produto);
        return new ProdutoDTO(produto);
    }

    @Transactional(readOnly = false)
    public ProdutoDTO update(Long id, ProdutoDTO dto) {
        try{

            Produto produto = produtoRepository.getReferenceById(id);
            produto.setDescricao(dto.getDescricao());
            produto.setPreco(dto.getPreco());

            produto = produtoRepository.save(produto);
            return new ProdutoDTO(produto);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Produto não encontrado ou inexistente");
        }

    }

    @Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        if (!produtoRepository.existsById(id)){
            throw new ResourceNotFoundException("Elemento não encontrado ou inexistente!");
        }

        produtoRepository.deleteById(id);
    }

}