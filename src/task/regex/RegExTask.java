package task.regex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utils.InvalidInputException;
import utils.UtilityActions;

public class RegExTask {
	
	private static Pattern mobilePattern =
			Pattern.compile("^[7-9]{1}[0-9]{9}$");
	private static Pattern alphaNumeric =
			Pattern.compile("\\A[0-9a-z]+\\Z",Pattern.CASE_INSENSITIVE);
	private static Pattern mailPattern = 
			Pattern.compile("\\A[a-zA-Z0-9+-_~]+@[a-zA-Z]+.[a-zA-Z]{2,}");
	private static Pattern tagPattern = Pattern.compile("<[^>]*>");
	//"[[a-z]+[A-Z]+[0-9]+[!@#$%^&*()_+]+]{8,}"

	 public boolean validateMobile(String num)
			 throws InvalidInputException {
		return validate(mobilePattern,num);
	}

	public boolean validateAlphaNum(String alphaNum) 
			throws InvalidInputException {
		return validate(alphaNumeric,alphaNum);
	}
	
	public boolean validateMail(String mail)
			throws InvalidInputException {
		return validate(mailPattern, mail);
	}
	
	public boolean validateStartsWith(String pattern,String matcher)
			throws InvalidInputException {
		Pattern pat = getPattern("^"+pattern);
		return validate(pat, matcher);
	}
	
	public boolean validateEndsWith(String pattern,String matcher)
			throws InvalidInputException {
		Pattern pat = getPattern(pattern+"$");
		return validate(pat, matcher);
	}
	
	public boolean validateContains(String pattern,String matcher)
			throws InvalidInputException{
		UtilityActions.checkNull(pattern);
		Pattern pat = getPattern(pattern);
		return validate(pat, matcher);
	}
	
	public boolean validateExact(String pattern,String matcher)
			throws InvalidInputException{
		Pattern pat = getPattern("\\A"+pattern+"\\Z");
		return validate(pat, matcher);
	}
	
	public List<String> validateCaseIns(String[] strArr, String str)
			throws InvalidInputException {
		UtilityActions.checkNull(strArr);
		Pattern pattern = Pattern.compile("\\A"+str+"\\Z",Pattern.CASE_INSENSITIVE);
		int len = strArr.length;
		List<String> list= new ArrayList<>();
		for(int i=0;i<len;i++) {
			boolean isValid = validate(pattern, strArr[i]);
			if(!isValid) {
				list.add(strArr[i]);
			}
		}
		return list;
	}
	
	public Map<String, Integer> getMap(List<String> keyList,List<String> valList)
			throws InvalidInputException {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		Pattern pat = getPattern(keyList.toString());
		boolean isValid = validate(pat, valList.toString());	
		if(!isValid) {
			return map;
		}
		for(String string : keyList) {
			map.put(string, valList.indexOf(string));
		}	return map;
	}
	
	public List<String> getTags(String hString)
			throws InvalidInputException{
		UtilityActions.checkNull(hString);
		Matcher matcher = tagPattern.matcher(hString);
		List<String> list = getList();
		while(matcher.find()) {
			list.add(matcher.group());
		}
		return list;
	}
		
	private boolean validate(Pattern pattern, String str) 
			throws InvalidInputException {
		UtilityActions.checkNull(str);
		return pattern.matcher(str).find();
	}	
	
	private static Pattern getPattern(String str){
		return Pattern.compile(str);
	}
	
	public static List<String> getList(){
		return new ArrayList<String>();
	}

	/*private boolean match(Pattern pattern,String str)
			throws InvalidInputException {
		UtilityActions.checkNull(str);
		return pattern.matcher(str).matches();
	}*/
}
