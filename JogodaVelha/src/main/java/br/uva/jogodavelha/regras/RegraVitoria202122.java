package br.uva.jogodavelha.regras;

/**
 * Created with IntelliJ IDEA.
 * User: leonardoneves
 * Date: 9/16/13
 * Time: 5:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class RegraVitoria202122 implements RegraResponsabilidade{

    private RegraResponsabilidade proximaRegra;

    @Override
    public String processarRegra(String[][] tabuleiro, String jogada) {
        if (tabuleiro[2][0].equals("O") && tabuleiro[2][1].equals("O") && tabuleiro[2][2].isEmpty())
            return "22";
        else if(tabuleiro[2][1].equals("O") && tabuleiro[2][2].equals("O") && tabuleiro[2][0].isEmpty())
            return "20";
        else if(tabuleiro[2][0].equals("O") && tabuleiro[2][2].equals("O") && tabuleiro[2][1].isEmpty())
            return "21";
        return proximaRegra.processarRegra(tabuleiro, jogada);
    }

    @Override
    public void proximaRegra(RegraResponsabilidade regra) {
        this.proximaRegra = regra;
    }
}
