/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberEscape.SMA;

import bomberEscape.go.Position;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.core.AID;


/**
 *
 * @author Matheus
 */
public class PlayerAgent extends Agent {
    public Position lastPosition;
    
    protected void setup(){
//        lastPosition = new Position(0, 0);
    }
    
    
       public void updatePosition(Position position){
        if(lastPosition == null){
            lastPosition = position;
        }
        
        if((position.getX() != lastPosition.getX() || position.getY() != lastPosition.getY())){
            System.out.println(position.toString());
            lastPosition = position;
        }
    }
}
