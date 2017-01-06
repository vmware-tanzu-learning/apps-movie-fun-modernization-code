DROP TABLE IF EXISTS album_scheduler_task;

CREATE TABLE album_scheduler_task (
  started_at TIMESTAMP NULL DEFAULT NULL
);

INSERT INTO album_scheduler_task (started_at) VALUES (NULL);
