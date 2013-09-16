package br.uva.jogodavelha.regras;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: leonardoneves
 * Date: 9/16/13
 * Time: 4:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class RegraQualquerJogada implements RegraResponsabilidade{

    private RegraResponsabilidade proximaRegra;

    @Override
    public String processarRegra(String[][] tabuleiro, String jogada) {
        List<String> vazios = new ArrayList<String>();
        for (int i=0;i<=2;i++){
            for(int j=0;j<=2;j++){
                if(tabuleiro[i][j].isEmpty())
                    vazios.add(""+i+""+j);
            }
        }
        if(vazios.size() == 2)
            return vazios.get(0);
        else if(vazios.size() == 0)
            return "V";
        return this.proximaRegra.processarRegra(tabuleiro,jogada);
    }

    @Override
    public void proximaRegra(RegraResponsabilidade regra) {
        this.proximaRegra = regra;
    }
}
