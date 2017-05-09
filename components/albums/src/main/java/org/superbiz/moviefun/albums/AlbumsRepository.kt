package org.superbiz.moviefun.albums

/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.criteria.CriteriaQuery

@Repository
class AlbumsRepository(val entityManager: EntityManager) {

    @Transactional
    fun addAlbum(album: Album) {
        entityManager.persist(album)
    }

    fun find(id: Long): Album {
        return entityManager.find(Album::class.java, id)
    }

    fun getAlbums(): List<Album> {
        val cq = entityManager.criteriaBuilder.createQuery(Album::class.java)
        cq.select(cq.from(Album::class.java))
        return entityManager.createQuery(cq).resultList
    }

    @Transactional
    fun deleteAlbum(album: Album) {
        entityManager.remove(album)
    }

    @Transactional
    fun updateAlbum(album: Album) {
        entityManager.merge(album)
    }
}
