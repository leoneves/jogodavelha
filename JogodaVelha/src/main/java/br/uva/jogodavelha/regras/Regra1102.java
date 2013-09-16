package br.uva.jogodavelha.regras;

/**
 * Created with IntelliJ IDEA.
 * User: leonardoneves
 * Date: 9/12/13
 * Time: 4:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class Regra1102 implements RegraResponsabilidade{

    private RegraResponsabilidade proximaRegra;

    @Override
    public String processarRegra(String[][] tabuleiro, String jogada) {
        if(jogada.equals("02") && tabuleiro[0][1].isEmpty() && tabuleiro[1][2].isEmpty() && tabuleiro[2][2].isEmpty())
            return "01";
        return proximaRegra.processarRegra(tabuleiro,jogada);
    }

    @Override
    public void proximaRegra(RegraResponsabilidade regra) {
        this.proximaRegra = regra;
    }
}
