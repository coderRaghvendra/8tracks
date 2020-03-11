CREATE TABLE `song_` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `uid` binary(16) NOT NULL DEFAULT '\\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0',
  `name` varchar(100) NOT NULL DEFAULT '',
  `play_count` bigint(20) NOT NULL DEFAULT '0',
  `like_count` bigint(20) NOT NULL DEFAULT '0',
  `status` tinyint(1) NOT NULL DEFAULT '1',
  `creation_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_song_uid` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=134 DEFAULT CHARSET=latin1;