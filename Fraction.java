class Fraction
{
    protected int numerator;
    protected int denominator;

    public Fraction(int numerator, int denominator)
    {
        if (denominator < 0)
        {
            this.numerator = -numerator;
            this.denominator = -denominator;
        }
        else
        {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    protected int GCD(int a, int b)
    {
        while (a != b)
        {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        return a;
    }
    protected int LCM(int a, int b)
    {
        return a * b / GCD(a, b);
    }
    protected Fraction reduce(Fraction f)
    {
        int nod = GCD(Math.abs(f.numerator), f.denominator);
        f.numerator = f.numerator / nod;
        f.denominator = f.denominator / nod;
        return f;
    }
    
    public Fraction sum(Fraction f)
    {
        if (f.denominator == denominator)
            return reduce(new Fraction(numerator + f.numerator, denominator));
        else
        {
            int nok = LCM(denominator, f.denominator);
            int k1 = nok / denominator;
            int k2 = nok / f.denominator;
            int num = k1 * numerator + k2 * f.numerator;
            return reduce(new Fraction(num, nok));
        }
    }
    public Fraction minus(Fraction f)
    {
        if (f.denominator == denominator)
            return reduce(new Fraction(numerator - f.numerator, denominator));
        else
        {
            int nok = LCM(denominator, f.denominator);
            int k1 = nok / denominator;
            int k2 = nok / f.denominator;
            int num = k1 * numerator - k2 * f.numerator;
            return reduce(new Fraction(num, nok));
        }
    }
    public Fraction mult(Fraction f)
    {
        return reduce(new Fraction(numerator * f.numerator, denominator * f.denominator));
    }
    public Fraction div(Fraction f)
    {
        if (f.numerator < 0)
            return mult(new Fraction(-f.denominator, -f.numerator));
        else
            return mult(new Fraction(f.denominator, f.numerator));
    }
    public Fraction sum(int number)
    {
        Fraction f = new Fraction(number, 1);
        return sum(f);
    }
    public Fraction minus(int number)
    {
        Fraction f = new Fraction(number, 1);
        return minus(f);
    }
    public Fraction mult(int number)
    {
        Fraction f = new Fraction(number, 1);
        return mult(f);
    }
    public Fraction div(int number)
    {
        Fraction f = new Fraction(number, 1);
        return div(f);
    }

    @Override
    public String toString()
    {
        return numerator + " / " + denominator;
    }
    public Fraction clone()
    {
        return new Fraction(numerator, denominator);
    }
    @Override
    public boolean equals(Object obj)
    {
        if (obj == null) 
            return false;
        if (!(obj instanceof Fraction)) 
            return false;

        Fraction other = (Fraction) obj;

        int thisNumerator = this.numerator;
        int otherNumerator = other.numerator;
        int thisDenominator = this.denominator;
        int otherDenominator = other.denominator;

        return thisNumerator == otherNumerator && thisDenominator == otherDenominator;
    }
}