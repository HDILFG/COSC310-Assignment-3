package Archive;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiMain extends JFrame implements ActionListener {

    public JTextArea chatArea = new JTextArea();
    public JTextField chatBox = new JTextField();

    String text;

    public static void main (String[] args) {
        new GuiMain();
    }

    public GuiMain() {

        JFrame f = new JFrame();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        f.setVisible(true);
        f.setResizable(false);//
        f.setLayout(null);//
        f.setSize(600,600);
        f.setTitle("ChatBot!");
        f.add(chatArea);
        f.add(chatBox);

        //chatArea
        chatArea.setSize(500,400);
        chatArea.setLocation(2,2);

        //textField
        chatBox.setSize(540,30);
        chatBox.setLocation(2,500);

        Opening o = new Opening();
        bot(o.sayHi());
        chatBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text = chatBox.getText();
                chatArea.append("You: " + text + '\n');
                chatBox.setText("");


                Conversation c = new Conversation();
                String q = text;
                bot(c.userAskQuestion(q));


            }
        });

    }

    public void bot(String str) {
        chatArea.append("Bot: " + str + "\n");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
