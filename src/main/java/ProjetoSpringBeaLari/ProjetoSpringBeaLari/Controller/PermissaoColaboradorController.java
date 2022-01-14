package ProjetoSpringBeaLari.ProjetoSpringBeaLari.Controller;

import ProjetoSpringBeaLari.ProjetoSpringBeaLari.Service.PermissaoColaboradorService;
import ProjetoSpringBeaLari.ProjetoSpringBeaLari.domain.PermissaoColaborador;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.util.List;


@RestController
@RequestMapping("permissaoColaboradores")
@RequiredArgsConstructor
public class PermissaoColaboradorController {

    private final PermissaoColaboradorService permissaoColaboradorService;

    //http://localhost:8080/permissaoColaboradores
    @GetMapping
    public ResponseEntity<List<PermissaoColaborador>> list() {
        return new ResponseEntity<>(permissaoColaboradorService.listAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{codigoColaborador}")
    public ResponseEntity<List<PermissaoColaborador>> findByCodigoPermissaoColaborador(@PathVariable int codigoColaborador){
        return new ResponseEntity<>(permissaoColaboradorService.findByCodigoPermissaoColaborador(codigoColaborador), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PermissaoColaborador> save (@RequestBody PermissaoColaborador permissaoColaborador) throws ParseException {
        return new ResponseEntity<>(permissaoColaboradorService.save(permissaoColaborador), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{codigoColaborador}/{codigoPermissao}")
    public ResponseEntity<Void> delete (@PathVariable int codigoColaborador, @PathVariable int codigoPermissao) {
        permissaoColaboradorService.delete(codigoColaborador, codigoPermissao);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
