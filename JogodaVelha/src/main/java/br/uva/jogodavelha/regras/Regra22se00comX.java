package br.uva.jogodavelha.regras;

/**
 * Created with IntelliJ IDEA.
 * User: leonardoneves
 * Date: 9/16/13
 * Time: 7:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class Regra22se00comX implements RegraResponsabilidade {

    private RegraResponsabilidade proximaRegra;

    @Override
    public String processarRegra(String[][] tabuleiro, String jogada) {
        if (jogada.equals("22") && tabuleiro[0][0].equals("X") && tabuleiro[0][1].isEmpty() && (!tabuleiro[2][0].equals("X")) )
            return "01";
        return proximaRegra.processarRegra(tabuleiro, jogada);
    }

    @Override
    public void proximaRegra(RegraResponsabilidade regra) {
        this.proximaRegra = regra;
    }
}
