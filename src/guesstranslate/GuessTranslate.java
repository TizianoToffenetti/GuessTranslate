/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guesstranslate;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Tiziano Toffenetti
 */
public class GuessTranslate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            String[][] traduzioni = new String[9][2];
            Scanner lettore = new Scanner(System.in);
            FileReader fr = new FileReader("data/traduzioni.txt");
            BufferedReader br = new BufferedReader(fr);

            int x = 0;
            while (br.ready()) {
                String s = br.readLine();
                String[] ss = s.split(",");
                if (ss.length != traduzioni[x].length) {
                    System.out.println("Errore");
                    continue;
                }
                traduzioni[x][0] = ss[0];
                traduzioni[x][1] = ss[1];
                x++;

                Random r = new Random();
                int n = r.nextInt(traduzioni.length);

                System.out.println("Traduci: " + ss[0]);
                String in = lettore.nextLine();

                if (in.equalsIgnoreCase(ss[0] = ss[1])) {
                    System.out.println("Risposta esatta");
                } else {
                    System.out.println("Risposta sbagliata");
                }
            }

        } catch (FileNotFoundException exc) {
            System.out.println("Errore" + exc.getMessage());

        } catch (IOException ex) {
            System.out.println("Errore" + ex.getMessage());
        }
    }
}
