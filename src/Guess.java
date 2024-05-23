
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Guess extends JFrame implements ActionListener {
    JLabel label1,label2, label3;

    int Score=0;
    JTextField guessNum;

    JButton checkButton,restartButton,exitButton, startButton;
    Random random = new Random();

    int round =1;
    int lScore = 0;
    int attempt = 1;
    int uNum;

    int sNum = random.nextInt(1, 100);



    Guess(){

        ImageIcon bg = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png"));
        Image bg1 = bg.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon back= new ImageIcon(bg1);
        JLabel bImage = new JLabel(back);
        bImage.setBounds(0,0,250,250);
        add(bImage);

        label1= new JLabel("Round - 1");
        label1.setBounds(330,40,100,30);
        label1.setFont(new Font("Ralway",Font.BOLD,20));
        label1.setForeground(Color.white);
        add(label1);
        label2= new JLabel("Lives - 10");
        label2.setBounds(330,100,100,30);
        label2.setFont(new Font("Ralway",Font.BOLD,20));
        label2.setForeground(Color.white);
        add(label2);


        JLabel j= new JLabel("Guess Number");
        j.setBounds(300,160,170,30);
        j.setFont(new Font("Ralway",Font.BOLD,18));
        j.setForeground(Color.white);
        add(j);






        guessNum = new JTextField();
        guessNum.setFont(new Font("Arial", Font.BOLD, 24));
        guessNum.setBackground(new Color(30, 30, 66));
        guessNum.setForeground(Color.white);
        guessNum.setBounds(300, 190, 150, 35);
        add(guessNum);

        label3= new JLabel("HINT:- 'The Number is in Between 1 - 100'");
        label3.setBounds(50,300,350,40);
        label3.setFont(new Font("Ralway",Font.BOLD,15));
        label3.setForeground(new Color(239, 220, 54));
        add(label3);



        startButton =new JButton("Start");
        startButton.setBackground(new Color(30, 30, 66));
        startButton.setFont(new Font("System",Font.BOLD,20));
        startButton.setBounds(170,255,150,30);
        startButton.setForeground(Color.white);
        startButton.addActionListener(this);
        add(startButton);
        checkButton =new JButton("Check");
        checkButton.setBackground(new Color(30, 30, 66));
        checkButton.setFont(new Font("System",Font.BOLD,20));
        checkButton.setBounds(170,255,150,30);
        checkButton.setForeground(Color.white);
        checkButton.addActionListener(this);
        add(checkButton);







        restartButton =new JButton("Restart");
        restartButton.setBackground(new Color(30, 30, 66));
        restartButton.setFont(new Font("System",Font.BOLD,17));
        restartButton.setBounds(50,385,120,30);
        restartButton.setForeground(Color.white);
        restartButton.addActionListener(this);
        add(restartButton);
        exitButton =new JButton("Exit");
        exitButton.setBackground(new Color(30, 30, 66));
        exitButton.setFont(new Font("System",Font.BOLD,17));
        exitButton.setBounds(300,385,120,30);
        exitButton.setForeground(Color.white);
        exitButton.addActionListener(this);
        add(exitButton);



        setSize(500,500);
        getContentPane().setBackground(new Color(28, 25, 21));
        setLayout(null);
        setLocation(500,200);
        setUndecorated(true);
        setVisible(true);

        JOptionPane.showMessageDialog(null, "                  RULES                " + " \n 1. You have to guess the number\n2.For each round you get 10 attempts\n3. No. of rounds 5 ");


    }
    @Override
    public void actionPerformed(ActionEvent e) {

        try{
            if (round == 6 || attempt == 11) {
                JOptionPane.showMessageDialog(null, "Game over\n Your total score is - " + Score);
                setVisible(false);
                new Start();
            }
            if (e.getSource() == startButton || e.getSource() == checkButton) {
                startButton.setVisible(false);
                uNum = Integer.parseInt(guessNum.getText());


                if (guessNum.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Enter a number.");

                } else if ((uNum >= 1) && (uNum <= 100)) {

                    if (uNum == sNum) {
                        lScore = 11 - attempt;
                        Score += lScore;
                        ++round;
                        attempt = 1;
                        label3.setText("HINT:- 'The Number is in Between 1 - 100'");
                        sNum = random.nextInt(1, 100);
                        JOptionPane.showMessageDialog(null, "HURRAY!......\nYour Score is - " + lScore);


                    } else if (uNum < sNum) {
                        attempt++;
                        label2.setText("Lives - " + (11 - attempt));
                        label3.setText("HINT:- 'The Guess is less than number'");

                    } else {
                        attempt++;
                        label2.setText("Lives - " + (11 - attempt));
                        label3.setText("HINT:- 'The Guess is more than number'");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Enter a Valid Number");
                    guessNum.setText("");
                }
                guessNum.setText("");
                if (round < 6) {
                    label1.setText("Round - " + round);
                    label2.setText("Lives - " + (11 - attempt));
                }

            } else if (e.getSource() == exitButton) {
                System.exit(0);
            } else if (e.getSource() == restartButton) {
                new Start();
                setVisible(false);
            }

        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Guess();

    }
}

