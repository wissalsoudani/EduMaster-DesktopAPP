/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
// lid.getSelectionModel().selectedIndexProperty().addListener(observable -> System.out.printf("Indice sélectionné: %d", lid.getSelectionModel().getSelectedIndex()).println());

/**
 *
 * @author dell
 */
public class Cours {

    private Integer id_cours;
    private String nom_cours;
    private String contenu_cours;
    private Integer nb_pages;
    private Integer nb_chapitres;

//contucteur parametre
//constructeur parametre

    public Cours(Integer id_cours, String nom_cours, String contenu_cours, Integer nb_pages, Integer nb_chapitres) {
        this.id_cours = id_cours;
        this.nom_cours = nom_cours;
        this.contenu_cours = contenu_cours;
        this.nb_pages = nb_pages;
        this.nb_chapitres = nb_chapitres;
    }

        
    public Cours(String nom_cours) {
        this.nom_cours = nom_cours;
    }
   
    
    

//constructeur par defaut
    public Cours() {
    }

    //constructeur parametre SANS ID 

    public Cours(String nom_cours, String contenu_cours, Integer nb_pages, Integer nb_chapitres) {
        this.nom_cours = nom_cours;
        this.contenu_cours = contenu_cours;
        this.nb_pages = nb_pages;
        this.nb_chapitres = nb_chapitres;
    }
   

    public Integer getId_cours() {
        return id_cours;

    }

    public void setId_cours(Integer id_cours) {
        this.id_cours = id_cours;
    }

    public Integer getNb_pages() {
        return nb_pages;
    }

    public void setNb_pages(Integer nb_pages) {
        this.nb_pages = nb_pages;
    }

    public Integer getNb_chapitres() {
        return nb_chapitres;
    }

    //getters & setters
    public void setNb_chapitres(Integer nb_chapitres) {   
        this.nb_chapitres = nb_chapitres;
    }

    public String getNom_cours() {
        return nom_cours;
    }

    public void setNom_cours(String nom_cours) {
        this.nom_cours = nom_cours;
    }

    public String getContenu_cours() {
        return contenu_cours;
    }



    public void setContenu_cours(String contenu_cours) {
        this.contenu_cours = contenu_cours;
    }

   

    

    // toString

    @Override
    public String toString() {
        return "Cours{" + "id_cours=" + id_cours + ", nom_cours=" + nom_cours + ", contenu_cours=" + contenu_cours + ", nb_pages=" + nb_pages + ", nb_chapitres=" + nb_chapitres + '}';
    }
   

}
