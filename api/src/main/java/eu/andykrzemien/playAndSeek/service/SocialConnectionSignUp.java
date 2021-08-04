package eu.andykrzemien.playAndSeek.service;

import lombok.RequiredArgsConstructor;
import eu.andykrzemien.playAndSeek.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class SocialConnectionSignUp implements ConnectionSignUp {

    private static final Logger log = LoggerFactory.getLogger(SocialConnectionSignUp.class);

    private final PersonService personService;

    @Override
    public String execute(Connection<?> connection) {
        final UserProfile profile = connection.fetchUserProfile();
        log.debug("Authenticating social request: {}", profile);

        final String email = profile.getEmail();
        if (!StringUtils.isEmpty(email)) {
            Person person = personService.findByEmail(email);
            if (person == null) {
                person = personService.create(profile.getFirstName(), profile.getLastName(), email, "");
                log.info("New person: {} was successfully authenticated by email: {}", person, email);
            } else {
                log.info("Existing person: {} was successfully authenticated by email: {}", person, email);
            }
        } else {

            log.error("Failed to authenticate person with blank email from connection: {}", connection);
        }

        return email;
    }

}
