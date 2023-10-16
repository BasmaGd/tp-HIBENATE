/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Date;
import ma.projet.beans.Femme;
import ma.projet.beans.Homme;
import ma.projet.beans.Mariage;
import ma.projet.beans.MariagePK;
import ma.projet.services.FemmeService;
import ma.projet.services.HommeService;
import ma.projet.services.MariageService;
import ma.projet.util.HibernateUtil;

/**
 *
 * @author DELL
 */
public class Test {

    public static void main(String[] args) {
        FemmeService fs = new FemmeService();
        HommeService hs = new HommeService();
        MariageService ms = new MariageService();
        //1==========================
         Femme femme1 = new Femme("Alice", "Dupont", "0612345678", "Paris", new Date("1990/05/15"));
        Femme femme2 = new Femme("Eva", "Martin", "0654321098", "Marseille", new Date("1985/10/20"));
        Femme femme3 = new Femme("Claire", "Lefebvre", "0678901234", "Lyon", new Date("1992/03/30"));
        Femme femme4 = new Femme("Sophie", "Garcia", "0612345678", "Toulouse", new Date("1988/09/25"));
        Femme femme5 = new Femme("Laura", "Petit", "0645678901", "Bordeaux", new Date("1994/06/07"));
        Femme femme6 = new Femme("Julie", "Robert", "0612345678", "Nice", new Date("1989/03/15"));
        Femme femme7 = new Femme("Marie", "Thomas", "0654321098", "Strasbourg", new Date("1991/08/20"));
        Femme femme8 = new Femme("Elise", "Dumont", "0678901234", "Lille", new Date("1997/02/10"));
        Femme femme9 = new Femme("Caroline", "Leroux", "0612345678", "Bordeaux", new Date("1993/11/30"));
        Femme femme10 = new Femme("Camille", "Lemoine", "0645678901", "Nantes", new Date("1986/07/04"));
// Enregistrement des femmes
        fs.create(femme1);
        fs.create(femme2);
        fs.create(femme3);
        fs.create(femme4);
        fs.create(femme5);
        fs.create(femme6);
        fs.create(femme7);
        fs.create(femme8);
        fs.create(femme9);
        fs.create(femme10);
        
       Homme homme1 = new Homme("Paul", "Dupont", "0612345678", "Paris", new Date("1990/05/15"));
        Homme homme2 = new Homme("Antoine", "Martin", "0654321098", "Marseille", new Date("1985/10/20"));
        Homme homme3 = new Homme("Thomas", "Lefebvre", "0678901234", "Lyon", new Date("1992/03/30"));
        Homme homme4 = new Homme("Lucas", "Garcia", "0612345678", "Toulouse", new Date("1988/09/25"));
        Homme homme5 = new Homme("Hugo", "Petit", "0645678901", "Bordeaux", new Date("1994/06/07"));

       // Enregistrement des hommes
        

        hs.create(homme1);
        hs.create(homme2);
        hs.create(homme3);
        hs.create(homme4);
        hs.create(homme5);

        MariagePK mpk1 = new MariagePK(1, 12, new Date("2023/03/09"));
        MariagePK mpk2 = new MariagePK(5, 13, new Date("2020/06/07"));
        MariagePK mpk3 = new MariagePK(6, 14, new Date("2020/03/09"));
        MariagePK mpk4 = new MariagePK(2, 12, new Date("2016/07/08"));
        MariagePK mpk5 = new MariagePK(4, 12, new Date("2022/06/06"));
        MariagePK mpk6 = new MariagePK(7, 12, new Date("2017/12/27"));
        MariagePK mpk7 = new MariagePK(9, 11, new Date("2017/09/17"));

        Mariage m1 = new Mariage(mpk1, null, 3);
        Mariage m2 = new Mariage(mpk2, new Date("2023/06/11"), 2);
        Mariage m3 = new Mariage(mpk3, null, 3);
        Mariage m4 = new Mariage(mpk4, new Date("2019/08/17"), 1);
        Mariage m5 = new Mariage(mpk5, new Date("2023/01/09"), 3);
        Mariage m6 = new Mariage(mpk6, new Date("2021/06/15"), 3);
        Mariage m7 = new Mariage(mpk7, new Date("2019/04/15"), 3);

        ms.create(m1);
        ms.create(m2);
        ms.create(m3);
        ms.create(m4);
        ms.create(m5);
        ms.create(m6);
        ms.create(m7);

//10.2
        for (Femme ff : fs.getAll()) {
            System.out.println(ff);
        }
//10.3
        System.out.println(fs.getFemmeLaPlusAgee().getNom());
//10.4
        hs.getEpousesParHomme(hs.getById(13));
        //10.5
        System.out.println(fs.nombreEnfantsEntreDates(2, new Date("1999/04/13"), new Date("2025/02/16")));
        //10.6
        for (Femme fem : fs.femmesMarieesDeuxFoisOuPlus()) {
            System.out.println(fem);
        }
//10.7
        hs.marriedByFourWomenBetweenDates(new Date("1995/01/11"), new Date("2025/05/11"));
//10.8
        for (Mariage m : hs.mariagesByHomme(hs.getById(12))) {
            System.out.println(m);
        }
    }
}
