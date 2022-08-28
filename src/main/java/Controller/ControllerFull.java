package Controller;

import Entidades.Ejemplo2.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.Empresaservice;

import java.util.List;

@Controller

public class ControllerFull {
    @Autowired
    Empresaservice empresaService;
    @GetMapping ({"/","/VerEmpresas"})
    public String viewEmpresas(Model model, @ModelAttribute("mensaje")String mensaje){
        List<Empresa> listaEmpresas=empresaService.getAllEmpresas();
        model.addAttribute("emplist",listaEmpresas);
        model.addAttribute("mensaje",mensaje);
       return "verEmpresas";//Llamamos al HTML
    }
    @GetMapping("/AgregarEmpresa")
    public String nuevaEmpresa(Model model){
        Empresa emp = new Empresa();
        model.addAttribute("emp",emp);
        return "agregarEmpresa";
    }
    @PostMapping("/GuardarEmpresa")
    public String guardarEmpresa(Empresa emp, RedirectAttributes redirectAttributes){
    if(empresaService.saveOrUpdateEmpresa(emp)==true){
        return "redirect:/verEmpresa";
    }
    return "redirect:/agregarEmpresa";
    }

    @GetMapping("/EditarEmpresa/{id}")
    public String editarEmpresa(Model model, @PathVariable Integer id){

  Empresa emp = empresaService.getEmpresaById(id);
        model.addAttribute("emp", emp);
        return "editarEmpresa";
    }


    @PostMapping("/ActualizarEmpresa")
    public String updateEmpresa(Empresa emp) {
        if (empresaService.saveOrUpdateEmpresa(emp)) {
            return "redirect:/verEmpresa";
        }
        return "redirect:/EditarEmpresa";
    }

    @GetMapping("/EliminarEmpresa/{id}")
    public String eliminarEmpresa(@PathVariable Integer id){
        try{
empresaService.deleteEmpresa(id);
        }
        catch (Exception e){
            return"redirect:/VerEmpresas";
        }
        return"redirect:/VerEmpresas";
    }

}

