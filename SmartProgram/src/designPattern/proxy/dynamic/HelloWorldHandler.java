package designPattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HelloWorldHandler implements InvocationHandler {

	//要代理的原始对象
	private Object obj;
	
	public HelloWorldHandler(Object obj) {

		super();
		this.obj = obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result = null;

		doBefore();
		result = method.invoke(obj, args);
		doAfter();
		
		return result;
	}

	private void doBefore() {

		System.out.println("Before method invoke");
	}
	
	private void doAfter() {
		
		System.out.println("after method invoke");
	}
}
