package com.ssafy.happyhouse.model;

public class AddressDto {
	private String sido;
	private String gugun;
	private String dong;
	public AddressDto() {}
	
	public AddressDto(String sido, String gugun, String dong) {
		super();
		this.sido = sido;
		this.gugun = gugun;
		this.dong = dong;
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getGugun() {
		return gugun;
	}

	public void setGugun(String gugun) {
		this.gugun = gugun;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}
	
	
}
