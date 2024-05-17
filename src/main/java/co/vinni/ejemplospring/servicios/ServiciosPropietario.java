package co.vinni.ejemplospring.servicios;

import co.vinni.ejemplospring.entidades.Propietario;
import co.vinni.ejemplospring.operaciones.OperacionesPropietario;
import co.vinni.ejemplospring.repositorio.RepositorioPropietario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosPropietario implements OperacionesPropietario {


    RepositorioPropietario repositorioPropietario ;

    public ServiciosPropietario(RepositorioPropietario repositorioPropietario) {
        this.repositorioPropietario = repositorioPropietario;
    }

    @Override
    public Propietario crear(Propietario propietario) {
        return repositorioPropietario.save(propietario);
    }

    @Override
    public Propietario actualizar(Propietario propietario) {
        if (this.consultarPK(propietario.getCodigo()) != null)
            return repositorioPropietario.save(propietario);
        return null;
    }

    @Override
    public void borrar(Propietario propietario) {
         repositorioPropietario.delete(propietario);
    }

    @Override
    public List<Propietario> consultarT() {
        return repositorioPropietario.findAll();
    }

    @Override
    public Propietario consultarPK(int pk) {
        return repositorioPropietario.findById(pk).orElse(null);
    }
}
