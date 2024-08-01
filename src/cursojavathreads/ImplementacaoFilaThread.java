package cursojavathreads;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplementacaoFilaThread extends Thread {
	private static ConcurrentLinkedQueue<ObjetoFilaThread> pilha_fila = new ConcurrentLinkedQueue<ObjetoFilaThread>();

	public static void add(ObjetoFilaThread objetoFilaThread) {
		pilha_fila.add(objetoFilaThread);
	}

	@Override
	public void run() {
		System.out.println("Fila rodando...");

		while (true) {
			
			synchronized (pilha_fila) {		
				
				Iterator<ObjetoFilaThread> iteracao = pilha_fila.iterator();	
				
				while (iteracao.hasNext()) {
					
					ObjetoFilaThread processar = (ObjetoFilaThread) iteracao.next();
					/*
					 * A partir daqui, o processamento deve correr: Gerar documentos, PDFs, enviar
					 * emails, etc.
					 */
					System.out.println("--------------------------------------");
					System.out.println(processar.getEmail());
					System.out.println(processar.getNome());
					System.out.println("--------------------------------------");
					iteracao.remove(); // Final do processamento, tirar da lista
					
					try {
						Thread.sleep(1000); // Aguardar a descarga da memória
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			try {
				Thread.sleep(10); // Apos processar toda a lista, também conceder um tempo para limpeza da memória
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		

	}
}
