package service;

import Entidades.Ejemplo2.Empresa;
import Repo.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Empresaservice {
    @Autowired
    EmpresaRepository empresaRepository;

    public List<Empresa> getAllEmpresas() {
        List<Empresa> empresaList = new ArrayList<>();
        empresaRepository.findAll().forEach(empresa -> empresaList.add(empresa));
        return empresaList;
    }

    public Empresa getEmpresaById(Integer id) {
        return empresaRepository.findById(id).get();
    }

    public boolean saveOrUpdateEmpresa(Empresa empresa) {
        Empresa emp = empresaRepository.save(empresa);
        if (empresaRepository.findById(emp.getId()) != null) {
            return true;
        }
        return false;
    }

}


