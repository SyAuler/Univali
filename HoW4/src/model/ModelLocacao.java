package model;

import java.io.Serializable;
import java.util.Objects;

public class ModelLocacao {

    private Integer codigo;
    private ModelCliente cliente;
    private ModelCarro carro;
    private double valor;
    private String dataRetirada;
    private String dataDevolucao;
    private String observacao;
    

    public ModelLocacao(Integer codigo, ModelCliente cliente, ModelCarro carro, 
            String nome, double valor, String dataRetirada, String dataDevolucao, String observacao) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.carro = carro;
        this.valor = valor;
        this.dataRetirada = dataRetirada;
        this.dataDevolucao = dataDevolucao;
        this.observacao = observacao;
    }

    public ModelLocacao(){
    
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ModelCliente getCliente() {
        return cliente;
    }

    public void setCliente(ModelCliente cliente) {
        this.cliente = cliente;
    }
    
    public ModelCarro getCarro() {
        return carro;
    }

    public void setCarro(ModelCarro carro) {
        this.carro = carro;
    }
    
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public String getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(String dataRetirada) {
        this.dataRetirada = dataRetirada;
    }
    
    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ModelLocacao other = (ModelLocacao) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

}