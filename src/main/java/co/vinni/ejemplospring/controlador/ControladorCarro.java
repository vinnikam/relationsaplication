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


    ServiciosCarro serviciosCarro;
    private int x = 0; // rama -issues
    ServiciosPropietario serviciosPropietario;

    public ControladorCarro(ServiciosPropietario serviciosPropietario, ServiciosCarro serviciosCarro) {
        this.serviciosPropietario = serviciosPropietario;
        this.serviciosCarro = serviciosCarro;
    }

    @GetMapping({  "/carro/lista"})
    public String listarEquipos(Model model){
        model.addAttribute("listacarrosT",serviciosCarro.consultarT());


        return "listacarros";
    }

    @GetMapping({  "/carro/nuevo"})
    public String cargarCarroModal(Model model){
        Carro carrollenar = new Carro();
        Propietario propietariollenar = new Propietario();

        carrollenar.setPropietario(propietariollenar);
        model.addAttribute("carrollenar",carrollenar);
        model.addAttribute("listapropietarios",this.serviciosPropietario.consultarT());

        return "formcreacarro";
    }

    @PostMapping({  "/accioncrear"})
    public String accioncrear(@ModelAttribute("carrollenar") Carro carro){
        this.serviciosCarro.crear(carro);
        return "redirect:/carro/lista";
    }



    public Carro crearCarro(Carro carro){
        return serviciosCarro.crear(carro);
    }

    public Carro buscarCarro(int pk){
        return  serviciosCarro.consultarPK(pk);

    }
}


