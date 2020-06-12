package Utils;


import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nielson Soares
 */
public class Utilitario {
    
    private Utilitario(){};
    
    public static String coonverteDataBrasilFormat(Date data){
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        return dateFormat.format(data);
    }
    
    public static String coonverteDataSQLFormat(Date data){
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        return dateFormat.format(data);
    }
}
