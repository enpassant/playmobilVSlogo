package playmobil;

import java.util.List;
import java.util.Arrays;

import playmobil.impl.AvgAlgorithm;
import playmobil.impl.MeanAlgorithm;
import playmobil.impl.SimpleConfig;
import playmobil.impl.SimpleOperation;
import playmobil.impl.SimpleStatistic;
import playmobil.impl.TestReader;
import playmobil.impl.TestWriter;
import playmobil.impl.MeanAlgorithm;

public class Playmobil
{
    public static void main(String[] args) throws Exception
    {
        final Processor meanProcessor = createMeanProcessor();
        meanProcessor.run();

        final Processor avgProcessor = createAvgProcessor();
        avgProcessor.run();
    }

    public static Processor createMeanProcessor()
    {
        final SimpleConfig config = new SimpleConfig();
        final SimpleOperation operation = new SimpleOperation(config);
        final SimpleStatistic statistic = new SimpleStatistic(operation);
        final Double[] values = {2.4, 3.7, 8.7, 9.5, 99.2};
        final List<Double> numbers = Arrays.asList(values);
        final TestReader reader = new TestReader(numbers);
        final TestWriter writer = new TestWriter("Result (mean)");
        final MeanAlgorithm algorithm = new MeanAlgorithm(statistic);
        final Processor processor = new Processor(reader, writer, algorithm);
        return processor;
    }

    public static Processor createAvgProcessor()
    {
        final SimpleConfig config = new SimpleConfig();
        final SimpleOperation operation = new SimpleOperation(config);
        final SimpleStatistic statistic = new SimpleStatistic(operation);
        final Double[] values = {2.4, 3.7, 8.7, 9.5, 99.2};
        final List<Double> numbers = Arrays.asList(values);
        final TestReader reader = new TestReader(numbers);
        final TestWriter writer = new TestWriter("Result (average)");
        final AvgAlgorithm algorithm = new AvgAlgorithm(statistic);
        final Processor processor = new Processor(reader, writer, algorithm);
        return processor;
    }
}
