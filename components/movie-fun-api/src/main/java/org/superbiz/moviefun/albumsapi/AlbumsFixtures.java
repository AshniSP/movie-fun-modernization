package org.superbiz.moviefun.albumsapi;

import java.util.List;
import static java.util.Arrays.asList;

public class AlbumsFixtures {
    public List<AlbumInfo> load() {
        return asList(
                new AlbumInfo(null, "Massive Attack", "Mezzanine", 1998, 9),
                new AlbumInfo(null, "Radiohead", "OK Computer", 1997, 8),
                new AlbumInfo(null, "Radiohead", "Kid A", 2000, 9)
        );
    }

}
