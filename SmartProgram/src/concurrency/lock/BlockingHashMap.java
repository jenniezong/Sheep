/**
 * 
 */
package concurrency.lock;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author zongnan
 *
 */
public class BlockingHashMap {
	
	private ConcurrentMap<String, List> map = new ConcurrentHashMap<String, List>();

}
