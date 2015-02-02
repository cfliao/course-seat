package seoo.module4.mvc;

public class Controller implements Observer
{
    private Model model;

    private View view;

    public void update(Event event)
    {
        String data = model.getData();
        System.out.println(view.getClass().getSimpleName() + " Controller: data=" + data);
        view.display();
    }

    public Controller(Model m, View v)
    {
        model = m;
        view = v;
        m.attach(this);
    }

    public void handelEvent(Event e)
    {
        model.service(e);
    }
}
