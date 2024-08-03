package trabalhandoComDatas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DatasEmJava3 {

	public static void main(String[] args) throws ParseException {
		
		Calendar calendar = Calendar.getInstance();
		
		calendar.setTime(new SimpleDateFormat("dd/MM/yyyy").parse("02/08/2024"));

		System.out.println("Data original: "+new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()));

		
		calendar.add(calendar.DAY_OF_MONTH, 3);
		
		System.out.println("Somando 3 dias à data: "+new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()));
		
		calendar.add(calendar.MONTH, 6);
		
		System.out.println("Somando 6 meses à data: "+new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()));
	}

}
