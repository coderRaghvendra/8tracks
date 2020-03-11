CREATE TABLE `tag_` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `uid` binary(16) NOT NULL DEFAULT '\\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0',
  `name` varchar(100) NOT NULL DEFAULT '',
  `song_count` bigint(20) NOT NULL DEFAULT '0',
  `status` tinyint(1) NOT NULL DEFAULT '1',
  `creation_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_tag_uid` (`uid`),
  UNIQUE KEY `uk_tag_name` (`name`),
  KEY `ind_tag_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=latin1;