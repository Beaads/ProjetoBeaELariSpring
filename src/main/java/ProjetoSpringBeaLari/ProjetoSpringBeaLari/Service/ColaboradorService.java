package ProjetoSpringBeaLari.ProjetoSpringBeaLari.Service;

import ProjetoSpringBeaLari.ProjetoSpringBeaLari.Dao.ColaboradorDAO;
import ProjetoSpringBeaLari.ProjetoSpringBeaLari.domain.Colaborador;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColaboradorService {

    private ColaboradorDAO colaboradorDao = new ColaboradorDAO();

    public List<Colaborador> listAll() {
        return colaboradorDao.listAllColaboradores();
    }

    public Colaborador findByCodigoColaborador(int codigoColaborador) {
        return colaboradorDao.findByCodigoColaborador(codigoColaborador);
    }

    public Colaborador save(Colaborador colaborador) {
        return colaboradorDao.cadastrarColaborador(colaborador);
    }

    public void delete(int codigoColaborador) {
        colaboradorDao.deleteById(codigoColaborador);
    }

    public void replace(Colaborador colaborador, int codigoColaborador) {
        colaboradorDao.updateById(colaborador, codigoColaborador);
    }
}

