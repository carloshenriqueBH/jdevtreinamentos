package cursojavathreads;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaTimeThread extends JDialog {

	private JPanel jpanel = new JPanel(new GridBagLayout());

	private JLabel descricaoHora = new JLabel("Time thread 1");
	private JTextField mostraTempo = new JTextField();
	private JLabel descricaoHora2 = new JLabel("Time thread 2");
	private JTextField mostraTempo2 = new JTextField();
	private JButton jButtonStart = new JButton("Start");
	private JButton jButtonStop = new JButton("Stop");
	
	private volatile boolean runningThread1 = false;
	private volatile boolean runningThread2 = false;

	private Runnable thread1 = new Runnable() {

		public void run() {
			runningThread1 = true;
			while (runningThread1) {
				mostraTempo
						.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm.ss").format(Calendar.getInstance().getTime()));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};
	private Runnable thread2 = new Runnable() {

		public void run() {
			runningThread2 = true;
			while (runningThread2) {
				mostraTempo2
						.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(Calendar.getInstance().getTime()));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};
	private Thread thread1Time;
	private Thread thread2Time;
	
	
	public TelaTimeThread() {
		setTitle("Minha tela de time com thread");
		setSize(new Dimension(240, 300));
		setLocationRelativeTo(null);
		setResizable(false);
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.insets = new Insets(5, 10, 5, 5);
		gridBagConstraints.anchor = GridBagConstraints.WEST;

		descricaoHora.setPreferredSize(new Dimension(200, 25));
		jpanel.add(descricaoHora, gridBagConstraints);
		add(jpanel, BorderLayout.WEST);
		gridBagConstraints.gridy++;
		jpanel.add(mostraTempo, gridBagConstraints);
		mostraTempo.setPreferredSize(new Dimension(200, 25));
		mostraTempo.setEditable(false);
		descricaoHora2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		jpanel.add(descricaoHora2, gridBagConstraints);
		mostraTempo2.setPreferredSize(new Dimension(200, 25));
		mostraTempo2.setEditable(false);
		gridBagConstraints.gridy++;
		jpanel.add(mostraTempo2, gridBagConstraints);

		gridBagConstraints.gridwidth = 1;
		jButtonStart.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridy++;
		jpanel.add(jButtonStart, gridBagConstraints);

		jButtonStop.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridx++;
		jpanel.add(jButtonStop, gridBagConstraints);

		jButtonStart.addActionListener(new ActionListener() {

			/* executa o click do botão de start */
			public void actionPerformed(ActionEvent e) {
				runningThread1 = false;
				runningThread2 = false;
				
				thread1Time = new Thread(thread1);
				thread1Time.start();
				
				thread2Time = new Thread(thread2);
				thread2Time.start();
				
				jButtonStart.setEnabled(false);
				jButtonStop.setEnabled(true);
			}
		});

		jButtonStop.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) { // EXECUTA O CLICK DO BOTÃO
			//	thread1Time.stop();
			//	thread2Time.stop();
				runningThread1 = false;
				runningThread2 = false;
				jButtonStart.setEnabled(true);
				jButtonStop.setEnabled(false);
			}
		});

		
		jButtonStop.setEnabled(false);
		
		setVisible(true);
	}

}
