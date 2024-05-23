

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class Start extends JFrame implements ActionListener {

        JButton playButton;

        Start() {


            ImageIcon bg = new ImageIcon(ClassLoader.getSystemResource("icon/game.png"));
            Image bg1 = bg.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
            ImageIcon back = new ImageIcon(bg1);
            JLabel bImage = new JLabel(back);
            bImage.setBounds(50, 0, 400, 400);

            playButton = new JButton("Play");
            playButton.setBackground(new Color(30, 30, 66));
            playButton.setFont(new Font("System", Font.BOLD, 25));
            playButton.setBounds(150, 340, 200, 50);
            playButton.setForeground(Color.white);
            playButton.addActionListener(this);
            add(playButton);


            add(bImage);
            setSize(500, 500);
            setLayout(null);
            getContentPane().setBackground(new Color(136, 120, 229));
            setLocation(500, 200);
            setUndecorated(true);
            setVisible(true);


        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                new Guess();
                setVisible(false);

            } catch (Exception E) {
                E.printStackTrace();
            }

        }

        public static void main(String[] args) {
            new Start();
        }


    }
