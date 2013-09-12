package br.uva.jogodavelha.regras;

/**
 * Created with IntelliJ IDEA.
 * User: leonardoneves
 * Date: 9/12/13
 * Time: 4:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class RegraDoMeio implements RegraResponsabilidade {

    private RegraResponsabilidade proximaRegra;

    @Override
    public String processarRegra(String[][] tabuleiro, String jogada) {
        if (!tabuleiro[1][1].equals("X") && tabuleiro[1][1].isEmpty()){
            return "11";
        }
        return proximaRegra.processarRegra(tabuleiro,jogada);
    }

    @Override
    public void proximaRegra(RegraResponsabilidade regra) {
        this.proximaRegra = regra;
    }
}
