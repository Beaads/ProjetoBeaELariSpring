package ProjetoSpringBeaLari.ProjetoSpringBeaLari.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Colaborador {
    private int codigoColaborador;
    private String nomeColaborador;
    private String dataNascimento;
    private int qtdMaxPermissoes;

//    private List<Permissao> permissaoLista = new ArrayList<>();


}
