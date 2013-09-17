package br.uva.jogodavelha.regras;

/**
 * Created with IntelliJ IDEA.
 * User: leoneves
 * Date: 9/17/13
 * Time: 1:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class RegraComMeio2021com12X implements RegraResponsabilidade {

    private RegraResponsabilidade proximaRegra;

    @Override
    public String processarRegra(String[][] tabuleiro, String jogada) {
        if (tabuleiro[1][1].equals("O") && jogada.equals("20") && tabuleiro[2][1].isEmpty() && tabuleiro[1][2].equals("X") && tabuleiro[2][2].isEmpty())
            return "21";
        return proximaRegra.processarRegra(tabuleiro, jogada);
    }

    @Override
    public void proximaRegra(RegraResponsabilidade regra) {
        this.proximaRegra = regra;
    }
}
