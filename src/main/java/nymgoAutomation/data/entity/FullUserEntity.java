package nymgoAutomation.data.entity;

/**
 * Created by Iuliia Khikmatova on Oct 8, 2015
 */
public class FullUserEntity {

	String username;
    String password;
    String fullName;
    String email;
    String mobile;
    String phone;
    String countryOfResidence;
    String city;
    String fullAddress;
    String street;
    String postalCode;
    String displayCurrency;
    String paymentCurrency;
    String language;
    String geoIpCountry;
    String VAT;

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCountryOfResidence() {
		return countryOfResidence;
	}

	public void setCountryOfResidence(String countryOfResidence) {
		this.countryOfResidence = countryOfResidence;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getDisplayCurrency() {
		return displayCurrency;
	}

	public void setDisplayCurrency(String displayCurrency) {
		this.displayCurrency = displayCurrency;
	}

	public String getPaymentCurrency() {
		return paymentCurrency;
	}

	public void setPaymentCurrency(String paymentCurrency) {
		this.paymentCurrency = paymentCurrency;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String getGeoIpCountry() {
		return geoIpCountry;
	}

	public void setGeoIpCountry(String geoIpCountry) {
		this.geoIpCountry = geoIpCountry;
	}
	
	public String getVat() {
		return VAT;
	}

	public void setVat(String VAT) {
		this.VAT = VAT;
	}
	
	public FullUserEntity(){
		
		this.username = "";
		this.password = "";
		this.fullName = "";
		this.email = "";
		this.mobile = "";
		this.phone = "";
		this.countryOfResidence = "";
		this.city = "";
		this.fullAddress = "";
		this.street = "";
		this.postalCode = "";
		this.displayCurrency = "";
		this.paymentCurrency = "";
		this.language = "";
		this.geoIpCountry = "";
		this.VAT = "";
	}
	
	public FullUserEntity(Object[] obj){
		setUsername(String.valueOf(obj[0]));
		setPassword(String.valueOf(obj[1]));
		setFullName(String.valueOf(obj[2]));
		setEmail(String.valueOf(obj[3]));
		setMobile(String.valueOf(obj[4]));
		setPhone(String.valueOf(obj[5]));
		setCountryOfResidence(String.valueOf(obj[6]));
		setCity(String.valueOf(obj[7]));
		setFullAddress(String.valueOf(obj[8]));
		setStreet(String.valueOf(obj[9]));
		setPostalCode(String.valueOf(obj[10]));
		setDisplayCurrency(String.valueOf(obj[11]));
		setPaymentCurrency(String.valueOf(obj[12]));
		setLanguage(String.valueOf(obj[13]));
	}
}
