CREATE TABLE `song_tag` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `uid` binary(16) NOT NULL DEFAULT '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0',
  `song_id` bigint(20) NOT NULL,
  `tag_id` bigint(20) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1',
  `creation_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_song_tag_uid` (`uid`),
  UNIQUE KEY `uk_song_tag_song_id_tag_id` (`song_id`,`tag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4416 DEFAULT CHARSET=latin1;