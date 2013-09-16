package br.uva.jogodavelha.regras;

/**
 * Created with IntelliJ IDEA.
 * User: leonardoneves
 * Date: 9/16/13
 * Time: 5:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class RegraVitoria001020 implements RegraResponsabilidade{

    private RegraResponsabilidade proximaRegra;

    @Override
    public String processarRegra(String[][] tabuleiro, String jogada) {
        if (tabuleiro[0][0].equals("O") && tabuleiro[1][0].equals("O") && tabuleiro[2][0].isEmpty())
            return "20";
        else if(tabuleiro[1][0].equals("O") && tabuleiro[2][0].equals("O") && tabuleiro[0][0].isEmpty())
            return "00";
        else if(tabuleiro[0][0].equals("O") && tabuleiro[2][0].equals("O") && tabuleiro[1][0].isEmpty())
            return "10";
        return proximaRegra.processarRegra(tabuleiro, jogada);
    }

    @Override
    public void proximaRegra(RegraResponsabilidade regra) {
        this.proximaRegra = regra;
    }
}
