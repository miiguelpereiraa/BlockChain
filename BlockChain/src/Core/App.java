package Core;

import java.security.NoSuchAlgorithmException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MisterZii
 */
public class App {
    public static void main(String[] args) throws NoSuchAlgorithmException, InterruptedException {
        BlockChain bc = new BlockChain();
//        bc.add("Hello");
//        bc.add("World");
//        bc.add("of");
//        bc.add("Blockchain");
        bc.addPhone(0, "Primeiro Telefone");
        bc.addPhone(0, "Primeira reparação");
        bc.addPhone(1, "Segundo Telefone");
        bc.print();
//        for(Phone ph : bc.getBlockById(0)){
//            System.out.println(ph.getDesc());
//        }
    }
}
