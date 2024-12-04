import java.util.HashMap;

class FractionDecorator extends Fraction implements IFractional
{
    private HashMap<Fraction, Double> cashe;

    private boolean isContains(Fraction f)
    {
        for (Fraction temp: cashe.keySet())
            if (f.equals(temp))
                return true;
        return false;
    }
    private double getCashe(Fraction f)
    {
        for (Fraction temp: cashe.keySet())
            if (f.equals(temp))
                return cashe.get(temp);
        return 0;
    }
    @Override
    public double toDouble()
    {
        if (!isContains(this))
        {
            System.out.println("Число записано в кэш");
            cashe.put(this.clone(), (double)numerator / denominator);
        }
        return getCashe(this);
    }
    @Override
    public void setFraction(int numerator, int denominator)
    {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public FractionDecorator(int numerator, int denominator)
    {
        super(numerator, denominator);
        cashe = new HashMap<>();
    }
}