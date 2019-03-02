/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakalarka;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ján
 */
public class Loader {
    private double[][] distances;
    private HashMap<Integer,String> names;

    public Loader() {
        loadFiles();
    }
    
    
    public void loadFiles() {
        try {
            File f = new File("maticaVzdialenosti.txt");
            Scanner sc = new Scanner(f);
            int row = sc.nextInt();
            int column = sc.nextInt();
            distances = new double[row][column];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    distances[i][j] = sc.nextDouble();
                }
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*
        File f1 = new File("nazvyCentier.txt");
        try {
            Scanner s = new Scanner(f1);
            String p = s.nextLine();
            int count=  Integer.parseInt(p);
            for (int i = 0; i < count; i++) {
                String b = s.nextLine();
                String array[] = b.split(". ");
                names.put(Integer.parseInt(array[0]) - 1, array[1]);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    public double getVzdialenosti(int x,int y) {
        return distances[x][y];
    }

    public HashMap<Integer, String> getNames() {
        return names;
    }
    public int getMaxPocetZariadeni() {
        return distances.length;
    }
    
    
    
    
}
