DROP TABLE IF EXISTS `tx_sample`;
CREATE TABLE `tx_sample` (
  `id` char(32) NOT NULL DEFAULT 'REPLACE(UUID(), ''-'', '''')' comment 'ID',
  `name` varchar(255) NOT NULL comment 'name',
  `created_user` varchar(45) DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT NULL,
  `updated_user` varchar(45) DEFAULT NULL,
  `updated_date` timestamp NULL DEFAULT NULL,
  `is_delete` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) comment = 'TXサンプルテーブル';