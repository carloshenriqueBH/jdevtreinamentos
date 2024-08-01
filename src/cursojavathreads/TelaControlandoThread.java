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

public class TelaControlandoThread extends JDialog {

	private JPanel jpanel = new JPanel(new GridBagLayout());

	private JLabel nome = new JLabel("Nome:");
	private JTextField pegaNome = new JTextField();
	private JLabel email = new JLabel("E-mail:");
	private JTextField pegaEmail = new JTextField();
	private JButton jButtonStart = new JButton("Add Lista");
	private JButton jButtonStop = new JButton("Stop");
	
	private ImplementacaoFilaThread fila = new ImplementacaoFilaThread();
	private volatile boolean runningThread1 = false;
	private volatile boolean runningThread2 = false;

	
	public TelaControlandoThread() {
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

		nome.setPreferredSize(new Dimension(200, 25));
		jpanel.add(nome, gridBagConstraints);
		add(jpanel, BorderLayout.WEST);
		gridBagConstraints.gridy++;
		jpanel.add(pegaNome, gridBagConstraints);
		pegaNome.setPreferredSize(new Dimension(200, 25));

		email.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		jpanel.add(pegaEmail, gridBagConstraints);
		pegaEmail.setPreferredSize(new Dimension(200, 25));

		gridBagConstraints.gridy++;
		jpanel.add(pegaEmail, gridBagConstraints);

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
				
				ObjetoFilaThread filaThread = new ObjetoFilaThread();
				
				filaThread.setNome(pegaNome.getText());
				filaThread.setEmail(pegaEmail.getText());
				fila.add(filaThread);
				runningThread1 = false;
				runningThread2 = false;				
				
			}
		});

		jButtonStop.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) { // EXECUTA O CLICK DO BOTÃO
			
				runningThread1 = false;
				runningThread2 = false;
			
			}
		});

		
		
		fila.start();
		setVisible(true);
	}

}
