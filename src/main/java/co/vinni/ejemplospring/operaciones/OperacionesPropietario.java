package co.vinni.ejemplospring.operaciones;

import co.vinni.ejemplospring.entidades.Propietario;

import java.util.List;

public interface OperacionesPropietario {
    public Propietario crear(Propietario Propietario);
    public Propietario actualizar(Propietario Propietario);
    public void borrar(Propietario Propietario);
    public List<Propietario> consultarT();
    public Propietario consultarPK(int pk);
}
