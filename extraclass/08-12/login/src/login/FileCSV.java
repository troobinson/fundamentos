
package login;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileCSV {
   
    
    
   public static final String SEPARATOR=";";
   public static final String QUOTE="\"";

    public static String ReadFile(String userL,String passwordL) throws IOException
    {

      BufferedReader br = null;
      
      String user = "";
      String password = "";
      String message = "";
      Boolean existe;
      
      try 
      {
         br = new BufferedReader(new FileReader("Users.txt"));
         String line = br.readLine();
         existe = false;
         while (line != null)
         {
            String [] fields = line.split(SEPARATOR);
            fields = removeTrailingQuotes(fields);
            user = fields[0];
            password = fields[1];
            if (user.toString().equals(userL.toString()))
            {
                existe = true;
                message = "Usuario Aceptado.";
                if (!password.toString().equals(passwordL.toString()))
                {
                    message = "Contraseña Incorrecta.";
                }
            }   
            line = br.readLine();
         }
         if (existe == false)
         {
             message = "Usuario no existe";
         }
         
      } 
      catch (Exception e)
      {
         message = "En este momento no podemos atender la solicitud";
      } 
      finally 
      {
         if (null!=br) { br.close(); }
         return (message);
      }
    }
    
    private static String[] removeTrailingQuotes(String[] fields) {

      String result[] = new String[fields.length];

      for (int i=0;i<result.length;i++){
         result[i] = fields[i].replaceAll("^"+QUOTE, "").replaceAll(QUOTE+"$", "");
      }
      return result;
   }
    
}

