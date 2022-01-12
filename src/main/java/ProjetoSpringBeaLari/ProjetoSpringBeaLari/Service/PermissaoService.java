package ProjetoSpringBeaLari.ProjetoSpringBeaLari.Service;

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

    static {
        permissoes = new ArrayList<>(List.of(new Permissao(10, "Permissao Para Mexer no Jira"),
                new Permissao(11, "Permissao Para Mexer no E-mail"),
                new Permissao(12, "Permissao Para Mexer no Discord")));

    }

    public List<Permissao> listAll() {
        return permissoes;
}

    public Permissao findByCodigoPermissao(int codigoPermissao) {
        return permissoes.stream()
                .filter(permissao -> permissao.getCodigoPermissao() == (codigoPermissao))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Colaborador nao encontrado"));

    }

    public Permissao save(Permissao permissao) {
        permissao.setCodigoPermissao(ThreadLocalRandom.current().nextInt(1, 10000));
        permissoes.add(permissao);
        return permissao;
    }

    public void delete(int codigoPermissao) {
        permissoes.remove(findByCodigoPermissao(codigoPermissao));
    }

    public void replace(Permissao permissao) {
        delete(permissao.getCodigoPermissao());
        permissoes.add(permissao);
    }
}

