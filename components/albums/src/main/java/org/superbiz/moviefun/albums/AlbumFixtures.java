package org.superbiz.moviefun.albums;

import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Arrays.asList;

@Component
public class AlbumFixtures {

    public List<Album> load() {
        return asList(
            new Album("Massive Attack", "Mezzanine", 1998, 9),
            new Album("Radiohead", "OK Computer", 1997, 8),
            new Album("Radiohead", "Kid A", 2000, 9)
        );
    }
}
