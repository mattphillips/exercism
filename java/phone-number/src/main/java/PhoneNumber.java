public class PhoneNumber {
	
	private static final int AREA_CODE_START_POSITION = 0;
	private static final int AREA_CODE_END_POSITION = 3;
	private static final int FIRST_BLOCK_END_POSITION = 6;
	private static final int MAX_SIZE = 10;
	private static final int NUMBER_WITH_PREFIX_SIZE = 11;
	private static final int PREFIX_POSITION = 1;

	private static final String VALID_PREFIX = "1";
	private static final String NON_WORD_REGEX = "\\W";
	private static final String EMPTY = "";
	private static final String INVALID_NUMBER = "0000000000";
	private static final String PRETTY_STRING_FORMAT = "(%s) %s-%s";
	
	private final String cleanNumber;
	private final String number;
	private final String areaCode;
	
	public PhoneNumber(final String number) {
		this.cleanNumber = cleanNumber(number);
		this.number = validateNumber(cleanNumber);
		this.areaCode = extractAreaCode(cleanNumber);
	}
	
	public String getNumber() {
		return number;
	}
	
	public String getAreaCode() {
		return areaCode;
	}
	
	public String pretty() {
		return String.format(
				PRETTY_STRING_FORMAT, 
				areaCode, 
				cleanNumber.substring(AREA_CODE_END_POSITION, FIRST_BLOCK_END_POSITION), 
				cleanNumber.substring(FIRST_BLOCK_END_POSITION, MAX_SIZE));
	}
	
	private String cleanNumber(final String number) {
		return checkNumberSize(number.replaceAll(NON_WORD_REGEX, EMPTY));
	}
	
	private String checkNumberSize(final String number) {
		if (number.length() == NUMBER_WITH_PREFIX_SIZE && number.startsWith(VALID_PREFIX)) 
			return number.substring(PREFIX_POSITION);
		
		return number;
	}
	
	private String validateNumber(final String number) {
		if (isNumberInvalid(number))
			return INVALID_NUMBER;
		
		return number;
	}
	
	private boolean isNumberInvalid(final String number) {
		return number.length() == 
				NUMBER_WITH_PREFIX_SIZE && !number.startsWith(VALID_PREFIX) 
				|| number.length() != MAX_SIZE;
	}

	private String extractAreaCode(String cleanNumber) {
		return cleanNumber.substring(AREA_CODE_START_POSITION, AREA_CODE_END_POSITION);
	}
}