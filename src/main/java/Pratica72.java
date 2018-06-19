
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import utfpr.ct.dainf.if62c.pratica.ContadorPalavras;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bisol
 */
public class Pratica72 {
    public static void main(String[] args) {
        String endereco;
        ContadorPalavras contador;
        Scanner teclado = new Scanner(System.in);
        HashMap<String, Integer> palavras;
        
        System.out.println("Digite o caminho completo para o seu arquivos");
            endereco = teclado.next();
        
        contador = new ContadorPalavras(endereco);
        palavras = contador.getPalavras();
        
        List<Map.Entry<String, Integer>> listaPalavras = new ArrayList(palavras.entrySet());
        
        Collections.sort(listaPalavras, (o1, o2) -> -o1.getValue().compareTo(o2.getValue()));   
       
        endereco+=".out";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(endereco));
            
            for(Map.Entry<String, Integer> palavra: listaPalavras) {
                writer.write(palavra.getKey()+','+palavra.getValue());
                writer.newLine();
            }
        writer.close();
        } catch (IOException ex) {
            Logger.getLogger(ContadorPalavras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
