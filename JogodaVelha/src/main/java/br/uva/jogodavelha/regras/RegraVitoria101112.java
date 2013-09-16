package br.uva.jogodavelha.regras;

/**
 * Created with IntelliJ IDEA.
 * User: leonardoneves
 * Date: 9/16/13
 * Time: 4:14 PM
 * To change this template use File | Settings | File Templates.
 */
//Regra também serve para mesmo fluxo com jogada final 22
public class RegraVitoria101112 implements RegraResponsabilidade {

    private RegraResponsabilidade proximaRegra;

    @Override
    public String processarRegra(String[][] tabuleiro, String jogada) {
        if (tabuleiro[1][0].equals("O") && tabuleiro[1][1].equals("O") && tabuleiro[1][2].isEmpty())
            return "12";
        else if (tabuleiro[1][1].equals("O") && tabuleiro[1][2].equals("O") && tabuleiro[1][0].isEmpty())
            return "10";
        return proximaRegra.processarRegra(tabuleiro, jogada);
    }

    @Override
    public void proximaRegra(RegraResponsabilidade regra) {
        this.proximaRegra = regra;
    }
}
