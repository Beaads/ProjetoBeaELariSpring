package ProjetoSpringBeaLari.ProjetoSpringBeaLari.Controller;

;
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

    //http://localhost:8080/permissao
    @GetMapping
    public ResponseEntity<List<Permissao>> list() {
        return ResponseEntity.ok(permissaoService.listAll());
    }

    @GetMapping(path = "/{codigoPermissao}")
    public ResponseEntity<Permissao> findByCodigoPermissao(@PathVariable int codigoPermissao){
        return ResponseEntity.ok(permissaoService.findByCodigoPermissao(codigoPermissao));
    }


@PostMapping
    public ResponseEntity<Permissao> save (@RequestBody Permissao permissao) {
        return new ResponseEntity<>(permissaoService.save(permissao), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{codigoPermissao}")
    public ResponseEntity<Void> delete (@PathVariable int codigoPermissao) {
        permissaoService.delete(codigoPermissao);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace (@RequestBody Permissao permissao) {
        permissaoService.replace(permissao);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}






