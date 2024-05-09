package co.vinni.ejemplospring.repositorio;

import co.vinni.ejemplospring.entidades.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioCarro extends JpaRepository<Carro, Integer> {
    Optional<Carro> findByPlaca(String placa);

}
