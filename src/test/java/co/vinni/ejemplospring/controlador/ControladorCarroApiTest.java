package co.vinni.ejemplospring.controlador;

import co.vinni.ejemplospring.entidades.Carro;
import co.vinni.ejemplospring.entidades.Propietario;
import co.vinni.ejemplospring.servicios.ServiciosCarro;
import co.vinni.ejemplospring.servicios.ServiciosPropietario;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class ControladorCarroApiTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiciosCarro serviciosCarro;

    @MockBean
    private ServiciosPropietario serviciosPropietario;
    @Autowired
    private ObjectMapper objectMapper;


    @DisplayName("Test guardar controlador API")
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
                .willAnswer((invocation) -> invocation.getArgument(0));
        //when


        ResultActions response = mockMvc.perform(post("/api/carros/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(carro)));

        //.andExpect(jsonPath("$.placa", is(carro.getPlaca())));

        //then
        response.andDo(print())
        .andExpect(status().isCreated());
    }
}
