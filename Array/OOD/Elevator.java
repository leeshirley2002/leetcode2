/*
<<enumeration>> Direction
Up
Down

<<enumeration>> Status
Up
Down
Idle

ExternalRequest                            
-direction                   
-int level

InternalRequest
-int level
                                                

--> ElevatorSystem                                
-List<Elevator> elevators              
+boolean handleRequest(ExternalRequest r)

---------> Elevator                  
-List<ElevatorButton> buttons
-List<Integer> upStops
-List<Integer> downStops
-int currentLevel
-Status status
-boolean gateOpen
-float weightLimit

+void handleExternalRequest(ExternalRequest r)
+void handleInternalRequest(InternalRequest r)
-boolean isRequestValid(InternalRequest r)
-void openGate()
-void closeGate()
-float checkWeight()


------>  ElevatorButton
-int level
Elevator elevator
+pressButton()
*/

enum Direction{
    Up,
    Down
}
enum Status{
    Up,Down,Idle
}
public interface Request{
    private int level;    
}
public class ExternalRequest implements Request{
    private Direction direction;
    private level;
    public ExternalRequest(Direction d, int l){
        this.direction = d;
        this.level = l;
    }
}
public class InternalRequest implements Request{

}
public class Passenger{
    private float weight;

    public void sendExternalRequest(){
    }
    public void sendInternalRequest(){
    }
}

public class ElevatorSystem{
    private List<Elevator> elevators;

    public void handleExternalRequest(ExternalRequest r){
        boolean flag = false;
        //add elevators that 
        for(Elevator e:elevators){
            if(e.status == r.direction){
                if(r.direction == Up && e.currentLevel < r.level){
                    e.;
                    flag = true;
                }else if(r.direction == Down && e.currentLevel > r.level){
                    e.downStops.add(r.level);
                    sort(downStops);
                    flag = true;
                }
            }
        }
        if(flag == false){
            for(Elevator e:elevators){
                if(e.status == Idle){
                    if(e.level > r.level){
                        e.;
                        flag = true;
                    }else if(e.level < r.level){
                        e.upStops.add(r.level);
                        e.status = Up;
                        flag = true;
                    }else{
                        e.openGate();
                    }
                }
            }
        }
        if(flag == false){
            //deal with the reversed direction
        }
    }
}
public class Elevator{
    private List<Button> buttons;
    private Status status;
    private List<Integer> upStops;
    private List<Integer> downStops;
    private float weightLimit;
    private boolean gateOpen;
    private int currentLevel;
    private List<Passenger> passengers;
    public void handleExternalRequest(ExternalRequest r){
        if(r.)
    }
    public void handleInternalRequest(InternalRequest r){}
    public boolean isValidRequest()
    public void closeGate(){}
    public void openGate(){}
    public float checkWeight(){}
}
public class Button{
    private int level;
    public void pressButton(){}
}
