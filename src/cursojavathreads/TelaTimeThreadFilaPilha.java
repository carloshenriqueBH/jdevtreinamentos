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

public class TelaTimeThreadFilaPilha extends JDialog {

	private JPanel jpanel = new JPanel(new GridBagLayout());

	private JLabel descricaoNome = new JLabel("Nome:");
	private JTextField mostraNome = new JTextField();

	private JLabel descricaoEmail = new JLabel("E-mail:");
	private JTextField mostraEmail = new JTextField();

	private JLabel iteracoes = new JLabel("Qtde:");

	private JButton jButtonAdd = new JButton("add lista");
	private JButton jButtonStop = new JButton("Stop");

	private volatile boolean rodandoThread = false;

	private ImplementacaoFilaThread fila = new ImplementacaoFilaThread();

	public TelaTimeThreadFilaPilha() {
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

		descricaoNome.setPreferredSize(new Dimension(200, 25));
		jpanel.add(descricaoNome, gridBagConstraints);
		add(jpanel, BorderLayout.WEST);
		gridBagConstraints.gridy++;
		jpanel.add(mostraNome, gridBagConstraints);
		mostraNome.setPreferredSize(new Dimension(200, 25));

		descricaoEmail.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		jpanel.add(descricaoEmail, gridBagConstraints);
		mostraEmail.setPreferredSize(new Dimension(200, 25));

		gridBagConstraints.gridy++;
		jpanel.add(mostraEmail, gridBagConstraints);

		gridBagConstraints.gridwidth = 1;
		jButtonAdd.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridy++;
		jpanel.add(jButtonAdd, gridBagConstraints);

		jButtonStop.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridx++;
		jpanel.add(jButtonStop, gridBagConstraints);

		jButtonAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {/* executa o click do botão de start */

				if (fila == null) {
					fila = new ImplementacaoFilaThread();
					fila.start();
				}
				ObjetoFilaThread filaThread = new ObjetoFilaThread();
				filaThread.setNome(mostraNome.getText());
				filaThread.setEmail(mostraEmail.getText());
				fila.add(filaThread);
			}
		});

		jButtonStop.addActionListener(new ActionListener() {

			@SuppressWarnings("removal")
			public void actionPerformed(ActionEvent e) { // EXECUTA O CLICK DO BOTÃO DE STOP

				fila.stop();
				fila = null;
			}
		});

		fila.start();
		setVisible(true);
	}

}
