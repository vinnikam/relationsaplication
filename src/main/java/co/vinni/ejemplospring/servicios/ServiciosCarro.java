package co.vinni.ejemplospring.servicios;

import co.vinni.ejemplospring.entidades.Carro;
import co.vinni.ejemplospring.operaciones.OperacionesCarro;
import co.vinni.ejemplospring.repositorio.RepositorioCarro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosCarro implements OperacionesCarro {

    @Autowired
    RepositorioCarro repositorioCarro ;

    @Override
    public Carro crear(Carro carro) {
        return repositorioCarro.save(carro);
    }

    @Override
    public Carro actualizar(Carro carro) {
        if (this.consultarPK(carro.getCodigo()) != null)
            return repositorioCarro.save(carro);
        return null;
    }

    @Override
    public void borrar(Carro carro) {
         repositorioCarro.delete(carro);;
    }

    @Override
    public List<Carro> consultarT() {
        return repositorioCarro.findAll();
    }

    @Override
    public Carro consultarPK(int pk) {
        return repositorioCarro.findById(pk).orElse(null);

    }
}
