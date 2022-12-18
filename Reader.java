
package com.mycompany.os2project;


public class Reader extends Thread {
    
    
    public Reader(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        while(true){
            GUI.c.StartReading();
            GUI.c.Read();
            GUI.c.StopReading();
        
        }
    }

}
