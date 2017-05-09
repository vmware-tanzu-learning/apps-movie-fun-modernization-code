package org.superbiz.moviefun

import com.fasterxml.jackson.databind.ObjectReader
import java.io.IOException
import java.io.InputStream
import java.util.*

object CsvUtils {
    @Throws(IOException::class)
    fun <T> readFromCsv(objectReader: ObjectReader, inputStream: InputStream) = ArrayList<T>().apply {
        val iterator = objectReader.readValues<T>(inputStream)

        while (iterator.hasNext()) {
            add(iterator.nextValue())
        }
    }
}
