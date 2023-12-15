import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ticTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame= new JFrame();
    JPanel titlePanel=new JPanel();
    JPanel buttonPanel= new JPanel();
    JButton []buttons = new JButton[9];
    JLabel textfield= new JLabel();
    boolean player1Turn;


    public ticTacToe() {
        //frame layout
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(Color.white);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        //textfield design
        textfield.setBackground(Color.black);
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Arial",Font.ITALIC,55));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("TIC-TAC-TOE");
        textfield.setOpaque(true);
        //design title panel
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 800, 100);
        //design button panel
        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(Color.lightGray);
        //add buttons to the panel
        for(int i=0;i<9;i++) {
            buttons[i]=new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,110));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        //add all to frame
        titlePanel.add(textfield);
        frame.add(titlePanel,BorderLayout.NORTH);
        frame.add(buttonPanel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<9;i++) {

            if(e.getSource()==buttons[i]) {
                if(player1Turn) {
                    if(buttons[i].getText()=="") {
                        buttons[i].setForeground(Color.blue);
                        buttons[i].setText("X");
                        player1Turn=false;
                        textfield.setText("O turns");
                        check();
                    }
                }
                else {
                    if(buttons[i].getText()=="") {
                        buttons[i].setForeground(Color.red);
                        buttons[i].setText("O");
                        player1Turn=true;
                        textfield.setText("X turns");
                        check();
                    }
                }
            }
        }

    }

    public void firstTurn() {
        try {
            Thread.sleep(2000);
            //make waiting time for 2sec before game starts
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //make the first turns either X or O using random func
        if(random.nextInt(2)==0) {
            player1Turn=true;
            textfield.setText("X turns");
        }
        else {
            player1Turn=false;
            textfield.setText("O turns");
        }
    }

    public void check() {
        //check for X wins
        if(
                (buttons[0].getText()=="X")&&
                        (buttons[1].getText()=="X")&&
                        (buttons[2].getText()=="X")) {
            xWins(0,1,2);
        }
        if(
                (buttons[3].getText()=="X")&&
                        (buttons[4].getText()=="X")&&
                        (buttons[5].getText()=="X")) {
            xWins(3,4,5);
        }
        if(
                (buttons[6].getText()=="X")&&
                        (buttons[7].getText()=="X")&&
                        (buttons[8].getText()=="X")) {
            xWins(6,7,8);
        }
        if(
                (buttons[0].getText()=="X")&&
                        (buttons[3].getText()=="X")&&
                        (buttons[6].getText()=="X")) {
            xWins(0,3,6);
        }
        if(
                (buttons[1].getText()=="X")&&
                        (buttons[4].getText()=="X")&&
                        (buttons[7].getText()=="X")) {
            xWins(1,4,7);
        }
        if(
                (buttons[2].getText()=="X")&&
                        (buttons[5].getText()=="X")&&
                        (buttons[8].getText()=="X")) {
            xWins(2,5,8);
        }
        if(
                (buttons[0].getText()=="X")&&
                        (buttons[4].getText()=="X")&&
                        (buttons[8].getText()=="X")) {
            xWins(0,4,8);
        }
        if(
                (buttons[2].getText()=="X")&&
                        (buttons[4].getText()=="X")&&
                        (buttons[6].getText()=="X")) {
            xWins(2,4,6);
        }

        //check for O wins
        if(
                (buttons[0].getText()=="O")&&
                        (buttons[1].getText()=="O")&&
                        (buttons[2].getText()=="O")) {
            oWins(0,1,2);
        }
        if(
                (buttons[3].getText()=="O")&&
                        (buttons[4].getText()=="O")&&
                        (buttons[5].getText()=="O")) {
            oWins(3,4,5);
        }
        if(
                (buttons[6].getText()=="O")&&
                        (buttons[7].getText()=="O")&&
                        (buttons[8].getText()=="O")) {
            oWins(6,7,8);
        }
        if(
                (buttons[0].getText()=="O")&&
                        (buttons[3].getText()=="O")&&
                        (buttons[6].getText()=="O")) {
            oWins(0,3,6);
        }
        if(
                (buttons[1].getText()=="O")&&
                        (buttons[4].getText()=="O")&&
                        (buttons[7].getText()=="O")) {
            oWins(1,4,7);
        }
        if(
                (buttons[2].getText()=="O")&&
                        (buttons[5].getText()=="O")&&
                        (buttons[8].getText()=="O")) {
            oWins(2,5,8);
        }
        if(
                (buttons[0].getText()=="O")&&
                        (buttons[4].getText()=="O")&&
                        (buttons[8].getText()=="O")) {
            oWins(0,4,8);
        }
        if(
                (buttons[2].getText()=="O")&&
                        (buttons[4].getText()=="O")&&
                        (buttons[6].getText()=="O")) {
            oWins(2,4,6);
        }

    }

    public void xWins(int a,int b,int c) {
        //display the final winning output set in magneta colour
        buttons[a].setBackground(Color.magenta);
        buttons[b].setBackground(Color.magenta);
        buttons[c].setBackground(Color.magenta);
        for(int i=0;i<9;i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("X Wins :)");
    }

    public void oWins(int a,int b,int c) {
        //display the final winning output set in magneta colour
        buttons[a].setBackground(Color.magenta);
        buttons[b].setBackground(Color.magenta);
        buttons[c].setBackground(Color.magenta);
        for(int i=0;i<9;i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("O Wins :)");
    }

}
