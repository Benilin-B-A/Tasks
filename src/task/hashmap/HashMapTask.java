package task.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import utils.InvalidInputException;
import utils.UtilityActions;

public class HashMapTask {
	
	public static <K, V> HashMap<K,V> getHashMap() {	//create and return a Hasmap
		return new HashMap<K,V>();
	}
	
	public static <K,V> int getSize(Map<K,V> map)	//returns size of hasmap
			throws InvalidInputException{
		UtilityActions.checkNull(map);
		return map.size();
	}
	
	public static<K,V> V insertEntry(Map<K,V> map,K obj1,V obj2) 
			throws InvalidInputException {
		UtilityActions.checkNull(map);
		map.put(obj1,obj2);   //make an entry in an Hasmap
		return obj2;
	}
	
	public boolean checkValPresence(Map<String, String> map,String val) 
			throws InvalidInputException{  //check if a value is present in Hasmap
		UtilityActions.checkNull(map);
		return map.containsValue(val);
	}

	public Set<String> getKeySet(Map<String,String> map)
			throws InvalidInputException{  //returns the KeySet of the Hasmap
		UtilityActions.checkNull(map);
		return map.keySet();
	}
	
	public String getValue(Map<String, String> map,String keyVal)
			throws InvalidInputException{	//get value of a key
		UtilityActions.checkNull(map);
		return map.get(keyVal);		
	}

	public void removeKey(Map<String, String> map, String rKey)
			throws InvalidInputException {	//remove key from Hasmap
		UtilityActions.checkNull(map);
		map.remove(rKey);		
	}

	public void removeKey(Map<String,String> map,String rKey,String val)
			throws InvalidInputException {	//remove key only if existing value matches
		UtilityActions.checkNull(map);
		map.remove(rKey, val);		
	}

	public void replaceKeyVal(Map<String, String> map, String replaceKey, String replaceVal)
			throws InvalidInputException {	//replace the given key's value
		UtilityActions.checkNull(map);
		map.replace(replaceKey, replaceVal);
	}

	public void replaceKeyVal(Map<String, String> map, String replaceKey, String oldVal, String replaceVal)
			throws InvalidInputException {	//replace key's value only if matched with given key's corresponding value
		UtilityActions.checkNull(map);
		map.replace(replaceKey, oldVal, replaceVal);
	}
	
	public void mergeMap(Map<String,String> map1,Map<String,String> map2) 
			throws InvalidInputException {  //copy all mapings from one hasmap to another
		UtilityActions.checkNull(map1);
		UtilityActions.checkNull(map2);
		map1.putAll(map2);		
	}

	public void clearAllEntries(Map<String, String> map)
			throws InvalidInputException {  //clear all entries in a hasmap
		UtilityActions.checkNull(map);
		map.clear();
	}

	/*public String insertIfAbs(Hasmap<String, String> map,String getKey, String str)
			throws InvalidInputException {  //put an entry if absent
		UtilityActions.checkNull(map);
		map.putIfAbsent(getKey, str);
		return str;
	}*/

	public String getDefault(Map<String, String> map, String key, String string)
			throws InvalidInputException {  //gets the value for given key or default value if key doesn't exist
		UtilityActions.checkNull(map);
		return map.getOrDefault(key, string);
	}
	
	public boolean checkKeyPresence(Map<String,String> map,String key)
			throws InvalidInputException {
		UtilityActions.checkNull(map);
		return map.containsKey(key);
	}
	
}