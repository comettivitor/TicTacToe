import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Tictactoe implements ActionListener {
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JPanel score_panel = new JPanel();
    JLabel score_label = new JLabel();
    JLabel label = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean playerOneTurn;
    Tictactoe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,900);
        frame.getContentPane().setBackground(Color.darkGray);
        frame.setLayout((new BorderLayout()));
        frame.setVisible(true);
        frame.setTitle("TIC-TAC-TOE");

        label.setBackground(Color.darkGray);
        label.setForeground(Color.white);
        label.setFont(new Font("Arial", Font.BOLD, 75));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,80,100);

        score_label.setBackground(Color.darkGray);
        score_label.setForeground(Color.white);
        score_label.setFont(new Font("Arial", Font.BOLD, 75));
        score_label.setHorizontalAlignment(JLabel.CENTER);
        score_label.setOpaque(true);
        score_label.setText("teste");

        score_panel.setLayout(new BorderLayout());
        score_panel.setBounds(0,0,80, 100);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(Color.lightGray);

        for(int i = 0; i < 9; i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Arial", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].setBackground(Color.lightGray);
            buttons[i].addActionListener(this);
        }

        title_panel.add(label);
        score_panel.add(score_label);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);
        frame.add(score_panel, BorderLayout.SOUTH);
        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 9; i++){
            if(e.getSource() == buttons[i]){
                if(playerOneTurn){
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(Color.blue);
                        buttons[i].setText(("X"));
                        playerOneTurn = false;
                        label.setText("O Turn");
                        check();
                    }
                } else {
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(Color.red);
                        buttons[i].setText(("O"));
                        playerOneTurn = true;
                        label.setText("X Turn");
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn(){
        playerOneTurn = true;
        label.setText("X turn");
    }

    public void check(){
        if(
                (buttons[0].getText() == "X") &&
                (buttons[1].getText() == "X") &&
                (buttons[2].getText() == "X")){
                xWins(0,1,2);
        }else if(
                (buttons[3].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[5].getText() == "X")){
            xWins(3,4,5);
        }else if(
                (buttons[6].getText() == "X") &&
                (buttons[7].getText() == "X") &&
                (buttons[8].getText() == "X")){
            xWins(6,7,8);
        }else if(
                (buttons[0].getText() == "X") &&
                (buttons[3].getText() == "X") &&
                (buttons[6].getText() == "X")){
            xWins(0,3,6);
        }else if(
                (buttons[1].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[7].getText() == "X")){
            xWins(1,4,7);
        }else if(
                (buttons[2].getText() == "X") &&
                (buttons[5].getText() == "X") &&
                (buttons[8].getText() == "X")){
            xWins(2,5,8);
        }else if(
                (buttons[0].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[8].getText() == "X")){
            xWins(0,4,8);
        }else if(
                (buttons[2].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[6].getText() == "X")){
            xWins(2,4,6);
        }else if(
                (buttons[0].getText() == "O") &&
                        (buttons[1].getText() == "O") &&
                        (buttons[2].getText() == "O")){
            oWins(0,1,2);
        }else if(
                (buttons[3].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[5].getText() == "O")){
            oWins(3,4,5);
        }else if(
                (buttons[6].getText() == "O") &&
                        (buttons[7].getText() == "O") &&
                        (buttons[8].getText() == "O")){
            oWins(6,7,8);
        }else if(
                (buttons[0].getText() == "O") &&
                        (buttons[3].getText() == "O") &&
                        (buttons[6].getText() == "O")){
            oWins(0,3,6);
        }else if(
                (buttons[1].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[7].getText() == "O")){
            oWins(1,4,7);
        }else if(
                (buttons[2].getText() == "O") &&
                        (buttons[5].getText() == "O") &&
                        (buttons[8].getText() == "O")){
            oWins(2,5,8);
        }else if(
                (buttons[0].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[8].getText() == "O")){
            oWins(0,4,8);
        }else if(
                (buttons[2].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[6].getText() == "O")){
            oWins(2,4,6);
        }
    }

    public void xWins(int a, int b, int c){
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);

        for(int i = 0; i < 9; i++){
            buttons[i].setEnabled(false);
        }
        label.setText("X wins");
    }

    public void oWins(int a, int b, int c){
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);

        for(int i = 0; i < 9; i++){
            buttons[i].setEnabled(false);
        }
        label.setText("O wins");
    }
}
