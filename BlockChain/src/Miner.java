/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MisterZii
 */
public class Miner {

    public static void mine(Block b) {
        int num = (int) Math.pow(10, b.size);
        b.nonce = 0;
        while (true) {
            if (b.calcHash() % num == 0) {
                b.hash = b.calcHash();
                break;
            }
            b.nonce++;
        }
    }
}
