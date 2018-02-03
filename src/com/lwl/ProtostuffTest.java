package com.lwl;

import java.util.ArrayList;
import java.util.Collections;

import com.alibaba.fastjson.JSON;
import com.bruce.protostuff.runtime.RuntimeSchema;
import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;

public class ProtostuffTest {
	
	public static RuntimeSchema<UserInfo>  userInfoSchema = RuntimeSchema.createFrom(UserInfo.class);
	

	
	private void test(){
		
		UserInfo userInfo = new UserInfo(15, "李文龙", "男");
		
		byte[] byteArray = ProtostuffIOUtil.toByteArray(userInfo, userInfoSchema,
				LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
		System.out.println(byteArray.length);
		
		UserInfo userinfo = userInfoSchema.newMessage();
		ProtostuffIOUtil.mergeFrom(byteArray, userinfo, userInfoSchema);
		
		System.out.println(JSON.toJSONString(userinfo));
		
	}
	
	public static void main(String[] args) {
		
		new ProtostuffTest().test();
		
		
	}
	
	private void order() {
		ArrayList<String> data = new ArrayList<String>();
				
		data.add("ab");
		data.add("cc");
		data.add("bb");
		data.add("GG");
		data.add("EE");
		
		/*data.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return 0;
			}
		});*/
		
		Collections.sort(data);

		System.out.println(data);
	}
	
	
	

}
