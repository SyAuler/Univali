package dao;

import model.ModelDados;
import model.ModelModelo;
import java.util.List;

public class DAOModelo {
    
    public List<ModelModelo> getLista() {
        return ModelDados.listaModelo;
    }

    public boolean salvar(ModelModelo obj) {

        if (obj.getCodigo() == null) {
            Integer codigo = ModelDados.listaModelo.size() + 1;
            obj.setCodigo(codigo);
            ModelDados.listaModelo.add(obj);
        }
        return true;
    }

    public boolean remover(ModelModelo obj) {
        ModelDados.listaModelo.remove(obj);
        return true;
    }
}
