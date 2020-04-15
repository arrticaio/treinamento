package com.lc.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lc.admin.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> 
{


}