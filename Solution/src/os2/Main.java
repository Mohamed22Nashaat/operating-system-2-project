/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package os2;

/**
 *
 * @author Medo Nashaat
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Read read = new Read();
        Write write = new Write();
        Thread t1 = new Thread((Runnable) read);
        t1.setName("thread1");
        Thread t2 = new Thread((Runnable) read);
        t2.setName("thread2");
        Thread t3 = new Thread(write);
        t3.setName("thread3");
        Thread t4 = new Thread((Runnable) read);
        t4.setName("thread4");
        t1.start();
        t3.start();
        t2.start();
        t4.start();
    }
    
}
