/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package os2;

/**
 *
 * @author Medo Nashaat
 */
public class Read extends WriterReadersFirst implements Runnable{
     @Override
        public void run() {
            try {
                in_mutex.acquire();
                mutex.acquire();
                readerCount++;
                if (readerCount == 1) rw_mutex.acquire();
                mutex.release();
                in_mutex.release();

                System.out.println("Thread "+Thread.currentThread().getName() + " is READING");
                Thread.sleep(1500);
                System.out.println("Thread "+Thread.currentThread().getName() + " has FINISHED READING");
                
                mutex.acquire();
                readerCount--;
                if (readerCount == 0) rw_mutex.release();
                mutex.release();

            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    

