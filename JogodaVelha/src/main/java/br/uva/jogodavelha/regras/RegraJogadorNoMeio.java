package br.uva.jogodavelha.regras;

/**
 * Created with IntelliJ IDEA.
 * User: leonardoneves
 * Date: 9/12/13
 * Time: 4:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class RegraJogadorNoMeio implements RegraResponsabilidade {

    private RegraResponsabilidade proximaRegra;

    @Override
    public String processarRegra(String[][] tabuleiro, String jogada) {
        if( (jogada.equals("11")) ){
            return "02";
        }

        return proximaRegra.processarRegra(tabuleiro, jogada);
    }

    @Override
    public void proximaRegra(RegraResponsabilidade regra) {
       this.proximaRegra = regra;
    }

}
