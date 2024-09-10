/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desafiotecnico1;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author pedro
 */
public class Resistores {
    private static final Map<Integer, String> DIGIT_TO_COLOR = new HashMap<>();

    static {
        DIGIT_TO_COLOR.put(0, "preto");
        DIGIT_TO_COLOR.put(1, "marrom");
        DIGIT_TO_COLOR.put(2, "vermelho");
        DIGIT_TO_COLOR.put(3, "laranja");
        DIGIT_TO_COLOR.put(4, "amarelo");
        DIGIT_TO_COLOR.put(5, "verde");
        DIGIT_TO_COLOR.put(6, "azul");
        DIGIT_TO_COLOR.put(7, "violeta");
        DIGIT_TO_COLOR.put(8, "cinza");
        DIGIT_TO_COLOR.put(9, "branco");
    }

    public static String getCorResistor(String resistor) {
        resistor = resistor.replace(" ohms", "");

        String tolerancia = "dourado";

        if (resistor.contains("k")) {
            resistor = resistor.replace("k", "");
            double valorNumerico = Double.parseDouble(resistor) * 1000;
            return calcularColoracao(valorNumerico, tolerancia);
        } else if (resistor.contains("M")) {
            resistor = resistor.replace("M", "");
            double valorNumerico = Double.parseDouble(resistor) * 1_000_000;
            return calcularColoracao(valorNumerico, tolerancia);
        } else {
            double valorNumerico = Double.parseDouble(resistor);
            return calcularColoracao(valorNumerico, tolerancia);
        }
    }

    private static String calcularColoracao(double valorNumerico, String tolerancia) {
        int value = (int) valorNumerico;
        String codigoCor = "";

        int primeiroDigito = Integer.parseInt(Integer.toString(value).substring(0, 1));
        int segundoDigito = Integer.parseInt(Integer.toString(value).substring(1, 2));

        int multiplicador = (int) Math.log10(valorNumerico / (primeiroDigito * 10 + segundoDigito));

        codigoCor += DIGIT_TO_COLOR.get(primeiroDigito) + " ";
        codigoCor += DIGIT_TO_COLOR.get(segundoDigito) + " ";
        codigoCor += DIGIT_TO_COLOR.get(multiplicador) + " ";
        codigoCor += tolerancia;

        return codigoCor;
    }
}
