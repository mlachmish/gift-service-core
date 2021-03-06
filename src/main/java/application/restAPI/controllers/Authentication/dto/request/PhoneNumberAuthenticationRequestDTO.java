package application.restAPI.controllers.Authentication.dto.request;

import application.utils.ValidationUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

/**
 * Created by matan,
 * On 04/10/2016.
 */
@ApiModel(value = "PhoneNumberAuthenticationRequest")
public class PhoneNumberAuthenticationRequestDTO {

    @ApiModelProperty(value = "Phone number to be validated", name = "phoneNumber", example = "0501234567")
    @NotEmpty(message = "Phone number cannot be null or empty")
    @Pattern(regexp = ValidationUtils.IS_NUMERIC_REGEXP, message = "Phone number should contain numbers only")
    @Length(min = 10, max = 10, message = "Phone number should contain exactly 10 digits")
    private String phoneNumber;

    @ApiModelProperty(value = "Verification code to be validated", name = "verificationCode", example = "12345")
    @NotEmpty(message = "Phone number cannot be null or empty")
    @Pattern(regexp = ValidationUtils.IS_NUMERIC_REGEXP, message = "Verification code should contain numbers only")
    @Length(min = 5, max = 5, message = "Verification code should contain exactly 5 digits")
    private String verificationCode;

    public PhoneNumberAuthenticationRequestDTO() {
    }

    public PhoneNumberAuthenticationRequestDTO(String phoneNumber, String verificationCode) {
        this.phoneNumber = phoneNumber;
        this.verificationCode = verificationCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}