package kr.or.ddit.vo;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Member {
	
	@NotBlank(message = "아이디는 필수입력항목입니다.")
	private String userId = "stw777";
	
	@NotBlank(message = "이름는 필수입력항목입니다.")
	@Size(max = 3, message = "최대 3자리까지 가능!")
	private String userName = "서태웅";
	
	@NotBlank(message = "비밀번호는 필수입력항목입니다.")
	private String password = "7777";
	private int coin = 100;
	
	@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;
	
	@Email(message = "메일 형식이 이상합니다~")
	private String email;
	private String gender;
	private String hobby;
	private String[] hobbyArray;
	private List<String> hobbyList;
	private boolean foreigner;
	private String developer;
	private String nationality;
	
	// 중첩된 자바빈즈의 입력값 검증을 지정한다.
	@Valid
	private Address address;
	
	@Valid
	private List<Card> cardList;
	
	private String cars;
	private String[] carArray;
	private List<String> carList;
	
	private String introduction;
	private String birthDay;
}
