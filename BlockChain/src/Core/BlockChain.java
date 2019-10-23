package Core;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MisterZii
 */
public class BlockChain {
    
    protected ArrayList<Phone> chain = new ArrayList<>();
    
//    public void add(String data) throws NoSuchAlgorithmException, InterruptedException{
//        String prev = getLastBlock();
//        Block block = new Block(prev, data);
//        chain.add(block);
//    }
    
    public void addPhone(int id, String desc) throws NoSuchAlgorithmException, InterruptedException{
        String prev = getLastBlock();
        Phone block = new Phone(prev, id, desc);
        chain.add(block);
    }
    
    public String getLastBlock(){
        if(chain.isEmpty())
            return "";
        return chain.get(chain.size() - 1).hash;
    }
    
    public void print(){
        for (Block block : chain) {
            System.out.println(block.toString());
        }
    }
    
    public List<Phone> getBlockById(int id){
        ArrayList<Phone> phones = new ArrayList<>();
        for (Phone phone : chain) {
            if(phone.getId() == id)
                phones.add(phone);
        }
        return phones;
    }
}
