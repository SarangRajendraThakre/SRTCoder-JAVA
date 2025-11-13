package com.srt.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserInfoRequest {

	
private String	name;
private String		email;
private String		password;
	
}
