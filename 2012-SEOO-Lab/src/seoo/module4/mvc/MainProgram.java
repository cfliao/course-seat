package seoo.module4.mvc;

public class MainProgram
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
         // setup
         Model m = new Model();
         
         MyView1 v1 = new MyView1(m);
         
         MyView2 v2 = new MyView2(m);
         
         m.service(new Event("test"));

    }

}
