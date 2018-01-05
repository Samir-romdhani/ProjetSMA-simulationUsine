package main;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import Agents.Atelier;
import Objects.Produits;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.util.ExtendedProperties;
import jade.util.Logger;
import jade.util.leap.Properties;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;


import Agents.Atelier;
import Objects.Produits;

public class projetsma {
	public static void main(String[] args) throws StaleProxyException, InterruptedException {
//      Driver driver = new Driver();
//      System.out.println(driver.getName());
//      System.out.println(driver.getCar());
//      System.out.println(driver.getDateIn());
//      System.out.println(driver.getDateOut());

      final Runtime runTime = Runtime.instance();
      runTime.setCloseVM(true);
      Profile mainProfile = new ProfileImpl(true);
      AgentContainer mainContainer = runTime.createMainContainer(mainProfile);
      AgentController rma = mainContainer.createNewAgent("rma", "jade.tools.rma.rma", null);
      rma.start();
      Thread.sleep(900);
      



      Profile anotherProfile;
      AgentContainer anotherContainer;
      AgentController agent;
      AgentController agent2;
     

      
      List<Produits> listP1 = new ArrayList<>(); 
      List<Produits> listP2 = new ArrayList<>();
      List<Produits> listP3 = new ArrayList<>();
      Produits p1 = new Produits("Table", 20, 4, 5) ;
      Produits p2 = new Produits("Chaise", 120, 4, 2) ;
      Produits p3 = new Produits("Buffet", 20, 4, 6) ;
      listP1.add(p1) ;
      listP2.add(p2) ;
      listP3.add(p3) ;
      Atelier Atelier1 = new Atelier(1, listP1);
      /////////////////////////
      Produits p4 = new Produits("Lit", 10, 2, 7) ;
      Produits p5 = new Produits("Chevet", 20, 2, 1) ;
      Produits p6 = new Produits("Armoire", 10, 2, 8) ;
      listP2.add(p4) ;
      listP2.add(p5) ;
      listP2.add(p6) ;
      Atelier Atelier2 = new Atelier(2, listP2) ;
     ////////////////////////////////////////
      Produits p7 = new Produits("Banquette", 20, 3, 6) ;
      Produits p8 = new Produits("Fauteuil", 120, 3, 3) ;
      Produits p9 = new Produits("Etagère", 20, 3, 8) ;
      listP3.add(p7) ;
      listP3.add(p8) ;
      listP3.add(p9) ;
      Atelier Atelier3 = new Atelier(2, listP3) ;
      
      //System.out.println("-----------------"+Atelier1.getProduitList().get(0).getfornisseur());

      
  /*   
      anotherProfile = new ProfileImpl(false);
      anotherContainer = runTime.createAgentContainer(anotherProfile);
      System.out.println("Starting up a Production...ControllerAgent");
      agent = anotherContainer.createNewAgent("ControllerAgent", "Agents.ControllerAgent", null);
      agent.start();
      Thread.sleep(900);    
*/
      anotherProfile = new ProfileImpl(false);
      anotherContainer = runTime.createAgentContainer(anotherProfile);
      System.out.println("Starting up a Production...");
      agent = anotherContainer.createNewAgent("Atelier", "Agents.Atelier", null);
      agent.start();
      Thread.sleep(900); 
      
      anotherProfile = new ProfileImpl(false);
      anotherContainer = runTime.createAgentContainer(anotherProfile);
      System.out.println("Starting up a Demandes...");
      agent = anotherContainer.createNewAgent("Clients", "Agents.Client", null);
      agent.start();
      Thread.sleep(900);
      
    
     
      /*
      anotherProfile = new ProfileImpl(false);
      anotherContainer = runTime.createAgentContainer(anotherProfile);
      System.out.println("Sending...");
      agent = anotherContainer.createNewAgent("Client1", "Agents.Client1", null);
      agent.start();
      Thread.sleep(900); 
      anotherProfile = new ProfileImpl(false);
      anotherContainer = runTime.createAgentContainer(anotherProfile);
      System.out.println("receive...");
      agent = anotherContainer.createNewAgent("Atelier1", "Agents.Atelier1", null);
      agent.start();
      Thread.sleep(900); 
        
      /*  
      ///////////
      try {
          anotherProfile = new ProfileImpl(false);
          anotherContainer = runTime.createAgentContainer(anotherProfile);
          AgentController a1 = anotherContainer.createNewAgent("Client1", "Agents.Client1", null);
          a1.start();  
          Thread.sleep(900);
          anotherProfile = new ProfileImpl(false);
          anotherContainer = runTime.createAgentContainer(anotherProfile);
          AgentController a2 = anotherContainer.createNewAgent("Atelier1", "Agents.Atelier1", null);
          a2.start();
          Thread.sleep(900);
    } catch (StaleProxyException ex) {
          
      }
  */
      
      String[] args0 = {"-gui","atelier1:Agents.Atelier1"};
      String[] args1 = {"-container","client1:Agents.Client1"};
      //jade.Boot.main(args0);
      //jade.Boot.main(args1);
      
      String[] args2 = {"-gui","Atelier:Agents.Atelier"};
      String[] args3 = {"-container","Client:Agents.Client"};
      String[] args4 = {"-container","Atelier:Agents.Atelier"};
      //jade.Boot.main(args2);
      //jade.Boot.main(args3);
      
      //jade.Boot.main(args4);
      
      String[] args5 = {"-gui","Acheteur:Agents.Acheteur"};
      String[] args6 = {"-container","Vendeur:Agents.Vendeur"};
      String[] args7 = {"-container","Portail:Agents.Portail"};
      //jade.Boot.main(args2);
      //jade.Boot.main(args3);
     
   
      

	}

}
