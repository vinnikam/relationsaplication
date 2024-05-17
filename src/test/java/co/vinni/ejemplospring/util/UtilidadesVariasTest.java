package co.vinni.ejemplospring.util;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UtilidadesVariasTest {

    @Test
    void testCambioFecha(){
        String lafecha = UtilidadesVarias.convertirDatetoString(new Date());
        assertNotNull(lafecha);
    }


}
