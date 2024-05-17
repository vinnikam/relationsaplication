package co.vinni.ejemplospring.servicios;

import co.vinni.ejemplospring.exceptions.ResourceNotFoundException;
import co.vinni.ejemplospring.entidades.Carro;
import co.vinni.ejemplospring.entidades.Propietario;
import co.vinni.ejemplospring.repositorio.RepositorioCarro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
class ServiciosCarroTest {
    private Carro carro;
    private Propietario propietario;

    @InjectMocks
    ServiciosCarro serviciosCarro;
    @Mock
    RepositorioCarro repositorioCarro;

    @BeforeEach
    void setup(){
        Propietario propietario = Propietario
                .builder()
                .codigo(1)
                .nombre("Elsa Patero")
                .identificacion(123L)
                .build();

        carro = Carro
                .builder()
                .codigo(1)
                .placa("abc344".toUpperCase())
                .modelo(1254)
                .propietario(propietario)
                .build();
        repositorioCarro.save(carro);
    }
    @DisplayName("Test de guardar carro")
    @Test
    void testGuardarCarro(){
        //given
        //given(repositorioCarro.findByPlaca(carro.getPlaca()))
        //        .willReturn(Optional.empty());
        given(repositorioCarro.save(carro)).willReturn(carro);
        //when
        Carro carroG = serviciosCarro.crear(carro);
        //then
        assertThat(carroG).isNotNull();
    }

    @DisplayName("Test listado de carros ")
    @Test
    void testListar() {
        //given ()
        Propietario propietario = Propietario
                .builder()
                .codigo(2)
                .nombre("Elsa Patero")
                .identificacion(123L)
                .build();

        Carro carro1 = Carro
                .builder()
                .codigo(2)
                .placa("sdsd")
                .modelo(1254)
                .propietario(propietario)
                .build();

        given(repositorioCarro.findAll()).willReturn(List.of(carro, carro1));
        //when ()
        List<Carro> carros = serviciosCarro.consultarT();

        // then
        assertThat(carros).isNotNull();
        assertThat(carros.size()).isEqualTo(2);
    }
    @DisplayName("Test listado de carros vacio")
    @Test
    void testListarVacio() {
        //given ()
        given(repositorioCarro.findAll()).willReturn(Collections.emptyList());
        //when ()
        List<Carro> carros = serviciosCarro.consultarT();

        // then
        assertThat(carros).isEmpty();
        assertThat(carros.size()).isZero();
    }
    @DisplayName("Test listado de carros vacio")
    @Test
    void testObtenerId() {
        //given ()
        given(repositorioCarro.findById(1)).willReturn(Optional.of(carro));

        //when ()
        Carro carroG = serviciosCarro.consultarPK(carro.getCodigo());

        // then
        assertThat(carroG).isNotNull();

    }
    @DisplayName("Test Actualizar carro")
    @Test
    void testActualizar() {
        //given ()
        given(repositorioCarro.findById(1)).willReturn(Optional.of(carro));
        given(repositorioCarro.save(carro)).willReturn(carro);
        carro.setPlaca("abc123".toUpperCase());
        carro.setModelo(2013);

        //when ()
        Carro carroG = serviciosCarro.actualizar(carro);

        // then
        assertThat(carroG.getModelo()).isEqualTo(2013);
        //assertThat(carroG.getPlaca()).isEqualTo("abc123".toUpperCase());


    }

    private Carro createCarro() {
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
        return carro;
    }

}
