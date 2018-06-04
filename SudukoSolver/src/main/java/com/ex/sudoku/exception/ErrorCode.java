package com.ex.sudoku.exception;

public enum ErrorCode {
	
	ERROR_VALUE_BELOW_BOUND("ERROR-SUD01","Element value below minimum bound "),
	ERROR_VALUE_ABOVE_BOUND("ERROR-SUD02","Element value above max bound "),
	ERROR_SUBSECTION_SIZE_INVALID("ERROR-SUD03","Subsection should be sqaure root of board length ");
	
	private final String errorCode;
	
	private final String errorMessage;
	
	
	public String getErrorCode() {
		return errorCode;
	}


	public String getErrorMessage() {
		return errorMessage;
	}


	ErrorCode(String errorCode,String errorMessage) {
		this.errorCode=errorCode;
		this.errorMessage=errorMessage;
	}
	
	

}
