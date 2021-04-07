/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotadores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;





/**
 *
 * @author Julian Sanchez
 */
public class CountUp {
    
    private Timer timer;
    
    private int exercising;
    private int relaxing;
    
    private int second;
    
    private int breakTime;
    private int exerciseTime;
    
    private boolean exerciseFlag;
    private boolean relaxFlag;
    
    private JLabel State;    

    public CountUp() {
        countUpTimer();
        timer.start();
    }

    public void setExercising(int exercising) {
        this.exercising = exercising;
    }

    public void setRelaxing(int relaxing) {
        this.relaxing = relaxing;
    }

    public void assignJLabel(JLabel State) {
        this.State = State;
    }
    
    public void countUpTimer() {
        
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                second ++;
                if(second == 6){
                   exerciseFlag = true;
                   State.setText("¡EXERCISING!");
                   ReproducirSonido("C:\\Users\\Julian Sanchez\\Desktop\\JulianUD\\2021-1\\FundamentoSoftware\\ContadorRutina\\src\\recursos\\beep-07.wav");
                } else if (second < 5) {
                    State.setText("ARE YOU READY?"); 
                }
                
                if (exerciseFlag == true){
                    exerciseTime ++;
                    if (exerciseTime == exercising ){
                        exerciseFlag = false;
                        relaxFlag = true;
                        exerciseTime = 0;
                        State.setText("Flojeanding");
                        ReproducirSonido("C:\\Users\\Julian Sanchez\\Desktop\\JulianUD\\2021-1\\FundamentoSoftware\\ContadorRutina\\src\\recursos\\beep-07.wav");
                    }
                } else if (relaxFlag ==true){
                    breakTime++;
                    if (breakTime == relaxing){
                        exerciseFlag = true;
                        relaxFlag = false;
                        breakTime = 0;
                        State.setText("¡EXERCISING!");
                        ReproducirSonido("C:\\Users\\Julian Sanchez\\Desktop\\JulianUD\\2021-1\\FundamentoSoftware\\ContadorRutina\\src\\recursos\\beep-07.wav");
                    } 
                }
            }    
        });
    }
    
    public void ReproducirSonido(String nombreSonido) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(nombreSonido));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Error al reproducir el sonido."+ ex);
            
        }
    }
    
}
