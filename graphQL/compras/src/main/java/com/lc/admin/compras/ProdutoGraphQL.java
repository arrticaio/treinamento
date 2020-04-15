package com.lc.admin.compras;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.lc.admin.model.Produto;
import com.lc.admin.model.ProdutoInput;
import com.lc.admin.service.ProdutoService;

@Component
public class ProdutoGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver
{
	@Autowired
	private ProdutoService servico;
	
	public Produto produto(Long id)
	{
		return servico.findById(id) ;
	}
	
	
	public List<Produto> produtos()
	{
		return servico.findAll();
	}
	
	public Produto saveProduto(ProdutoInput input)
	{

		ModelMapper model = new ModelMapper();
		Produto produto = new Produto();
		
		produto = model.map(input, Produto.class);
		
		return servico.save(produto);
	}
	
	
	public Boolean deletarProduto(Long id)
	{
		return servico.deletar(id);
	}
}
