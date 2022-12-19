/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banking.system;

/**
 *
 * @author Medo Nashaat
 */
public class Withdraw extends DepositWithdraw implements Runnable{
     @Override
        public void run() {
            try {
                in_mutex.acquire();
                mutex.acquire();
                WithdrawCount++;
                if (WithdrawCount == 1) rw_mutex.acquire();
                mutex.release();
                in_mutex.release();

                System.out.println("cleint "+Thread.currentThread().getName() + " is withdrawing");
                Thread.sleep(1500);
                System.out.println("client "+Thread.currentThread().getName() + " has FINISHED withdrawing");
                
                mutex.acquire();
                WithdrawCount--;
                if (WithdrawCount == 0) rw_mutex.release();
                mutex.release();

            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
