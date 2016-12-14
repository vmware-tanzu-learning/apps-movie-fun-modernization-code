package org.superbiz.moviefun.albums;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AlbumTest {

    @Test
    public void testIsEquivalent() {
        Album persisted = new Album("Radiohead", "OK Computer", 1997, 8);
        persisted.setId(10);

        Album sameFromCsv = new Album("Radiohead", "OK Computer", 1997, 9);
        assertThat(persisted.isEquivalent(sameFromCsv), is(true));

        Album otherFromCsv = new Album("Radiohead", "Kid A", 2000, 9);
        assertThat(persisted.isEquivalent(otherFromCsv), is(false));
    }
}
