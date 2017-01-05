package org.superbiz.moviefun.albums; /**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class AlbumsBean {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void addAlbum(Album album) {
        entityManager.persist(album);
    }

    public Album find(long id) {
        return entityManager.find(Album.class, id);
    }

    public List<Album> getAlbums() {
        CriteriaQuery<Album> cq = entityManager.getCriteriaBuilder().createQuery(Album.class);
        cq.select(cq.from(Album.class));
        return entityManager.createQuery(cq).getResultList();
    }

    @Transactional
    public void deleteAlbum(Album album) {
        entityManager.remove(album);
    }

    @Transactional
    public void updateAlbum(Album album) {
        entityManager.merge(album);
    }
}
