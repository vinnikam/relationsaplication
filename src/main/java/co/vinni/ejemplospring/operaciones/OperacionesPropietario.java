package co.vinni.ejemplospring.operaciones;

import co.vinni.ejemplospring.entidades.Propietario;

import java.util.List;

public interface OperacionesPropietario {
    public Propietario crear(Propietario propietario);
    public Propietario actualizar(Propietario propietario);
    public void borrar(Propietario propietario);
    public List<Propietario> consultarT();
    public Propietario consultarPK(int pk);
}
