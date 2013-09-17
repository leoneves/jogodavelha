package br.uva.jogodavelha.regras;

/**
 * Created with IntelliJ IDEA.
 * User: leoneves
 * Date: 9/16/13
 * Time: 11:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class RegraJogMeio1210 implements RegraResponsabilidade {

    private RegraResponsabilidade proximaRegra;

    @Override
    public String processarRegra(String[][] tabuleiro, String jogada) {
        if (tabuleiro[1][1].equals("X") && jogada.equals("12") && tabuleiro[1][0].isEmpty())
            return "10";
        return proximaRegra.processarRegra(tabuleiro, jogada);
    }

    @Override
    public void proximaRegra(RegraResponsabilidade regra) {
        this.proximaRegra = regra;
    }
}
