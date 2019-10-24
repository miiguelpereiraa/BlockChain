/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.security.NoSuchAlgorithmException;


public class Phone extends Block{
    
    private int id;
    private String desc;
    
    /**
     * Constrói um bloco com informação sobre o telemóvel, dado o hash do bloco anterior, o id do telefone e uma descrição
     * @param previous Hash do bloco anterior
     * @param id Id do telefone
     * @param desc Descrição
     * @throws NoSuchAlgorithmException
     * @throws InterruptedException 
     */
    public Phone(String previous, int id, String desc) throws NoSuchAlgorithmException, InterruptedException {
        super(previous, id+desc);
        this.id = id;
        this.desc = desc;
    }

    /**
     * Obtém o id de um bloco
     * @return int que representa o id do bloco
     */
    public int getId() {
        return id;
    }
    
    /**
     * Imprime a informação de Phone
     * @return String com a informação sobre o Phone
     */
    @Override
    public String toString(){
        return String.format("%20s | %d , %10s |(%6d)| %20s ", previous, id, desc, nonce, hash);
    }
    
    
}
