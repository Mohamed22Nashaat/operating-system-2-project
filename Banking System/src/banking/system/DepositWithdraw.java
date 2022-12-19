/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banking.system;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Medo Nashaat
 */
public class DepositWithdraw {
     static int WithdrawCount = 0;
    static Semaphore mutex = new Semaphore(1);
    static Semaphore  in_mutex = new Semaphore(1);
    static Semaphore  rw_mutex = new Semaphore(1);
}
