package lab_5.individual_lab;
import kareltherobot.*; 


/**
 * @author :  D. Appel
 */
public class TreasureBot extends Robot
{
    int beeperCount = 0;
    public TreasureBot(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void findTreasure() {
        main();
    }
    
    public void faceNorth() {
        while(!facingNorth()) {
            turnLeft();
        }
    }
    
    public void faceEast() {
        while(!facingEast()) {
            turnLeft();
        }
    }
    
    public void faceSouth(){
        while(!facingSouth()) {
            turnLeft();
        }
    }
    
    public void faceWest(){
        while(!facingWest()) {
            turnLeft();
        }
    }
    
    public void main() {
        while(!nextToABeeper()) {
            move();
        }      
        while(nextToABeeper()){
            pickAndCount();
            faceCorrectDirection();
            putDownBeepers();
            if(beeperCount == 5) {
                turnOff();
            }
            else {
                beeperCount = 0;
                move();
                main();
            }
        }
    }
    
    public void pickAndCount() {
        while(nextToABeeper()) {
            pickBeeper();
            beeperCount++;
        }
    }
    
    public void putDownBeepers(){
        for(int i = beeperCount; i > 0; i--){
            putBeeper();
        }
    }
    
    public void faceCorrectDirection() {
        if(beeperCount == 1){
            faceNorth();
        }
        if(beeperCount == 2) {
            faceEast();
        }
        if(beeperCount == 3){
            faceSouth();
        }
        if(beeperCount == 4) {
            faceWest();
        }
    }
   
}

