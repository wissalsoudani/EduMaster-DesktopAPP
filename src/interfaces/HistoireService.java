/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import model.Histoire;
import model.Test_histoire;
/**
 *
 * @author user
 */
public interface HistoireService <t> {
    
    //add
    public void AjouterHistoire(Histoire h);
    //select
    public List<Histoire> afficherhistoire();
    //delete
    public void SupprimerHistoire(Histoire h);
    //update
    public boolean ModifierHistoire (Histoire H); 
    //rechercher par nom
    public List<Histoire>rechercherHistoire(String nomCherche);
   // public int histoireID();
    
    
    ////////////////////////
    
   
    
}
