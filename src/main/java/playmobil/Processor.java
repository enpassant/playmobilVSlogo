package playmobil;

import java.util.List;

import playmobil.api.Reader;
import playmobil.api.Writer;
import playmobil.api.Algorithm;

public class Processor
{
    private final Reader reader;
    private final Writer writer;
    private final Algorithm algorithm;

    public Processor(Reader reader, Writer writer, Algorithm algorithm)
    {
        this.reader = reader;
        this.writer = writer;
        this.algorithm = algorithm;
    }

    public void run()
    {
        reader.read();
        final List<Double> numbers = reader.getNumbers();
        final Double result = algorithm.calc(numbers);
        writer.write(result);
    }
}
