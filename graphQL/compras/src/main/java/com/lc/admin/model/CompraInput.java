package com.lc.admin.model;


public class CompraInput 
{

    private Long id;
    private Integer quantidade;
    private String status;

    private Long clienteId;

    private Long produtoId;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Integer getQuantidade()
	{
		return quantidade;
	}

	public void setQuantidade(Integer quantidade)
	{
		this.quantidade = quantidade;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public Long getClienteId()
	{
		return clienteId;
	}

	public void setClienteId(Long clienteId)
	{
		this.clienteId = clienteId;
	}

	public Long getProdutoId()
	{
		return produtoId;
	}

	public void setProdutoId(Long produtoId)
	{
		this.produtoId = produtoId;
	}
    
    
    
}
