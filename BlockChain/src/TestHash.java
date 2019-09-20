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

    public static void main(String[] args) {
        String txt = "olá";
        System.out.println(txt + " " + txt.hashCode());

        for (int i = 0; i < 100; i++) {
            System.out.println(txt + i + "\t" + (txt + i).hashCode());
        }
    }
}
