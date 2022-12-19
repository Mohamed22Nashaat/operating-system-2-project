/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package banking.system;

/**
 *
 * @author Medo Nashaat
 */
public class BankingSystem {

    /**
     * @param args the command line arguments
     */
  public static void main(String[] args) {
        Withdraw w1 = new Withdraw();
        Deposit d1 = new Deposit();
        Thread t1 = new Thread((Runnable) w1);
        t1.setName("client 1");
        Thread t2 = new Thread((Runnable) w1);
        t2.setName("client 2");
        Thread t3 = new Thread(d1);
        t3.setName("client 3");
        Thread t4 = new Thread((Runnable) w1);
        t4.setName("client 4");
        t1.start();
        t3.start();
        t2.start();
        t4.start();
  }
}
