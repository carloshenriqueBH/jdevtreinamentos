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
		Iterator iteracao = pilha_fila.iterator();

		synchronized (iteracao) {
			/* Tem por missão que apenas essa thread vai ter acesso a 
			 * esta pilha/lista de processamento.
			 * Bloqueando o acesso por outros processos.
			 */

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
					Thread.sleep(100); // Aguardar a descarga da memória
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		try {
			Thread.sleep(1000); // Apos processar toda a lista, também conceder um tempo para limpeza da memória
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
