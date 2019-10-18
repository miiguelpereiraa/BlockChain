package Core;


import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MisterZii
 */
public class Block implements Serializable{
    
    String previous;
    
    protected String fact;
    
    protected String hash;
    protected long nonce;
    protected int size;

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public long getNonce() {
        return nonce;
    }

    public void setNonce(long nonce) {
        this.nonce = nonce;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public Block(String previous, String data) throws NoSuchAlgorithmException, InterruptedException{
        this.previous = previous;
        this.fact = data;
        this.size = 4;
        Miner.mine(this);
    }
    
    public String calcHash() throws NoSuchAlgorithmException{
        //return (previous + fact + nonce).hashCode();
        MessageDigest hasher = MessageDigest.getInstance("SHA-256");
        String msg = (previous + fact + nonce);
        byte[] hbytes = hasher.digest(msg.getBytes());
        return Base64.getEncoder().encodeToString(hbytes);
    }
    
    public boolean isValid() throws NoSuchAlgorithmException{
        return calcHash().equals(hash);
    }
    
    //CONFIRMAR MÉTODO
    public String toString(){
        try {
            return String.format("%20s %10s (%6d) %20s %b", previous, fact, nonce, hash, isValid());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Block.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
}
