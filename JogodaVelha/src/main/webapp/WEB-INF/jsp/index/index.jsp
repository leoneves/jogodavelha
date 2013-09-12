<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Jogo da velha</title>
    <script type="text/javascript" src="<c:url value="/js/jquery-1.10.2.min.js"/>"></script>
    <style type="text/css">
        <!--
        .bla{
            width: 100px;
            height: 100px;
            background: #99ccff;
            font-size: 80px;
            color: #ff0000;
            cursor: pointer;
        }
        .ble{
            background: #000066;
        }
        -->
    </style>
    <script language="JavaScript" type="text/javascript">
        var letra = "X";

        function joga(celula){
            var celulaclicada = document.getElementById(celula).innerHTML;
            if (celulaclicada == "X" || celulaclicada == "O"){
                alert("Opa, este quadrado já foi escolhido!");
            }else{
                document.getElementById(celula).innerHTML = letra;
                letra = "O";
            }
            var matriz = {
                '00' : document.getElementById('cel00').innerHTML,
                '01' : document.getElementById('cel01').innerHTML,
                '02' : document.getElementById('cel02').innerHTML,
                '10' : document.getElementById('cel10').innerHTML,
                '11' : document.getElementById('cel11').innerHTML,
                '12' : document.getElementById('cel12').innerHTML,
                '20' : document.getElementById('cel20').innerHTML,
                '21' : document.getElementById('cel21').innerHTML,
                '22' : document.getElementById('cel22').innerHTML
            };

            var httpTabuleiro = JSON.stringify(matriz);

            $.ajax({
                type: "POST",
                url: "http://0.0.0.0:8080/computerTurn",
                data: { stringTabuleiro: httpTabuleiro, jogada: celula },
                success: function (data) {
                    computerTurn(data);
                }
            });
        }

        function computerTurn(celula){
            document.getElementById(celula).innerHTML = "O";
            letra = "X";
            verif();
        }

        function verif(){
            var c00 = document.getElementById('cel00').innerHTML;
            var c01 = document.getElementById('cel01').innerHTML;
            var c02 = document.getElementById('cel02').innerHTML;
            var c10 = document.getElementById('cel10').innerHTML;
            var c11 = document.getElementById('cel11').innerHTML;
            var c12 = document.getElementById('cel12').innerHTML;
            var c20 = document.getElementById('cel20').innerHTML;
            var c21 = document.getElementById('cel21').innerHTML;
            var c22 = document.getElementById('cel22').innerHTML;
            if (    ((c00 != '') && (c01 != '') && (c02 != '') && (c00 == c01) && (c01 == c02)) ||
                    ((c10 != '') && (c11 != '') && (c12 != '') && (c10 == c11) && (c11 == c12)) ||
                    ((c20 != '') && (c21 != '') && (c22 != '') && (c20 == c21) && (c21 == c22)) ||
                    ((c00 != '') && (c10 != '') && (c20 != '') && (c00 == c10) && (c10 == c20)) ||
                    ((c01 != '') && (c11 != '') && (c21 != '') && (c01 == c11) && (c11 == c21)) ||
                    ((c02 != '') && (c12 != '') && (c22 != '') && (c02 == c12) && (c12 == c22)) ||
                    ((c00 != '') && (c11 != '') && (c22 != '') && (c00 == c11) && (c11 == c22)) ||
                    ((c02 != '') && (c11 != '') && (c20 != '') && (c02 == c11) && (c11 == c20))) {
                alert('Voce Perdeu !');
            }
        }
    </script>

</head>
<body>

<table class="ble">

    <tr>
        <td align="center" valign="middle" id="cel00" class="bla" onclick="joga(this.id);verif();"></td>
        <td align="center" valign="middle" id="cel01" class="bla" onclick="joga(this.id);verif();"></td>
        <td align="center" valign="middle" id="cel02" class="bla" onclick="joga(this.id);verif();"></td>
    </tr>

    <tr>
        <td align="center" valign="middle" id="cel10" class="bla" onclick="joga(this.id);verif();"></td>
        <td align="center" valign="middle" id="cel11" class="bla" onclick="joga(this.id);verif();"></td>
        <td align="center" valign="middle" id="cel12" class="bla" onclick="joga(this.id);verif();"></td>
    </tr>

    <tr>
        <td align="center" valign="middle" id="cel20" class="bla" onclick="joga(this.id);verif();"></td>
        <td align="center" valign="middle" id="cel21" class="bla" onclick="joga(this.id);verif();"></td>
        <td align="center" valign="middle" id="cel22" class="bla" onclick="joga(this.id);verif();"></td>
    </tr>

</table>


</body>
</html>