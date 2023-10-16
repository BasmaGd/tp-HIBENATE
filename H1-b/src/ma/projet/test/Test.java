/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ma.projet.entity.Produit;
import ma.projet.service.ProduitService;
import ma.projet.util.HibernateUtil;

/**
 *
 * @author DELL
 */
public class Test {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateDebut = null;
        Date dateFin = null;
        ProduitService ps = new ProduitService();
        Produit p1 = new Produit("YAN&ONE", "SUPER",  new Date("2020/01/20"), 90.0,"RAL");
        Produit p2 = new Produit("ESSENCE", "SUPER", new Date("2020/02/20"), 190.0, "MASCARA");
        Produit p3 = new Produit("GOLDEN", "SUPER", new Date("2020/03/20"), 120.0, "GR");
        Produit p4 = new Produit("MAC", "MAKEUP", new Date("2020/04/20"), 200.0, "GLOSE");
        Produit p5 = new Produit("HBT", "GAMME", new Date("2020/05/20"), 600.000, "HAUTEGAMME");
//        ps.create(p1);
//        ps.create(p2);
//        ps.create(p3);
//        ps.create(p4);
//        ps.create(p5);
        for (Produit p : ps.findAll()) {
            System.out.println(p);
        }
        System.out.println(ps.findById(2));
      //  ps.delete(ps.findById(3));
     Produit pp = ps.findById(1);

 pp.setDateAchat(new Date());
        ps.update(pp);
        
        for (Produit p : ps.findAll()) {
            if (p.getPrix() > 100) {
                System.out.println(p);
            }
        }
        System.out.println("entrez la date de debut ");
        try {
            dateDebut = dateFormat.parse(s.nextLine());
        } catch (ParseException ex) {
            System.out.println("date invalide");
        }
        System.out.println("entrez la date de fin");
        try {
            dateFin = dateFormat.parse(s.nextLine());
        } catch (ParseException ex) {
            System.out.println("date non valide");
        }
        for (Produit p : ps.findAll()) {
            if (p.getDateAchat().after(dateDebut) && p.getDateAchat().before(dateFin)) {
                System.out.println(p);
            }
        }
}
}
    
    
