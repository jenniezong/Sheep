package file.statistics;
public class ConcurrencyMainTest {

	public static void main(String[] args) {
		for (String arg : args) {
			StatisticsIfThread thread = new StatisticsIfThread(arg);
			thread.start();
		}

	}

}
