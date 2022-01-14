package ProjetoSpringBeaLari.ProjetoSpringBeaLari.Service;

import ProjetoSpringBeaLari.ProjetoSpringBeaLari.Dao.ColaboradorDAO;
import ProjetoSpringBeaLari.ProjetoSpringBeaLari.Dao.PermissaoColaboradorDAO;
import ProjetoSpringBeaLari.ProjetoSpringBeaLari.Dao.PermissaoDAO;
import ProjetoSpringBeaLari.ProjetoSpringBeaLari.domain.PermissaoColaborador;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Objects;

@Service
public class PermissaoColaboradorService {
    public List<PermissaoColaborador> listAll() {
        PermissaoColaboradorDAO permissaoColaboradorDAO = new PermissaoColaboradorDAO();
        return permissaoColaboradorDAO.listAllPermissaoColaboradores();
    }

    public List<PermissaoColaborador> findByCodigoPermissaoColaborador(int codigoColaborador) {
        PermissaoColaboradorDAO permissaoColaboradorDAO = new PermissaoColaboradorDAO();
        return permissaoColaboradorDAO.findByCodigoPermissaoColaborador(codigoColaborador);
    }


    public PermissaoColaborador save(PermissaoColaborador permissaoColaborador) throws ParseException {
        PermissaoColaboradorDAO permissaoColaboradorDAO = new PermissaoColaboradorDAO();
        ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
        int qntdMaxPermissaoColaborador = ColaboradorDAO.returnQntMaxPermissao(permissaoColaborador.getCodigoColaborador());
        int qntdPermissaoNoColaborador = permissaoColaboradorDAO.returnQntPermissaoPorColaborador(permissaoColaborador.getCodigoColaborador());
        if (qntdPermissaoNoColaborador < qntdMaxPermissaoColaborador) {
            int idade = colaboradorDAO.calculaIdade(permissaoColaborador.getCodigoColaborador());
            if(idade < 35) {
                PermissaoDAO permissaoDAO = new PermissaoDAO();
                String permissao = permissaoDAO.returnPermisao(permissaoColaborador.getCodigoPermissao());
                if (Objects.equals(permissao, "Gerencial")) {
                    return null;
                }
            }
            return permissaoColaboradorDAO.cadastrarPermissaoColaborador(permissaoColaborador);
        }
        return null;
    }


    public void delete(int codigoColaborador, int codigoPermissao) {
        PermissaoColaboradorDAO permissaoColaboradorDAO = new PermissaoColaboradorDAO();
        permissaoColaboradorDAO.deleteById(codigoColaborador, codigoPermissao);
    }
}
