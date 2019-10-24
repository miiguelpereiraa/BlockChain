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

public class BlockChain {
    
    //Blockchain
    protected ArrayList<Phone> chain = new ArrayList<>();
    
//    public void add(String data) throws NoSuchAlgorithmException, InterruptedException{
//        String prev = getLastBlock();
//        Block block = new Block(prev, data);
//        chain.add(block);
//    }
    /**
     * Adiciona um novo bloco à blockchain, dado um id e uma descrição
     * @param id int que representa o id do telefone
     * @param desc String com uma descrição
     * @throws NoSuchAlgorithmException
     * @throws InterruptedException 
     */
    public void addPhone(int id, String desc) throws NoSuchAlgorithmException, InterruptedException{
        String prev = getLastBlock();
        Phone block = new Phone(prev, id, desc);
        chain.add(block);
    }
    
    /**
     * Obtém o último bloco da blockchain
     * @return String com o último bloco da blockchain
     */
    public String getLastBlock(){
        if(chain.isEmpty())
            return "";
        return chain.get(chain.size() - 1).hash;
    }
    
    /**
     * Imprime os blocos da blockchain
     */
    public void print(){
        for (Block block : chain) {
            System.out.println(block.toString());
        }
    }
    
    /**
     * Obtém a lista de blocos com o id enviado por parâmetro
     * @param id Int que representa o Id do bloco a procurar
     * @return Lista de blocos que correspondem ao id fornecido
     */
    public List<Phone> getBlockById(int id){
        ArrayList<Phone> phones = new ArrayList<>();
        for (Phone phone : chain) {
            if(phone.getId() == id)
                phones.add(phone);
        }
        return phones;
    }
}
