package org.superbiz.moviefun.albums

import org.junit.Test

import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThat

class AlbumTest {

    @Test
    fun testIsEquivalent() {
        val persisted = Album(id = 10, artist = "Radiohead", title = "OK Computer", year = 1997, rating = 8)

        val sameFromCsv = Album(artist = "Radiohead", title = "OK Computer", year = 1997, rating = 9)
        assertThat(persisted.isEquivalent(sameFromCsv), `is`(true))

        val otherFromCsv = Album(artist = "Radiohead", title = "Kid A", year = 2000, rating = 9)
        assertThat(persisted.isEquivalent(otherFromCsv), `is`(false))
    }
}
