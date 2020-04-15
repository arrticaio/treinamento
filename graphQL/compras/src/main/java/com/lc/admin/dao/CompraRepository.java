package com.lc.admin.dao;


import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lc.admin.model.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> 
{

    @Query("select c from Compra c where c.cliente.id = :clienteId")
    @QueryHints ({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    List<Compra> findAllByCliente(@Param("clienteId") Long clienteId);

//    @Query("select new com.lc.admin.model.dto.CompraResumo(c.id,cli.nome,p.nome,c.quantidade) from Compra c inner join c.cliente cli inner join c.produto p")
//    List<CompraResumo> findAllComprasRelatorio();
}