
package com.mycompany.os2project;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Controller {
    
    boolean writing;
    int WaitingWrtiers , readers;
    public synchronized void StartWriting(){
        System.out.println(Thread.currentThread().getName() + " Try to write ");
        while(writing || readers > 0){
            try {
                WaitingWrtiers++;
                System.out.println(Thread.currentThread().getName() + " Wait...");
                wait();
                WaitingWrtiers--;
                System.out.println(Thread.currentThread().getName() + " Notify ");
            } catch (InterruptedException ex) {
                WaitingWrtiers--;
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        writing = true;
    }
       
    
       public void write(String s){
        System.out.println(Thread.currentThread().getName() + " Start Writing ");
        GUI.shared_tf.setText(s);
        System.out.println();
        System.out.println(Thread.currentThread().getName() + " End writing ");
    }
       
       public synchronized void StopWriting(){
           writing = false;
           System.out.println(Thread.currentThread().getName() + " Stop Righting !");
           notifyAll();
       }
       
        public synchronized void StartReading(){
            System.out.println(Thread.currentThread().getName() + " Try to read");
        while(writing || readers > 0){
            try {
               System.out.println(Thread.currentThread().getName() + " Wait ...");
                wait();
                System.out.println(Thread.currentThread().getName() + " Notify ");
            } catch (InterruptedException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        readers++;
    }
       public void Read(){
           System.out.println(Thread.currentThread().getName() + " Start Reading ");
           System.out.print(Thread.currentThread().getName() + " Reading " + GUI.shared_tf.getText() + " ");
           System.out.println();
           System.out.println(Thread.currentThread().getName() + " Finish Reading ");
       }
       
       
       public synchronized void StopReading(){
           readers--;
           System.out.println(Thread.currentThread().getName() + " Stop Reading !");
           if(readers == 0){
              notifyAll();
           }
       }
}
