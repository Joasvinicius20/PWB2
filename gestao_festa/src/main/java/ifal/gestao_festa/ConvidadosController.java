package ifal.gestao_festa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConvidadosController {
    @Autowired
    private Convidados convidados;

    @RequestMapping("/convidados")
    public ModelAndView listar() {
        final ModelAndView mv = new ModelAndView("ListaConvidados");
        mv.addObject(new Convidado());
        mv.addObject("convidados", convidados.todos());
        return mv;
    }

    @RequestMapping("/convidado/excluir/{nome}")
    public String excluir(@PathVariable(name = "nome") String nome) {
        Convidado convidadoTemp = new Convidado();
        for (Convidado convidado : convidados.todos()) {
            if(convidado.getNome().equals(nome)){            
                convidadoTemp = convidado;
            }
        }
        this.convidados.deletar(convidadoTemp);
        
        return "redirect:/convidados";
    }


    @RequestMapping(value = "/convidados", method = RequestMethod.POST)
    public String salvar(final Convidado convidado) {
        this.convidados.adicionar(convidado);
        return "redirect:/convidados";
    }


}
