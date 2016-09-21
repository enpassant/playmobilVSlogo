package playmobil.impl;

import java.util.Collections;
import java.util.List;

import playmobil.api.Operation;
import playmobil.api.Statistic;

public class SimpleStatistic implements Statistic
{
    private final Operation operation;

    public SimpleStatistic(Operation operation)
    {
        this.operation = operation;
    }

    public Double mean(List<Double> numbers)
    {
        final List<Double> list = operation.sort(numbers);
        return operation.center(list);
    }

    public Double average(List<Double> numbers)
    {
        double sum = 0.0;
        for (Double number : numbers) {
            sum += number;
        }
        return sum / numbers.size();
    }

    public Double min(List<Double> numbers)
    {
        return Collections.min(numbers);
    }

    public Double max(List<Double> numbers)
    {
        return Collections.max(numbers);
    }
}
