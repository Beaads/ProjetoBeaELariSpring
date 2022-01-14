package ProjetoSpringBeaLari.ProjetoSpringBeaLari.Controller;

import ProjetoSpringBeaLari.ProjetoSpringBeaLari.Service.ColaboradorService;
import ProjetoSpringBeaLari.ProjetoSpringBeaLari.domain.Colaborador;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("colaboradores")
@RequiredArgsConstructor
public class ColaboradorController {

    private final ColaboradorService colaboradorService;

    //http://localhost:8080/colaboradores
    @GetMapping
    public ResponseEntity<List<Colaborador>> list() {
        return new ResponseEntity<>(colaboradorService.listAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{codigoColaborador}")
    public ResponseEntity<Colaborador> findById(@PathVariable int codigoColaborador){
        return new ResponseEntity<>(colaboradorService.findByCodigoColaborador(codigoColaborador), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Colaborador> save (@RequestBody Colaborador colaborador) {
        return new ResponseEntity<>(colaboradorService.save(colaborador), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{codigoColaborador}")
    public ResponseEntity<Void> delete (@PathVariable int codigoColaborador) {
        colaboradorService.delete(codigoColaborador);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{codigoColaborador}")
    public ResponseEntity<Void> replace (@RequestBody Colaborador colaborador, @PathVariable int codigoColaborador) {
        colaboradorService.replace(colaborador, codigoColaborador);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


