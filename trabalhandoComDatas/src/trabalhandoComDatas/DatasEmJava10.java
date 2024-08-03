package trabalhandoComDatas;

import java.time.LocalDate;

public class DatasEmJava10 {

	public static void main(String[] args) {

		LocalDate dataBase = LocalDate.parse("2019-10-05");
		System.out.println("data ["+dataBase+"] com mais 5 Dias: "+(dataBase = dataBase.plusDays(5)));
		System.out.println("data ["+dataBase+"] com mais 5 Semanas: "+(dataBase = dataBase.plusWeeks(5)));
		System.out.println("data ["+dataBase+"] com mais 1 Ano: "+(dataBase = dataBase.plusYears(1)));

	}

}
