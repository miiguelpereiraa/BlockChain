package Core;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import miners.MinerTHR;

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

    public static void mine(Block b) throws NoSuchAlgorithmException, InterruptedException {
//        int num = (int) Math.pow(10, b.size);
//        String prefix = String.format("%0"+b.size+"d", 0);
//        b.nonce = 0;
//        while (true) {
//            if (b.calcHash().startsWith(prefix)) {
//                b.hash = b.calcHash();
//                break;
//            }
//            b.nonce++;
//        }

        AtomicBoolean isDone = new AtomicBoolean(false);
        AtomicLong nonce = new AtomicLong(0);
        
        int procs = Runtime.getRuntime().availableProcessors();
        MinerTHR[] miner = new MinerTHR[procs];
        
        for (int i = 0; i < miner.length; i++) {
            miner[i] = new MinerTHR(isDone, nonce, b);
            miner[i].start();
        }
        
        for (int i = 0; i < miner.length; i++) {
            miner[i].join();
        }
        
        b.setNonce(nonce.get());
        
        MessageDigest hasher = MessageDigest.getInstance("SHA-256");
        byte[] bh = hasher.digest((b.getFact()+b.getNonce()).getBytes());
        b.setHash(Base64.getEncoder().encodeToString(bh));
    }
}
