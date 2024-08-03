package trabalhandoComDatas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class DatasEmJava7 {

	public static void main(String[] args) {
		
		@SuppressWarnings("deprecation")
		Locale brasil = new Locale("pt", "BR");
		
		LocalDate localDate = LocalDate.now();
		System.out.println("Data atual: " + localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		System.out.println("Dia da semama: "+localDate.getDayOfWeek().getDisplayName(TextStyle.FULL, brasil));
		System.out.println("Dia do mês: "+localDate.getDayOfMonth());
		System.out.println("Dia do ano: "+localDate.getDayOfYear());
		System.out.println("Mês do ano: "+localDate.getMonth().getDisplayName(TextStyle.FULL, brasil));
	}

}
