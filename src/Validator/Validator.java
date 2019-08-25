package Validator;

import java.util.ArrayList;

public class Validator {

	public static ArrayList<String> validate(String value1, String value2, String name1, String name2){

	    ArrayList<String> error = new ArrayList<>();

	    String errorcheck = "";

	    errorcheck = checkEmpty(value1,name1);
	    if(!"".equals(errorcheck)){
	        error.add(errorcheck);
	    }
	    errorcheck = checkEmpty(value2,name2);
	    if(!"".equals(errorcheck)){
	        error.add(errorcheck);
	    }
	    return error;
	}

	public static String checkEmpty(String value,String name){
        if(value == null || "".equals(value) ){
            return name + "を入力してください";
        }
        return "";
    }
}
