package com.vacinaweb.zuprestservice.enums;

public enum VaccineStatus {
		
		NOT_VACCINED(1),
		VACCINED(2);
	
		private int code;
		
		private VaccineStatus(int code) {
			this.code = code;
		}
		
		public int getCode() {
			return code;
		}
		
		public static VaccineStatus valueOf(int code) {
			for(VaccineStatus value : VaccineStatus.values()) {
				if(value.getCode() == code) {
					return value;
				}
			}
			throw new IllegalArgumentException("Invalid VaccineStatus code");
		}
}
