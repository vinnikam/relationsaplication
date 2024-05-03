package co.vinni.ejemplospring.repositorio;

import co.vinni.ejemplospring.entidades.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioPropietario extends JpaRepository<Propietario, Integer> {
}
