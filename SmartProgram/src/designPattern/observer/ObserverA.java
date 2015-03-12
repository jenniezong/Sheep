package designPattern.observer;

import java.util.Observable;
import java.util.Observer;

public class ObserverA implements Observer{

    @Override
    public void update(Observable o, Object arg) {

	System.out.println("Observer A recieved the updating message!");
    }

    

}
