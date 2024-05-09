package co.vinni.ejemplospring.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilidadesVarias {
    public static String convertirDatetoString(Date fecha){
        SimpleDateFormat sd = new SimpleDateFormat("dd/mm/yyyy");
        return sd.format(fecha);
    }
}
