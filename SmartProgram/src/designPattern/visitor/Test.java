package designPattern.visitor;


/**
 * 访问者模式是将数据结构与操作解耦
 * 适用于数据结构相对稳定，操作易于变化的模型
 * @author dzp
 *
 */
public class Test {

	public static void main(String[] args) {

		Quote quote = new StockQuote();
		quote.accept(new BasicQuoteVisitor());
		quote.accept(new FastQuoteVisitor());
		
	}

}
