package br.uva.jogodavelha.regras;

/**
 * Created with IntelliJ IDEA.
 * User: leoneves
 * Date: 9/17/13
 * Time: 1:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class RegraComMeio0010 implements RegraResponsabilidade {

    private RegraResponsabilidade proximaRegra;

    @Override
    public String processarRegra(String[][] tabuleiro, String jogada) {
        if (tabuleiro[1][1].equals("O") && jogada.equals("00") && tabuleiro[1][0].isEmpty() && tabuleiro[2][0].equals("X"))
            return "10";
        return proximaRegra.processarRegra(tabuleiro, jogada);
    }

    @Override
    public void proximaRegra(RegraResponsabilidade regra) {
        this.proximaRegra = regra;
    }
}
