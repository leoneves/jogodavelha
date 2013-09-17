package br.uva.jogodavelha;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.uva.jogodavelha.regras.*;
import br.uva.jogodavelha.util.Util;
import org.json.JSONException;

@Resource
public class IndexController {

    private final Result result;
    private Util util;
    private String[][] tabuleiro = new String[3][3];

    public IndexController(Result result, Util util) {
        this.result = result;
        this.util = util;
    }

    @Path("/")
    public void index() {
        result.include("", "VRaptor!");
    }

    @Path("/computerTurn")
    public void computerTurn(String stringTabuleiro, String jogada) throws JSONException {
        jogada = jogada.replaceAll("cel","");
        tabuleiro = util.transformaJSONEmArray(stringTabuleiro);
        String jogadaComputer = null;

        //inicia todas as regras
        RegraResponsabilidade regraDoMeio = new RegraDoMeio();
        RegraResponsabilidade regraJogadorNoMeio = new RegraJogadorNoMeio();
        //regras vitoria
        RegraResponsabilidade regraVitoria000102 = new RegraVitoria000102();
        RegraResponsabilidade regraVitoria101112 = new RegraVitoria101112();
        RegraResponsabilidade regraVitoria202122 = new RegraVitoria202122();
        RegraResponsabilidade regraVitoria001020 = new RegraVitoria001020();
        RegraResponsabilidade regraVitoria011121 = new RegraVitoria011121();
        RegraResponsabilidade regraVitoria021222 = new RegraVitoria021222();
        RegraResponsabilidade regraVitoria001122 = new RegraVitoria001122();
        RegraResponsabilidade regraVitoria021120 = new RegraVitoria021120();
        //fim regras vitoria
        RegraResponsabilidade regra1101 = new Regra1101();
        RegraResponsabilidade regra1102 = new Regra1102();
        RegraResponsabilidade regra1110 = new Regra1110();
        RegraResponsabilidade regra1202 = new Regra1202();
        RegraResponsabilidade regra2010 = new Regra2010();
        RegraResponsabilidade regra2112com02emX = new Regra2112com02emX();
        RegraResponsabilidade regra2120 = new Regra2120();
        RegraResponsabilidade regra22se00comX = new Regra22se00comX();
        RegraResponsabilidade regra2202 = new Regra2202();
        RegraResponsabilidade regra0011010210 = new Regra0011010210();
        RegraResponsabilidade regra0011010212 = new Regra0011010212();
        RegraResponsabilidade regra0011010222 = new Regra0011010222();
        RegraResponsabilidade regraSe21e20ocupada = new RegraSe21e20ocupada();
        RegraResponsabilidade regraSe22e20Ocupada = new RegraSe22e20Ocupada();
        RegraResponsabilidade regraSe12e02ocupada = new RegraSe12e02ocupada();
        RegraResponsabilidade regraSe22e02ocupada = new RegraSe22e02ocupada();
        RegraResponsabilidade regraSe02e22ocupada = new RegraSe02e22ocupada();
        RegraResponsabilidade regraSe01e02ocupada = new RegraSe01e02ocupada();
        RegraResponsabilidade regraSe02e01ocupada = new RegraSe02e01ocupada();
        RegraResponsabilidade regraSe20e10ocupada = new RegraSe20e10ocupada();
        RegraResponsabilidade regraSe02e12ocupada = new RegraSe02e12ocupada();
        RegraResponsabilidade regraJogadorMeio0022 = new RegraJogadorMeio0022();
        RegraResponsabilidade regraJogMeio1210 = new RegraJogMeio1210();
        RegraResponsabilidade regraJogMeio0121 = new RegraJogMeio0121();
        RegraResponsabilidade regraJogMeio1012 = new RegraJogMeio1012();
        RegraResponsabilidade regraJogMeio2012com02 = new RegraJogMeio2012com02();
        RegraResponsabilidade regraJogMeio2200 = new RegraJogMeio2200();
        RegraResponsabilidade regraJogMeio2101 = new RegraJogMeio2101();
        RegraResponsabilidade regraJogMeio2001com02 = new RegraJogMeio2001com02();

        //regra se sobrou apenas duas - então ninguém vai ganhar
        RegraResponsabilidade regraQualquerJogada = new RegraQualquerJogada();

        //adiciona a ordem das regras
        regraDoMeio.proximaRegra(regraJogadorNoMeio);
        //inicio regras vitoria
        regraJogadorNoMeio.proximaRegra(regraVitoria000102);
        regraVitoria000102.proximaRegra(regraVitoria101112);
        regraVitoria101112.proximaRegra(regraVitoria202122);
        regraVitoria202122.proximaRegra(regraVitoria001020);
        regraVitoria001020.proximaRegra(regraVitoria011121);
        regraVitoria011121.proximaRegra(regraVitoria021222);
        regraVitoria021222.proximaRegra(regraVitoria001122);
        regraVitoria001122.proximaRegra(regraVitoria021120);
        //fim regras vitoria
        regraVitoria021120.proximaRegra(regra1101);
        regra1101.proximaRegra(regra1102);
        regra1102.proximaRegra(regra1110);
        regra1110.proximaRegra(regra1202);
        regra1202.proximaRegra(regra2010);
        regra2010.proximaRegra(regra2112com02emX);
        regra2112com02emX.proximaRegra(regra2120);
        regra2120.proximaRegra(regra22se00comX);
        regra22se00comX.proximaRegra(regra2202);
        regra2202.proximaRegra(regra0011010210);
        regra0011010210.proximaRegra(regra0011010212);
        regra0011010212.proximaRegra(regra0011010222);
        regra0011010222.proximaRegra(regraSe21e20ocupada);
        regraSe21e20ocupada.proximaRegra(regraSe22e20Ocupada);
        regraSe22e20Ocupada.proximaRegra(regraSe12e02ocupada);
        regraSe12e02ocupada.proximaRegra(regraSe22e02ocupada);
        regraSe22e02ocupada.proximaRegra(regraSe02e22ocupada);
        regraSe02e22ocupada.proximaRegra(regraSe01e02ocupada);
        regraSe01e02ocupada.proximaRegra(regraSe02e01ocupada);
        regraSe02e01ocupada.proximaRegra(regraSe20e10ocupada);
        regraSe20e10ocupada.proximaRegra(regraSe02e12ocupada);
        regraSe02e12ocupada.proximaRegra(regraJogadorMeio0022);
        regraJogadorMeio0022.proximaRegra(regraJogMeio1210);
        regraJogMeio1210.proximaRegra(regraJogMeio0121);
        regraJogMeio0121.proximaRegra(regraJogMeio1012);
        regraJogMeio1012.proximaRegra(regraJogMeio2012com02);
        regraJogMeio2012com02.proximaRegra(regraJogMeio2200);
        regraJogMeio2200.proximaRegra(regraJogMeio2101);
        regraJogMeio2101.proximaRegra(regraJogMeio2001com02);

        //última regra
        regraJogMeio2001com02.proximaRegra(regraQualquerJogada);

        //processa as regras
        jogadaComputer = regraDoMeio.processarRegra(tabuleiro, jogada);

        result.use(Results.http()).body("cel"+jogadaComputer);
    }

}
