package trabalhandoComDatas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DatasEmJava {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws ParseException {

//		SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
//
//		Date dataVencimentoBoleto = SDF.parse("25/07/2024");
//		Date dataAtual = SDF.parse("02/08/2024");
//		if (dataVencimentoBoleto.before(dataAtual)) {
//			System.out.println("Boleto Vencido");
//		} else {
//			System.out.println("Boleto não Venceu ainda");
//
//		}

		@SuppressWarnings("deprecation")
		// Locale localeBrasileiro = new Locale("pt", "BR");
//		Date date = new Date();
//		System.out.println(date.getDate());
//
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss", new Locale("pt", "BR"));
//		System.out.println(simpleDateFormat.format(date));
//
//		Calendar calendar = Calendar.getInstance();
//
//		LocalDateTime localDateTime = LocalDateTime.ofInstant(calendar.toInstant(), calendar.getTimeZone().toZoneId());
//		System.out.println("Calendário data atual: " + calendar.getInstance().getTime());

		Calendar calendario = Calendar.getInstance();
		@SuppressWarnings("deprecation")
		SimpleDateFormat formato = new SimpleDateFormat("EEEE, dd, MMMM, HH:mm:ss", new Locale("pt", "BR"));
		String dataFormatada = formato.format(calendario.getTime());
		System.out.println("Data formatada completa: " + dataFormatada);			
	}
}
