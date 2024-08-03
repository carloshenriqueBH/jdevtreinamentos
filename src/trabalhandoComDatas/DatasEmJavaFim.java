package trabalhandoComDatas;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatasEmJavaFim {
   /*
    * O erro estava no dataBase.plusMonths(mes) - em vez de (1). 03/08/2024
    */
	public static void main(String[] args) {
		LocalDate dataBase = LocalDate.parse("2019-10-05");
		for (int mes = 1; mes <= 12; mes ++) {
			dataBase = dataBase.plusMonths(1);
			System.out.println("Data de vencimento do boleto : "+dataBase.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+" do mês : "+mes);
		}			
	}
}
