package eu.andykrzemien.playAndSeek;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.andykrzemien.playAndSeek.domain.Message;
import eu.andykrzemien.playAndSeek.domain.Person;
import eu.andykrzemien.playAndSeek.model.MessagePost;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.GregorianCalendar;

public abstract class AppTest {

	protected final static String DEFAULT_MESSAGE_TEXT = "Lorem ipsum dolor sit amet...";

	protected static final MediaType APPLICATION_JSON_UTF8 = new MediaType(
			MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(),
			Charset.forName("utf8"));

	protected static Person getDefaultPerson() {
		return Person.builder()
				.id(1L)
				.firstName("Andy")
				.lastName("Flintstone")
				.shortName("Flint")
				.email("andy@gmail.com")
				.password("12345")
				.birthDate(new GregorianCalendar(1984, 2, 23).getTime())
				.city("Myslowice")
				.phone("79211234567")
				.build();
	}

	protected static Message getDefaultMessage() {
		final Person person = getDefaultPerson();
		final Message msg = new Message();
		msg.setSender(person);
		msg.setRecipient(person);
		msg.setBody(DEFAULT_MESSAGE_TEXT);
		return msg;
	}

	protected static MessagePost getDefaultMessagePost(Person person) {
		return new MessagePost(
				person.getId(),
				person.getId(),
				DEFAULT_MESSAGE_TEXT);
	}

	protected static Pageable getDefaultPageRequest() {
		return new PageRequest(0, 20);
	}

	protected static byte[] convertObjectToJsonBytes(Object object) throws IOException {
		final ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return mapper.writeValueAsBytes(object);
	}

}
