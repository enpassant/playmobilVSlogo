package playmobil.api;

import java.util.List;

public interface Statistic
{
    public Double mean(List<Double> numbers);

    public Double average(List<Double> numbers);

    public Double min(List<Double> numbers);

    public Double max(List<Double> numbers);
}
