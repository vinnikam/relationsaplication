package co.vinni.ejemplospring.controlador;

import co.vinni.ejemplospring.entidades.Carro;
import co.vinni.ejemplospring.entidades.Propietario;
import co.vinni.ejemplospring.servicios.ServiciosCarro;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
class ControladorCarroTest {


    @Mock
    private ServiciosCarro serviciosCarro;


    @InjectMocks
    private ControladorCarro controladorCarro;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Test guardar controlador Thymeleaf")
    @Test
    void testGuardar() throws Exception {
        //given -config
        Propietario propietario = Propietario
                .builder()
                .codigo(1)
                .nombre("Elsa Patero")
                .identificacion(123L)
                .build();

        Carro carro = Carro
                .builder()
                .codigo(1)
                .placa("abc344".toUpperCase())
                .modelo(1254)
                .propietario(propietario)
                .build();
        given(serviciosCarro.crear(any(Carro.class)))
                .willAnswer((invocation)  -> invocation.getArgument(0) );
        //when
        Carro carroG = controladorCarro.crearCarro(carro);


        //then
        assertThat(carroG).isNotNull();

    }

}
