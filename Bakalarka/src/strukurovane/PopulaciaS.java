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
    private int velkostElitnejMnoziny;
    private int[] elitnaMnozina;
    private double[] ucelovky;
    private Turnaj turnaj;


    public PopulaciaS(int pocetKandidatov, int velkostPopulacie, int maxMutacii, double sancaMutacie, Loader loader, double velkostElity) {
        this.pocetKandidatov = pocetKandidatov;
        this.velkostPopulacie = velkostPopulacie;
        this.maxMutacii = maxMutacii;
        this.sancaMutacie = sancaMutacie;
        this.loader = loader;
        populacia = new int[velkostPopulacie][pocetKandidatov];
        ucelovky = new double[velkostPopulacie];
        rnd = new Random();
        velkostElitnejMnoziny = (int) ((velkostElity / 100) * velkostPopulacie);
        elitnaMnozina = new int[velkostElitnejMnoziny];
        turnaj = new Turnaj(velkostPopulacie, pocetKandidatov);
    }

    public void vytvorZaciatocnuPopulaciu() {
        for (int i = 0; i < velkostPopulacie; i++) {
            populacia[i] = novyPrvok(null);
            ucelovky[i] = getHodnotuUcelovky(populacia[i]);
        }
    }

    public int[] novyPrvok(int[] pole) {
        if (pole == null) {
            pole = new int[pocetKandidatov];
        }
        for (int i = 0; i < pocetKandidatov; i++) {
            while (true) {
                int cislo = rnd.nextInt(loader.getMaxPocetZariadeni());
                if (!uzMaZariadenie(pole, cislo)) {
                    pole[i] = cislo;
                    break;
                }
            }
        }

        return pole;
    }

    private boolean uzMaZariadenie(int[] pole, int z) {
        for (int i = 0; i < pole.length; i++) {
            if (pole[i] == z) {
                return true;
            }
        }
        return false;
    }

    public void vypisPopulaciu() {
        for (int i = 0; i < populacia.length; i++) {
            for (int j = 0; j < populacia[i].length; j++) {
                System.out.print(populacia[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private double getHodnotuUcelovky(int[] pole) {
        double uc = 0;
        for (int i = 0; i < loader.getMaxPocetZariadeni(); i++) {
            if (!maZariadenie(i, pole)) {
                double najnizsia = Double.MAX_VALUE;
                for (int j = 0; j < pole.length; j++) {
                    if (loader.getVzdialenosti(i, j) < najnizsia) {
                        najnizsia = loader.getVzdialenosti(i, j);
                    }
                }
                uc += najnizsia;
            }

        }

        return uc;
    }

    private boolean maZariadenie(int zariadenie, int pole[]) {
        for (int i = 0; i < pole.length; i++) {
            if (pole[i] == zariadenie) {
                return true;
            }
        }
        return false;
    }
    public void vytvorElitnuMnozinu(int pocet,double najUcelovka) {
        double naj = 0;
        int index = -1;
        for (int i = 0; i < ucelovky.length; i++) {
            if(ucelovky[i] > naj && ucelovky[i] < najUcelovka) {
                naj = ucelovky[i];
                index = i;
            }
        }
        elitnaMnozina[pocet] = index;
        if(pocet +1 == velkostElitnejMnoziny) {
            return;
        }else {
            vytvorElitnuMnozinu(++pocet, naj);
        }
        
    }
    public void aa() {
        System.out.println("ucelovky");
        for (int i = 0; i < ucelovky.length; i++) {
            System.out.println(i + ": " + ucelovky[i]);
        }
        System.out.println("elita");
        for (int i = 0; i < elitnaMnozina.length; i++) {
            System.out.println(elitnaMnozina[i] + " ");
        }
    }
    

}
