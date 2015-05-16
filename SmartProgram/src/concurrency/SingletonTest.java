package concurrency;

@NotThreadSafe
public class SingletonTest {
    
    private SingletonTest instance;
    
    public SingletonTest getInstance() {
	
	if (instance == null) {
	    
	    instance = new SingletonTest();
	}
	
	return instance;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
