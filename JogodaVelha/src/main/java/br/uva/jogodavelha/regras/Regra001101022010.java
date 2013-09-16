package br.uva.jogodavelha.regras;

/**
 * Created with IntelliJ IDEA.
 * User: leoneves
 * Date: 9/15/13
 * Time: 10:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class Regra001101022010 implements RegraResponsabilidade {

    private RegraResponsabilidade proximaRegra;

    @Override
    public String processarRegra(String[][] tabuleiro, String jogada) {
        if (jogada.equals("20") && tabuleiro[0][2].equals("O") && tabuleiro[1][1].equals("O") )
            return "10";
        return proximaRegra.processarRegra(tabuleiro, jogada);
    }

    @Override
    public void proximaRegra(RegraResponsabilidade regra) {
        this.proximaRegra = regra;
    }
}
