package lab_5.individual_lab;
import kareltherobot.*; 


/**
 * @author :  D. Appel
 */
public class DemocracyBot extends Robot
{
    int moveCount = 0;
    public DemocracyBot(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void fixBallots() {
        while(moveCount < 7) {
            findBeeper();
            if(moveCount < 7){
                clearTopRoom();
                clearBottomRoom();
            }
        }
    }
    
    public void faceNorth(){
        while(!facingNorth()) {
            turnLeft();
        }
    }
    
    public void faceSouth(){
        while(!facingSouth()) {
            turnLeft();
        }
    }
    
    public void faceEast(){
        while(!facingEast()) {
            turnLeft();
        }
    }
    
    public void faceWest(){
        while(!facingWest()) {
            turnLeft();
        }
    }
    
    public void findBeeper(){
        while(!nextToABeeper() && moveCount < 7){
            move();
            moveCount++;
        }
    }
    
    public void clearTopRoom(){
        faceNorth();
        move();
        pickBeeper();
        faceSouth();
        move();
    }
    
    public void clearBottomRoom(){
        faceSouth();
        move();
        pickBeeper();
        faceNorth();
        move();
        faceEast();
        move();
    }
   
}

