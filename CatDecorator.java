class CatDecorator implements IMeowable
{
    private final IMeowable meowable;
    private int countMeow;
    public IMeowable getMeowable()
    {
        return meowable;
    }
    public int getCountMeow()
    {
        return countMeow;
    }
    public CatDecorator(IMeowable meowable)
    {
        this.meowable = meowable;
        countMeow = 0;
    }
    @Override
    public void meow()
    {
        countMeow++;
        meowable.meow();
    }
}