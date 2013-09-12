package br.uva.jogodavelha.regras;

/**
 * Created with IntelliJ IDEA.
 * User: leonardoneves
 * Date: 9/12/13
 * Time: 3:57 PM
 * To change this template use File | Settings | File Templates.
 */
public interface RegraResponsabilidade {

    public String processarRegra(String[][] tabuleiro, String jogada);
    public void proximaRegra(RegraResponsabilidade regra);


}
