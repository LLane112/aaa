/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strukurovane;

import bakalarka.Loader;
import java.util.Random;

/**
 *
 * @author Ján
 */
public class PopulaciaS {
    private int pocetKandidatov;
    private int velkostPopulacie;
    private int maxMutacii;
    private double sancaMutacie;
    private Loader loader;
    private int[][] populacia;
    private Random rnd;

    public PopulaciaS(int pocetKandidatov, int velkostPopulacie, int maxMutacii, double sancaMutacie,Loader loader) {
        this.pocetKandidatov = pocetKandidatov;
        this.velkostPopulacie = velkostPopulacie;
        this.maxMutacii = maxMutacii;
        this.sancaMutacie = sancaMutacie;
        this.loader = loader;
        populacia = new int[velkostPopulacie][pocetKandidatov];
        rnd = new Random();
    }
    public void vytvorZaciatocnuPopulaciu() {
        for (int i = 0; i < velkostPopulacie; i++) {
            
        }
    }
    public int[] novyPrvok() {
        int[] pole = new int[pocetKandidatov];
        for (int i = 0; i < pocetKandidatov; i++) {
            int cislo = rnd.nextInt(loader.getMaxPocetZariadeni());
        }
        
        
        return pole;
    }
    private boolean uzMaZariadenie(int[] pole,int z) {
        
    }
    
    
    
}
