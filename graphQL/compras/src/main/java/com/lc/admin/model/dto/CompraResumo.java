package com.lc.admin.model.dto;




public class CompraResumo 
{
    private Long compraId;
    private String cliente;
    private String produto;
    private int quantidade;
    
    
	public Long getCompraId()
	{
		return compraId;
	}
	public void setCompraId(Long compraId)
	{
		this.compraId = compraId;
	}
	public String getCliente()
	{
		return cliente;
	}
	public void setCliente(String cliente)
	{
		this.cliente = cliente;
	}
	public String getProduto()
	{
		return produto;
	}
	public void setProduto(String produto)
	{
		this.produto = produto;
	}
	public int getQuantidade()
	{
		return quantidade;
	}
	public void setQuantidade(int quantidade)
	{
		this.quantidade = quantidade;
	}
    
    
    
}
