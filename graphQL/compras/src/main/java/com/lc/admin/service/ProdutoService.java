package com.lc.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lc.admin.dao.ProdutoRepository;
import com.lc.admin.model.Produto;

@Transactional
@Service
public class ProdutoService 
{
	@Autowired
	private ProdutoRepository dao;
	
	@Transactional(readOnly = true)
	public Produto findById(Long id)
	{
		return dao.findById(id).orElse(null);
	}
	
	@Transactional(readOnly = true)
	public List<Produto> findAll()
	{
		return dao.findAll();
	}
	
	public Produto save(Produto produto)
	{
		return dao.save(produto);
	}
	
	public Boolean deletar(Long id)
	{
		if(dao.findById(id).isPresent())
		{
			dao.deleteById(id);
			return true;
		}
		
		return false;
		
	}
}
