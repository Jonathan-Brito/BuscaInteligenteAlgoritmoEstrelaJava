/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturas;

/**
 *
 * @author Jonathan
 */
public class Recursao {
    int i = 0;
    
    public void funcao() {
        System.out.println("Executando");
        if (i < 5) {
            i++;
            funcao();
        }
        
    }
    
    public static void main(String args[]) {
        Recursao r = new Recursao();
        r.funcao();
    }
}
