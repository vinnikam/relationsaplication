package co.vinni.ejemplospring.repositorio;

import co.vinni.ejemplospring.entidades.Carro;
import co.vinni.ejemplospring.entidades.Propietario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RepositorioPropietarioTest {

    @Autowired
    RepositorioCarro repositorioCarro;

    @Autowired
    TestEntityManager testEntityManager;
    @DisplayName("Test de equipos")
    @Test
    void testGuardarCarro() {

        Propietario propietario = Propietario
                .builder()
                .nombre("Elsa Patero")
                .identificacion(123L)
                .build();

        Carro carro = Carro
                .builder()
                .placa("sdsd")
                .modelo(1254)
                .propietario(propietario)
                .build();


        //2 WHEN  - ACCION
        Carro carro1 = repositorioCarro.save(carro);
        //3 THEN - VERIFICAR
        assertThat(carro1).isNotNull();
        assertThat(carro1.getCodigo()).isGreaterThan(0);
    }
}
