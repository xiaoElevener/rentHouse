package com.xiao.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class GeneratorPasswordUtil {
	
	public static String getHashPassword(String password,String user_id){
		
		String hashAlgorithmName = "MD5";
        int hashIterations = 1024;
        ByteSource salt = ByteSource.Util.bytes(user_id);
        Object obj = new SimpleHash(hashAlgorithmName, password, salt, hashIterations);
		return obj.toString();
	}
}
