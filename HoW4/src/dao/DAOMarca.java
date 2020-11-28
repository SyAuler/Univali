package dao;

import model.ModelMarca;
import model.ModelDados;
import java.util.List;

public class DAOMarca {

    public List<ModelMarca> getLista() {
        return ModelDados.listaMarca;
    }

    public boolean salvar(ModelMarca obj) {

        if (obj.getCodigo() == null) {
            Integer codigo = ModelDados.listaMarca.size() + 1;
            obj.setCodigo(codigo);
            ModelDados.listaMarca.add(obj);
        }
        return true;
    }

    public boolean remover(ModelMarca obj) {
        ModelDados.listaMarca.remove(obj);
        return true;
    }
}
