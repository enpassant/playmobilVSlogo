package playmobil.impl;

import java.util.List;

import playmobil.api.Reader;

public class TestReader implements Reader
{
    private final List<Double> numbers;

    public TestReader(List<Double> numbers)
    {
        this.numbers = numbers;
    }

    public void read() {
    }

    public List<Double> getNumbers()
    {
        return numbers;
    }
}
