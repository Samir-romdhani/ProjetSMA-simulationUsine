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


      
  /*   
      anotherProfile = new ProfileImpl(false);
      anotherContainer = runTime.createAgentContainer(anotherProfile);
      System.out.println("Starting up a Production...ControllerAgent");
      agent = anotherContainer.createNewAgent("ControllerAgent", "Agents.ControllerAgent", null);
      agent.start();
      Thread.sleep(900);    

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
  */    
    
     
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
      jade.Boot.main(args2);
      jade.Boot.main(args3);
     
	}

}
