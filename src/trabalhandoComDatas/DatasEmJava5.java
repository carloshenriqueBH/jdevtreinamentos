package trabalhandoComDatas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatasEmJava5 {

	public static void main(String[] args) throws ParseException {
	
	Date dataInicial = 	new SimpleDateFormat("dd/MM/yyyy").parse("02/08/2024");
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dataInicial);
		
		for (int parcelas = 1; parcelas < 13; parcelas ++) {
			calendar.add(calendar.MONTH, 1);
			System.out.println("Parcela n° "
			+parcelas
			+" Vencimento em: "
			+ new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()));
		}
	}

}
