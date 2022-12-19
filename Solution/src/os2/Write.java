/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package os2;

/**
 *
 * @author Medo Nashaat
 */
public class Write extends WriterReadersFirst implements Runnable {
      @Override
        public void run() {
            try {
                in_mutex.acquire();
                rw_mutex.acquire();
                System.out.println("Thread "+Thread.currentThread().getName() + " is WRITING");
                Thread.sleep(2500);
                System.out.println("Thread "+Thread.currentThread().getName() + " has finished WRITING");
                rw_mutex.release();
                in_mutex.release();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    
}
