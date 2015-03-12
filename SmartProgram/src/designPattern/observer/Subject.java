package designPattern.observer;

import java.util.Observable;

public class Subject extends Observable{

    
    public void operation() {
	System.out.println("Update the message!");
	setChanged();
	notifyObservers();
    }
}
