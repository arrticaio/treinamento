package com.lc.admin.compras;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.lc.admin.model.Compra;
import com.lc.admin.service.ClienteService;
import com.lc.admin.service.CompraService;
import com.lc.admin.service.ProdutoService;
import com.lc.admin.model.CompraInput;
import com.lc.admin.model.dto.CompraResumo;


@Component
public class CompraGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver
{

	@Autowired
	private CompraService service;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ProdutoService produtoService;

	public Compra compra(Long id)
	{
		return service.findById(id);
	}
	
//	public List<Compra> compras()
//	{
//		return service.findAll();
//	}

	public List<Compra> compras(int page, int size)
	{
		Pageable pageable = PageRequest.of(page, size, Sort.by("quantidade"));
		return service.findAll(pageable);
	}

//	public List<CompraResumo> getComprasRelatorio()
//	{
//		return service.findAllComprasRelatorio();
//	}

	public Compra saveCompra(CompraInput input)
	{
		ModelMapper m = new ModelMapper();
		Compra c = m.map(input, Compra.class);

		//c.setData(new Date());

		c.setCliente(clienteService.find(input.getClienteId()));
		c.setProduto(produtoService.findById(input.getProdutoId()));

		return service.save(c);
	}

	public Boolean deleteCompra(Long id)
	{
		return service.deleteById(id);
	}
}
