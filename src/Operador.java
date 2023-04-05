import java.text.DecimalFormat;

public class Operador {

    //Realiza a operação
    public String SelecionarOperacao(String operacao, Double primeiroValor, Double segundoValor){
        DecimalFormat converter = new DecimalFormat("#.##");
        String valor = null;

        if ("Somar".equals(operacao)){
            double soma = primeiroValor + segundoValor;
            valor = String.valueOf(converter.format(soma));
        }else if ("Subtrair".equals(operacao)){
            double diminuir = primeiroValor - segundoValor;
            valor = String.valueOf(converter.format(diminuir));
        }else if ("Multiplicar".equals(operacao)){
            double multiplicar = primeiroValor * segundoValor;
            valor = String.valueOf(converter.format(multiplicar));
        }else if ("Dividir".equals(operacao)){
            double dividir  = primeiroValor / segundoValor;
            valor = String.valueOf(converter.format(dividir));
        }
        return valor;
    }

    //Converte os valores
    public String ConverterValor(String formato, String valor) {
        var valorDecimal = Integer.parseInt(valor);
        String valorFormatado = null;

        if (formato.equalsIgnoreCase("binario")) {
            valorFormatado = Integer.toBinaryString(valorDecimal);
        } else if (formato.equalsIgnoreCase("decimal")) {
            valorFormatado = Integer.toString(valorDecimal);
        } else if (formato.equalsIgnoreCase("octal")) {
            valorFormatado = Integer.toOctalString(valorDecimal);
        } else if (formato.equalsIgnoreCase("hexa")) {
            valorFormatado = Integer.toHexString(valorDecimal);
        }
        return valorFormatado;
    }
}
