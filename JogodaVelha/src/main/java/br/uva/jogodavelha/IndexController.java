package br.uva.jogodavelha;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
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
        tabuleiro = util.transformaJSONEmArray(stringTabuleiro);
        String jogadaComputer = null;
        if (!tabuleiro[1][1].equals("X") && tabuleiro[1][1].isEmpty()){
            jogadaComputer = "cel11";
        }
        else if( (!tabuleiro[1][1].equals("O")) && (!tabuleiro[1][1].isEmpty()) ){
            jogadaComputer = "cel00";
        }


        result.use(Results.http()).body(jogadaComputer);
    }

}
