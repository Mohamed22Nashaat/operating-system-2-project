
package com.mycompany.os2project;

import java.util.Random;


public class Writer extends Thread {

     
    public Writer(String name) {
        this.setName(name);
    }
    
    
    
    
   @Override
    public void run() {
        
        while(true){
            GUI.c.StartWriting();
            GUI.c.write(" Number= " + new Random().nextInt(20));
            GUI.c.StopWriting();
            
        }
    }
}
