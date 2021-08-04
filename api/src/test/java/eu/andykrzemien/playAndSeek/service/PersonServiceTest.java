package eu.andykrzemien.playAndSeek.service;

import eu.andykrzemien.playAndSeek.AppTest;
import eu.andykrzemien.playAndSeek.domain.Gender;
import eu.andykrzemien.playAndSeek.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.GregorianCalendar;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PersonServiceTest extends AppTest {

	@Autowired
	private PersonService personService;

	@Test
	public void shouldFindPersonWithCorrectIdAndFields() throws Exception {
		final Person person = personService.findById(2L);

		assertThat(person.getId()).isEqualTo(2L);
		assertThat(person.getFirstName()).isEqualTo("Alex");
		assertThat(person.getLastName()).isEqualTo("Krz");
		assertThat(person.getShortName()).isEqualTo("Ola");
		assertThat(person.getFullName()).isEqualTo("Alex Krz");
		assertThat(person.getEmail()).isEqualTo("alex@gmail.com");
		assertThat(person.getPhone()).isEqualTo("792112347");
		assertThat(person.getBirthDate()).isEqualTo(new GregorianCalendar(1956, 10, 19).getTime());
		assertThat(person.getGender()).isEqualTo(Gender.FEMALE);
//		...
	}

	@Test
	public void shouldFindPersonWithCorrectEmail() throws Exception {
		final Person person = personService.findByEmail("alex@gmail.com");

		assertThat(person.getId()).isEqualTo(2L);
		assertThat(person.getEmail()).isEqualTo("alex@gmail.com");
	}

	@Test
	public void shouldFindAllPeople() throws Exception {
		final Page<Person> people = personService.getPeople("", getDefaultPageRequest());

		assertThat(people).hasSize(16);
		assertThat(people)
				.extracting("id", "fullName")
				.contains(
						tuple(1L, "Andy Flintstone"),
						tuple(2L, "Alex Krz"));
	}

	@Test
	public void shouldFindAllFriends() throws Exception {
		final Person person = personService.findById(1L);
		final Page<Person> friends = personService.getFriends(person, "", getDefaultPageRequest());

		assertThat(friends).hasSize(10);
		assertThat(friends)
				.extracting("id", "fullName")
				.contains(
						tuple(1L, "Andy Flintstone"),
						tuple(5L, "Daniel Sroka"));
	}

	@Test
	public void shouldFindAllFriendOf() throws Exception {
		final Person person = personService.findById(1L);
		final Page<Person> friendOf = personService.getFriendOf(person, "", getDefaultPageRequest());

		assertThat(friendOf).hasSize(4);
		assertThat(friendOf)
				.extracting("id", "fullName")
				.contains(
						tuple(3L, "Marta Falx"),
						tuple(4L, "Zbigniew Falko"));
	}

	@Test
	public void shouldFindAPerson() throws Exception {
		final Person person = personService.findById(2L);

		assertThat(person)
				.hasFieldOrPropertyWithValue("id", 2L)
				.hasFieldOrPropertyWithValue("fullName", "Alex Krz");
	}

	@Test
	public void shouldAddAndRemoveAFriend() throws Exception {
		final Person person = personService.findById(1L);
		final Person friend = personService.findById(15L);

		// Check preconditions
		assertFalse(person.hasFriend(friend));
		assertFalse(person.isFriendOf(friend));
		assertFalse(friend.hasFriend(person));
		assertFalse(friend.isFriendOf(person));

		// Check when person makes friendship with anotherPerson
		personService.addFriend(person, friend);
		assertTrue(person.hasFriend(friend));
		assertFalse(person.isFriendOf(friend));
		assertFalse(friend.hasFriend(person));
		assertTrue(friend.isFriendOf(person));

		// Check when person severs friendship with anotherPerson
		personService.removeFriend(person, friend);
		assertFalse(person.hasFriend(friend));
		assertFalse(person.isFriendOf(friend));
		assertFalse(friend.hasFriend(person));
		assertFalse(friend.isFriendOf(person));
	}

	@Test
	public void shouldUpdatePersonInformation() throws Exception {
		final Person person = personService.findById(1L);
		person.setGender(Gender.UNDEFINED);
		personService.update(person);

		final Person result = personService.findById(person.getId());

		assertThat(result)
				.hasFieldOrPropertyWithValue("id", 2L)
				.hasFieldOrPropertyWithValue("fullName", "Alex Krz")
				.hasFieldOrPropertyWithValue("gender", Gender.UNDEFINED);
	}

	@Test
	public void shouldChangePassword() throws Exception {
		final Person person = personService.findById(1L);
		final String currentPwd = "12345";
		final String newPwd = "54321";

		assertTrue(personService.hasValidPassword(person, currentPwd));
		assertFalse(personService.hasValidPassword(person, newPwd));

		personService.changePassword(person, newPwd);

		assertFalse(personService.hasValidPassword(person, currentPwd));
		assertTrue(personService.hasValidPassword(person, newPwd));
	}

	@Test
	public void shouldCreateNewPerson() throws Exception {
		final Person actual = personService.create(
				"John",
				"Doe",
				"john.doe@gmail.com",
				"johnny");

		final Person expected = personService.findByEmail("john.doe@gmail.com");

		assertThat(actual)
				.hasFieldOrPropertyWithValue("id", expected.getId())
				.hasFieldOrPropertyWithValue("fullName", expected.getFullName())
				.hasFieldOrPropertyWithValue("email", expected.getEmail());
	}

}
