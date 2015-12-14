package ss.week5;

import java.util.HashMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapUtil {
    public static <K, V> boolean isOneOnOne(Map<K, V> map) {
        boolean result = true;
        Object[] keyList = map.keySet().toArray();
        Object[] valueList = map.values().toArray();
		
    	
        for(int i = 0; i < map.values().size(); i++) {
    		int counter = 0;
        	for(int j = 0; j < map.keySet().size(); j++) {
        		if (valueList[i] == map.get(keyList[j])) {
        			counter = counter + 1;
        		}               	
        	}
            if(counter != 1) {
            	result = false;
            }
        }
        return result;
    }

    public static <K, V>  boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
		boolean result = true;
    	for (Object e : range){
			if (!map.values().contains(e)) { 
				result = false;
			}
		}
		return result;
	}
   
    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
		Map<V, Set<K>> result = new HashMap<V, Set<K>>();
		for (K k : map.keySet()){
			if (!result.containsKey(map.get(k)))
				result.put(map.get(k), (new HashSet<K>()));		
			result.get(map.get(k)).add(k);
		}	
		return result;

	}
	public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
		Map<V, K> result = new HashMap<V, K>();
			for(K k : map.keySet()) {
				result.put(map.get(k), k);
			}
        return result;
	}
	public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
        boolean result = true;
		for(V v : f.values()) {
        	if(!g.keySet().contains(v)) {   
        		result = false;
        	}
        }
		
        return result;
	}
	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
		Map<K, W> result = new HashMap<K, W>();
		if(!compatible(f, g)) {
        	return null;
        }
		for (K k : f.keySet()){
			result.put(k, g.get(f.get(k)));
        
		}
	return result;
	}
}
