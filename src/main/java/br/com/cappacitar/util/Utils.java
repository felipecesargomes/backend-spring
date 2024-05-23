package br.com.cappacitar.util;

import java.text.Normalizer;

public class Utils {
	public static String removerAcentos(String str) {
		return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").toUpperCase();
	}
	
	public static String removerPontos(String str) {
		return str.replaceAll("\\D+","");
	}
	
//	public static Double FormatacaoDecimal(Double num) {
//		Double valor;
//		DecimalFormat formatador = new DecimalFormat("0.00");
//		valor = Double.valueOf(formatador.format(num).replaceAll(",", "."));
//		System.out.println(valor);
//		return valor;
//	}
}
