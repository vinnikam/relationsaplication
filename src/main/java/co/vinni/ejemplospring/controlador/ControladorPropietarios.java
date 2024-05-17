package co.vinni.ejemplospring.controlador;

import co.vinni.ejemplospring.entidades.Propietario;
import co.vinni.ejemplospring.servicios.ServiciosPropietario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorPropietarios {


    ServiciosPropietario serviciosPropietario;

    public ControladorPropietarios(ServiciosPropietario serviciosPropietario) {
        this.serviciosPropietario = serviciosPropietario;
    }

    @GetMapping({  "/propietario/lista"})
    public String listarPropietarios(Model model){
        model.addAttribute("listapropietarioT",serviciosPropietario.consultarT());

        return "listapropietarios";
    }

    @GetMapping({  "/propietario/nuevo"})
    public String cargarPropietarioModal(Model model){
        Propietario propietariollenar = new Propietario();
        model.addAttribute("propietariollenar",propietariollenar);

        return "formcreapropietario";
    }
    @PostMapping ({"/propietario/accioncrear"})
    public String crearPropietarioModal(@ModelAttribute("propietariollenar") Propietario propietario){
        this.serviciosPropietario.crear(propietario);

        return "redirect:/propietario/lista";
    }

}
