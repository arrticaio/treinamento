package com.lc.admin.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lc.admin.dao.CompraRepository;
import com.lc.admin.exceptions.DomainException;
import com.lc.admin.model.Cliente;
import com.lc.admin.model.Compra;

@Transactional
@Service
public class CompraService 
{

    @Autowired
	private CompraRepository rep;

    @Transactional(readOnly = true)
	public Compra findById(Long id)
	{
		return rep.findById(id).orElse(null);
	}

   
    @Transactional(readOnly = true)
	public List<Compra> findAll(Pageable pageable)
	{
		return rep.findAll(pageable).getContent();
	}

	//@CacheEvict(value="compras",key = "#c.cliente.id" )
	public Compra save(Compra c)
	{
		if (c.getQuantidade() > 100)
		{
			throw new DomainException("Não é possível fazer uma compra com mais de 100 items");
			
			//throw new  RuntimeException("Não é possível fazer uma compra com mais de 100 items");
		}
		return rep.save(c);
	}

	
	public boolean deleteById(Long id)
	{
		if (rep.findById(id).isPresent())
		{
			rep.deleteById(id);
			return true;
		}
		return false;
	}

	//@Cacheable(value="compras",key = "#c.id" )
	public List<Compra> findAllByCliente(Cliente c)
	{
		return rep.findAllByCliente(c.getId());
	}

//	public List<CompraResumo> findAllComprasRelatorio()
//	{
//		return rep.findAllComprasRelatorio();
//	}
}
