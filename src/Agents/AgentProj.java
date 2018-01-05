package Agents;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.*;
import jade.core.ContainerID;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.RowData;
public class AgentProj extends Agent{
	 Connection connection;
	//Record[][] dc = new Record [3][4]; // donnes recupere 
	 String prod;
     public void setup(){
        addBehaviour(new B());
 
                        }
     private class B extends SimpleBehaviour{
 
    	 private boolean _done;
    	 private int step=0;
 
 
            public void action(){
            	System.out.println("My name is "+ getLocalName());
            	System.out.println(" I'm in Main container ");
        		Object[] args = getArguments();
        		if (args != null){
        			for (int i = 0; i < args.length; i++) {
        			   System.out.println(" I'm try to buy "+(String)args[i]);
        			   prod=(String)args[i];
        	    }	
        		}else{
        			System.out.println("No arguments");
        		}
         //************************************Migration 1*************************************
 
             switch(step){
 
                     case 0:
                          System.out.println("\n Moving1 ...");
                          // on déclare la variable qui va contenir le nom du Container 
                         String containerName = "Container-1";
                         ContainerID destination = new ContainerID();
                         // on déclare la variable qui represente la destination
                          destination.setName(containerName);
                         // et on fait la migration
                         myAgent.doMove(destination);
                         System.out.println("Hello, I'm in container-1 ");
                         try
                         {
                             Class.forName("com.mysql.jdbc.Driver");
                             System.out.println("com.mysql.jdbc.Driver found");
                             connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/rhdb","root"," "+"?useSSL=false");
                             System.out.println("Connexion Ok");
                             Statement instruction = connection.createStatement();
                     		 ResultSet resultat = instruction.executeQuery("SELECT * FROM tab1 where nom_prod LIKE'"+prod+"'");
                     		  while(resultat.next()){
                     			  if (resultat!= null){
                     				  System.out.println(resultat.getString("prix_prod")); 
 
                     			  }
                     		  }
                         }
                         catch(Exception cnfe)
                         {
                             System.out.println("Error:"+cnfe.getMessage());
                         }
				         step++;
                        break;
          //***************************** Migration 2***********************************************              
                    case 1:
                         System.out.println("\n Moving2 ...");
                      // on déclare la variable qui va contenir le nom du Container 
                         String containerName2 = "Container-2";
                         ContainerID destination2 = new ContainerID();
                         // on déclare la variable qui represente la destination
                         destination2.setName(containerName2);
                         // et on fait la migration
                         myAgent.doMove(destination2);
                         System.out.println("Hello I'm in container-2 ");
                         try
                         {
                             Class.forName("com.mysql.jdbc.Driver");
                             System.out.println("com.mysql.jdbc.Driver found");
                             connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/rhdb","root"," "+"?useSSL=false");
                             System.out.println("Connexion Ok");
                             Statement instruction = connection.createStatement();
                     		 ResultSet resultat2 = instruction.executeQuery("SELECT * FROM tab2 where nom_prod LIKE'"+prod+"'");
                     		  while(resultat2.next()){
                     			  if (resultat2!= null){
                     				  System.out.println(resultat2.getString("prix_prod")); 
 
                     			  }
                     		  }
                         }
                         catch(Exception cnfe)
                         {
                             System.out.println("Error:"+cnfe.getMessage());
                         }
                         step++;
                         break;
          //******************************** Retour à Main container *******************************          
                    case 2:
 
                        System.out.println("\n\nMoving3 ...");
            			String containerName3 = "Main-Container";
                        ContainerID destination3 = new ContainerID();
                        // on déclare la variable qui represente la destination
                        destination3.setName(containerName3);
                        System.out.println("je vais retourner ...");
                        // et on fait la migration
                        myAgent.doMove(destination3);
                        System.out.println(" Les donnes recuperer :");
                        step++;
                        break;
 
        //********************************** Finich************************************************           
 
                  case 3:
                  _done=true;
                  System.out.println(" I'm finiche My work :The agent has terminated its itinirary");
 
                          }//end switch
   }//end action
            public boolean done()
            {
            	return _done;
            }
 
 
} // end setup
} // end AgentProj