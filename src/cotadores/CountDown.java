/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotadores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Julian Sanchez
 */
public class CountDown {
    
    private Timer timer;
    
    private int second = 5;
    protected int minute;
    private int hour;
    private String ddSecond;
    private String ddMinute;
    private String ddHour;
    
    private JLabel count;
    
    private String timeString;
    DecimalFormat dformat = new DecimalFormat("00");

    public String getTimeString() {
        return timeString;
    }
    
    public void setTimeString(String timeString) {
        this.timeString = timeString;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
    
    public void assignJLabel(JLabel count) {
        this.count = count;
    }
    
    public CountDown() {
        countDownTimer();
        timer.start();
    }
    
    public void countDownTimer(){
        timer = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
              
                second --;
                ddSecond = dformat.format(second);
                ddMinute = dformat.format(minute);
                ddHour =   dformat.format(hour);
                
                timeString = ddHour+":"+ddMinute+":"+ ddSecond;
                count.setText(timeString);
                
                if (second == -1){
                    second = 59;
                    minute--;
                    ddSecond = dformat.format(second);
                    ddMinute = dformat.format(minute);
                    ddHour =   dformat.format(hour);
                    
                    timeString = ddHour+":"+ddMinute+":"+ ddSecond;
                    count.setText(timeString);
                    
                    if(minute < 0 && second == 0){
                        timer.stop();
                    }
                }
            }
            
        });
    }
}
