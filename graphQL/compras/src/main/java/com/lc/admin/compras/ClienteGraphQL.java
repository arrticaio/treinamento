package com.lc.admin.compras;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.lc.admin.model.Cliente;
import com.lc.admin.model.ClienteInput;
import com.lc.admin.service.ClienteService;

@Component
public class ClienteGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver
{
	@Autowired
	private ClienteService servico;
	
	
	public Cliente cliente(Long id)
	{
		return servico.find(id);
	}
	
	public List<Cliente> clientes()
	{
		return servico.findAll();
	}
	
	@Transactional
	public Cliente saveCliente(ClienteInput input)
	{
//		Cliente cli = new Cliente();
//		
//		cli.setId(input.getId());
//		cli.setNome(input.getNome());
//		cli.setEmail(input.getEmail());
		
		ModelMapper model = new ModelMapper();
		Cliente cli = model.map(input, Cliente.class);
		
		return servico.save(cli);
	}
	
	@Transactional
	public Boolean deletarCliente(Long id)
	{
		return servico.deletar(id);
	}
}
