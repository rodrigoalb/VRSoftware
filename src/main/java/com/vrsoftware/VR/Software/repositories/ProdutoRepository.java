package com.vrsoftware.VR.Software.repositories;

import com.vrsoftware.VR.Software.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
