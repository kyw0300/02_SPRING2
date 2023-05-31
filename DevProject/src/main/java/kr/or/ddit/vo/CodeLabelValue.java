package kr.or.ddit.vo;

import lombok.Data;

@Data
public class CodeLabelValue {

	private String value;
	private String label;
	
	public CodeLabelValue() {}
	public CodeLabelValue(String value, String label) {
		this.value = value;
		this.label = label;
	}
}
