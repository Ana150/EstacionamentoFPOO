package br.com.estacionabem.util;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Util {
	
	public static String gerarCodigo() {
		return UUID.randomUUID().toString().substring(0,8).toUpperCase();
	}
	
	public static String converterDataParaString(LocalDate data) {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return df.format(data);
	}
	
	public static LocalDate converterDataParaLocalDate(String data) {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate ld = LocalDate.parse(data, df);
		return ld;
	}
	
	public static String converterHoraParaString(LocalTime hora) {
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("HH:mm");
		return dt.format(hora);
	}
	
	public static LocalTime converterHoraParaLocalTime(String hora) {
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime lt = LocalTime.parse(hora, dt);
		return lt;
	}
	
	public static double horas(LocalTime t1, LocalTime t2, double tempo) {
		Duration t = Duration.between(t1, t2);
		tempo = t.toHoursPart();
				System.out.println(tempo);
		return tempo;
	}
}
