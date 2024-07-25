package cursojavathreads;

import javax.swing.JOptionPane;

public class AulaThread {

	public static void main(String[] args) throws InterruptedException {

		Thread threadPrimeira = new Thread(thread1);
		Thread threadSegunda = new Thread(thread2);
		threadPrimeira.start();
		threadSegunda.start();

		JOptionPane.showMessageDialog(null, "Sistema continua executando para o usuário");
	}

	private static Runnable thread1 = new Runnable() {

		public void run() {

			for (int i = 0; i <= 1000000; i++) {
				System.out.println(i + " Executando um loop até 10 na primeira thread");

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Fim do processamento da primeira thread");
		}

	};
	private static Runnable thread2 = new Runnable() {

		public void run() {

			for (int i = 0; i <= 1000000; i++) {
				System.out.println(i + "loop até 10 na segunda thread");

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Fim do processamento da segunda thread");
		}

	};
}
