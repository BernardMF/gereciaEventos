/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventools.custom;

import javafx.scene.control.TextField;

/**
 *
 * @author Bernardo
 */
public class LetraTextField extends TextField{
    public LetraTextField(){
        this.setPromptText("");
    }
    
    @Override
    public void replaceText(int i, int i1, String string){
        if(string.matches("[a-zA-Z]") || string.isEmpty()){
            super.replaceText(i, i1, string);
        }
    }
    
    @Override
    public void replaceSelection(String string){
        super.replaceSelection(string);
    }
}
