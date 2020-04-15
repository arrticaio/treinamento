package com.lc.admin.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lc.admin.dao.ClientRepositorory;
import com.lc.admin.model.Cliente;

@Transactional
@Service
public class ClienteService
{
	@Autowired
	private ClientRepositorory dao;
	
	@Transactional(readOnly=true)
	public Cliente find(Long id)
	{
		return dao.findById(id).orElse(null);
	}
	
	//@Cacheable("clientes")
	@Transactional(readOnly=true)
	public List<Cliente> findAll()
	{
		
		return dao.findAll();
	}
	
	
	public Cliente save(Cliente cli)
	{
		return dao.save(cli);
	}
	
	
	public Boolean deletar(Long id)
	{
		
		if(dao.findById(id).isPresent())
		{
			dao.deleteById(id);
			return true;
		}
		else
		{
			return false;
		}
	}
}
