package pbeav.person;

import java.util.Collection;
import java.util.Date;

public interface PersonRepository {

	Person find(PersonId id);

	Person find(String firstName);

	Collection<Person> findAll();

	Person create(String firstName, String lastname, Date birthday, Gender gender, Occupation occupation);

	Person makeUSCitizen(Person person, TaxId taxId);

	void remove(PersonId id);

}
