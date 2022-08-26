package Controller;

import Entidades.Ejemplo2.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.Empresaservice;

import java.util.List;

@Controller

public class ControllerFull {
    @Autowired
    Empresaservice empresaService;
    @GetMapping ({"/Empresas","/VerEmpresas"})
    public String viewEmpresas(Model model){
        List<Empresa> listaEmpresa=empresaService.getAllEmpresas();
       model.addAttribute( attributeName: "emplist", listaEmpresas);
       return "verEmpresas";//Llamamos al HTML
    }
}
