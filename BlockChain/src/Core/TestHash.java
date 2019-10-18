package Core;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MisterZii
 */
public class TestHash {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        
        MessageDigest hasher = MessageDigest.getInstance("SHA-256");
        
        String txt = "olá";
        String key = "00";
        int i = 0;

        while(true) {
            String msg = txt + i++;
            byte[] h = hasher.digest(msg.getBytes());
            String txtH = Base64.getEncoder().encodeToString(h);
            
            System.out.println(msg + "\t " + txtH);
            if(txtH.startsWith(key))
                break;
        }

           
//           BlockChain bc = new BlockChain();
//           bc.add("Hello");
//           bc.add("World");
//           bc.add("of");
//           bc.add("blockchain");
//           bc.print();
    }
}
