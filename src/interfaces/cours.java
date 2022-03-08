/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import javafx.collections.ObservableList;
import model.Cours;

/**
 *
 * @author dell
 */
public interface cours {
    public void ajouterCours(Cours c);//add ajouter
    public List<Cours> afficher(); //afficher, select
   public void SupprimerParId(Cours c);
   public void ModifierCours(Cours c);
    public void rechercherParId(Cours c);
    
}
