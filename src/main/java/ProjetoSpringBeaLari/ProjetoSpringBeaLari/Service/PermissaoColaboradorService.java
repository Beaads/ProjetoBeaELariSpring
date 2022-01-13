package ProjetoSpringBeaLari.ProjetoSpringBeaLari.Service;

import ProjetoSpringBeaLari.ProjetoSpringBeaLari.Dao.ColaboradorDAO;
import ProjetoSpringBeaLari.ProjetoSpringBeaLari.Dao.PermissaoColaboradorDAO;
import ProjetoSpringBeaLari.ProjetoSpringBeaLari.Dao.PermissaoDAO;
import ProjetoSpringBeaLari.ProjetoSpringBeaLari.domain.Colaborador;
import ProjetoSpringBeaLari.ProjetoSpringBeaLari.domain.Permissao;
import ProjetoSpringBeaLari.ProjetoSpringBeaLari.domain.PermissaoColaborador;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissaoColaboradorService {
    public List<PermissaoColaborador> listAll() {
        PermissaoColaboradorDAO permissaoColaboradorDAO = new PermissaoColaboradorDAO();
        return permissaoColaboradorDAO.listAllPermissaoColaboradores();
    }


    public PermissaoColaborador findByCodigoPermissaoColaborador(int codigoColaborador) {
        PermissaoColaboradorDAO permissaoColaboradorDAO = new PermissaoColaboradorDAO();
        return permissaoColaboradorDAO.findByCodigoPermissaoColaborador(codigoColaborador);
    }

    public PermissaoColaborador save(PermissaoColaborador permissaoColaborador   ) {
        PermissaoColaboradorDAO permissaoColaboradorDAO = new PermissaoColaboradorDAO();

        ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
//        colaboradorDAO.calculaIdade();
//        PermissaoDAO permissaoDAO = new PermissaoDAO();
//        Permissao byCodigoPermissao = permissaoDAO.findByCodigoPermissao(permissaoColaborador.getCodigoPermissao());
//        Colaborador byCodigoColaborador = colaboradorDAO.findByCodigoColaborador(permissaoColaborador.getCodigoColaborador());
//
//
        return permissaoColaboradorDAO.cadastrarPermissaoColaborador(permissaoColaborador);
    }


    public void delete(int codigoColaborador, int codigoPermissao) {
        PermissaoColaboradorDAO permissaoColaboradorDAO = new PermissaoColaboradorDAO();
        permissaoColaboradorDAO.deleteById(codigoColaborador, codigoPermissao);
    }
}

//        if (byCodigoColaborador. < 35 && byCodigoPermissao.equals("Gerencial")) {
//            // nao pode
//
//        permissaoColaboradorDAO.findByCodigoPermissaoColaborador(permissaoColaborador.getCodigoColaborador())
//                >=4
//