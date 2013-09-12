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
        RegraResponsabilidade regra1202 = new Regra1202();
        RegraResponsabilidade regra2010 = new Regra2010();
        RegraResponsabilidade regra2102 = new Regra2102();
        RegraResponsabilidade regra2202 = new Regra2202();
        RegraResponsabilidade regra0011010210 = new Regra0011010210();
        RegraResponsabilidade regra0011010212 = new Regra0011010212();
        RegraResponsabilidade regra0011010221 = new Regra0011010221();
        RegraResponsabilidade regra0011010222 = new Regra0011010222();

        //adiciona a ordem das regras
        regraDoMeio.proximaRegra(regraJogadorNoMeio);
        regraJogadorNoMeio.proximaRegra(regra1101);
        regra1101.proximaRegra(regra1102);
        regra1102.proximaRegra(regra1110);
        regra1110.proximaRegra(regra1202);
        regra1202.proximaRegra(regra2010);
        regra2010.proximaRegra(regra2102);
        regra2102.proximaRegra(regra2202);
        regra2202.proximaRegra(regra0011010210);
        regra0011010210.proximaRegra(regra0011010212);
        regra0011010212.proximaRegra(regra0011010221);
        regra0011010221.proximaRegra(regra0011010222);


        //processa as regras
        jogadaComputer = regraDoMeio.processarRegra(tabuleiro, jogada);

        result.use(Results.http()).body("cel"+jogadaComputer);
    }

}
