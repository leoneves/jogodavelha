package br.uva.jogodavelha.regras;

/**
 * Created with IntelliJ IDEA.
 * User: leonardoneves
 * Date: 9/16/13
 * Time: 7:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class RegraSe12e02ocupada implements RegraResponsabilidade {

    private RegraResponsabilidade proximaRegra;

    @Override
    public String processarRegra(String[][] tabuleiro, String jogada) {
        if (jogada.equals("12") && tabuleiro[0][2].equals("X") && tabuleiro[2][2].isEmpty())
            return "22";
        return proximaRegra.processarRegra(tabuleiro, jogada);
    }

    @Override
    public void proximaRegra(RegraResponsabilidade regra) {
        this.proximaRegra = regra;
    }
}
