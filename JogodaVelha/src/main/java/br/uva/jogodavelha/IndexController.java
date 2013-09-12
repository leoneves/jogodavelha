package br.uva.jogodavelha;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.uva.jogodavelha.regras.*;
import br.uva.jogodavelha.util.Util;
import org.json.JSONException;

@Resource
public class IndexController {

    private final Result result;
    private Util util;
    private String[][] tabuleiro = new String[3][3];

    public IndexController(Result result, Util util) {
        this.result = result;
        this.util = util;
    }

    @Path("/")
    public void index() {
        result.include("", "VRaptor!");
    }

    @Path("/computerTurn")
    public void computerTurn(String stringTabuleiro, String jogada) throws JSONException {
        jogada = jogada.replaceAll("cel","");
        tabuleiro = util.transformaJSONEmArray(stringTabuleiro);
        String jogadaComputer = null;

        //inicia todas as regras
        RegraResponsabilidade regraDoMeio = new RegraDoMeio();
        RegraResponsabilidade regraJogadorNoMeio = new RegraJogadorNoMeio();
        RegraResponsabilidade regra1101 = new Regra1101();
        RegraResponsabilidade regra1102 = new Regra1102();
        RegraResponsabilidade regra1110 = new Regra1110();

        //adiciona a ordem das regras
        regraDoMeio.proximaRegra(regraJogadorNoMeio);
        regraJogadorNoMeio.proximaRegra(regra1101);
        regra1101.proximaRegra(regra1102);
        regra1102.proximaRegra(regra1110);

        //processa as regras
        jogadaComputer = regraDoMeio.processarRegra(tabuleiro, jogada);

        result.use(Results.http()).body("cel"+jogadaComputer);
    }

}
