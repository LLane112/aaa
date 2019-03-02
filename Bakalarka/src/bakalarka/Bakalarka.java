/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakalarka;

import strukurovane.PopulaciaS;

/**
 *
 * @author Ján
 */
public class Bakalarka {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Loader loader = new Loader();
        PopulaciaS ps = new PopulaciaS(10, 30, 0, 0, loader,20);
        ps.vytvorZaciatocnuPopulaciu();
        ps.vypisPopulaciu();
        ps.vytvorElitnuMnozinu(0, 1000000000);
        ps.aa();
    }
    
}
