/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
/**
 *                                                      
 * @author user
 */
public class Histoire {

    //att 
   private int id_histoire;
    private int age;
    private String langue;
    private String nom_histoire;
    private String contenu_histoire;
    private String couverture_histoire;
    private String catégorie;
    
     
    
    //constructor
    public Histoire(int id_histoire, int age, String langue, String nom_histoire, String contenu_histoire, String couverture_histoire, String catégorie) {   
        this.id_histoire = id_histoire;
        this.age = age;
        this.langue = langue;
        this.nom_histoire = nom_histoire;
        this.contenu_histoire = contenu_histoire;
        this.couverture_histoire = couverture_histoire;
        this.catégorie = catégorie;
    }

    public Histoire(int age, String langue, String nom_histoire, String contenu_histoire, String couverture_histoire, String catégorie) {
        this.age = age;
        this.langue = langue;
        this.nom_histoire = nom_histoire;
        this.contenu_histoire = contenu_histoire;
        this.couverture_histoire = couverture_histoire;
        this.catégorie = catégorie;
    }
    

    //constructor_pardefaut
    public Histoire() {
    }

    public Histoire(int id_histoire) {
        this.id_histoire = id_histoire;
    }

    public Histoire(String nom_histoire) {
        this.nom_histoire = nom_histoire;
    }

    public int getId_histoire() {
        return id_histoire;
    }

    public void setId_histoire(int id_histoire) {
        this.id_histoire = id_histoire;
    }
   
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getNom_histoire() {
        return nom_histoire;
    }

    public void setNom_histoire(String nom_histoire) {
        this.nom_histoire = nom_histoire;
    }

    public String getContenu_histoire() {
        return contenu_histoire;
    }

    public void setContenu_histoire(String contenu_histoire) {
        this.contenu_histoire = contenu_histoire;
    }

    public String getCouverture_histoire() {
        return couverture_histoire;
    }

    public void setCouverture_histoire(String couverture_histoire) {
        this.couverture_histoire = couverture_histoire;
    }

    public String getCatégorie() {
        return catégorie;
    }

    public void setCatégorie(String catégorie) {
        this.catégorie = catégorie;
    }
    
    
    //afficher

    @Override
    public String toString() {
        return "Histoire{" + "id_histoire=" + id_histoire + ", age=" + age + ", langue=" + langue + ", nom_histoire=" + nom_histoire + ", contenu_histoire=" + contenu_histoire + ", couverture_histoire=" + couverture_histoire + ", cat\u00e9gorie=" + catégorie + '}';
    }

   

    

    
    
}
