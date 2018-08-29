package pbeav.personediting;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import pbeav.person.MutablePerson;
import pbeav.person.Person;
import pbeav.person.PersonId;
import pbeav.person.PersonRepository;

public class People {

	private final List<MutablePerson> people = new ArrayList<MutablePerson>();
	private final Set<PersonId> removedPeople = new HashSet<PersonId>();

	public MutablePerson getAtIndex(int index) {
		return people.get(index);
	}

	public void removePersionAtIndex(int index) {
		MutablePerson p = people.get(index);

		// if person is in database it should have an id
		if (p.id() != null) {
			removedPeople.add(p.id());
		}
	}

	public void persistToRepository(PersonRepository peopleRepo) {
		for(Person p: people) {
			if(p.id()==null) {
				Person newPerson = peopleRepo.create(p.firstName(), p.lastname(), p.birthday(), p.gender(), p.occupation());
				p.set(newPerson);
			} else {
				//TODO update the person
				//Person newPerson = peopleRepo.update(...);
				//p.set(newPerson);
			}
		}
		
		for (PersonId p : removedPeople) {
			peopleRepo.remove(p);
		}
		removedPeople.clear();
	}

}
