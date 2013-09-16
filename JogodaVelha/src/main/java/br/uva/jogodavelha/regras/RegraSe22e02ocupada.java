package br.uva.jogodavelha.regras;

/**
 * Created with IntelliJ IDEA.
 * User: leonardoneves
 * Date: 9/16/13
 * Time: 7:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class RegraSe22e02ocupada implements RegraResponsabilidade {

    private RegraResponsabilidade proximaRegra;

    @Override
    public String processarRegra(String[][] tabuleiro, String jogada) {
        if (jogada.equals("22") && tabuleiro[0][2].equals("X") && tabuleiro[1][2].isEmpty())
            return "12";
        return proximaRegra.processarRegra(tabuleiro, jogada);
    }

    @Override
    public void proximaRegra(RegraResponsabilidade regra) {
        this.proximaRegra = regra;
    }
}
