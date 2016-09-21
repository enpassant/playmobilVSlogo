package playmobil.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import playmobil.api.Config;
import playmobil.api.Operation;

public class SimpleOperation implements Operation
{
    private final Config config;

    public SimpleOperation(Config config)
    {
        this.config = config;
    }

    public List<Double> sort(List<Double> numbers)
    {
        final List<Double> list = new ArrayList<Double>(numbers);
        Collections.sort(list);
        return list;
    }

    public Double center(List<Double> numbers)
    {
        final int size = numbers.size();
        final int center = size / 2;
        return numbers.get(center);
    }

    public List<Double> sample(List<Double> numbers)
    {
        final List<Double> list = new ArrayList<Double>();
        final double percent = config.getSamplePercent();
        final Random random = new Random();

        for (Double number : numbers) {
            final double prob = random.nextDouble();
            if (prob < percent) {
                list.add(number);
            }
        }
        return list;
    }
}
