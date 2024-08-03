package trabalhandoComDatas;

import java.time.LocalDate;
import java.time.Period;

public class DatasEmJava9 {

	public static void main(String[] args) {
//	LocalDate dataNova = LocalDate.of(2024,8,3);
//	LocalDate dataAntiga = LocalDate.of(1960, 7,10);
	LocalDate dataNova = LocalDate.parse("2024-08-03");
	LocalDate dataAntiga = LocalDate.parse("1960-07-10");
	
	System.out.println("Data Nova ["+dataNova+"] é maior que data antiga ["+dataAntiga+"] ? "+dataNova.isAfter(dataAntiga));
	System.out.println("Data Nova ["+dataNova+"] é igual a data antiga ["+dataAntiga+"] ? "+dataNova.isEqual(dataAntiga));
	
	Period periodo = Period.between(dataAntiga,dataNova);
	
	System.out.println("Quantos dias decorridos entre as duas datas: "+periodo.getDays());
	System.out.println("Quantos anos decorridos entre as duas datas: "+periodo.getYears());
	System.out.println("Quantos meses decorridos entre as duas datas: "+periodo.toTotalMonths());
	
	}

}
