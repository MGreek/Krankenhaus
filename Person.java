public class Person
{
    public Person(Integer initialId, String initialName)
    {
        id = initialId;
        name = initialName;
    }

    private Integer id;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer newId)
    {
        id = newId;
    }

    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String newName)
    {
        name = newName;
    }
}
