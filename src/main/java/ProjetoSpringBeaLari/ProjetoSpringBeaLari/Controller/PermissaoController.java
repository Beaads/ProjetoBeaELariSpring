package ProjetoSpringBeaLari.ProjetoSpringBeaLari.Controller;

import ProjetoSpringBeaLari.ProjetoSpringBeaLari.Service.PermissaoService;
import ProjetoSpringBeaLari.ProjetoSpringBeaLari.domain.Permissao;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("permissoes")
@RequiredArgsConstructor

public class PermissaoController {

    private final PermissaoService permissaoService;

    //http://localhost:8080/permissoes
    @GetMapping
    public ResponseEntity<List<Permissao>> list() {
        return new ResponseEntity<>(permissaoService.listAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{codigoPermissao}")
    public ResponseEntity<Permissao> findById(@PathVariable int codigoPermissao) {
        return new ResponseEntity<>(permissaoService.findByCodigoPermissao(codigoPermissao), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Permissao> save(@RequestBody Permissao permissao) {
        return new ResponseEntity<>(permissaoService.save(permissao), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{codigoPermissao}")
    public ResponseEntity<Void> delete(@PathVariable int codigoPermissao) {
        permissaoService.delete(codigoPermissao);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{codigoPermissao}")
    public ResponseEntity<Void> replace(@RequestBody Permissao permissao, @PathVariable int codigoPermissao) {
        permissaoService.replace(permissao, codigoPermissao);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}






