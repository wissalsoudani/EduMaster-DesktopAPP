/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import javafx.collections.ObservableList;
import model.User;

/**
 *
 * @author NEEEGROO
 */
public interface user_i {
    public void ajouterUser(User u);
    public List<User> afficherUser();
    public void Supprimer_Id(User u);
    public void ModifierUser(User u,int id);
    public void MettrejourUser(String Login,String mdp);
    public boolean VerifierCompte(String login,String mdp);
    public void Mails(String login);
    public boolean VerifierCompteAdmin(String login,String mdp);
    public void ajouterAdmin(User u);
    public List<User> afficherAdmin();
    public boolean ComparerCode(String c,String login);
    public void Supprimer_Id_Admin(User u);
    public void ModifierAdmin(String Login,String Mdp,String Mail,int id);
    public ObservableList<User> chercherUserid(String email);
    public void ChangerEtat(String login);
    public void ChangerEtatd(String login);
    public void ChangerEtatetat();
    public User GetUserConnected();
}
