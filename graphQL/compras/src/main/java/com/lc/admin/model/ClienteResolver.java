package com.lc.admin.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.lc.admin.service.CompraService;

@Component
public class ClienteResolver implements GraphQLResolver<Cliente>
{
	@Autowired
	private CompraService compraService;

	public List<Compra> compras (Cliente c )
	{
		return compraService.findAllByCliente(c);
	}
}
