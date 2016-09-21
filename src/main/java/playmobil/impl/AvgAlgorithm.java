package playmobil.impl;

import java.util.List;

import playmobil.api.Algorithm;
import playmobil.api.Statistic;

public class AvgAlgorithm implements Algorithm
{
    private final Statistic statistic;

    public AvgAlgorithm(Statistic statistic) {
        this.statistic = statistic;
    }

    public Double calc(List<Double> numbers)
    {
        return statistic.average(numbers);
    }
}
