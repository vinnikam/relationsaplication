package co.vinni.ejemplospring.operaciones;

import co.vinni.ejemplospring.entidades.Carro;

import java.util.List;

public interface OperacionesCarro {
    public Carro crear(Carro carro);
    public Carro actualizar(Carro carro);
    public void borrar(Carro carro);
    public List<Carro> consultarT();
    public Carro consultarPK(int pk);
}
