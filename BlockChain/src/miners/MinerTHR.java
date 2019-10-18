/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miners;

import Core.Block;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author MisterZii
 */
public class MinerTHR extends Thread{
    
    AtomicBoolean isDone;
    AtomicLong nonce;
    Block block;
    
    public MinerTHR(AtomicBoolean isDone, AtomicLong nonce, Block blk){
        this.isDone = isDone;
        this.nonce = nonce;
        this.block = blk;
    }
    
    public void run(){
        try {
            MessageDigest hasher = MessageDigest.getInstance("SHA-256");
            String prefix = String.format("%0"+block.getSize()+"d",0);
            
            while(!isDone.get()){
                long num = nonce.getAndIncrement();
                
                //Falta ligar ao previous
                //Criar objecto telemovel que herda de bloco e alteramos apenas o fact - criar os atributos que precisamos nele
                String msg = block.getFact() + num;
                byte[] h = hasher.digest(msg.getBytes());
                String txtH = Base64.getEncoder().encodeToString(h);
                
                if(txtH.startsWith(prefix)){
                    nonce.set(num);
                    isDone.set(true);
                }
                
                
                
            }
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(MinerTHR.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
