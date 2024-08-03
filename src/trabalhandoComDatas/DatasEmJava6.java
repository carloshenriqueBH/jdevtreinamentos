package trabalhandoComDatas;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DatasEmJava6 {

	public static void main(String[] args) {
		/*
		 * Conhecendo a nova API de datas do Java 
		 * (a partir do java 8)
		 */
		LocalDate dataAtual = LocalDate.now();
		System.out.println("Data atual: "+dataAtual);
		LocalTime horaAtual = LocalTime.now();
		System.out.println("Hora atual: "+horaAtual);
		LocalDateTime dataHoraAtuais = LocalDateTime.now();
		System.out.println("Data e Hora atuais: "+dataHoraAtuais);
	}
}
