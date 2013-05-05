package com.d3.common.utils;

public class BtagUtils {

	public static String toUrlSafe(String btag) {
		return btag.replaceAll("#", "-");
	}
	
	public static String fromUrlSafe(String urlBtag) {
		return urlBtag.replaceAll("-", "#");
	}
	
}
