/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import cotadores.CountDown;
import cotadores.CountUp;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author Julian Sanchez
 */
public class Interface implements ActionListener{
    
    private JFrame window;
  
    private Border border = BorderFactory.createLineBorder(Color.BLUE, 5);
    private Font font1 = new Font("Arial", Font.PLAIN, 30);
    private Font font2 = new Font("Arial", Font.ITALIC,14);
    private Font font3 = new Font("Agency FB", Font.BOLD,30);
    
    private JLabel lblCounter;
    private JLabel lblTotalExerciseTime;
    private JLabel lblExerciseTime;
    private JLabel lblBreakTime;
    private JLabel lblState;
    
    private JTextField txtTotalExerciseTime;
    private JTextField txtExerciseTime;
    private JTextField txtBreakTime;
    private JButton btnStart;
    
    CountDown cd;
    CountUp cu;

    public Interface() {
    
        window = new JFrame();
        window.setSize(800,400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        
        lblCounter = new JLabel();
        lblCounter.setBounds(50, 230, 300, 100);
        lblCounter.setHorizontalAlignment(JLabel.CENTER);
        lblCounter.setFont(font1);
        lblCounter.setText("00:00:00");
        
        lblState = new JLabel();
        lblState.setBounds(350, 230, 300, 100);
        lblState.setHorizontalAlignment(JLabel.CENTER);
        lblState.setFont(font1);
        lblState.setText("Are you Ready?");
        
        lblTotalExerciseTime = new JLabel();
        lblTotalExerciseTime.setBounds(30,20,150,20);
        lblTotalExerciseTime.setFont(font2);
        lblTotalExerciseTime.setHorizontalAlignment(JLabel.LEFT);
        lblTotalExerciseTime.setText("Minutos de ejercicio");
        
        lblExerciseTime = new JLabel();
        lblExerciseTime.setBounds(330,20,150,20);
        lblExerciseTime.setFont(font2);
        lblExerciseTime.setHorizontalAlignment(JLabel.LEFT);
        lblExerciseTime.setText("Segundos ejercicio");
        
        lblBreakTime = new JLabel();
        lblBreakTime.setBounds(580,20,150,20);
        lblBreakTime.setFont(font2);
        lblBreakTime.setHorizontalAlignment(JLabel.LEFT);
        lblBreakTime.setText("Segundos descanso");
        
        txtBreakTime = new JTextField();
        txtBreakTime.setBounds(580,50,150,20);
        
        txtExerciseTime = new JTextField();
        txtExerciseTime.setBounds(330,50,150,20);
        
        txtTotalExerciseTime = new JTextField();
        txtTotalExerciseTime.setBounds(30,50,150,20);
        
        btnStart = new JButton();
        btnStart.setBounds(50, 90, 680, 100);
        btnStart.setFont(font3);
        btnStart.setBorder(border);
        btnStart.setText("LETS GO!");
        btnStart.addActionListener(this);
        
        
        window.add(txtBreakTime);
        window.add(lblBreakTime);
        window.add(lblExerciseTime);
        window.add(txtExerciseTime);
        window.add(lblTotalExerciseTime);
        window.add(txtTotalExerciseTime);
        window.add(btnStart);
        window.add(lblCounter);
        window.add(lblState);
        window.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()== btnStart){
            
            int totalExerciseTime = Integer.parseInt(txtTotalExerciseTime.getText());
            int exerciseTime = Integer.parseInt(txtExerciseTime.getText());
            int breakTime = Integer.parseInt(txtBreakTime.getText());
            
            cd = new CountDown();
            cu = new CountUp();
            
            cu.setExercising(exerciseTime);
            cu.setRelaxing(breakTime);
            cd.setMinute(totalExerciseTime);
            
            cd.assignJLabel(lblCounter);
            cu.assignJLabel(lblState);
            
            cd.countDownTimer();
            cu.countUpTimer();
        }
    }
    
    
}
