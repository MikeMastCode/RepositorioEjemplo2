package Repo;

import Entidades.Ejemplo2.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmpresaRepository extends JpaRepository <Empresa, Integer> {

    void deleteById();
}

