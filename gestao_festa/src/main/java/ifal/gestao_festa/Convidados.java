package ifal.gestao_festa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ifal.gestao_festa.Convidado;

@Repository
public class Convidados {

    private static final List<Convidado> LISTA_CONVIDADOS = new ArrayList<>();

    static {
        
    }

    public List<Convidado> todos() {
        return Convidados.LISTA_CONVIDADOS;
    }

    public void adicionar(Convidado convidado) {
        Convidados.LISTA_CONVIDADOS.add(convidado);
    }

	public void deletar (Convidado convidado){
        Convidados.LISTA_CONVIDADOS.remove(convidado);

    }

}