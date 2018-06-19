/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.ct.dainf.if62c.pratica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Arrays.sort;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bisol
 */
public class ContadorPalavras {
    private BufferedReader reader;
    private int ocorrencia;
    private String caminho;

    public ContadorPalavras(String caminho) {
        try {
            this.reader = new BufferedReader(new FileReader(caminho));
            this.caminho = caminho;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ContadorPalavras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public HashMap<String, Integer> getPalavras() {
        HashMap<String, Integer> palavras = new HashMap<>();
        String linha, palavra="";
        int i = 0;
        
        try {
            while((linha = reader.readLine()) != null) {
                i=0;
                while(i<linha.length()){
                   
                    while(i<linha.length() && linha.charAt(i)!=' ') {
                        if(linha.charAt(i)=='.' || linha.charAt(i)==',')
                            break;
                        
                            palavra+=linha.charAt(i);
                            i++;
                    }                
                    if(!palavra.equals("")) {
                        if(palavras.containsKey(palavra)) {
                            ocorrencia = palavras.get(palavra);
                            palavras.put(palavra, ocorrencia+1);
                        } else {
                            palavras.put(palavra, 1);
                        }
                    }
                    i++;
                    palavra = "";
                }
            }
        reader.close();
        } catch (IOException ex) {
            Logger.getLogger(ContadorPalavras.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return palavras;
    }   
    
}
