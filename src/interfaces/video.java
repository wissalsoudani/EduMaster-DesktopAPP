/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.Date;
import java.util.List;
import model.Video;

/**
 *
 * @author dell
 */
public interface video {
     public void ajouterVideo(Video v);//add ajouter
    public List<Video> afficher(); //afficher, select
   public void SupprimerParId(Video v);
   public void ModifierVideo(Video v);
}
