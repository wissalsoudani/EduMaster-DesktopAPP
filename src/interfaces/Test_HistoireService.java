/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import model.Test_histoire;

/**
 *
 * @author user
 */
public interface Test_HistoireService {
  public void AjouterTest_histoire(Test_histoire t);
    //select
    public List<Test_histoire> afficherTest_histoire();
    //delete
    public void SupprimerTest_histoire(Test_histoire T);
    //update
    public boolean ModifierTest_histoire(Test_histoire T); 
       
}
