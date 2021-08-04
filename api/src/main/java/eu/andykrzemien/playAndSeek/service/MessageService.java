package eu.andykrzemien.playAndSeek.service;

import eu.andykrzemien.playAndSeek.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import eu.andykrzemien.playAndSeek.domain.Message;
import eu.andykrzemien.playAndSeek.domain.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {

	private final MessageRepository messageRepository;

	public List<Message> getDialog(Person person, Person interlocutor) {
		return messageRepository.findByRecipientOrSenderOrderByPostedDesc(person, interlocutor);
	}

	public List<Message> getLastMessages(Person person) {
		return messageRepository.findLastMessagesByPerson(person);
	}

	public Message send(Message message) {
		return messageRepository.save(message);
	}

}
