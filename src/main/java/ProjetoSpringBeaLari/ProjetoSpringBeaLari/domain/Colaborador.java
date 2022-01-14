package ProjetoSpringBeaLari.ProjetoSpringBeaLari.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Data
@AllArgsConstructor
public class Colaborador {
    private int codigoColaborador;
    private String nomeColaborador;
    private String dataNascimento;
    private int qtdMaxPermissoes;

    public Colaborador() {
        this.qtdMaxPermissoes = 4;
    }

    public int calculaIdade() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sdf.parse(dataNascimento));
        Calendar dataAtual = Calendar.getInstance();
        int idade = dataAtual.get(Calendar.YEAR) - calendar.get(Calendar.YEAR);
        if (dataAtual.get(Calendar.MONTH) < calendar.get(Calendar.MONTH)) {
            idade--;
        } else {
            if (dataAtual.get(Calendar.MONTH) == calendar.get(Calendar.MONTH) && dataAtual
                    .get(Calendar.DAY_OF_MONTH) < calendar.get(Calendar.DAY_OF_MONTH)) {
                idade--;
            }
        }
        return idade;
    }
}
