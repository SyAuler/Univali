package model;

import java.util.Objects;

public class ModelCarro {
    
    private Integer codigo;
    private String nome;
    private ModelModelo modelo;
    private ModelMarca marca;
    private String cor;
    private String ano;
    private String observacao;

    public ModelCarro(Integer codigo, String nome, ModelModelo modelo, ModelMarca marca, String cor, String ano, String observacao) {
        this.codigo = codigo;
        this.nome = nome;
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
        this.ano = ano;
        this.observacao = observacao;
    }

    public ModelCarro() {
        
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ModelModelo getModelo() {
        return modelo;
    }

    public void setModelo(ModelModelo modelo) {
        this.modelo = modelo;
    }

    public ModelMarca getMarca() {
        return marca;
    }

    public void setMarca(ModelMarca marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
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
        hash = 43 * hash + Objects.hashCode(this.codigo);
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
        final ModelCarro other = (ModelCarro) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        return nome;
    }
    
}
