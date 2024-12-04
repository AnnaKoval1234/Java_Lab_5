class Cat implements IMeowable
{
    private final String name;
    public String getName()
    {
        return name;
    }
    public Cat(String name)
    {
        this.name = name;
    }
    @Override
    public void meow()
    {
        System.out.println(name + ": мяу!");
    }
    @Override
    public String toString()
    {
        return "кот: " + name;
    }
}