package designPattern.observer;

import java.util.Observable;
import java.util.Observer;

public class ObserverB implements Observer{

    @Override
    public void update(Observable o, Object arg) {

	System.out.println("Observer B recieved the updating message!");
    }

}
