/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import model.Abonnement;

/**
 *
 * @author NEEEGROO
 */
public interface abonnement_i {
     public void ajouterAbonnement(String t ,String j);
     public List<Abonnement> afficherAbonnement();
     public void SupprimerAbonnement (Abonnement a);
     public void ModifierAbonnement (Abonnement a,int id);
     public String SelectRole (String login);
    
}
