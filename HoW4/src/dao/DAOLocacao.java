package dao;

import java.util.List;
import model.ModelDados;
import model.ModelLocacao;

public class DAOLocacao {
    ModelLocacao modelLocacao = new ModelLocacao();
    ModelDados modelDados = new ModelDados();
       
    public List<ModelLocacao> getLista()    {
        return ModelDados.listaLocacoes;
    }
    
    public boolean salvar(ModelLocacao obj){
        if (obj.getCodigo() == null){
            Integer codigo = ModelDados.listaLocacoes.size() + 1;
            obj.setCodigo(codigo);
            ModelDados.listaLocacoes.add(obj);
        }
        return true;
    }
    
    public boolean remover(ModelLocacao obj){
        ModelDados.listaLocacoes.remove(obj);
        return true;
    }
}
