package trabalhandoComDatas;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DatasEmJava4 {

	public static void main(String[] args) {

		long dias = ChronoUnit.DAYS.between(LocalDate.parse("1960-07-10"), LocalDate.now());
		long meses = ChronoUnit.MONTHS.between(LocalDate.parse("1960-07-10"), LocalDate.now());
		long anos = ChronoUnit.YEARS.between(LocalDate.parse("1960-07-10"), LocalDate.now());
		
		System.out.println("Você já viveu "+dias+" dias!");
		System.out.println("Você já viveu "+meses+" meses!");
		System.out.println("Você já viveu "+anos+" anos!");
	}

}
