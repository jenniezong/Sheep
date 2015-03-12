package designPattern.observer;

public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {

	Subject sb = new Subject();
	sb.addObserver(new ObserverA());
	sb.addObserver(new ObserverB());
	sb.operation();
    }

}
