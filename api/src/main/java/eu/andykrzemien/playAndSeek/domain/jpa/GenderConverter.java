package eu.andykrzemien.playAndSeek.domain.jpa;

import eu.andykrzemien.playAndSeek.domain.Gender;

import javax.persistence.AttributeConverter;

public class GenderConverter implements AttributeConverter<Gender, Integer> {

	@Override
	public Integer convertToDatabaseColumn(Gender gender) {
		if (gender == null)
			return null;
		return gender.getId();
	}

	@Override
	public Gender convertToEntityAttribute(Integer id) {
		return Gender.getGender(id);
	}

}