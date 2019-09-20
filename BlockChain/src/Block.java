
import java.io.Serializable;

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
    
    String fact;
    int hash;
    int previous;
    int nonce;
    int size;
    
    public Block(int previous, String data){
        this.previous = previous;
        this.fact = data;
        this.size = 2;
        Miner.mine(this);
    }
    
    public int calcHash(){
        return (previous + fact + nonce).hashCode();
    }
    
    public boolean isValid(){
        return calcHash() == hash;
    }
    
    public String toString(){
        return String.format("%10d %10s(%d) %10d %b", previous, fact, nonce, hash, isValid());
    }
    
}
