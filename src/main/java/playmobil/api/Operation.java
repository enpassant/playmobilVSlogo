package playmobil.api;

import java.util.List;

public interface Operation
{
    public List<Double> sort(List<Double> numbers);

    public Double center(List<Double> numbers);

    public List<Double> sample(List<Double> numbers);
}
