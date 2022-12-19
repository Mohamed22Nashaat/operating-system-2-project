/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banking.system;

/**
 *
 * @author Medo Nashaat
 */
public class Deposit extends DepositWithdraw implements Runnable {
      @Override
        public void run() {
            try {
                in_mutex.acquire();
                rw_mutex.acquire();
                System.out.println("client  "+Thread.currentThread().getName() + " is deposting");
                Thread.sleep(2500);
                System.out.println("client "+Thread.currentThread().getName() + " has finished deposting");
                rw_mutex.release();
                in_mutex.release();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    
}