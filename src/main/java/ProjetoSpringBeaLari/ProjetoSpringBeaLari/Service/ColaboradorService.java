package ProjetoSpringBeaLari.ProjetoSpringBeaLari.Service;

import ProjetoSpringBeaLari.ProjetoSpringBeaLari.domain.Colaborador;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

@Service
public class ColaboradorService {

    private static List<Colaborador> colaboradores;

   static {
       colaboradores = new ArrayList<>(List.of(new Colaborador(1, "Beatriz", "31/05/1997", 4),
               new Colaborador(2, "Larissa", "15/09/1994", 4)));
   }

    public List<Colaborador> listAll() {
        return colaboradores;
    }

    public Colaborador findByCodigoColaborador(int codigoColaborador) {
       return colaboradores.stream()
               .filter(colaborador -> colaborador.getCodigoColaborador() == (codigoColaborador))
               .findFirst()
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Colaborador nao encontrado"));

    }

    public Colaborador save(Colaborador colaborador) {
        colaborador.setCodigoColaborador(ThreadLocalRandom.current().nextInt(1, 10000));
        colaboradores.add(colaborador);
        return colaborador;
    }

    public void delete(int codigoColaborador) {
       colaboradores.remove(findByCodigoColaborador(codigoColaborador));
    }

    public void replace(Colaborador colaborador) {
       delete(colaborador.getCodigoColaborador());
       colaboradores.add(colaborador);
    }
}

