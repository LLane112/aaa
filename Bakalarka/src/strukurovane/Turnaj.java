/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strukurovane;

import java.util.Random;

/**
 *
 * @author Ján
 */
public class Turnaj {

    private int[] rodic1;
    private int[] rodic2;
    private Random rnd;
    private int velkostPopulacie;
    private int pocetKandidatov;

    public Turnaj(int velkostPopulacie, int pocetKandidatov) {
        rnd = new Random();
        this.velkostPopulacie = velkostPopulacie;
        this.pocetKandidatov = pocetKandidatov;
    }

    public int[] convert(int[] pole, int velkostPopulacie) {
        int[] nove = new int[velkostPopulacie];
        for (int i = 0; i < pole.length; i++) {
            nove[pole[i]] = 1;
        }
        return nove;
    }

    public int[] getRodic1() {
        return rodic1;
    }

    public int[] getRodic2() {
        return rodic2;
    }

    public void setRodic1() {

    }

    public void setRodic2() {

    }

    public void turnajRodicov(int rodic, int[] ucelkovky, int[][] populacia) {
        int index1 = rnd.nextInt(velkostPopulacie);
        int index2 = rnd.nextInt(velkostPopulacie);
        if (index1 == index2 && index2 - 1 < ucelkovky.length) {
            index2++;
        }
        if (index1 == index2 && index2 + 1 == ucelkovky.length) {
            index1--;
        }
        int najIndex = -1;
        double najUcelovka = 0;
        for (int i = Math.min(index1, index2); i < Math.max(index1, index2); i++) {
            if (ucelkovky[i] > najUcelovka) {
                najIndex = i;
                najUcelovka = ucelkovky[i];
            }
        }
        if (rodic == 1) {
            rodic1 = populacia[najIndex];
        } else {
            rodic2 = populacia[najIndex];
        }

    }

    private int[] naNulaJedna(int[] pole) {
        int[] polee = new int[velkostPopulacie];
        for (int i = 0; i < pole.length; i++) {
            if (pole[i] != -1) {
                polee[pole[i]] = 1;
            }
        }
        return polee;
    }

    private int[] zNulaJedna(int[] pole) {
        int polee[] = new int[pocetKandidatov];
        int pocet = 0;
        for (int i = 0; i < pole.length; i++) {
            if (pole[i] == 1) {
                polee[pocet] = i;
                pocet++;
            }
        }
        return polee;
    }

    public void krizenie() {
        int[] rodic110 = naNulaJedna(rodic1);
        int[] rodic210 = naNulaJedna(rodic2);

        for (int i = 0; i < rodic110.length; i++) {
            if (rodic110[i] != rodic210[i]) {
                int cislo = rnd.nextInt(2);
                if (cislo == 0) {
                    rodic110[i] = 1;
                    rodic210[i] = 0;
                } else {
                    rodic110[i] = 0;
                    rodic210[i] = 1;
                }
            }
        }
        int a = pocet1(rodic110);
        int b = pocet1(rodic210);
        if(a < 0) {
            a*=-1;
            pridajZariadenie(rodic110, a);
        }else if(a > 0) {
            odoberZariadenie(rodic110, a);
        }
         if(b < 0) {
            b*=-1;
            pridajZariadenie(rodic210, b);
        }else if(b > 0) {
            odoberZariadenie(rodic210, b);
        }

    }

    private int pocet1(int[] pole) {
        int pocet = 0;
        for (int i = 0; i < pole.length; i++) {
            if (pole[i] == 1) {
                pocet++;
            }
        }
        return pocetKandidatov - pocet;
    }

    private void pridajZariadenie(int pole[], int pocet) {
        while (pocet > 0) {
            int cislo = rnd.nextInt(velkostPopulacie);
            if (pole[cislo] != 1) {
                pole[cislo] = 1;
                pocet--;
            }
        }
    }

    private void odoberZariadenie(int pole[], int pocet) {
        int[] pole1 = zNulaJedna(pole);
        while (pocet > 0) {
            int cislo = rnd.nextInt(pocetKandidatov);
            pole1[cislo] = -1;
            pocet--;
        }
        pole = naNulaJedna(pole1);
    }

}
