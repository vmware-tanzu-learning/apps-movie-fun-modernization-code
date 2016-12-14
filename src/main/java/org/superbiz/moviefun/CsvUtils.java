package org.superbiz.moviefun;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CsvUtils {

    public static <T> List<T> readFromCsv(ObjectReader objectReader, InputStream inputStream) throws IOException {
        List<T> results = new ArrayList<>();

        MappingIterator<T> iterator = objectReader.readValues(inputStream);

        while (iterator.hasNext()) {
            results.add(iterator.nextValue());
        }

        return results;
    }
}
