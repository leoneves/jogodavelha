package br.uva.jogodavelha.regras;

/**
 * Created with IntelliJ IDEA.
 * User: leonardoneves
 * Date: 9/16/13
 * Time: 6:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class RegraSe21e20ocupada implements RegraResponsabilidade{

    private RegraResponsabilidade proximaRegra;

    @Override
    public String processarRegra(String[][] tabuleiro, String jogada) {
        if (jogada.equals("21") && tabuleiro[2][0].equals("X") && tabuleiro[2][2].isEmpty())
            return "22";
        return proximaRegra.processarRegra(tabuleiro, jogada);
    }

    @Override
    public void proximaRegra(RegraResponsabilidade regra) {
        this.proximaRegra = regra;
    }
}
