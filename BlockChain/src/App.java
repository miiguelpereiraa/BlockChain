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
    public static void main(String[] args) {
        BlockChain bc = new BlockChain();
        bc.add("Hello");
        bc.add("World");
        bc.add("of");
        bc.add("Blockchain");
        bc.print();
        bc.save();
    }
}
