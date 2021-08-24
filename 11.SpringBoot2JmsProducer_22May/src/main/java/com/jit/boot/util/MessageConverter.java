package com.jit.boot.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jit.boot.model.CircInfo;

public class MessageConverter {
	public static String convertCircInfo(CircInfo c) {
		String data = null;
		try {
			data = new ObjectMapper().writeValueAsString(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}