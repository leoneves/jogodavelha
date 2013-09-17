package br.uva.jogodavelha.regras;

/**
 * Created with IntelliJ IDEA.
 * User: leonardoneves
 * Date: 9/17/13
 * Time: 12:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class RegraJogMeio0212com21 implements RegraResponsabilidade {

    private RegraResponsabilidade proximaRegra;

    @Override
    public String processarRegra(String[][] tabuleiro, String jogada) {
        if (tabuleiro[1][1].equals("O") && jogada.equals("02") && tabuleiro[1][2].isEmpty()  && tabuleiro[2][1].equals("X") )
            return "12";
        return proximaRegra.processarRegra(tabuleiro, jogada);
    }

    @Override
    public void proximaRegra(RegraResponsabilidade regra) {
        this.proximaRegra = regra;
    }
}
