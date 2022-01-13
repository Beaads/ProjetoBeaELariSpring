package ProjetoSpringBeaLari.ProjetoSpringBeaLari.Service;

import ProjetoSpringBeaLari.ProjetoSpringBeaLari.Dao.ColaboradorDAO;
import ProjetoSpringBeaLari.ProjetoSpringBeaLari.domain.Colaborador;
import org.springframework.stereotype.Service;



import java.util.List;


@Service
public class ColaboradorService {

    public List<Colaborador> listAll() {
        ColaboradorDAO colaboradorDao = new ColaboradorDAO();
        return colaboradorDao.listAllColaboradores();
    }

    public Colaborador findByCodigoColaborador(int codigoColaborador) {
        ColaboradorDAO colaboradorDao = new ColaboradorDAO();
        return colaboradorDao.findByCodigoColaborador(codigoColaborador);

    }

    public Colaborador save(Colaborador colaborador) {
        ColaboradorDAO colaboradorDao = new ColaboradorDAO();
        return colaboradorDao.cadastrarColaborador(colaborador);
    }

    public void delete(int codigoColaborador) {
        ColaboradorDAO colaboradorDao = new ColaboradorDAO();
        colaboradorDao.deleteById(codigoColaborador);
    }

    public void replace(Colaborador colaborador, int codigoColaborador) {
        ColaboradorDAO colaboradorDao = new ColaboradorDAO();
        colaboradorDao.updateById(colaborador, codigoColaborador);
    }
}

