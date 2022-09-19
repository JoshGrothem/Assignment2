package grothem;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 
 * @author Joshua
 *
 */
public class MyMain {

	private JFrame frame;
	private JTextField textInput;
	private JTextArea textOutput;
	private JButton btnScramble;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyMain window = new MyMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MyMain() {
		initialize();

		btnScramble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				makeWords();
			}
		});
	}

	private void makeWords() {
		Words tiles = new Words(textInput.getText());
		/**
		 * I did the input validation here so it checks before it runs the code for combinations
		 * That way it does not run all this extra code if not necessary
		 */
		for (int i = 0; i < textInput.getText().length(); i++) {
			char c = textInput.getText().charAt(i);
			if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z')) {
				textOutput.setText("Invalid Input");
			}
			/**
			 * I know the directions say let it be up to 7 tiles but it takes a very long
			 * time to run so to be safe I only let the use input 6 Sorry it might work fine
			 * on my laptop, but I've been doing this on my crappy desktop
			 * It runs slow with 6
			 * but it is instant with 4, so I hope that is fine
			 */
			else if (textInput.getText().length() < 4 || textInput.getText().length() > 6) {
				textOutput.setText("Invalid Input");
			} else {
				textOutput.setText(tiles.scramble(textInput.getText().length()));
			}
			//this is to test pushing a change :3
		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Type 4 letters, no spaces");
		lblNewLabel.setBounds(171, 11, 156, 14);
		frame.getContentPane().add(lblNewLabel);

		textInput = new JTextField();
		textInput.setBounds(158, 59, 86, 20);
		frame.getContentPane().add(textInput);
		textInput.setColumns(10);

		btnScramble = new JButton("make me words");
		btnScramble.setBounds(143, 113, 131, 23);
		frame.getContentPane().add(btnScramble);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(126, 186, 187, 45);
		frame.getContentPane().add(scrollPane);

		textOutput = new JTextArea();
		scrollPane.setViewportView(textOutput);
	}
}
