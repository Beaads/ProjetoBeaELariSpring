package ProjetoSpringBeaLari.ProjetoSpringBeaLari.Service;

import ProjetoSpringBeaLari.ProjetoSpringBeaLari.Dao.PermissaoColaboradorDAO;
import ProjetoSpringBeaLari.ProjetoSpringBeaLari.domain.PermissaoColaborador;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissaoColaboradorService {
    public List<PermissaoColaborador> listAll() {
        PermissaoColaboradorDAO permissaoColaboradorDAO = new PermissaoColaboradorDAO();
        return permissaoColaboradorDAO.listAllPermissaoColaboradores();
    }

//
//    public PermissaoColaborador findByCodigoPermissaoColaborador(int codigoColaborador) {
//        PermissaoColaboradorDAO permissaoColaboradorDAO = new PermissaoColaboradorDAO();
//        return permissaoColaboradorDAO.findByCodigoPermissaoColaborador(codigoColaborador);
//
//    }

    public PermissaoColaborador save(PermissaoColaborador permissaoColaborador   ) {
        PermissaoColaboradorDAO permissaoColaboradorDAO = new PermissaoColaboradorDAO();
        return permissaoColaboradorDAO.cadastrarPermissaoColaborador(permissaoColaborador);
    }


    public void delete(int codigoColaborador, int codigoPermissao) {
        PermissaoColaboradorDAO permissaoColaboradorDAO = new PermissaoColaboradorDAO();
        permissaoColaboradorDAO.deleteById(codigoColaborador, codigoPermissao);
    }
}
