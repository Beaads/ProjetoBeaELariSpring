package ProjetoSpringBeaLari.ProjetoSpringBeaLari.Service;

import ProjetoSpringBeaLari.ProjetoSpringBeaLari.Dao.PermissaoDAO;
import ProjetoSpringBeaLari.ProjetoSpringBeaLari.domain.Permissao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissaoService {
    private PermissaoDAO permissaoDao = new PermissaoDAO();

    public List<Permissao> listAll() {
        return permissaoDao.listAllPermissoes();
    }

    public Permissao findByCodigoPermissao(int codigoPermissao) {
        return permissaoDao.findByCodigoPermissao(codigoPermissao);
    }

    public Permissao save(Permissao permissao) {
        return permissaoDao.cadastrarPermissao(permissao);
    }

    public void delete(int codigoPermissao) {
        permissaoDao.deleteById(codigoPermissao);
    }

    public void replace(Permissao permissao, int codigoPermissao) {
        permissaoDao.updateById(permissao, codigoPermissao);
    }
}

