package ProjetoSpringBeaLari.ProjetoSpringBeaLari.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Colaborador {
    private int codigoColaborador;
    private String nomeColaborador;
    private String dataNascimento;
    private int qtdMaxPermissoes = 4;
//    private List<Permissao> permissaoLista = new ArrayList<>();


}
