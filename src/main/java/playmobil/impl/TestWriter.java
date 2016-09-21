package playmobil.impl;

import java.util.Collection;

import playmobil.api.Writer;

public class TestWriter implements Writer
{
    private final String label;

    public TestWriter(String label) {
        this.label = label;
    }

    public void write(Double result)
    {
        System.out.println(label + ": " + result);
    }
}
