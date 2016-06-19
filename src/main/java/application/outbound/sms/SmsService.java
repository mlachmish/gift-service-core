package application.outbound.sms;

import application.configuration.PropertiesConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by matan,
 * On 28/05/2016.
 */

@Service
public class SMSService {

    private static final Logger log = Logger.getLogger( SMSService.class.getName() );

    @Autowired
    private TwilioClient twilioClient;

    @Autowired
    PropertiesConfiguration propertiesConfiguration;

    public void sendVerificationSMS(String toNumber, int verificationCode) {
        if (propertiesConfiguration.getSmsDisabled()) {
            log.log(Level.INFO, "Skipping SMS sending , SMS service is disabled");
            return;
        }

        String text = "Welcome to Gift App, your verification code is: " + verificationCode;

        twilioClient.sendSMS(toNumber,text);
        log.log(Level.INFO, "Verification SMS sent to: " + toNumber);
    }

}