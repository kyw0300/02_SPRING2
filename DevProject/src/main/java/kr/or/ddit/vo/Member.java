package kr.or.ddit.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Member {
	private String userId = "stw777";
	private String userName = "서태웅";
	private String password = "7777";
	private int coin = 100;
	
	@DateTimeFormat(pattern = "yyyyMMdd")
	private Date dateOfBirth;
}
