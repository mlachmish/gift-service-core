package application.restAPI.controllers.Authentication;

import application.restAPI.controllers.Authentication.dto.request.PhoneNumberAuthenticationRequestDTO;
import application.restAPI.controllers.Authentication.dto.request.VerifyPhoneNumberRequestDTO;
import application.restAPI.controllers.Authentication.dto.response.TokenResponseDTOImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by matan,
 * On 07/10/2016.
 */
@RequestMapping("/authentication")
public interface AuthenticationControllerAPI {
    //POST
    @ApiOperation(
            value = "Verify a phone number",
            notes = "This method will be the first API call for clients." +
                    "The client will provide a phone number which should be authenticated via SMS",
            code = 202,
            position = 2)
    @RequestMapping(path = "/phoneNumberChallenge", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity verifyPhoneNumber(@ApiParam(name = "VerifyPhoneNumberRequest", required = true)
                                     @Valid @NotNull @RequestBody VerifyPhoneNumberRequestDTO verifyPhoneNumberRequestDTO);

    @ApiOperation(
            value = "Get token with phone number challenge",
            notes = "This method will be called by by clients at initial login, \n" +
                    "after the client possess a verification code that was sent via SMS. \n" +
                    "As a result client will get a token object which he can later use in order to consume gift API",
            response = TokenResponseDTOImpl.class,
            position = 1)
    @RequestMapping(path = "/token", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity getTokenWithPhoneNumberChallenge(@ApiParam(name = "PhoneNumberAuthenticationRequest", required = true)
                                                    @Valid @NotNull @RequestBody PhoneNumberAuthenticationRequestDTO phoneNumberAuthenticationRequest) throws AuthenticationException;
}
