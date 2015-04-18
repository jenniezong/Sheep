package general;

public class PlusPlusTest {

    public static void main(String[] args) {

	int i = 0;
	i = i++;
	System.out.println(i);

	i = i++ + ++i;
	System.out.println(i);

	int j = 0;
	for (int k = 0; k < 100; k++) {
	    j = j++;
	}

	System.out.println(j);
    }

}
