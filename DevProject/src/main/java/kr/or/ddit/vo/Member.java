package kr.or.ddit.vo;

import java.util.Date;
import java.util.List;

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
	
	private String email;
	private String gender;
	private String hobby;
	private String[] hobbyArray;
	private List<String> hobbyList;
	private boolean foreigner;
	private String developer;
	private String nationality;
	private Address address;
	private List<Card> cardList;
	private String cars;
	private String[] carArray;
	private List<String> carList;
	
	private String introduction;
	private String birthDay;
}
