package trabalhandoComDatas;

import java.time.Duration;
import java.time.Instant;

public class DatasEmJava8 {
public static void main(String[] args) throws InterruptedException {
	
	Instant inicio = Instant.now();
	Thread.sleep(2000);
	Instant iFinal = Instant.now();
	Duration duracao = Duration.between(inicio,iFinal);
	System.out.println("Duração em nano segundos: "+duracao);
	System.out.println("Duração em segundos: "+duracao.getSeconds());
	System.out.println("Duração em minutos : "+duracao.toHours());
	System.out.println("Duração em minutos : "+duracao.toHoursPart());
	System.out.println("Duração em milissegundos : "+duracao.toMillis());
}
}
