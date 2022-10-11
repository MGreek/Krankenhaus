import java.util.*

public class View {
    private Controller controller;

    public void setController(Controller newController)
    {
        controller = newController;
    }

    public void printPersons()
    {
        for (int i = 0; i < controller.getPersons().length; ++i)
        {
            System.out.println(controller.getPersons()[i].getName());
        }
    }
}
