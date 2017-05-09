package org.superbiz.moviefun.albums

import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import javax.sql.DataSource

@Configuration
@EnableAsync
@EnableScheduling
class AlbumsUpdateScheduler(dataSource: DataSource, private val albumsUpdater: AlbumsUpdater) {

    private val jdbcTemplate: JdbcTemplate = JdbcTemplate(dataSource)
    private val logger = LoggerFactory.getLogger(javaClass)


    @Scheduled(initialDelay = 5_000, fixedRate = 15_000)
    fun run() {
        try {
            logger.debug("Checking for albums task to start")

            if (startAlbumSchedulerTask()) {
                logger.debug("Starting albums update")

                albumsUpdater.update()

                logger.debug("Finished albums update")
            } else {
                logger.debug("Nothing to start")
            }

        } catch (e: Throwable) {
            logger.error("Error while updating albums", e)
        }

    }

    private fun startAlbumSchedulerTask(): Boolean {
        val updatedRows = jdbcTemplate.update(
            "UPDATE album_scheduler_task" +
                " SET started_at = now()" +
                " WHERE started_at IS NULL" +
                " OR started_at < date_sub(now(), INTERVAL 2 MINUTE)"
        )

        return updatedRows > 0
    }
}
