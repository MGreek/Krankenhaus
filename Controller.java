import java.util.*
public class Controller {
    private Integer globalId;

    private Vector<Person> persons;

    public void create()
    {
        globalId = 0;
        persons = new Vector<Person>();
    }

    public Vector<Person> getPersons()
    {
        return persons;
    }

    public int addPerson(String name)
    {
        Person person = new Person(++globalId, name);
        persons.add(person);
        return person.getId();
    }

    public boolean removePerson(Integer id)
    {
        for (int i = 0; i < persons.length; ++i)
        {
            if (persons[i].getId() == id)
            {
                persons.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean updatePerson(Integer id, Person newPerson)
    {
        for (int i = 0; i < persons.length; ++i) {
            if (persons[i].getId() == id) {
                persons[i] = newPerson;
                return true;
            }
        }
        return false;
    }
}
