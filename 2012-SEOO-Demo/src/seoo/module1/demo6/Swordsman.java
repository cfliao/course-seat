package seoo.module1.demo6;

public class Swordsman extends RpgPerson
{
    @Override
    public void attack()
    {
        System.out.println("���z����!");
    }
    
    @Override
    public void cure()
    {
        System.out.println("�ܸɦ���!");
    }
    

    public Swordsman(String name, int hp, int mp)
    {
        super(name, hp, mp);
    }
    
}
