package co.vinni.ejemplospring.controlador;

import co.vinni.ejemplospring.entidades.Propietario;
import co.vinni.ejemplospring.servicios.ServiciosPropietario;
import org.springframework.ui.Model;
import co.vinni.ejemplospring.entidades.Carro;
import co.vinni.ejemplospring.servicios.ServiciosCarro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * author Vinni
 */
@Controller
public class ControladorCarro {

    @Autowired
    ServiciosCarro serviciosCarro;
    int valor = 0;  // develop
    @Autowired
    ServiciosPropietario serviciosPropietario;



    @GetMapping({  "/carro/lista"})
    public String listarEquipos(Model model){
        model.addAttribute("listacarrosT",serviciosCarro.consultarT());

        for (Carro elcarro : serviciosCarro.consultarT()){
            System.out.println( elcarro);
        }
        System.out.println("Paso por aca");
        return "listacarros";
    }

    @GetMapping({  "/carro/nuevo"})
    public String cargarCarroModal(Model model){
        Carro carrollenar = new Carro();
        Propietario propietariollenar = new Propietario();

        carrollenar.setPropietario(propietariollenar);
        model.addAttribute("carrollenar",carrollenar);
        model.addAttribute("listapropietarios",this.serviciosPropietario.consultarT());


        System.out.println("Paso por aca formulario");
        return "formcreacarro";
    }

    @PostMapping({  "/accioncrear"})
    public String accioncrear(@ModelAttribute("carrollenar") Carro carro){
        System.out.println("Paso por aca para guardar formulario");
        System.out.println(carro);

        /*Propietario p = Propietario
                .builder()
                .identificacion(carro.getPropietario().getIdentificacion())
                .nombre(carro.getPropietario().getNombre())
                .build();

        Carro carro1 = Carro
                .builder()
                .modelo(carro.getModelo())
                .placa(carro.getPlaca())
                .build();


        List<Carro> lista = new ArrayList<>();

        lista.add(carro1);


        Propietario p1 =  serviciosPropietario.crear(p);
        System.out.println("++++++ "+p1);
        */


        this.serviciosCarro.crear(carro);
        return "redirect:/carro/lista";
    }



    public Carro crearCarro(Carro carro){
        return serviciosCarro.crear(carro);
    }

    public Carro buscarCarro(int pk){
        Carro carro = serviciosCarro.consultarPK(pk);


        /*if(carro != null){
            Moto moto = serviciosMoto.consultarPK(carro.getIdmoto());
            return  Carro
                    .builder()
                    .placa(carro.getPlaca())
                    .moto(moto)
                    .build();
        }*/
        return null;
    }
}


