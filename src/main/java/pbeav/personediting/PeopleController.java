package pbeav.personediting;

import pbeav.person.PersonRepository;

public class PeopleController {

	public interface PeopleViewFactory {
		PeopleView createPeopleView(PeopleController controller);
	}

	private final PeopleView view;
	private final PersonRepository peopleRepo;
	private final People people = new People();

	public PeopleController(PeopleViewFactory viewFactory, PersonRepository peopleRepo) {
		this.peopleRepo = peopleRepo;
		this.view = viewFactory.createPeopleView(this);
	}

	public void newPersonAtIndex(int index) {
	}

	public void setFirstName(int index, String name) {
		people.getAtIndex(index).setFirstName(name);
	}

	public void persistToRepository() {
		people.persistToRepository(peopleRepo);
	}

}
