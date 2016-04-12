package com.Nepian.Test;

import java.util.regex.Pattern;

public class PlayGround {

	public static void main(String[] args) {
		Pattern pat = Pattern.compile("add|remove", Pattern.CASE_INSENSITIVE);
		
		String pat1 = "add";
		String pat2 = "remove";
		String pat3 = "addd";
		String pat4 = "removeee";
		String pat5 = "addremove";
		String pat6 = "removeadd";
		
		println(pat.matcher(pat1).matches());
		println(pat.matcher(pat2).matches());
		println(pat.matcher(pat3).matches());
		println(pat.matcher(pat4).matches());
		println(pat.matcher(pat5).matches());
		println(pat.matcher(pat6).matches());
	}
	
	public static void println(Object obj) {
		System.out.println(obj);
	}
}
