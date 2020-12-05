import javax.swing.*;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class Main extends JFrame {

	/**
	 * default serial version uid
	 */
	private static final long serialVersionUID = 1L;
	public JTextArea chatArea = new JTextArea();
	public JTextField chatBox = new JTextField();

	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		super();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);//
		setLayout(null);//
		setPreferredSize(new Dimension(400, 800));
		setTitle("ChatBot!");

		// chatArea
		chatArea.setSize(400, 750);
		chatArea.setLocation(0, 0);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatArea.setEditable(false);

		// textField
		chatBox.setSize(400, 20);
		chatBox.setLocation(0, 750);

		add(chatArea);
		add(chatBox);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);

		chatBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = chatBox.getText();
				chatBox.setText("");
				chatArea.append("You: " + input + '\n');
				System.out.println(Arrays.toString(input.toLowerCase().trim().split("\\W+")));
				Conversation c = new Conversation();
				ArrayList<String> q = new ArrayList<String>(Arrays.asList(input.toLowerCase().trim().split("\\W+")));
				bot(c.userAskQuestion(q));

			}
		});
		setVisible(true);
		bot("Hello, I'm Mike. Nice to meet you.");
	}

	public void bot(String str) {
		chatArea.append("Mike: " + str + "\n");
	}

}
