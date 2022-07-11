/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

/**
 *
 * @author meria
 */
public class FxmlLoader {
    private Pane view;
    
    
public Pane getPage(String fileName){

try{
    URL fileUrl= testFXMain.class.getResource("/GUI/" + fileName);
    if(fileUrl == null){
        throw new java.io.FileNotFoundException("FXML file Not Found");
    }
    
    view = new FXMLLoader().load(fileUrl);
        
    }catch (Exception e){
        System.out.println("No page " +fileName+ " Please check FxmlLoader.");
    }
return view;
}    
    
    
}
