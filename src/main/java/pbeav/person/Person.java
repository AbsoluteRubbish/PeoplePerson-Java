package pbeav.person;

public interface Person {

	public PersonId id();

	public String firstName();

	public String lastname();

	public boolean usCitizen();

	public TaxId taxId();

}
