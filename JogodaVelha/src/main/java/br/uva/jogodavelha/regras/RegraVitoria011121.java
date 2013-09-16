package br.uva.jogodavelha.regras;

/**
 * Created with IntelliJ IDEA.
 * User: leonardoneves
 * Date: 9/16/13
 * Time: 5:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class RegraVitoria011121 implements RegraResponsabilidade {

    private RegraResponsabilidade proximaRegra;

    @Override
    public String processarRegra(String[][] tabuleiro, String jogada) {
        if (tabuleiro[0][1].equals("O") && tabuleiro[1][1].equals("O") && tabuleiro[2][1].isEmpty())
            return "21";
        else if(tabuleiro[1][1].equals("O") && tabuleiro[2][1].equals("O") && tabuleiro[0][1].isEmpty())
            return "01";
        return proximaRegra.processarRegra(tabuleiro, jogada);
    }

    @Override
    public void proximaRegra(RegraResponsabilidade regra) {
        this.proximaRegra = regra;
    }
}
