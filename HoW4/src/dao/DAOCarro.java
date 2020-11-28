package dao;

import model.ModelDados;
import model.ModelCarro;
import java.util.List;

public class DAOCarro {
    
    ModelDados modelDados = new ModelDados();
    
    public List<ModelCarro> getLista() {
        return ModelDados.listaCarro;
    }
    
    public ModelCarro getListaCod(int codigo) {
        return ModelDados.listaCarro.get(codigo);
    }

    public boolean salvar(ModelCarro obj) {

        if (obj.getCodigo() == null) {
            Integer codigo = ModelDados.listaCarro.size() + 1;
            obj.setCodigo(codigo);
            ModelDados.listaCarro.add(obj);
        }
        return true;
    }

    public boolean remover(ModelCarro obj) {
        ModelDados.listaCarro.remove(obj);
        return true;
    }
}
