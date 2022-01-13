package ProjetoSpringBeaLari.ProjetoSpringBeaLari.Service;

import ProjetoSpringBeaLari.ProjetoSpringBeaLari.Dao.PermissaoDAO;
import ProjetoSpringBeaLari.ProjetoSpringBeaLari.domain.Colaborador;
import ProjetoSpringBeaLari.ProjetoSpringBeaLari.domain.Permissao;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PermissaoService {

    private static List<Permissao> permissoes;

    public List<Permissao> listAll() {
        PermissaoDAO permissaodDao = new PermissaoDAO();
        return permissaodDao.listAllPermissoes();
}

    public Permissao findByCodigoPermissao(int codigoPermissao) {
        PermissaoDAO permissaoDAO = new PermissaoDAO();
        return permissaoDAO.findByCodigoPermissao(codigoPermissao);

    }

    public Permissao save(Permissao permissao) {
        PermissaoDAO permissaoDAO = new PermissaoDAO();
        return permissaoDAO.cadastrarPermissao(permissao);
    }

    public void delete(int codigoPermissao) {
        PermissaoDAO permissaoDAO = new PermissaoDAO();
        permissaoDAO.deleteById(codigoPermissao);
    }

    public void replace(Permissao permissao, int codigoPermissao) {
        PermissaoDAO permissaoDAO = new PermissaoDAO();
        permissaoDAO.updateById(permissao,codigoPermissao);
    }
}

