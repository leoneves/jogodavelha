package br.uva.jogodavelha.util;

import br.com.caelum.vraptor.Resource;
import org.json.JSONException;
import org.json.JSONObject;

@Resource
public class Util {

    private String[][] tabuleiro = new String[3][3];

    public String[][] transformaJSONEmArray(String tabuleiro) throws JSONException{
        JSONObject objTabuleiro = new JSONObject(tabuleiro);
        this.tabuleiro[0][0] = objTabuleiro.getString("00");
        this.tabuleiro[0][1] = objTabuleiro.getString("01");
        this.tabuleiro[0][2] = objTabuleiro.getString("02");
        this.tabuleiro[1][0] = objTabuleiro.getString("10");
        this.tabuleiro[1][1] = objTabuleiro.getString("11");
        this.tabuleiro[1][2] = objTabuleiro.getString("12");
        this.tabuleiro[2][0] = objTabuleiro.getString("20");
        this.tabuleiro[2][1] = objTabuleiro.getString("21");
        this.tabuleiro[2][2] = objTabuleiro.getString("22");

        return this.tabuleiro;
    }

}
