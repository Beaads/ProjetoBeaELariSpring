package ProjetoSpringBeaLari.ProjetoSpringBeaLari.Service;

import ProjetoSpringBeaLari.ProjetoSpringBeaLari.Dao.ColaboradorDAO;
import ProjetoSpringBeaLari.ProjetoSpringBeaLari.Dao.PermissaoColaboradorDAO;
import ProjetoSpringBeaLari.ProjetoSpringBeaLari.Dao.PermissaoDAO;
import ProjetoSpringBeaLari.ProjetoSpringBeaLari.domain.Colaborador;
import ProjetoSpringBeaLari.ProjetoSpringBeaLari.domain.Permissao;
import ProjetoSpringBeaLari.ProjetoSpringBeaLari.domain.PermissaoColaborador;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Objects;

@Service
public class PermissaoColaboradorService {
    private PermissaoColaboradorDAO permissaoColaboradorDAO = new PermissaoColaboradorDAO();

    public List<PermissaoColaborador> listAll() {
        return permissaoColaboradorDAO.listAllPermissaoColaboradores();
    }

    public List<PermissaoColaborador> findByCodigoPermissaoColaborador(int codigoColaborador) {
        return permissaoColaboradorDAO.findByCodigoPermissaoColaborador(codigoColaborador);
    }

    public PermissaoColaborador save(PermissaoColaborador permissaoColaborador) throws ParseException {
        ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
        Colaborador colaborador = colaboradorDAO.findByCodigoColaborador(permissaoColaborador.getCodigoColaborador());
        List<PermissaoColaborador> permissoes =
                permissaoColaboradorDAO.findByCodigoPermissaoColaborador(permissaoColaborador.getCodigoColaborador());
        if (permissoes.size() < colaborador.getQtdMaxPermissoes()) {
            int idade = colaborador.calculaIdade();
            if (idade < 35) {
                PermissaoDAO permissaoDAO = new PermissaoDAO();
                Permissao permissao = permissaoDAO.findByCodigoPermissao(permissaoColaborador.getCodigoPermissao());
                if (Objects.equals(permissao.getNomePermissao(), "Gerencial")) {
                    return null;
                }
            }
            return permissaoColaboradorDAO.cadastrarPermissaoColaborador(permissaoColaborador);
        }
        return null;
    }

    public void delete(int codigoColaborador, int codigoPermissao) {
        permissaoColaboradorDAO.deleteById(codigoColaborador, codigoPermissao);
    }
}
