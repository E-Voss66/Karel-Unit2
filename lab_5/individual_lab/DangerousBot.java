package lab_5.individual_lab;
import kareltherobot.*; 


/**
 * @author :  D. Appel
 */
public class DangerousBot extends Robot
{
    int beeperCount = 0;
    public DangerousBot(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void choosePile() {
        pickUpBeepers();
        if(pileIsOdd()){
            faceWest();
            move();
        }
        else {
            faceEast();
            move();
        }
    }
    
    public void faceWest() {
        while(!facingWest()) {
            turnLeft();
        }
    }
    
    public void faceEast() {
        while(!facingEast()) {
            turnLeft();
        }
    }
    
    public void pickUpBeepers(){
        while(nextToABeeper()){
            pickBeeper();
            beeperCount++;
        }
    }
    
    public boolean pileIsOdd() {
        if(beeperCount % 2 == 0) {
            return false;
        }
        else {
            return true;
        }
    }
}

