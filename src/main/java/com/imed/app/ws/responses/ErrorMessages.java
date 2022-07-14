package com.imed.app.ws.responses;

public enum ErrorMessages {

		MISSING_REQUIRED_FILED("Missing required filed."),
		RECORD_ALREADY_EXISTS("Record already exists."),
		INTERNAL_SERVER_ERROR("Internal imed server error."),
		NO_RECORD_FOUND("record with provided id is not found.");
		
		private String errorMessage;

		private ErrorMessages(String errorMessage) {
			this.errorMessage = errorMessage;
		}

		public String getErrorMessage() {
			return errorMessage;
		}

		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}
		
}
