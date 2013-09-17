package br.uva.jogodavelha.regras;

/**
 * Created with IntelliJ IDEA.
 * User: leoneves
 * Date: 9/17/13
 * Time: 12:17 AM
 * To change this template use File | Settings | File Templates.
 */
public class RegraJogMeio2012com02 implements RegraResponsabilidade {

    private RegraResponsabilidade proximaRegra;

    @Override
    public String processarRegra(String[][] tabuleiro, String jogada) {
        if (tabuleiro[1][1].equals("X") && jogada.equals("20") && tabuleiro[2][2].isEmpty() && tabuleiro[0][2].equals("O") && (!tabuleiro[1][2].equals("X")) )
            return "22";
        return proximaRegra.processarRegra(tabuleiro, jogada);
    }

    @Override
    public void proximaRegra(RegraResponsabilidade regra) {
        this.proximaRegra = regra;
    }
}
