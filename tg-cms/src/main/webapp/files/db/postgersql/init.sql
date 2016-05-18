/*
Navicat PGSQL Data Transfer

Source Server         : 图灵谷-开发服务器
Source Server Version : 90404
Source Host           : 182.92.129.128:5432
Source Database       : tg_cms
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90404
File Encoding         : 65001

Date: 2016-05-18 22:59:21
*/


-- ----------------------------
-- Table structure for tg_c_attachment
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_c_attachment";
CREATE TABLE "public"."tg_c_attachment" (
"id" varchar(45) COLLATE "default" NOT NULL,
"user_id" varchar(45) COLLATE "default",
"attach_name" varchar(150) COLLATE "default" NOT NULL,
"file_type" varchar(45) COLLATE "default" NOT NULL,
"file_length" int8 NOT NULL,
"file_path" varchar(255) COLLATE "default" NOT NULL,
"file_url" varchar(255) COLLATE "default" NOT NULL,
"create_time" timestamp(6),
"owner_type" varchar(45) COLLATE "default",
"owner_id" varchar(45) COLLATE "default",
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tg_c_attachment" IS '附件表';
COMMENT ON COLUMN "public"."tg_c_attachment"."id" IS '附件';
COMMENT ON COLUMN "public"."tg_c_attachment"."user_id" IS '上传人';
COMMENT ON COLUMN "public"."tg_c_attachment"."attach_name" IS '文件名';
COMMENT ON COLUMN "public"."tg_c_attachment"."file_length" IS '文件长度';
COMMENT ON COLUMN "public"."tg_c_attachment"."create_time" IS '时间';

-- ----------------------------
-- Records of tg_c_attachment
-- ----------------------------
INSERT INTO "public"."tg_c_attachment" VALUES ('0653909c-9b30-48e5-ad61-779ed0fc644f', null, 'Xftp.exe', 'exe', '2070232', 'uploads/201508/20150806/d795c9ba-01b9-409f-8327-393398d4e179.exe', 'uploads/201508/20150806/d795c9ba-01b9-409f-8327-393398d4e179.exe', '2015-08-06 10:50:57.372', null, null, '2015-08-06 10:50:57.372', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('0ac0ca73-2098-44fa-ab01-e8dd5cf9102b', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150805/d403a342-39e9-432f-8f87-ed00e1a09e7f.txt', 'uploads/201508/20150805/d403a342-39e9-432f-8f87-ed00e1a09e7f.txt', '2015-08-05 12:13:40.201', null, null, '2015-08-05 12:13:40.201', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('0f2d575c-4ed1-4957-b920-907b8ccc5027', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150805/d01b2629-ecbf-4cb2-8ee2-a417345f3cd3.txt', 'uploads/201508/20150805/d01b2629-ecbf-4cb2-8ee2-a417345f3cd3.txt', '2015-08-05 12:10:09.392', null, null, '2015-08-05 12:10:09.392', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('22b670ec-45a2-4b44-8c3c-6e80063d5047', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150805/5e5811a6-8348-482d-b6ed-2c5599897322.txt', 'uploads/201508/20150805/5e5811a6-8348-482d-b6ed-2c5599897322.txt', '2015-08-05 11:29:08.585', null, null, '2015-08-05 11:29:08.585', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('262c6576-96cf-4a28-b154-4ef6122add46', null, '项目wbs分解.xlsx', 'xlsx', '17677', 'uploads/201508/20150805/1e80ee90-2fa0-44d8-9c87-c77754593ef1.xlsx', 'uploads/201508/20150805/1e80ee90-2fa0-44d8-9c87-c77754593ef1.xlsx', '2015-08-05 13:33:42.673', null, null, '2015-08-05 13:33:42.673', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('272e474b-8f87-404b-be7f-9f8df478bc8d', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150806/ad02ba4f-7c95-46e1-b761-32bdd4a141ae.txt', 'uploads/201508/20150806/ad02ba4f-7c95-46e1-b761-32bdd4a141ae.txt', '2015-08-06 14:57:19.671', null, null, '2015-08-06 14:57:19.671', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('2dcb299b-6c07-46b5-8e7b-b29980a7cc03', null, '项目wbs分解.xlsx', 'xlsx', '17690', 'uploads/201508/20150805/a10d8ac2-61a0-478f-b897-0fc2cc479e89.xlsx', 'uploads/201508/20150805/a10d8ac2-61a0-478f-b897-0fc2cc479e89.xlsx', '2015-08-05 16:17:13.198', null, null, '2015-08-05 16:17:13.198', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('328a107a-2967-42f8-8549-b52208c6e1ef', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150805/18437cce-86c7-4dd4-a7b8-7d56a2a53adc.txt', 'uploads/201508/20150805/18437cce-86c7-4dd4-a7b8-7d56a2a53adc.txt', '2015-08-05 13:25:26.799', null, null, '2015-08-05 13:25:26.799', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('339b1795-beba-4c0b-8fba-a5b9070d5e2d', null, 'chrome.dll', 'dll', '44764488', 'uploads/201508/20150805/3deeedc5-8ee1-4847-a2b0-14dff5b1b687.dll', 'uploads/201508/20150805/3deeedc5-8ee1-4847-a2b0-14dff5b1b687.dll', '2015-08-05 13:42:37.708', null, null, '2015-08-05 13:42:37.708', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('33e9df16-9107-42f1-b7f0-253c8b6cd577', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150805/8fef4954-7c90-46c5-aafc-a74bc4179dcf.txt', 'uploads/201508/20150805/8fef4954-7c90-46c5-aafc-a74bc4179dcf.txt', '2015-08-05 13:01:02.638', null, null, '2015-08-05 13:01:02.638', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('3aeef69e-9de8-4b39-abaa-ab8c3d59c976', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150806/b94480fb-5953-411e-95da-50f4630bec02.txt', 'uploads/201508/20150806/b94480fb-5953-411e-95da-50f4630bec02.txt', '2015-08-06 14:34:47.95', null, null, '2015-08-06 14:34:47.95', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('41198fd4-a292-4fd0-b2e5-175961cdfb14', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150806/0eb8c460-cda4-46d8-b6d8-38bb214c02e6.txt', 'uploads/201508/20150806/0eb8c460-cda4-46d8-b6d8-38bb214c02e6.txt', '2015-08-06 14:57:15.007', null, null, '2015-08-06 14:57:15.007', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('42d95495-d843-4ede-9dd7-334564070fa2', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150805/e386c47a-3c7c-45ad-bdde-9cb42de20a3e.txt', 'uploads/201508/20150805/e386c47a-3c7c-45ad-bdde-9cb42de20a3e.txt', '2015-08-05 12:20:46.292', null, null, '2015-08-05 12:20:46.292', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('45836c1d-5ab1-4bbd-aeac-1e4f6fab6ff6', null, '新建 Microsoft Word 97-2003 文档.doc', 'doc', '40448', 'uploads/201508/20150804/4ad1e85b-48e0-462f-a4d9-48b14c710e5f.doc', 'uploads/201508/20150804/4ad1e85b-48e0-462f-a4d9-48b14c710e5f.doc', '2015-08-04 11:05:23.224', null, null, '2015-08-04 11:05:23.224', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('481ea1de-6fe4-407f-a3d1-f637b41f1a2e', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150805/d9285dc5-e58d-42f8-bde5-2b7aa63d1b92.txt', 'uploads/201508/20150805/d9285dc5-e58d-42f8-bde5-2b7aa63d1b92.txt', '2015-08-05 11:29:24.053', null, null, '2015-08-05 11:29:24.053', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('50c6bbe8-ec33-4439-8ecb-1ac7a41d0ce2', null, 'QQ图片20150804144610.png', 'png', '2840', 'uploads/201508/20150805/8e56af90-e8a5-453e-b2f6-c80e6daad19c.png', 'uploads/201508/20150805/8e56af90-e8a5-453e-b2f6-c80e6daad19c.png', '2015-08-05 16:30:05.159', null, null, '2015-08-05 16:30:05.159', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('5142202e-a61a-40e2-9a23-77d0ee823cb4', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150806/bf5bd03e-8bdb-416b-ad6d-caa2de5912db.txt', 'uploads/201508/20150806/bf5bd03e-8bdb-416b-ad6d-caa2de5912db.txt', '2015-08-06 14:57:16.946', null, null, '2015-08-06 14:57:16.946', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('591464bf-59fa-4c42-89f5-8f8aa6fac436', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150806/631db521-6518-4e84-9950-e82bf5e632f5.txt', 'uploads/201508/20150806/631db521-6518-4e84-9950-e82bf5e632f5.txt', '2015-08-06 14:57:15.604', null, null, '2015-08-06 14:57:15.604', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('5bf752d3-dedf-4e16-8ebf-17551fe63d4e', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150805/4736e645-befc-4052-b817-73c063e091e5.txt', 'uploads/201508/20150805/4736e645-befc-4052-b817-73c063e091e5.txt', '2015-08-05 13:01:17.942', null, null, '2015-08-05 13:01:17.942', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('5dbd6e38-c7e1-4e43-9814-bfebafb301ad', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150805/344adc0b-7c0a-4426-8f39-e228292d4822.txt', 'uploads/201508/20150805/344adc0b-7c0a-4426-8f39-e228292d4822.txt', '2015-08-05 13:06:35.99', null, null, '2015-08-05 13:06:35.99', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('5f51d13a-28d3-4a69-970c-d4c9f116f209', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150805/8ab70970-d971-4dbf-8d03-82cf0c441b27.txt', 'uploads/201508/20150805/8ab70970-d971-4dbf-8d03-82cf0c441b27.txt', '2015-08-05 13:05:26.994', null, null, '2015-08-05 13:05:26.994', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('617ac8fa-2e58-482c-bcd4-7c17a05966d5', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150805/c0d40f32-1a55-4693-bc38-2deb7f8b0c3a.txt', 'uploads/201508/20150805/c0d40f32-1a55-4693-bc38-2deb7f8b0c3a.txt', '2015-08-05 12:13:29.639', null, null, '2015-08-05 12:13:29.639', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('61d4ba91-3bb9-43ee-8d4b-a24da282c238', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150805/7c57ae89-f19d-4205-a754-44e864f99d6e.txt', 'uploads/201508/20150805/7c57ae89-f19d-4205-a754-44e864f99d6e.txt', '2015-08-05 13:06:41.592', null, null, '2015-08-05 13:06:41.592', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('64c87175-211a-4893-9da3-889f3421c974', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150806/e35a1dea-2ef8-4e32-aded-ea49a15a1da2.txt', 'uploads/201508/20150806/e35a1dea-2ef8-4e32-aded-ea49a15a1da2.txt', '2015-08-06 14:57:16.255', null, null, '2015-08-06 14:57:16.255', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('64dd7d3b-3ca1-4997-9f80-80fea4325a45', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150806/8b198932-79b7-470d-a94c-4febf1457f1d.txt', 'uploads/201508/20150806/8b198932-79b7-470d-a94c-4febf1457f1d.txt', '2015-08-06 14:57:17.657', null, null, '2015-08-06 14:57:17.657', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('6590149e-46b7-49c8-be7e-a011fec106d8', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150806/1c322407-afe6-4b3c-a492-bdbe2a138fa3.txt', 'uploads/201508/20150806/1c322407-afe6-4b3c-a492-bdbe2a138fa3.txt', '2015-08-06 14:34:39.111', null, null, '2015-08-06 14:34:39.111', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('691b0181-7115-4fbb-b083-52f3385528db', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150805/16737c72-8fd5-44c7-8ef5-9565e299bee2.txt', 'uploads/201508/20150805/16737c72-8fd5-44c7-8ef5-9565e299bee2.txt', '2015-08-05 13:06:46.56', null, null, '2015-08-05 13:06:46.56', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('6c52a7c7-8efb-4af1-9a85-2b48b195bab3', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150806/97058d99-78f5-49a4-b8f0-a00e46e7c74e.txt', 'uploads/201508/20150806/97058d99-78f5-49a4-b8f0-a00e46e7c74e.txt', '2015-08-06 10:39:52.344', null, null, '2015-08-06 10:39:52.344', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('6ef3fdf2-42ea-4d73-9636-be08ea858fe4', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150806/dbebb1b8-cfa3-45a6-bc50-a51bd774954e.txt', 'uploads/201508/20150806/dbebb1b8-cfa3-45a6-bc50-a51bd774954e.txt', '2015-08-06 14:34:35.311', null, null, '2015-08-06 14:34:35.311', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('7166e85c-fab2-4e52-a839-82e30c32b5ec', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150805/a23ebdef-8c09-422a-a803-598fa5d663bc.txt', 'uploads/201508/20150805/a23ebdef-8c09-422a-a803-598fa5d663bc.txt', '2015-08-05 13:05:32.494', null, null, '2015-08-05 13:05:32.494', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('7314d912-2edc-4732-a2fe-e06c3a49b68c', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150806/8604a106-9fca-49c5-84e8-bc93421f12bb.txt', 'uploads/201508/20150806/8604a106-9fca-49c5-84e8-bc93421f12bb.txt', '2015-08-06 10:39:56.384', null, null, '2015-08-06 10:39:56.384', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('74cad456-827b-4fae-97b8-b642a9d9679b', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150805/6e35d1e3-9f69-46e5-99bc-ffff9f90d97a.txt', 'uploads/201508/20150805/6e35d1e3-9f69-46e5-99bc-ffff9f90d97a.txt', '2015-08-05 12:13:23.888', null, null, '2015-08-05 12:13:23.888', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('766f89c4-f4d9-4097-b85d-9f29c32079e3', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150805/e4432435-9556-4d84-9118-b49b2b50c8d7.txt', 'uploads/201508/20150805/e4432435-9556-4d84-9118-b49b2b50c8d7.txt', '2015-08-05 12:13:17.92', null, null, '2015-08-05 12:13:17.92', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('774edef0-7a41-4865-9c70-7b667502633b', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150805/e522d623-01ce-40ac-b385-38a85e630ce6.txt', 'uploads/201508/20150805/e522d623-01ce-40ac-b385-38a85e630ce6.txt', '2015-08-05 11:29:29.962', null, null, '2015-08-05 11:29:29.962', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('7b14bd3b-ee7f-4440-b880-5fd493ed7396', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150805/3dec1d02-733c-4e73-a2e5-96ec8759a101.txt', 'uploads/201508/20150805/3dec1d02-733c-4e73-a2e5-96ec8759a101.txt', '2015-08-05 14:46:44.207', null, null, '2015-08-05 14:46:44.207', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('7cef660e-4891-4967-a3cd-d307ebd41961', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150806/ef644aa6-826f-41c5-912e-48afaf44d289.txt', 'uploads/201508/20150806/ef644aa6-826f-41c5-912e-48afaf44d289.txt', '2015-08-06 14:34:32.099', null, null, '2015-08-06 14:34:32.099', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('81ae7cd6-3e59-479f-ad5a-5406c75c71e6', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150806/2f3ab2b9-5018-442e-82bc-637e8f06a7e1.txt', 'uploads/201508/20150806/2f3ab2b9-5018-442e-82bc-637e8f06a7e1.txt', '2015-08-06 14:34:44.123', null, null, '2015-08-06 14:34:44.123', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('836abeb4-a91c-4422-aab8-832b81a41bcc', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150805/b155e446-6f9a-4a83-bab6-04c72327307a.txt', 'uploads/201508/20150805/b155e446-6f9a-4a83-bab6-04c72327307a.txt', '2015-08-05 12:13:12.371', null, null, '2015-08-05 12:13:12.371', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('8fca7375-49df-4410-8ac2-d9bf2efb4163', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150805/e5774b81-35ff-44c2-82d8-b17ab5da7a35.txt', 'uploads/201508/20150805/e5774b81-35ff-44c2-82d8-b17ab5da7a35.txt', '2015-08-05 13:01:23.385', null, null, '2015-08-05 13:01:23.385', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('99208fa0-e393-447e-94a9-0605cd780f44', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150805/80aaa9ee-ae31-439b-a037-132428e1c76f.txt', 'uploads/201508/20150805/80aaa9ee-ae31-439b-a037-132428e1c76f.txt', '2015-08-05 12:13:35.115', null, null, '2015-08-05 12:13:35.115', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('99ad46b3-8fbd-4814-bf7f-f6d8ebb993c0', null, '测试专用、.jnt', 'jnt', '4544', 'uploads/201508/20150806/78ebd3ca-f640-41fe-8158-555e22c6a5f6.jnt', 'uploads/201508/20150806/78ebd3ca-f640-41fe-8158-555e22c6a5f6.jnt', '2015-08-06 11:26:20.847', null, null, '2015-08-06 11:26:20.847', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('9ddae067-7ae7-4f2d-981b-1216ca85cbcf', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150805/f728474d-3067-480d-834d-5d0425aaa14a.txt', 'uploads/201508/20150805/f728474d-3067-480d-834d-5d0425aaa14a.txt', '2015-08-05 13:06:51.918', null, null, '2015-08-05 13:06:51.918', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('ab35627c-c2da-445f-9e71-6400fb9b0092', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150806/15510303-2544-4fbb-b9c4-d3085130916c.txt', 'uploads/201508/20150806/15510303-2544-4fbb-b9c4-d3085130916c.txt', '2015-08-06 14:54:20.412', null, null, '2015-08-06 14:54:20.412', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('b211711c-58d5-4f84-8361-8dee1b3c4ca9', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150806/89f9606b-4916-41bb-aaaa-f1c94d0cff24.txt', 'uploads/201508/20150806/89f9606b-4916-41bb-aaaa-f1c94d0cff24.txt', '2015-08-06 14:57:18.392', null, null, '2015-08-06 14:57:18.392', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('b2d95cc2-71f9-4da8-9b34-673c0484a5fb', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150805/f87b890a-5eb7-4925-b1a2-a5c1013983df.txt', 'uploads/201508/20150805/f87b890a-5eb7-4925-b1a2-a5c1013983df.txt', '2015-08-05 12:20:35.33', null, null, '2015-08-05 12:20:35.33', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('b54f05e2-2f96-4d76-abe8-60bbfac2858f', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150805/28a8f7ae-719d-4ea4-879d-d5a0ede67014.txt', 'uploads/201508/20150805/28a8f7ae-719d-4ea4-879d-d5a0ede67014.txt', '2015-08-05 13:05:22.084', null, null, '2015-08-05 13:05:22.084', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('b72ba396-86e1-4aa0-8a75-5960edcafe79', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150804/806d4fcc-3bd4-4b83-8db1-98832444a775.txt', 'uploads/201508/20150804/806d4fcc-3bd4-4b83-8db1-98832444a775.txt', '2015-08-04 18:39:32.107', null, null, '2015-08-04 18:39:32.107', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('c4d392e4-7e01-40c4-b5e2-8d75b2e19476', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150805/5335c18c-feb2-4c9f-b280-906a8b91a882.txt', 'uploads/201508/20150805/5335c18c-feb2-4c9f-b280-906a8b91a882.txt', '2015-08-05 11:29:15.612', null, null, '2015-08-05 11:29:15.612', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('cc08efe1-554b-46fd-b62a-16f50df71ec3', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150805/421a8ffa-4410-4d1b-9d23-8cffb088ed8f.txt', 'uploads/201508/20150805/421a8ffa-4410-4d1b-9d23-8cffb088ed8f.txt', '2015-08-05 13:01:13.04', null, null, '2015-08-05 13:01:13.04', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('d6c492f5-18c6-4b9f-b0f1-3093dd304efd', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150805/03b90046-fe32-46f3-91f3-cb12bcf6e1a1.txt', 'uploads/201508/20150805/03b90046-fe32-46f3-91f3-cb12bcf6e1a1.txt', '2015-08-05 13:05:37.711', null, null, '2015-08-05 13:05:37.711', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('d70b94de-2c7a-4216-b1b5-4e38240b50fe', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150806/d4492db4-dd22-4e22-88fc-919ed5146b1f.txt', 'uploads/201508/20150806/d4492db4-dd22-4e22-88fc-919ed5146b1f.txt', '2015-08-06 10:40:04.037', null, null, '2015-08-06 10:40:04.037', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('e0328c37-84ed-4445-8ceb-1ca6915528b9', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150805/ce9082b0-7885-4420-a503-770e9fcd65ee.txt', 'uploads/201508/20150805/ce9082b0-7885-4420-a503-770e9fcd65ee.txt', '2015-08-05 12:20:51.153', null, null, '2015-08-05 12:20:51.153', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('f03526fc-a442-4706-9aec-a59da0233c0b', null, '新建 Microsoft Word 97-2003 文档 (2).doc', 'doc', '38912', 'uploads/201508/20150805/2bbd9850-cff1-4345-903d-1336e0e02567.doc', 'uploads/201508/20150805/2bbd9850-cff1-4345-903d-1336e0e02567.doc', '2015-08-05 16:38:31.725', null, null, '2015-08-05 16:38:31.725', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('f5705a9f-26bd-4fc6-8487-7a5ee99d2534', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150805/f562fda2-365a-400b-962c-c760f3063ac9.txt', 'uploads/201508/20150805/f562fda2-365a-400b-962c-c760f3063ac9.txt', '2015-08-05 12:20:40.986', null, null, '2015-08-05 12:20:40.986', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('f5fc6dd9-a493-44db-a65a-f8d7df9245b3', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150806/e5cb1245-d1f0-42aa-8457-a705c9c544f4.txt', 'uploads/201508/20150806/e5cb1245-d1f0-42aa-8457-a705c9c544f4.txt', '2015-08-06 10:40:00.61', null, null, '2015-08-06 10:40:00.61', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('f8e4785b-fe14-40ee-b2aa-246c9795b860', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150805/4ddbb6e5-d528-4422-9bb3-ce5ef9c106ec.txt', 'uploads/201508/20150805/4ddbb6e5-d528-4422-9bb3-ce5ef9c106ec.txt', '2015-08-05 13:01:07.917', null, null, '2015-08-05 13:01:07.917', null, null, null);
INSERT INTO "public"."tg_c_attachment" VALUES ('fa182154-9bf2-4ad5-9e50-6b324486445d', null, '68ca9b34-7085-43b1-987f-9f44d46be008.txt.txt', 'txt', '1135', 'uploads/201508/20150805/f9b73683-e450-4980-b3c0-19f2b73be53a.txt', 'uploads/201508/20150805/f9b73683-e450-4980-b3c0-19f2b73be53a.txt', '2015-08-05 12:13:46.825', null, null, '2015-08-05 12:13:46.825', null, null, null);

-- ----------------------------
-- Table structure for tg_c_custom_field
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_c_custom_field";
CREATE TABLE "public"."tg_c_custom_field" (
"id" varchar(45) COLLATE "default" NOT NULL,
"type" int2 NOT NULL,
"long_text_type" int2,
"inner_type" int2 NOT NULL,
"field_label" varchar(50) COLLATE "default" NOT NULL,
"field_name" varchar(50) COLLATE "default" NOT NULL,
"prompt" varchar(255) COLLATE "default",
"required" int2 NOT NULL,
"newline" int2 NOT NULL,
"sort_order" int2 NOT NULL,
"enabled" int2 NOT NULL,
"owner_type" varchar(50) COLLATE "default",
"owner_id" varchar(45) COLLATE "default",
"regex_str" varchar(45) COLLATE "default",
"field_max_length" int4,
"field_min_length" int4,
"field_max_value" float8,
"field_min_value" float8,
"field_default_value" varchar(45) COLLATE "default",
"date_format" varchar(45) COLLATE "default",
"checkbox_options" varchar(500) COLLATE "default",
"img_width" int4,
"img_height" int4,
"img_transcode" int2,
"img_format" varchar(45) COLLATE "default",
"img_compress" int2,
"img_extrude" int2,
"img_watermark" int2,
"video_transcode" int2,
"video_format" varchar(45) COLLATE "default",
"video_codec" varchar(45) COLLATE "default",
"video_rate" int4,
"audio_transcode" int2,
"audio_format" varchar(45) COLLATE "default",
"audio_codec" varchar(45) COLLATE "default",
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tg_c_custom_field" IS '模型字段表';
COMMENT ON COLUMN "public"."tg_c_custom_field"."id" IS '模型字段';
COMMENT ON COLUMN "public"."tg_c_custom_field"."type" IS '输入类型';
COMMENT ON COLUMN "public"."tg_c_custom_field"."long_text_type" IS '是否大字段';
COMMENT ON COLUMN "public"."tg_c_custom_field"."inner_type" IS '内部类型(1:用户自定义字段;2:系统定义字段;3:预留大文本字段;4:预留可查询字段)';
COMMENT ON COLUMN "public"."tg_c_custom_field"."field_label" IS '字段标签';
COMMENT ON COLUMN "public"."tg_c_custom_field"."field_name" IS '字段名称';
COMMENT ON COLUMN "public"."tg_c_custom_field"."prompt" IS '提示信息';
COMMENT ON COLUMN "public"."tg_c_custom_field"."required" IS '是否必填项';
COMMENT ON COLUMN "public"."tg_c_custom_field"."newline" IS '是否换行';
COMMENT ON COLUMN "public"."tg_c_custom_field"."sort_order" IS '顺序';
COMMENT ON COLUMN "public"."tg_c_custom_field"."enabled" IS '状态';
COMMENT ON COLUMN "public"."tg_c_custom_field"."regex_str" IS '正则表达式';
COMMENT ON COLUMN "public"."tg_c_custom_field"."field_max_length" IS '最大长度';
COMMENT ON COLUMN "public"."tg_c_custom_field"."field_min_length" IS '最小长度';
COMMENT ON COLUMN "public"."tg_c_custom_field"."field_max_value" IS '最大值';
COMMENT ON COLUMN "public"."tg_c_custom_field"."field_min_value" IS '最小值';
COMMENT ON COLUMN "public"."tg_c_custom_field"."field_default_value" IS '默认值';
COMMENT ON COLUMN "public"."tg_c_custom_field"."date_format" IS '日期格式化方式';
COMMENT ON COLUMN "public"."tg_c_custom_field"."checkbox_options" IS '多选框可选项';
COMMENT ON COLUMN "public"."tg_c_custom_field"."img_transcode" IS '图片转码';
COMMENT ON COLUMN "public"."tg_c_custom_field"."img_format" IS '图片转码格式';
COMMENT ON COLUMN "public"."tg_c_custom_field"."img_compress" IS '图片压缩';
COMMENT ON COLUMN "public"."tg_c_custom_field"."img_extrude" IS '图片拉伸';
COMMENT ON COLUMN "public"."tg_c_custom_field"."img_watermark" IS '添加水印';
COMMENT ON COLUMN "public"."tg_c_custom_field"."video_transcode" IS '视频转码';
COMMENT ON COLUMN "public"."tg_c_custom_field"."video_format" IS '视频转码格式';
COMMENT ON COLUMN "public"."tg_c_custom_field"."video_codec" IS '视频编码';
COMMENT ON COLUMN "public"."tg_c_custom_field"."video_rate" IS '视频码率';
COMMENT ON COLUMN "public"."tg_c_custom_field"."audio_transcode" IS '音频转码';
COMMENT ON COLUMN "public"."tg_c_custom_field"."audio_format" IS '音频格式';
COMMENT ON COLUMN "public"."tg_c_custom_field"."audio_codec" IS '音频编码';

-- ----------------------------
-- Records of tg_c_custom_field
-- ----------------------------
INSERT INTO "public"."tg_c_custom_field" VALUES ('0e7e01ad-0f1c-41bf-be11-b7dd8a5aa658', '1', null, '1', '22', 'cus_str_222', '22', '1', '1', '2', '1', null, null, null, '2', null, null, null, '22', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2015-09-04 02:19:05.17', null, null, null);
INSERT INTO "public"."tg_c_custom_field" VALUES ('572f2869-04ab-438e-841e-721cf0fd8d2a', '1', '2', '2', '完整标题', 'fullTitle', null, '1', '1', '13', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2', null, null, null, null, null, null);
INSERT INTO "public"."tg_c_custom_field" VALUES ('8923bbd3-06ef-44e9-9f3d-51c5f004a543', '6', '2', '1', '正文', 'infoText', null, '1', '1', '10', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2', null, null, null, null, null, null);
INSERT INTO "public"."tg_c_custom_field" VALUES ('9fd77808-8c73-4ba3-8cc2-f0bbe1fa1798', '1', null, '1', 'ee', 'cus_str_ee', null, '1', '1', '2', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2015-09-04 02:19:23.293', null, null, null);
INSERT INTO "public"."tg_c_custom_field" VALUES ('b0f0436f-ea27-457a-bbd3-c3e9d8bd2fa3', '7', null, '2', '图片上传', 'image', null, '2', '1', '4', '1', 'infoModel', '25fb6951-0819-423e-88b8-b9f1c8b59406', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2015-10-20 18:38:08.63', null, null, null);
INSERT INTO "public"."tg_c_custom_field" VALUES ('cec94905-8247-4fb8-9baf-3dbb22aad2b2', '3', '2', '2', '是否允许评论', 'allowComment', null, '1', '1', '9', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2', null, null, null, null, null, null);
INSERT INTO "public"."tg_c_custom_field" VALUES ('eacdb0e0-e11e-4b75-8f50-3d93fd31f3c0', '7', null, '2', '小图', 'image', null, '2', '1', '2', '1', 'nodeModel', '0b1459e3-66a2-42d5-8a19-f5e2d8e606a2', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2015-11-03 14:54:54.412', null, null, null);
INSERT INTO "public"."tg_c_custom_field" VALUES ('eacdb0e0-e11e-4b75-8f50-3d93fd31f3c0', '7', null, '2', '小图', 'image', null, '2', '1', '2', '1', 'nodeModel', '5bbd4645-d434-45ae-ab05-18161964aa5c', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2015-11-03 14:54:54.412', null, null, null);
INSERT INTO "public"."tg_c_custom_field" VALUES ('eacdb0e0-e11e-4b75-8f50-3d93fd31f3c0', '7', null, '2', '小图', 'image', null, '2', '1', '2', '1', 'nodeModel', 'a1dda5ec-98a9-47a3-a255-2705168d1ada', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2015-11-03 14:54:54.412', null, null, null);
INSERT INTO "public"."tg_c_custom_field" VALUES ('eacdb0e0-e11e-4b75-8f50-3d93fd31f3c0', '7', null, '2', '小图', 'image', null, '2', '1', '2', '1', 'nodeModel', 'd6580d68-bec3-45de-bc65-b62555d5f804', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2015-11-03 14:54:54.412', null, null, null);
INSERT INTO "public"."tg_c_custom_field" VALUES ('eacdb0e0-e11e-4b75-8f50-3d93fd31f3c0', '7', null, '2', '小图', 'image', null, '2', '1', '4', '1', 'nodeModel', '57056b0d-cbeb-407c-94bd-0ead61811f13', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2015-11-03 14:54:54.412', null, null, null);

-- ----------------------------
-- Table structure for tg_c_custom_field_value
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_c_custom_field_value";
CREATE TABLE "public"."tg_c_custom_field_value" (
"id" varchar(45) COLLATE "default" NOT NULL,
"key_str" varchar(50) COLLATE "default" NOT NULL,
"value_str" varchar(2000) COLLATE "default",
"value_for_double" float8,
"value_for_long_text" text COLLATE "default",
"value_for_date" timestamp(6),
"owner_type" varchar(45) COLLATE "default",
"owner_id" varchar(45) COLLATE "default",
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."tg_c_custom_field_value"."id" IS '自定义字段值';
COMMENT ON COLUMN "public"."tg_c_custom_field_value"."key_str" IS '名称';
COMMENT ON COLUMN "public"."tg_c_custom_field_value"."value_str" IS '值';
COMMENT ON COLUMN "public"."tg_c_custom_field_value"."value_for_double" IS '数字类型值';
COMMENT ON COLUMN "public"."tg_c_custom_field_value"."value_for_long_text" IS '大文本类型值';
COMMENT ON COLUMN "public"."tg_c_custom_field_value"."value_for_date" IS '日期类型值';
COMMENT ON COLUMN "public"."tg_c_custom_field_value"."owner_type" IS '类型';
COMMENT ON COLUMN "public"."tg_c_custom_field_value"."owner_id" IS '外表id';

-- ----------------------------
-- Records of tg_c_custom_field_value
-- ----------------------------
INSERT INTO "public"."tg_c_custom_field_value" VALUES ('8eff1de2-115f-40f1-8d56-b4e17fe40cea', 'cus_str_imgs', 'dda30b65-3998-41cd-aa8d-036bfddbe404', null, null, null, 'infoModel', 'dda07e4c-e6af-4360-963f-385634c998b9', null, null, null, null);
INSERT INTO "public"."tg_c_custom_field_value" VALUES ('956c1628-9ef1-4653-8131-d6fd05ff2b55', 'cus_str_b', '', null, null, null, 'infoModel', 'dda07e4c-e6af-4360-963f-385634c998b9', null, null, null, null);
INSERT INTO "public"."tg_c_custom_field_value" VALUES ('b74245b0-1021-4dd7-ab50-2c86983031b8', 'cus_str_imgs', '44c8a891-c12f-4c0a-8570-f64d0906bf2d', null, null, null, 'infoModel', '6322e6ec-53b2-4e82-9400-7ecd700a7af5', null, null, null, null);
INSERT INTO "public"."tg_c_custom_field_value" VALUES ('ba035a81-5c7c-4ebb-8316-d8411bd8056d', 'cus_str_b', '4', null, null, null, 'infoModel', '6322e6ec-53b2-4e82-9400-7ecd700a7af5', null, null, null, null);

-- ----------------------------
-- Table structure for tg_c_dict
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_c_dict";
CREATE TABLE "public"."tg_c_dict" (
"id" varchar(45) COLLATE "default" NOT NULL,
"dict_type" varchar(45) COLLATE "default" NOT NULL,
"dict_name" varchar(45) COLLATE "default" NOT NULL,
"dict_value" varchar(45) COLLATE "default" NOT NULL,
"description" varchar(100) COLLATE "default",
"sort_order" int2 DEFAULT 1 NOT NULL,
"editable" int2 DEFAULT 1 NOT NULL,
"enabled" int2 DEFAULT 1 NOT NULL,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."tg_c_dict"."id" IS '数据字典';
COMMENT ON COLUMN "public"."tg_c_dict"."dict_type" IS '字典类型';
COMMENT ON COLUMN "public"."tg_c_dict"."dict_name" IS '字典名称';
COMMENT ON COLUMN "public"."tg_c_dict"."dict_value" IS '字典值';
COMMENT ON COLUMN "public"."tg_c_dict"."description" IS '描述';
COMMENT ON COLUMN "public"."tg_c_dict"."sort_order" IS '优先级';
COMMENT ON COLUMN "public"."tg_c_dict"."editable" IS '是否可编辑  1可编辑 2不可编辑';
COMMENT ON COLUMN "public"."tg_c_dict"."enabled" IS '是否可用 1启用 2停用';

-- ----------------------------
-- Records of tg_c_dict
-- ----------------------------
INSERT INTO "public"."tg_c_dict" VALUES ('091fd60e-79b4-460b-ba76-5a8e3259f570', 'areaType', '山西省', '100004', null, '1', '1', '1', '2015-07-22 09:23:29.216', 'admin', null, null);
INSERT INTO "public"."tg_c_dict" VALUES ('0c9efa58-b05c-4e7e-a024-c47467e046ae', 'busType', '道路旅客运输', '100001001', null, '1', '1', '1', '2015-07-17 15:29:07.089', 'admin', '2015-07-21 19:19:21.9', 'admin');
INSERT INTO "public"."tg_c_dict" VALUES ('119fec99-108d-4353-91c6-f9fead2f7815', 'busType', '道路运输普通货运', '100001004', null, '1', '1', '1', '2015-07-17 15:29:42.281', 'admin', '2015-07-21 19:18:08.156', 'admin');
INSERT INTO "public"."tg_c_dict" VALUES ('14dd675f-cee5-4125-b10d-210d698afd8b', 'busType', '汽车客运站', '100001003', null, '1', '1', '1', '2015-07-17 15:29:29.673', 'admin', '2015-07-21 19:18:03.941', 'admin');
INSERT INTO "public"."tg_c_dict" VALUES ('1cdd86d6-b5b3-41c2-adc8-891bcf73bc0f', 'eduType', '文化程度', '100', null, '1', '1', '1', '2015-08-04 21:06:40.135', 'admin', null, null);
INSERT INTO "public"."tg_c_dict" VALUES ('27591c02-14e1-4d8e-9ac0-0945688e798f', 'areaType', '河东区', '100002002', null, '1', '1', '1', '2015-07-22 09:34:01.369', 'admin', null, null);
INSERT INTO "public"."tg_c_dict" VALUES ('277f344a-e141-4d39-978e-f5f2c2b48d3a', 'eduType', '博士生', '100002', null, '1', '1', '1', '2015-08-04 21:07:09.06', 'admin', '2015-08-04 21:08:44.57', 'admin');
INSERT INTO "public"."tg_c_dict" VALUES ('2894db0a-b669-4ec3-8452-c50da2ee87ff', 'busType', '危险货物码头运输', '100003002', null, '1', '1', '1', '2015-07-17 15:32:32.757', 'admin', '2015-07-21 19:18:40.44', 'admin');
INSERT INTO "public"."tg_c_dict" VALUES ('33775ec8-146a-49bc-9156-f4b4a9b2b408', 'busType', '机动车维修', '100001007', null, '1', '1', '1', '2015-07-17 15:30:04.92', 'admin', '2015-07-21 19:18:18.126', 'admin');
INSERT INTO "public"."tg_c_dict" VALUES ('36d492c0-2174-4b2d-8e5e-094fe8572433', 'busType', '城市客运', '100004', null, '1', '1', '1', '2015-07-17 15:27:39.533', 'admin', null, null);
INSERT INTO "public"."tg_c_dict" VALUES ('3ff69e22-e7d3-4b29-925f-6466d5870c35', 'busType', '港口运营', '100003', null, '1', '1', '1', '2015-07-17 15:27:29.752', 'admin', null, null);
INSERT INTO "public"."tg_c_dict" VALUES ('446899a1-6759-489d-ab15-68a66f3d4df5', 'nodeType', '相关链接', '100006', null, '1', '1', '1', '2015-07-28 11:12:47.501', 'admin', null, null);
INSERT INTO "public"."tg_c_dict" VALUES ('44d9cf20-f6bb-4755-a36a-0b817befaafe', 'busType', '其他', '100006001', null, '1', '1', '1', '2015-07-17 15:28:44.418', 'admin', '2015-07-21 19:19:26.076', 'admin');
INSERT INTO "public"."tg_c_dict" VALUES ('4626e45d-28c0-41c6-a69c-bba274d9b81f', 'areaType', '河北省', '100003', null, '1', '1', '1', '2015-07-22 09:22:55.573', 'admin', null, null);
INSERT INTO "public"."tg_c_dict" VALUES ('4ab35190-275f-4570-ac26-3191dcb69111', 'busType', '业务类别', '100', null, '1', '1', '1', '2015-07-17 15:26:46.7', 'admin', null, null);
INSERT INTO "public"."tg_c_dict" VALUES ('5f4656a1-24d6-40e0-b1cc-e7cca5d33861', 'busType', '城市轨道交通运输', '100004002', null, '1', '1', '1', '2015-07-17 15:33:09.909', 'admin', '2015-07-21 19:18:52.953', 'admin');
INSERT INTO "public"."tg_c_dict" VALUES ('611d7987-51d3-4eb0-9a6e-9edfa92fa434', 'nodeType', '政策法规', '100001', null, '1', '1', '1', '2015-07-27 15:20:41.89', 'admin', null, null);
INSERT INTO "public"."tg_c_dict" VALUES ('639f22ca-f951-4ddf-bcb3-a22b4e63bfa1', 'busType', '港口散杂货（集装箱）码头', '100003003', null, '1', '1', '1', '2015-07-17 15:32:41.665', 'admin', '2015-07-21 19:18:44.401', 'admin');
INSERT INTO "public"."tg_c_dict" VALUES ('66278609-1c74-45a9-868d-b560bf1e3845', 'busType', '交通运输工程建设', '100005', null, '1', '1', '1', '2015-07-17 15:27:48.236', 'admin', null, null);
INSERT INTO "public"."tg_c_dict" VALUES ('745d7935-222b-437c-af31-4028436cee2f', 'areaType', '北京市', '100001', null, '1', '1', '1', '2015-07-22 09:22:31.909', 'admin', null, null);
INSERT INTO "public"."tg_c_dict" VALUES ('7876d4ac-d628-4fcb-8d22-2dc9bed6d0a1', 'eduType', '研究生', '100005', null, '1', '1', '1', '2015-08-04 21:07:58.031', 'admin', null, null);
INSERT INTO "public"."tg_c_dict" VALUES ('78a05c61-b0ba-458a-bb7c-4f921b4a8f72', 'eduType', '本科', '100004', null, '1', '1', '1', '2015-08-04 21:07:49.097', 'admin', null, null);
INSERT INTO "public"."tg_c_dict" VALUES ('88b7be43-cdc1-413b-a4f2-a8b6160ae113', 'nodeType', '图片新闻', '100002', null, '1', '1', '1', '2015-07-27 15:20:49.163', 'admin', null, null);
INSERT INTO "public"."tg_c_dict" VALUES ('8c069cbf-b1af-49b7-888e-a163bf845523', 'nodeType', '相关下载', '100005', null, '1', '1', '1', '2015-07-27 15:21:14.175', 'admin', null, null);
INSERT INTO "public"."tg_c_dict" VALUES ('95ba41bd-1b09-4f0c-9325-dec66f099293', 'nodeType', '工作动态', '100003', null, '1', '1', '1', '2015-07-27 15:20:58.674', 'admin', null, null);
INSERT INTO "public"."tg_c_dict" VALUES ('9969e823-ae1c-4bda-911e-970aebd455c2', 'busType', '水路运输', '100002', null, '1', '1', '1', '2015-07-17 15:27:15.802', 'admin', null, null);
INSERT INTO "public"."tg_c_dict" VALUES ('9c10ae68-bb8e-42af-85ca-9e0e14f2a68c', 'busType', '道路货物运输场站', '100001006', null, '1', '1', '1', '2015-07-17 15:29:54.231', 'admin', '2015-07-21 19:18:12.106', 'admin');
INSERT INTO "public"."tg_c_dict" VALUES ('9ec34faf-b01a-4c5e-ab05-483d3b202b86', 'areaType', '地区选择', '100', null, '1', '1', '1', '2015-07-20 17:00:26.992', 'admin', '2015-07-22 09:32:56.311', 'admin');
INSERT INTO "public"."tg_c_dict" VALUES ('a013cadc-b3b7-435e-a58a-437250951452', 'areaType', '天津市', '100002', null, '1', '1', '1', '2015-07-22 09:22:46.998', 'admin', null, null);
INSERT INTO "public"."tg_c_dict" VALUES ('a07efed8-a00f-4e43-bdb1-68db3791d36c', 'busType', '城市公共汽车客运', '100004001', null, '1', '1', '1', '2015-07-17 15:32:57.811', 'admin', '2015-07-21 19:18:48.739', 'admin');
INSERT INTO "public"."tg_c_dict" VALUES ('a3329aee-d2e2-4547-9927-949211afcbeb', 'busType', '港口客运（滚装、渡船渡口）码头', '100003001', null, '1', '1', '1', '2015-07-17 15:32:17.792', 'admin', '2015-07-21 19:18:36.063', 'admin');
INSERT INTO "public"."tg_c_dict" VALUES ('a6c04450-6a13-4efc-93c9-68e0db4c0208', 'eduType', '大专', '100003', null, '1', '1', '1', '2015-08-04 21:07:40.912', 'admin', null, null);
INSERT INTO "public"."tg_c_dict" VALUES ('a733f52e-b19d-4c68-9d65-39fc156aedd8', 'areaType', '西城', '100001002', null, '1', '1', '1', '2015-07-22 09:32:36.427', 'admin', null, null);
INSERT INTO "public"."tg_c_dict" VALUES ('a8357513-8366-4d38-afcc-0b101b4d2875', 'areaType', '和平区', '100002001', null, '1', '1', '1', '2015-07-22 09:33:49.203', 'admin', null, null);
INSERT INTO "public"."tg_c_dict" VALUES ('af27c020-a71a-4f3e-8b55-99e700797c43', 'nodeType', '公告公示', '100004', null, '1', '1', '1', '2015-07-27 15:21:06.201', 'admin', null, null);
INSERT INTO "public"."tg_c_dict" VALUES ('afe0bca9-7682-4380-8c0d-d92111ac6672', 'busType', '出租汽车', '100004003', null, '1', '1', '1', '2015-07-17 15:33:27.124', 'admin', '2015-07-21 19:18:58.297', 'admin');
INSERT INTO "public"."tg_c_dict" VALUES ('b13f5c3b-4102-4962-b288-7e80d6e55f99', 'busType', '道路危险货物运输', '100001002', null, '1', '1', '1', '2015-07-17 15:29:16.191', 'admin', '2015-07-21 19:19:31.224', 'admin');
INSERT INTO "public"."tg_c_dict" VALUES ('c942adb6-819a-4f98-a5c1-e85e80f8f2d0', 'nodeType', '栏目类型', '100', null, '1', '1', '1', '2015-07-27 15:19:31.852', 'admin', null, null);
INSERT INTO "public"."tg_c_dict" VALUES ('c9922761-452e-47c0-a751-e327ab59c816', 'eduType', '中专', '100001', null, '1', '1', '1', '2015-08-04 21:07:00.179', 'admin', '2015-08-04 21:08:26.075', 'admin');
INSERT INTO "public"."tg_c_dict" VALUES ('ca283317-6886-43f3-ab62-683c1838bec9', 'busType', '水路旅客运输', '100002001', null, '1', '1', '1', '2015-07-17 15:30:32.566', 'admin', '2015-07-21 19:18:21.976', 'admin');
INSERT INTO "public"."tg_c_dict" VALUES ('cfe39523-ab6d-4eca-84f6-b075e927993b', 'busType', '水路散货运输', '100002003', null, '1', '1', '1', '2015-07-17 15:32:05.728', 'admin', '2015-07-21 19:18:32.251', 'admin');
INSERT INTO "public"."tg_c_dict" VALUES ('d7296edc-bb3a-4278-982e-c0ee6b2704b4', 'busType', '交通运输建筑施工', '100005001', null, '1', '1', '1', '2015-07-17 15:38:51.736', 'admin', '2015-07-21 19:19:02.776', 'admin');
INSERT INTO "public"."tg_c_dict" VALUES ('e852f16f-7e66-49c1-9115-729b68db85b1', 'busType', '其他', '100006', null, '1', '1', '1', '2015-07-17 15:27:58.866', 'admin', null, null);
INSERT INTO "public"."tg_c_dict" VALUES ('e88b10ad-9697-4d9f-b195-b532dc77e654', 'busType', '水路危险货物运输', '100002002', null, '1', '1', '1', '2015-07-17 15:31:54.803', 'admin', '2015-07-21 19:18:27.864', 'admin');
INSERT INTO "public"."tg_c_dict" VALUES ('ed4a87bf-8286-4fb8-bbcc-a238952d5ea4', 'busType', '道路运输', '100001', null, '1', '1', '1', '2015-07-17 15:27:02.797', 'admin', null, null);
INSERT INTO "public"."tg_c_dict" VALUES ('f5f1999a-6719-4e2b-b37b-3b83777a6d5d', 'areaType', '东城', '100001001', null, '1', '1', '1', '2015-07-22 09:32:29.821', 'admin', null, null);

-- ----------------------------
-- Table structure for tg_c_group
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_c_group";
CREATE TABLE "public"."tg_c_group" (
"id" varchar(45) COLLATE "default" NOT NULL,
"group_name" varchar(45) COLLATE "default",
"sort_order" int2,
"description" varchar(255) COLLATE "default",
"editable" int2,
"enabled" int2,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."tg_c_group"."id" IS '用户组';
COMMENT ON COLUMN "public"."tg_c_group"."group_name" IS '用户组名称';
COMMENT ON COLUMN "public"."tg_c_group"."sort_order" IS '排序';
COMMENT ON COLUMN "public"."tg_c_group"."description" IS '描述';
COMMENT ON COLUMN "public"."tg_c_group"."editable" IS '是否可编辑';

-- ----------------------------
-- Records of tg_c_group
-- ----------------------------

-- ----------------------------
-- Table structure for tg_c_log
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_c_log";
CREATE TABLE "public"."tg_c_log" (
"log_type" varchar(10) COLLATE "default",
"message" varchar(1000) COLLATE "default" NOT NULL,
"exception" varchar(100) COLLATE "default",
"event_date" timestamp(6) NOT NULL,
"ip_address" varchar(45) COLLATE "default",
"username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tg_c_log" IS '操作日志表';
COMMENT ON COLUMN "public"."tg_c_log"."log_type" IS '数据ID';
COMMENT ON COLUMN "public"."tg_c_log"."message" IS '描述';
COMMENT ON COLUMN "public"."tg_c_log"."exception" IS 'IP';
COMMENT ON COLUMN "public"."tg_c_log"."event_date" IS '时间';

-- ----------------------------
-- Records of tg_c_log
-- ----------------------------
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【成功】！', '', '2016-01-20 21:01:05.244', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【成功】！', '', '2016-01-20 21:04:00.033', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【成功】！', '', '2016-01-20 23:40:36.86', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【成功】！', '', '2016-01-21 18:17:33.21', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【成功】！', '', '2016-01-21 18:22:57.672', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【成功】！', '', '2016-01-22 09:51:20.494', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【成功】！', '', '2016-01-23 16:58:11.837', '0:0:0:0:0:0:0:1', '');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【成功】！', '', '2016-01-23 17:01:41.463', '0:0:0:0:0:0:0:1', '');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【成功】！', '', '2016-01-31 20:35:13.187', '219.142.242.93', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【成功】！', '', '2016-01-31 21:27:51.505', '219.142.242.93', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【成功】！', '', '2016-02-03 04:11:17.418', '219.142.242.93', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【成功】！', '', '2016-02-04 09:20:03.971', '219.142.242.93', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【成功】！', '', '2016-03-02 11:17:08.112', '1.202.81.74', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【成功】！', '', '2016-03-15 15:13:26.047', '1.202.83.2', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【成功】！', '', '2016-03-21 18:55:48.89', '106.120.43.21', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【成功】！', '', '2016-04-20 14:33:07.785', '106.120.42.50', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【成功】！', '', '2016-04-20 15:35:14.307', '106.120.42.50', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【成功】！', '', '2016-04-25 16:15:42.161', '106.120.63.80', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【失败】：Authentication method not supported: GET', '', '2016-03-04 21:13:21.114', '124.126.219.129', '');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【失败】：Authentication method not supported: GET', '', '2016-03-04 23:42:53.358', '124.126.169.30', '');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【失败】：认证信息不正确', '', '2016-01-21 18:19:50.985', '0:0:0:0:0:0:0:1', ' admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【失败】：认证信息不正确', '', '2016-01-21 18:21:12.287', '0:0:0:0:0:0:0:1', ' admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【失败】：认证信息不正确', '', '2016-01-21 18:21:37.34', '0:0:0:0:0:0:0:1', ' admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【失败】：认证信息不正确', '', '2016-01-21 18:21:45.991', '0:0:0:0:0:0:0:1', ' admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【失败】：认证信息不正确', '', '2016-01-31 20:35:01.257', '219.142.242.93', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【失败】：认证信息不正确', '', '2016-02-18 15:56:45.404', '220.175.6.110', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【失败】：认证信息不正确', '', '2016-02-25 13:51:13.76', '222.161.52.34', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【失败】：认证信息不正确', '', '2016-02-25 13:51:27.9', '222.161.52.34', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【失败】：认证信息不正确', '', '2016-03-01 22:51:25.753', '120.205.20.37', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【失败】：认证信息不正确', '', '2016-03-01 22:51:43.499', '120.205.20.37', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【失败】：认证信息不正确', '', '2016-03-14 16:34:10.124', '122.85.0.157', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【失败】：认证信息不正确', '', '2016-03-20 11:38:16.377', '111.174.250.87', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【失败】：认证信息不正确', '', '2016-03-20 11:38:35.231', '111.174.250.87', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【失败】：认证信息不正确', '', '2016-04-07 16:02:29.647', '59.172.87.126', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【失败】：认证信息不正确', '', '2016-04-07 16:02:58.448', '59.172.87.126', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【失败】：认证信息不正确', '', '2016-04-13 17:13:58.412', '219.223.173.199', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【失败】：认证信息不正确', '', '2016-04-14 17:43:35.642', '218.89.222.142', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【失败】：认证信息不正确', '', '2016-04-20 17:18:37.744', '222.128.71.253', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【失败】：认证信息不正确', '', '2016-04-20 17:18:53.776', '222.128.71.253', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【失败】：认证信息不正确', '', '2016-04-21 15:15:49.087', '61.141.156.16', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【失败】：认证信息不正确', '', '2016-04-25 15:10:54.415', '36.40.153.92', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【失败】：认证信息不正确', '', '2016-04-26 13:24:12.841', '220.160.3.88', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【失败】：认证信息不正确', '', '2016-04-26 13:24:42.109', '220.160.3.88', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【失败】：认证信息不正确', '', '2016-05-12 15:14:09.111', '101.204.148.120', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【失败】：认证信息不正确', '', '2016-05-16 15:41:16.555', '61.148.52.226', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【失败】：验证码不正确！', '', '2016-01-22 09:51:04.934', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【失败】：验证码不正确！', '', '2016-01-23 16:59:31.018', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【失败】：验证码不正确！', '', '2016-01-23 17:01:25.724', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【失败】：验证码不正确！', '', '2016-03-17 20:14:38.737', '218.26.176.5', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【失败】：验证码不正确！', '', '2016-04-25 15:10:20.309', '36.40.153.92', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【失败】：验证码不正确！', '', '2016-04-25 15:10:37.799', '36.40.153.92', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[登录]系统【失败】：验证码不正确！', '', '2016-05-12 15:13:54.722', '101.204.148.120', '');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[退出]系统【成功】！', '', '2016-01-31 21:27:42.097', '219.142.242.93', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('login', '用户[退出]系统【成功】！', '', '2016-03-21 18:57:42.67', '106.120.43.21', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('operate', '删除文章,id=1214bc8e-241b-4c15-ab88-4ad6eb1a313f', '', '2016-01-31 20:36:07.306', '219.142.242.93', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('operate', '系统异常：org.apache.ibatis.reflection.ReflectionException: There is no getter for property named ''log_type'' in ''class com.turingoal.cms.core.domain.query.LogInfoQuery''', '', '2016-01-20 21:01:34.345', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('operate', '系统异常：org.apache.ibatis.reflection.ReflectionException: There is no getter for property named ''log_type'' in ''class com.turingoal.cms.core.domain.query.LogInfoQuery''', '', '2016-01-20 21:01:36.499', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('operate', '新增文章,id=310d5a92-eb3d-467a-ae97-3da8b3a04697,title=基于微信公众号的webapp产品时间沙漏正式上线', '', '2016-02-03 04:13:45.441', '219.142.242.93', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('operate', '新增文章,id=6ce5e5d9-62e5-47bc-9c84-4a12d671c80c,title=与北京中平科学技术院签署项目协议', '', '2016-01-31 20:36:52.529', '219.142.242.93', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('operate', '新增文章,id=6f40bed6-705d-4f8c-96d6-8afce9a8f2d9,title=图灵谷发布开源项目 — 糖果cms', '', '2016-01-31 20:38:14.122', '219.142.242.93', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('operate', '新增文章,id=9eb31849-e3a7-4a80-bd7b-86339546b1be,title=公司组织员工前往香山观赏红叶', '', '2016-01-31 20:38:59.64', '219.142.242.93', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('operate', '修改文章,id=310d5a92-eb3d-467a-ae97-3da8b3a04697,title=基于微信公众号的webapp产品时间沙漏正式上线', '', '2016-02-04 09:20:13.821', '219.142.242.93', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('operate', '修改文章,id=6ce5e5d9-62e5-47bc-9c84-4a12d671c80c,title=与北京中平科学技术院签署项目协议', '', '2016-01-31 20:37:27.424', '219.142.242.93', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除栏目,id=083c4941-97ae-48d7-9a28-d5debfc9296a', '', '2015-11-03 09:37:13.609', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除栏目,id=0bb35bd9-6440-459d-99ef-d2fbce215d44', '', '2015-10-21 09:54:12.79', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除栏目,id=0deb3c1f-dc40-48d3-aced-bc9a5786e227', '', '2015-11-03 09:37:10.351', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除栏目,id=1180afd7-7dc6-4eb3-9632-c0e24d0ee482', '', '2015-11-03 14:55:31.972', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除栏目,id=14406fd6-8513-4d84-a606-5e3137e6a58a', '', '2015-10-21 11:05:29.001', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除栏目,id=22', '', '2015-09-06 16:04:17.342', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除栏目,id=23', '', '2015-09-06 16:03:47.48', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除栏目,id=3095c724-75a9-4d57-b915-d02614441aeb', '', '2015-11-03 10:51:27.978', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除栏目,id=33', '', '2015-09-06 16:04:03.65', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除栏目,id=367c507e-bdff-4f10-b9f1-5302be7642a0', '', '2015-10-21 15:59:12.978', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除栏目,id=37198106-b573-48de-82d1-92456254ba7c', '', '2015-09-04 11:57:38.799', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除栏目,id=3fa396fc-d5ea-49ec-9592-68e7c9c54bb6', '', '2015-11-03 10:55:16.719', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除栏目,id=5387a736-0405-44a8-9983-22ba52b55b4d', '', '2015-11-03 10:54:47.634', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除栏目,id=64', '', '2015-09-06 16:04:07.711', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除栏目,id=65', '', '2015-09-06 16:03:59.168', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除栏目,id=66', '', '2015-09-06 16:03:55.841', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除栏目,id=6680d3b4-e2d4-4dba-b02e-8eddeec39522', '', '2015-09-04 11:57:42.17', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除栏目,id=67', '', '2015-09-06 16:03:52.844', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除栏目,id=68', '', '2015-09-06 16:03:49.873', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除栏目,id=69', '', '2015-09-06 16:03:44.981', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除栏目,id=6a1a9195-9363-488a-af33-b8848bdfd93d', '', '2015-09-03 00:18:14.405', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除栏目,id=6f87eaee-1ee9-4316-9caa-1a99380d6785', '', '2015-11-03 09:36:56.812', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除栏目,id=7ab82cec-c82b-4e6b-89cb-722c266dce7d', '', '2015-11-03 09:37:00.246', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除栏目,id=7d69359f-d925-49f6-a32a-b454e3ecd87d', '', '2015-09-04 11:57:32.616', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除栏目,id=7fcc4981-33b3-4f16-9ba0-cc2ecdbd2e1f', '', '2015-09-04 11:57:29.997', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除栏目,id=9a3b2d12-d7b0-4b59-a8f7-5a39c2acb801', '', '2015-10-22 10:10:40.723', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除栏目,id=a83caaf9-6066-499d-8105-f0ed04cba4d7', '', '2015-11-03 09:37:07.527', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除栏目,id=b0dd043d-8692-4f87-8c8b-c38d07820414', '', '2015-10-21 15:59:10.362', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除栏目,id=c0ab0dc7-4ec8-41d8-b242-5880222571bd', '', '2015-11-03 09:37:16.081', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除栏目,id=ec218830-65c1-4f3a-ab7b-034aea15ec9c', '', '2015-11-03 09:37:52.52', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除栏目,id=ffdb9149-8566-4531-9c3e-58ec107a9a48', '', '2015-10-22 10:10:36.34', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除文章,id=17bfd550-4d80-404c-b75f-144510f06d3e', '', '2015-11-03 09:35:38.94', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除文章,id=39de3cfa-1355-4feb-9dd4-4bb2bdfe92fc', '', '2015-11-03 09:35:36.373', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除文章,id=467e33c7-435f-49a6-ae36-79a7741f129a', '', '2015-09-06 15:33:10.918', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除文章,id=4d05c734-d6ae-4b9d-b4f8-0378bb6bce0b', '', '2015-09-12 19:00:10.628', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除文章,id=4ecb4e32-8e85-4be0-9678-044e49b0b2db', '', '2015-11-03 09:35:28.309', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除文章,id=4ed3a4a6-e267-435f-9aa5-912c83f4bab0', '', '2015-10-21 15:13:22.613', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除文章,id=537f9fa7-b250-4ad5-8885-6df0e1f4d857', '', '2015-11-03 09:35:33.717', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除文章,id=576fc646-10af-43e8-9fc7-a426707f199b', '', '2015-09-02 22:43:32.653', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除文章,id=6322e6ec-53b2-4e82-9400-7ecd700a7af5', '', '2015-09-06 15:32:59.08', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除文章,id=6db67c5f-2c17-4aa8-90b4-d76277cdf5e0', '', '2015-09-04 15:44:08.993', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除文章,id=70a78c8d-9560-46b1-bc69-94350148fb5f', '', '2015-09-02 22:43:37.058', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除文章,id=830a1529-ea31-41f0-acec-ac68c7321ee9', '', '2015-10-22 10:40:58.615', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除文章,id=9118d1d1-8fe2-4854-92e0-ca3b7c9ee511', '', '2015-11-03 09:35:41.128', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除文章,id=97163193-3234-49df-a0e2-b9a5dfed6131', '', '2015-11-04 15:40:34.001', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除文章,id=9a73933e-43a7-4458-85d6-3416a819ceb8', '', '2015-09-12 19:03:04.511', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除文章,id=ad45780d-a450-491c-b8ff-15833bd66e95', '', '2015-09-06 16:11:11.39', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除文章,id=c3da4710-d18e-4804-a921-c8f9010a4b44', '', '2015-11-03 09:35:23.969', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除文章,id=dda07e4c-e6af-4360-963f-385634c998b9', '', '2015-09-06 15:33:04.774', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '删除文章,id=f0579b8d-80f0-4dff-aac9-8ff9c5a9b713', '', '2015-11-03 09:35:18.881', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.apache.ibatis.exceptions.PersistenceException: 
### Error querying database.  Cause: java.lang.IllegalArgumentException: invalid comparison: java.util.ArrayList and java.lang.String
### Cause: java.lang.IllegalArgumentException: invalid comparison: java.util.ArrayList and java.lang.String', '', '2015-09-04 17:05:42.809', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.apache.ibatis.exceptions.PersistenceException: 
### Error querying database.  Cause: java.lang.IllegalArgumentException: invalid comparison: java.util.ArrayList and java.lang.String
### Cause: java.lang.IllegalArgumentException: invalid comparison: java.util.ArrayList and java.lang.String', '', '2015-09-04 17:05:53.278', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.apache.ibatis.exceptions.PersistenceException: 
### Error querying database.  Cause: java.lang.IllegalArgumentException: invalid comparison: java.util.ArrayList and java.lang.String
### Cause: java.lang.IllegalArgumentException: invalid comparison: java.util.ArrayList and java.lang.String', '', '2015-09-04 17:06:10.174', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.apache.ibatis.exceptions.PersistenceException: 
### Error querying database.  Cause: java.lang.IllegalArgumentException: invalid comparison: java.util.ArrayList and java.lang.String
### Cause: java.lang.IllegalArgumentException: invalid comparison: java.util.ArrayList and java.lang.String', '', '2015-09-04 17:06:17.417', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.apache.ibatis.exceptions.PersistenceException: 
### Error querying database.  Cause: java.lang.IllegalArgumentException: invalid comparison: java.util.ArrayList and java.lang.String
### Cause: java.lang.IllegalArgumentException: invalid comparison: java.util.ArrayList and java.lang.String', '', '2015-09-04 17:06:26.902', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.apache.ibatis.exceptions.PersistenceException: 
### Error querying database.  Cause: java.lang.IllegalArgumentException: invalid comparison: java.util.ArrayList and java.lang.String
### Cause: java.lang.IllegalArgumentException: invalid comparison: java.util.ArrayList and java.lang.String', '', '2015-09-04 17:06:33.286', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.apache.ibatis.exceptions.PersistenceException: 
### Error querying database.  Cause: java.lang.IllegalArgumentException: invalid comparison: java.util.ArrayList and java.lang.String
### Cause: java.lang.IllegalArgumentException: invalid comparison: java.util.ArrayList and java.lang.String', '', '2015-09-04 17:06:47.252', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.apache.ibatis.exceptions.PersistenceException: 
### Error querying database.  Cause: java.lang.IllegalArgumentException: invalid comparison: java.util.ArrayList and java.lang.String
### Cause: java.lang.IllegalArgumentException: invalid comparison: java.util.ArrayList and java.lang.String', '', '2015-09-04 17:08:18.473', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.apache.ibatis.exceptions.PersistenceException: 
### Error querying database.  Cause: java.lang.IllegalArgumentException: invalid comparison: java.util.ArrayList and java.lang.String
### Cause: java.lang.IllegalArgumentException: invalid comparison: java.util.ArrayList and java.lang.String', '', '2015-09-04 17:15:33.929', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.apache.ibatis.exceptions.PersistenceException: 
### Error querying database.  Cause: java.lang.IllegalArgumentException: invalid comparison: java.util.ArrayList and java.lang.String
### Cause: java.lang.IllegalArgumentException: invalid comparison: java.util.ArrayList and java.lang.String', '', '2015-09-06 09:09:40.466', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.apache.ibatis.exceptions.PersistenceException: 
### Error querying database.  Cause: java.lang.IllegalArgumentException: invalid comparison: java.util.ArrayList and java.lang.String
### Cause: java.lang.IllegalArgumentException: invalid comparison: java.util.ArrayList and java.lang.String', '', '2015-09-06 09:12:29.789', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.apache.ibatis.exceptions.PersistenceException: 
### Error querying database.  Cause: java.lang.IllegalArgumentException: invalid comparison: java.util.ArrayList and java.lang.String
### Cause: java.lang.IllegalArgumentException: invalid comparison: java.util.ArrayList and java.lang.String', '', '2015-09-06 09:15:47.084', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.apache.ibatis.exceptions.PersistenceException: 
### Error querying database.  Cause: java.lang.IllegalArgumentException: invalid comparison: java.util.ArrayList and java.lang.String
### Cause: java.lang.IllegalArgumentException: invalid comparison: java.util.ArrayList and java.lang.String', '', '2015-09-06 09:28:36.702', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.apache.ibatis.reflection.ReflectionException: There is no getter for property named ''codseNum'' in ''class com.turingoal.cms.core.domain.form.ResourceForm''', '', '2015-11-06 14:52:27.093', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.apache.ibatis.reflection.ReflectionException: There is no getter for property named ''metaDdescription'' in ''class com.turingoal.cms.modules.base.domain.form.SpecialForm''', '', '2015-09-04 12:28:32.036', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.apache.ibatis.reflection.ReflectionException: There is no getter for property named ''metaDdescription'' in ''class com.turingoal.cms.modules.base.domain.form.SpecialForm''', '', '2015-09-04 14:15:17.837', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column b_info.sort_order does not exist
  位置：698', '', '2016-01-18 14:16:15.827', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column b_info.sort_order does not exist
  位置：698', '', '2016-01-18 14:16:41.647', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column b_info.sort_order does not exist
  位置：698', '', '2016-01-18 14:22:31.92', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column b_info.sort_order does not exist
  位置：698', '', '2016-01-18 17:50:07.251', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column b_info.sort_order does not exist
  位置：698', '', '2016-01-18 17:50:15.338', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column b_info.sort_order does not exist
  位置：724', '', '2016-01-18 14:22:34.29', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column b_info.sort_order does not exist
  位置：724', '', '2016-01-18 14:22:34.825', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column b_info.sort_order does not exist
  位置：724', '', '2016-01-18 14:22:35.496', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column b_info.sort_order does not exist
  位置：724', '', '2016-01-18 14:22:43.075', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column b_info.sort_order does not exist
  位置：724', '', '2016-01-18 14:24:10.324', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column b_info.sort_order does not exist
  位置：724', '', '2016-01-18 14:24:11.202', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column "b" of relation "tg_cms_m_base_attr" does not exist
  位置：33', '', '2015-09-04 14:44:55.886', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column "b" of relation "tg_cms_m_base_model" does not exist
  位置：34', '', '2015-09-04 00:15:29.21', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column c_field.fieldname does not exist
  位置：194', '', '2015-09-04 12:02:23.654', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column c_field.sort_order does not exist
  位置：385', '', '2016-01-18 14:22:37.15', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column c_field.sort_order does not exist
  位置：385', '', '2016-01-18 14:22:44.198', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column c_field.sort_order does not exist
  位置：385', '', '2016-01-18 14:22:46.195', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column "coade" of relation "tg_c_resource" does not exist
  位置：60', '', '2015-11-06 14:54:18.626', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column "createdatatime" of relation "tg_cms_m_base_template" does not exist
  位置：114', '', '2015-09-04 11:19:39.048', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column "field_maxlength" of relation "tg_c_custom_field" does not exist
  位置：151', '', '2015-09-04 02:11:26.394', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column "field_minlength" of relation "tg_c_custom_field" does not exist
  位置：172', '', '2015-09-04 02:15:29.101', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column f_value.valuefordate does not exist
  位置：79', '', '2015-09-04 12:06:17.272', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column f_value.value_for_long_text does not exist
  位置：51', '', '2015-09-04 12:04:27.392', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column "infoid" does not exist
  位置：44', '', '2015-09-02 22:14:47.527', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column "meta_ddescription" of relation "tg_cms_m_base_special" does not exist
  位置：141', '', '2015-09-04 14:23:41.458', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column "meta_description" of relation "tg_cms_m_base_special" does not exist
  位置：107', '', '2015-09-04 12:25:52.674', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column "meta_description" of relation "tg_cms_m_base_special" does not exist
  位置：107', '', '2015-09-04 14:14:07.799', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column "node_iodel_id" of relation "tg_cms_m_base_node" does not exist
  位置：50', '', '2015-09-02 23:55:19.959', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column "node_iodel_id" of relation "tg_cms_m_base_node" does not exist
  位置：50', '', '2015-09-03 00:06:46.394', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column "nodemodel_id" of relation "tg_cms_m_base_node" does not exist
  位置：52', '', '2015-09-02 23:59:54.852', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column "ownerid" does not exist
  位置：59', '', '2015-09-04 00:12:32.482', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column "ownertype" does not exist
  位置：37', '', '2015-09-04 00:10:31.428', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column "simplequeryparam" does not exist
  位置：133', '', '2015-09-04 10:37:41.885', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column "singlepage" of relation "tg_cms_m_base_node" does not exist
  位置：434', '', '2015-09-03 00:09:59.649', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column "sort_order" does not exist
  位置：233', '', '2016-01-18 14:16:15.5', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column "sort_order" does not exist
  位置：233', '', '2016-01-18 14:16:41.554', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column "sort_order" does not exist
  位置：233', '', '2016-01-18 14:18:53.873', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: column "userid" does not exist
  位置：34', '', '2015-09-03 02:09:08.921', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: function ifnull(smallint, integer) does not exist
  建议：No function matches the given name and argument types. You might need to add explicit type casts.
  位置：8', '', '2015-09-03 00:53:24.428', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: function ifnull(smallint, integer) does not exist
  建议：No function matches the given name and argument types. You might need to add explicit type casts.
  位置：8', '', '2015-09-04 00:06:01.923', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: missing FROM-clause entry for table "b"
  位置：43', '', '2015-09-04 00:18:16.606', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: null value in column "ad_name" violates not-null constraint
  详细：Failing row contains (95d29057-7ee7-4d2d-bad7-b8a9fdc5e9a8, 2, null, 2015-09-10 00:00:00, 2015-09-13 00:00:00, http://www.baidu.com, 还是原来的配方, 5666撒旦, null, null, 1, 2015-09-04 10:05:56.618, admin, null, null).', '', '2015-09-04 10:05:57.084', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: null value in column "expired" violates not-null constraint
  详细：Failing row contains (685e88f7-7031-47bc-acea-4f049ee39964, aaaaa, aa, f9203a4f59d6c5ee9d3fd3745402d26d6076268df1acc54265bf23ae5f52735b, enypfx, 1, null, null, null, null, null, null, null, null, null, null, null, null, 2, null, 2, null, null, null, null, null, null, null, 1, 1, 2015-11-06 10:21:42.677, admin, null, null).', '', '2015-11-06 10:21:42.76', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: null value in column "expired" violates not-null constraint
  详细：Failing row contains (effcd3a2-568d-4df6-b551-acce99d42dfd, aaaaa, aa, 9cd1a25b31dbaf591f9b6640ec962ee9b3621fd51daee93ea55ce4aca4b8c4f3, yhwbth, 1, null, null, null, null, null, null, null, null, null, null, null, null, 2, null, 2, null, null, null, null, null, null, null, 1, 1, 2015-11-06 10:21:19.956, admin, null, null).', '', '2015-11-06 10:21:20.048', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: null value in column "locked" violates not-null constraint
  详细：Failing row contains (7de62ccb-b2bd-430e-a799-ef923333820f, aaaaa, aa, c9fe44d7458b6bbb44596cc1fa751b7f10019e0e2ff0d0321a777b2866207a3e, xsdsha, 1, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1, 1, 2015-11-06 10:14:36.871, admin, null, null).', '', '2015-11-06 10:14:37.253', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: null value in column "question_id" violates not-null constraint
  详细：Failing row contains (bdc986a6-cfcc-405e-9a50-979a7dde2e56, null, 33, 2, 0, 1, 2015-09-06 09:51:02.198, null, null, null).', '', '2015-09-06 09:51:03.657', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: null value in column "title" violates not-null constraint
  详细：Failing row contains (c1ee5dc1-d04f-4129-9465-dbf17a37024a, 260a9657-06f7-4fe9-877d-3beb0e501fb8, null, 0, null, 1, 2015-09-04 16:08:35.635, null, null, null).', '', '2015-09-04 16:08:35.917', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: syntax error at or near "$1"
  位置：111', '', '2015-09-04 17:47:47.522', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: syntax error at or near "$1"
  位置：111', '', '2015-09-04 17:48:50.852', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: syntax error at or near "ORDER"
  位置：200', '', '2015-09-04 10:15:26.393', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: syntax error at or near "ORDER"
  位置：200', '', '2015-09-04 10:23:35.17', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: syntax error at or near "ORDER"
  位置：200', '', '2015-09-04 10:23:53.768', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: syntax error at or near "ORDER"
  位置：200', '', '2015-09-04 10:24:36.518', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: syntax error at or near "ORDER"
  位置：200', '', '2015-09-04 10:24:44.923', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '系统异常：org.postgresql.util.PSQLException: ERROR: syntax error at or near ")"
  位置：211', '', '2015-09-04 10:36:29.486', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增栏目,id=083c4941-97ae-48d7-9a28-d5debfc9296a,noddName=公司动态', '', '2015-09-06 16:25:06.641', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增栏目,id=0bae1118-477c-4f98-9ea5-989c7adc066c,noddName=首页', '', '2015-11-03 14:59:20.645', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增栏目,id=0bb35bd9-6440-459d-99ef-d2fbce215d44,noddName=qq', '', '2015-10-21 09:53:18.618', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增栏目,id=0deb3c1f-dc40-48d3-aced-bc9a5786e227,noddName=产品服务', '', '2015-09-06 16:08:57.246', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增栏目,id=1180afd7-7dc6-4eb3-9632-c0e24d0ee482,noddName=aa', '', '2015-11-03 09:53:18.244', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增栏目,id=14406fd6-8513-4d84-a606-5e3137e6a58a,noddName=aa', '', '2015-10-21 11:04:32.149', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增栏目,id=3095c724-75a9-4d57-b915-d02614441aeb,noddName=aa', '', '2015-11-03 09:53:23.021', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增栏目,id=367c507e-bdff-4f10-b9f1-5302be7642a0,noddName=解决方案子栏目', '', '2015-10-21 15:58:56.334', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增栏目,id=37198106-b573-48de-82d1-92456254ba7c,noddName=2', '', '2015-09-03 00:02:26.024', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增栏目,id=3fa396fc-d5ea-49ec-9592-68e7c9c54bb6,noddName=qq', '', '2015-11-03 10:55:13.113', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增栏目,id=4ef84122-5605-45af-bfea-a3c2e315b898,noddName=解决方案', '', '2015-11-03 15:03:12.835', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增栏目,id=5387a736-0405-44a8-9983-22ba52b55b4d,noddName=qq', '', '2015-11-03 10:54:40.265', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增栏目,id=54300408-c77f-4bf1-8237-7fe7c8addc54,noddName=测试', '', '2015-09-12 18:58:31.212', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增栏目,id=6680d3b4-e2d4-4dba-b02e-8eddeec39522,noddName=3', '', '2015-09-04 11:53:06.924', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增栏目,id=6a1a9195-9363-488a-af33-b8848bdfd93d,noddName=222', '', '2015-09-03 00:15:13.359', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增栏目,id=6f87eaee-1ee9-4316-9caa-1a99380d6785,noddName=联系我们', '', '2015-09-06 16:10:07.959', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增栏目,id=7ab82cec-c82b-4e6b-89cb-722c266dce7d,noddName=关于我们', '', '2015-09-06 16:08:29.109', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增栏目,id=7d69359f-d925-49f6-a32a-b454e3ecd87d,noddName=232233', '', '2015-09-03 00:18:27.611', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增栏目,id=7fcc4981-33b3-4f16-9ba0-cc2ecdbd2e1f,noddName=22', '', '2015-09-03 02:15:52.421', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增栏目,id=8f59a63d-62da-455e-b907-a5c1aca9c9bb,noddName=产品服务', '', '2015-11-03 15:02:36.305', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增栏目,id=9a3b2d12-d7b0-4b59-a8f7-5a39c2acb801,noddName=联系我们子栏目', '', '2015-10-21 15:59:38.147', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增栏目,id=a83caaf9-6066-499d-8105-f0ed04cba4d7,noddName=解决方案', '', '2015-09-06 16:09:30.953', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增栏目,id=b0dd043d-8692-4f87-8c8b-c38d07820414,noddName=联系我们子栏目', '', '2015-10-21 15:58:19.328', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增栏目,id=c08697fb-4655-41fd-8cbb-567ed31d92f1,noddName=联系我们', '', '2015-11-03 15:07:00.634', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增栏目,id=c0ab0dc7-4ec8-41d8-b242-5880222571bd,noddName=首页', '', '2015-09-06 16:07:58.515', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增栏目,id=e5c0a198-c8ac-4a69-8b3c-a13479f64191,noddName=公司动态', '', '2015-11-03 15:01:50.306', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增栏目,id=ec218830-65c1-4f3a-ab7b-034aea15ec9c,noddName=aa', '', '2015-11-03 09:37:46.517', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增栏目,id=f1b54eff-f129-4eba-be08-0e2be9586d28,noddName=关于我们', '', '2015-11-03 15:04:28.687', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增栏目,id=ffdb9149-8566-4531-9c3e-58ec107a9a48,noddName=产品服务子栏目', '', '2015-10-21 16:00:35.088', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增文章,id=0615bc0b-5e26-460e-8442-171504a4fa8d,title=在线教育平台', '', '2015-11-03 16:03:46.284', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增文章,id=1214bc8e-241b-4c15-ab88-4ad6eb1a313f,title=今天天气', '', '2015-11-04 15:39:20.917', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增文章,id=17bfd550-4d80-404c-b75f-144510f06d3e,title=互联网直播点播平台', '', '2015-10-22 10:44:29.966', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增文章,id=1ac3bcab-e82b-4788-8608-e4a31358c6d2,title=2', '', '2015-09-02 22:42:14.074', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增文章,id=39de3cfa-1355-4feb-9dd4-4bb2bdfe92fc,title=在线教育平台', '', '2015-10-22 10:45:07.376', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增文章,id=467e33c7-435f-49a6-ae36-79a7741f129a,title=逆流中奋进', '', '2015-09-04 14:50:20.96', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增文章,id=48b6d899-f4b7-4b59-b597-42dfa9fcbf7c,title=图灵谷统一业务服务平台', '', '2015-11-03 16:09:00.598', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增文章,id=4d05c734-d6ae-4b9d-b4f8-0378bb6bce0b,title=测试', '', '2015-09-12 18:59:57.817', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增文章,id=4ecb4e32-8e85-4be0-9678-044e49b0b2db,title=与北京星橙科技公司和深圳生活智造公司达成长期战略合作意向', '', '2015-09-06 16:36:54.123', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增文章,id=4ed3a4a6-e267-435f-9aa5-912c83f4bab0,title=是', '', '2015-10-20 18:54:02.48', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增文章,id=537f9fa7-b250-4ad5-8885-6df0e1f4d857,title=图灵谷统一业务服务平台', '', '2015-10-22 10:45:54.052', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增文章,id=576fc646-10af-43e8-9fc7-a426707f199b,title=4', '', '2015-09-02 21:55:04.996', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增文章,id=5f9810aa-e3e3-4520-a315-57ebb4062284,title=全媒体内容管理发布平台', '', '2015-11-03 16:01:43.217', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增文章,id=6322e6ec-53b2-4e82-9400-7ecd700a7af5,title=22', '', '2015-09-04 13:57:54.899', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增文章,id=6d40826d-e2d7-4841-8ccb-89e20bdec54d,title=互联网直播点播平台', '', '2015-11-03 16:02:28.028', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增文章,id=6db67c5f-2c17-4aa8-90b4-d76277cdf5e0,title=2222', '', '2015-09-04 09:29:55.349', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增文章,id=70a78c8d-9560-46b1-bc69-94350148fb5f,title=33', '', '2015-09-02 22:42:33.01', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增文章,id=711ace7c-9cc0-44c0-b435-6b275a18ff3e,title=交通行业', '', '2015-11-03 21:33:48.508', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增文章,id=830a1529-ea31-41f0-acec-ac68c7321ee9,title=说得对', '', '2015-10-21 15:13:40.48', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增文章,id=89161d2a-9251-46b6-af18-3c032ebc57b2,title=2', '', '2015-09-03 00:43:41.771', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增文章,id=8a1c54ec-63ad-4d94-9543-581442caa63b,title=广电行业', '', '2015-11-03 21:32:46.113', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增文章,id=9118d1d1-8fe2-4854-92e0-ca3b7c9ee511,title=全媒体内容管理发布平台', '', '2015-10-22 10:43:42.3', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增文章,id=97163193-3234-49df-a0e2-b9a5dfed6131,title=与北京中平科学技术院签署项目协议', '', '2015-11-03 15:38:27.442', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增文章,id=98054b10-4b0e-4ccd-a411-0033e5fb3822,title=法务系统', '', '2015-11-03 21:36:37.798', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增文章,id=9a73933e-43a7-4458-85d6-3416a819ceb8,title=1', '', '2015-09-12 19:02:27.215', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增文章,id=a01bf9b7-622d-4c38-b08a-b7618f485673,title=教育行业', '', '2015-11-03 21:34:16.458', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增文章,id=a55cece8-5e7e-4384-99c7-c69295a7e6c3,title=移动互联', '', '2015-11-03 21:35:16.936', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增文章,id=a6c35b39-7df5-427f-86b5-3681e1a3cf26,title=政务系统', '', '2015-11-03 21:36:12.967', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增文章,id=ad45780d-a450-491c-b8ff-15833bd66e95,title=2', '', '2015-09-06 16:10:58.388', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增文章,id=b97fac12-aadc-4f51-8fff-3cde5a98c358,title=与北京天地极峰达成合作意向', '', '2015-11-03 15:44:31.558', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增文章,id=c3da4710-d18e-4804-a921-c8f9010a4b44,title=与北京天地极峰达成合作意向', '', '2015-09-06 16:37:07.732', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增文章,id=d98e113d-b092-4440-bb0f-f77d86d51388,title=与北京星橙科技公司和深圳生活智造公司达成长期战略合作意向', '', '2015-11-03 15:45:30.517', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增文章,id=dda07e4c-e6af-4360-963f-385634c998b9,title=fff', '', '2015-09-04 14:30:43.487', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增文章,id=f0579b8d-80f0-4dff-aac9-8ff9c5a9b713,title=与北京中平科学技术院签署项目协议', '', '2015-09-06 16:37:28.685', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '新增文章,id=f6a5c8bd-927e-42f7-bbf5-cb8bc9aad75c,title=12', '', '2015-06-23 09:13:13', '125.121.32.117', 'admin1');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=083c4941-97ae-48d7-9a28-d5debfc9296a,noddName=公司动态', '', '2015-09-06 16:28:25.661', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=083c4941-97ae-48d7-9a28-d5debfc9296a,noddName=公司动态', '', '2015-09-06 16:35:59.152', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=083c4941-97ae-48d7-9a28-d5debfc9296a,noddName=公司动态', '', '2015-09-06 18:39:10.929', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=083c4941-97ae-48d7-9a28-d5debfc9296a,noddName=公司动态', '', '2015-10-08 15:17:06.717', '219.142.247.206', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=083c4941-97ae-48d7-9a28-d5debfc9296a,noddName=公司动态', '', '2015-10-21 09:57:29.985', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=083c4941-97ae-48d7-9a28-d5debfc9296a,noddName=公司动态', '', '2015-10-21 09:58:10.873', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=083c4941-97ae-48d7-9a28-d5debfc9296a,noddName=公司动态', '', '2015-10-21 09:58:39.348', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=083c4941-97ae-48d7-9a28-d5debfc9296a,noddName=公司动态', '', '2015-10-21 09:59:18.948', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=083c4941-97ae-48d7-9a28-d5debfc9296a,noddName=公司动态', '', '2015-10-21 09:59:50.816', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=083c4941-97ae-48d7-9a28-d5debfc9296a,noddName=公司动态', '', '2015-10-21 10:59:09.348', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=083c4941-97ae-48d7-9a28-d5debfc9296a,noddName=公司动态', '', '2015-10-21 11:00:09.638', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=083c4941-97ae-48d7-9a28-d5debfc9296a,noddName=公司动态', '', '2015-10-21 11:00:43.21', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=083c4941-97ae-48d7-9a28-d5debfc9296a,noddName=公司动态', '', '2015-10-21 11:01:15.638', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=083c4941-97ae-48d7-9a28-d5debfc9296a,noddName=公司动态', '', '2015-10-21 11:01:31.187', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=083c4941-97ae-48d7-9a28-d5debfc9296a,noddName=公司动态', '', '2015-10-21 11:03:05.203', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=083c4941-97ae-48d7-9a28-d5debfc9296a,noddName=公司动态', '', '2015-10-21 11:06:13.147', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=083c4941-97ae-48d7-9a28-d5debfc9296a,noddName=公司动态', '', '2015-10-21 17:08:20.015', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=083c4941-97ae-48d7-9a28-d5debfc9296a,noddName=公司动态', '', '2015-10-21 17:08:34.351', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=0deb3c1f-dc40-48d3-aced-bc9a5786e227,noddName=产品服务', '', '2015-09-06 18:39:18.519', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=0deb3c1f-dc40-48d3-aced-bc9a5786e227,noddName=产品服务', '', '2015-10-08 15:17:13.361', '219.142.247.206', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=0deb3c1f-dc40-48d3-aced-bc9a5786e227,noddName=产品服务', '', '2015-10-21 10:00:40.886', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=0deb3c1f-dc40-48d3-aced-bc9a5786e227,noddName=产品服务', '', '2015-10-21 10:01:04.776', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=0deb3c1f-dc40-48d3-aced-bc9a5786e227,noddName=产品服务', '', '2015-10-21 10:03:13.643', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=0deb3c1f-dc40-48d3-aced-bc9a5786e227,noddName=产品服务', '', '2015-10-21 10:03:51.65', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=1180afd7-7dc6-4eb3-9632-c0e24d0ee482,noddName=aa', '', '2015-11-03 10:40:53.261', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=1180afd7-7dc6-4eb3-9632-c0e24d0ee482,noddName=aa', '', '2015-11-03 10:44:18.765', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=1180afd7-7dc6-4eb3-9632-c0e24d0ee482,noddName=aa', '', '2015-11-03 10:44:46.192', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=1180afd7-7dc6-4eb3-9632-c0e24d0ee482,noddName=aa', '', '2015-11-03 10:48:28.267', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=1180afd7-7dc6-4eb3-9632-c0e24d0ee482,noddName=aa', '', '2015-11-03 10:49:02.193', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=1180afd7-7dc6-4eb3-9632-c0e24d0ee482,noddName=aa', '', '2015-11-03 10:50:51.249', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=1180afd7-7dc6-4eb3-9632-c0e24d0ee482,noddName=aa', '', '2015-11-03 10:51:03.757', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=1180afd7-7dc6-4eb3-9632-c0e24d0ee482,noddName=aa', '', '2015-11-03 10:51:21.874', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=1180afd7-7dc6-4eb3-9632-c0e24d0ee482,noddName=aa', '', '2015-11-03 11:13:42.985', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=1180afd7-7dc6-4eb3-9632-c0e24d0ee482,noddName=aa', '', '2015-11-03 11:45:37.515', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=3095c724-75a9-4d57-b915-d02614441aeb,noddName=aa', '', '2015-11-03 10:41:10.641', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=37198106-b573-48de-82d1-92456254ba7c,noddName=22', '', '2015-09-03 00:13:08.321', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=37198106-b573-48de-82d1-92456254ba7c,noddName=223', '', '2015-09-03 00:15:01.747', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=4ef84122-5605-45af-bfea-a3c2e315b898,noddName=解决方案', '', '2015-11-03 15:03:21.988', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=4ef84122-5605-45af-bfea-a3c2e315b898,noddName=解决方案', '', '2015-11-03 15:03:41.603', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=6f87eaee-1ee9-4316-9caa-1a99380d6785,noddName=联系我们', '', '2015-09-06 18:39:37.214', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=6f87eaee-1ee9-4316-9caa-1a99380d6785,noddName=联系我们', '', '2015-10-08 15:17:32.569', '219.142.247.206', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=6f87eaee-1ee9-4316-9caa-1a99380d6785,noddName=联系我们', '', '2015-10-21 15:56:38.908', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=6f87eaee-1ee9-4316-9caa-1a99380d6785,noddName=联系我们', '', '2015-10-21 15:56:55.256', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=7ab82cec-c82b-4e6b-89cb-722c266dce7d,noddName=关于我们', '', '2015-09-06 18:38:27.563', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=7ab82cec-c82b-4e6b-89cb-722c266dce7d,noddName=关于我们', '', '2015-09-06 18:38:31.056', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=7ab82cec-c82b-4e6b-89cb-722c266dce7d,noddName=关于我们', '', '2015-09-06 18:39:31.918', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=7ab82cec-c82b-4e6b-89cb-722c266dce7d,noddName=关于我们', '', '2015-10-08 15:17:24.847', '219.142.247.206', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=8f59a63d-62da-455e-b907-a5c1aca9c9bb,noddName=产品服务', '', '2015-11-03 15:03:25.594', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=8f59a63d-62da-455e-b907-a5c1aca9c9bb,noddName=产品服务', '', '2015-11-03 15:03:37.556', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=9a3b2d12-d7b0-4b59-a8f7-5a39c2acb801,noddName=联系我们子栏目', '', '2015-10-21 17:08:47.397', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=9a3b2d12-d7b0-4b59-a8f7-5a39c2acb801,noddName=联系我们子栏目', '', '2015-10-21 17:11:16.377', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=a83caaf9-6066-499d-8105-f0ed04cba4d7,noddName=解决方案', '', '2015-09-06 18:39:24.91', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=a83caaf9-6066-499d-8105-f0ed04cba4d7,noddName=解决方案', '', '2015-10-08 15:17:19.229', '219.142.247.206', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=a83caaf9-6066-499d-8105-f0ed04cba4d7,noddName=解决方案', '', '2015-10-21 11:03:22.102', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=a83caaf9-6066-499d-8105-f0ed04cba4d7,noddName=解决方案', '', '2015-10-21 11:03:51.148', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=c08697fb-4655-41fd-8cbb-567ed31d92f1,noddName=联系我们', '', '2015-11-04 16:35:46.721', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=c08697fb-4655-41fd-8cbb-567ed31d92f1,noddName=联系我们', '', '2015-11-04 16:35:59.381', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=c0ab0dc7-4ec8-41d8-b242-5880222571bd,noddName=首页', '', '2015-09-06 18:39:01.525', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=c0ab0dc7-4ec8-41d8-b242-5880222571bd,noddName=首页', '', '2015-10-08 15:16:59.543', '219.142.247.206', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=c0ab0dc7-4ec8-41d8-b242-5880222571bd,noddName=首页', '', '2015-10-21 15:50:44.994', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=c0ab0dc7-4ec8-41d8-b242-5880222571bd,noddName=首页', '', '2015-10-21 15:51:11.843', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=c0ab0dc7-4ec8-41d8-b242-5880222571bd,noddName=首页', '', '2015-10-21 15:51:29.705', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=e5c0a198-c8ac-4a69-8b3c-a13479f64191,noddName=公司动态', '', '2015-11-03 15:04:39.041', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=ffdb9149-8566-4531-9c3e-58ec107a9a48,noddName=产品服务子栏目', '', '2015-10-21 17:08:56.971', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改栏目,id=ffdb9149-8566-4531-9c3e-58ec107a9a48,noddName=产品服务子栏目', '', '2015-10-21 17:11:24.207', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改文章,id=0615bc0b-5e26-460e-8442-171504a4fa8d,title=在线教育平台', '', '2015-11-03 17:25:49.334', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改文章,id=39de3cfa-1355-4feb-9dd4-4bb2bdfe92fc,title=在线教育平台', '', '2015-10-22 10:46:05.178', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改文章,id=48b6d899-f4b7-4b59-b597-42dfa9fcbf7c,title=图灵谷统一业务服务平台', '', '2015-11-03 17:25:58.651', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改文章,id=4ecb4e32-8e85-4be0-9678-044e49b0b2db,title=与北京星橙科技公司和深圳生活智造公司达成长期战略合作意向', '', '2015-09-06 17:11:34.405', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改文章,id=576fc646-10af-43e8-9fc7-a426707f199b,title=42', '', '2015-09-02 22:39:52.461', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改文章,id=576fc646-10af-43e8-9fc7-a426707f199b,title=422', '', '2015-09-02 22:41:04.784', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改文章,id=576fc646-10af-43e8-9fc7-a426707f199b,title=422', '', '2015-09-02 22:41:29.942', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改文章,id=576fc646-10af-43e8-9fc7-a426707f199b,title=4222', '', '2015-09-02 22:42:07.88', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改文章,id=576fc646-10af-43e8-9fc7-a426707f199b,title=42222', '', '2015-09-02 22:43:27.578', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改文章,id=5f9810aa-e3e3-4520-a315-57ebb4062284,title=全媒体内容管理发布平台', '', '2015-11-03 17:22:23.079', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改文章,id=5f9810aa-e3e3-4520-a315-57ebb4062284,title=全媒体内容管理发布平台', '', '2015-11-03 17:22:33.513', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改文章,id=5f9810aa-e3e3-4520-a315-57ebb4062284,title=全媒体内容管理发布平台', '', '2015-11-03 17:23:39.702', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改文章,id=5f9810aa-e3e3-4520-a315-57ebb4062284,title=全媒体内容管理发布平台', '', '2015-11-03 17:25:24.594', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改文章,id=6322e6ec-53b2-4e82-9400-7ecd700a7af5,title=22', '', '2015-09-04 13:58:05.952', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改文章,id=6322e6ec-53b2-4e82-9400-7ecd700a7af5,title=22', '', '2015-09-04 14:26:57.135', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改文章,id=6d40826d-e2d7-4841-8ccb-89e20bdec54d,title=互联网直播点播平台', '', '2015-11-03 16:02:52.141', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改文章,id=6d40826d-e2d7-4841-8ccb-89e20bdec54d,title=互联网直播点播平台', '', '2015-11-03 17:25:37.179', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改文章,id=711ace7c-9cc0-44c0-b435-6b275a18ff3e,title=交通行业', '', '2015-11-04 17:37:10.292', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改文章,id=830a1529-ea31-41f0-acec-ac68c7321ee9,title=说得对', '', '2015-10-21 15:15:12.41', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改文章,id=8a1c54ec-63ad-4d94-9543-581442caa63b,title=广电行业', '', '2015-11-04 17:36:59.269', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改文章,id=97163193-3234-49df-a0e2-b9a5dfed6131,title=与北京中平科学技术院签署项目协议', '', '2015-11-03 15:46:32.223', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改文章,id=98054b10-4b0e-4ccd-a411-0033e5fb3822,title=法务系统', '', '2015-11-04 17:38:01.745', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改文章,id=9a73933e-43a7-4458-85d6-3416a819ceb8,title=1', '', '2015-09-12 19:02:52.541', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改文章,id=a01bf9b7-622d-4c38-b08a-b7618f485673,title=教育行业', '', '2015-11-04 17:37:22.178', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改文章,id=a55cece8-5e7e-4384-99c7-c69295a7e6c3,title=移动互联', '', '2015-11-04 17:37:34.141', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改文章,id=a6c35b39-7df5-427f-86b5-3681e1a3cf26,title=政务系统', '', '2015-11-04 17:37:48.872', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改文章,id=b97fac12-aadc-4f51-8fff-3cde5a98c358,title=与北京天地极峰达成合作意向', '', '2015-11-03 15:46:02.181', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改文章,id=c3da4710-d18e-4804-a921-c8f9010a4b44,title=与北京天地极峰达成合作意向', '', '2015-09-06 17:11:19.299', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改文章,id=dda07e4c-e6af-4360-963f-385634c998b9,title=fff', '', '2015-09-04 14:34:57.204', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改文章,id=f0579b8d-80f0-4dff-aac9-8ff9c5a9b713,title=与北京中平科学技术院签署项目协议', '', '2015-09-06 17:11:02.049', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改文章,id=f0579b8d-80f0-4dff-aac9-8ff9c5a9b713,title=与北京中平科学技术院签署项目协议', '', '2015-10-21 14:40:25.792', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('操作日志', '修改文章,id=f0579b8d-80f0-4dff-aac9-8ff9c5a9b713,title=与北京中平科学技术院签署项目协议', '', '2015-10-21 15:04:44.373', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-08 09:10:58', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-08 09:31:39', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-08 09:31:42', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-08 09:31:43', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-08 09:31:43', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-08 09:31:43', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-08 09:32:21', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-08 09:32:32', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-08 09:32:35', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-08 09:49:13', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-08 09:49:34', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-08 09:50:14', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-08 09:53:08', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-08 09:53:10', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-08 09:53:20', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-08 09:55:53', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-08 09:55:54', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-08 09:57:38', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-08 09:58:12', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-08 09:58:12', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-08 09:59:09', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-08 10:05:14', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-09 09:40:35', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-09 10:12:20', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-09 10:12:41', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-09 10:12:43', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-09 10:12:46', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-09 13:52:08', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-09 15:12:46', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-09 15:53:42', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-09 15:53:44', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-09 15:53:52', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-09 15:58:18', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-09 15:58:42', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-09 15:59:04', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-09 17:10:40', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-10 09:31:28', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-10 09:31:37', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-10 10:35:48', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-10 10:36:12', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-10 10:36:13', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-10 10:36:14', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-10 10:36:15', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-10 10:36:33', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-10 10:36:34', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-10 11:08:55', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-10 11:23:25', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-10 11:24:06', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-10 14:05:52', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-10 14:26:03', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-12 09:11:00', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-12 10:48:48', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-12 10:55:32', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-12 11:02:58', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-12 13:38:43', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-14 12:41:44', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-14 12:48:11', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-14 13:07:35', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-14 22:06:53', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-14 22:06:55', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-14 22:06:56', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-14 22:08:28', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-14 22:09:26', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-14 22:10:36', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-14 22:11:37', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-14 22:14:05', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-14 22:20:30', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-14 22:23:14', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-14 22:51:56', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-14 22:53:31', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-14 22:54:49', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-14 22:54:54', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-14 23:10:16', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-15 09:01:00', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-15 11:48:00', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-15 17:32:03', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-16 13:49:30', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-16 13:49:34', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-16 13:49:35', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-16 13:56:46', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-16 14:00:05', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-19 11:17:39', '122.235.84.66', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-19 11:36:44', '122.235.84.66', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-19 17:00:24', '122.235.84.66', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-19 17:00:51', '122.235.84.66', 'admin1');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-19 17:00:59', '122.235.84.66', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-19 17:01:41', '122.235.84.66', 'admin1');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-19 17:02:29', '122.235.84.66', 'admin1');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-19 17:02:41', '122.235.84.66', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-19 17:04:40', '122.235.84.66', 'admin1');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-19 17:11:58', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-19 17:26:08', '122.235.84.66', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-19 17:42:56', '122.235.84.66', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-19 17:46:08', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-19 17:47:41', '122.235.84.66', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-19 17:48:08', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-19 17:48:28', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-19 17:48:29', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-19 17:48:32', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-19 17:48:32', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-19 17:48:34', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-19 17:48:39', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-19 17:48:40', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-19 17:48:48', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-19 17:48:48', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-19 17:48:52', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-19 17:48:53', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-19 17:49:19', '0:0:0:0:0:0:0:1', 'admin1');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-06-23 09:12:03', '125.121.32.117', 'admin1');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-07-02 11:38:29', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-07-02 11:38:49', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-07-03 16:05:36', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-07-03 16:09:40', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-07-06 16:11:34', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-07-06 16:24:24', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-07-06 16:26:21', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-07-06 16:28:01', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-02 18:37:48.055', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-02 18:46:07.515', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-02 18:54:47.833', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-02 20:27:15.128', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-02 20:29:24.108', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-02 20:57:07.86', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-02 20:57:17.563', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-02 20:57:22.537', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-02 21:45:16.198', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-02 21:47:21.663', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-02 21:48:39.723', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-02 21:51:59.74', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-02 21:52:47.243', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-02 21:54:56.993', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-02 21:57:14.341', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-02 21:57:48.469', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-02 22:14:22.961', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-02 22:21:24.467', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-02 22:23:13.065', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-02 22:23:19.056', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-02 22:47:39.727', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-02 22:47:42.878', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-02 23:07:28.491', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-02 23:10:13.647', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-02 23:12:27.652', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-02 23:13:17.199', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-02 23:20:48.346', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-02 23:22:42.137', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-02 23:24:32.134', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-02 23:29:34.253', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-02 23:37:27.654', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-03 00:01:29.389', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-03 00:01:29.843', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-03 00:09:45.14', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-03 00:12:53.052', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-03 00:23:56.976', '127.0.0.1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-03 00:40:13.821', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-03 01:16:08.637', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-03 01:46:40.378', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-03 01:49:18.339', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-03 02:08:04.701', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-03 02:13:44.761', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-03 15:12:47.564', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-03 15:13:02.377', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-03 16:01:27.773', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-03 16:06:52.728', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-03 16:52:54.254', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-03 16:59:54.699', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-03 17:29:42.899', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-03 17:44:27.726', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-03 23:51:24.762', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 00:02:28.861', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 00:10:12.659', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 00:12:21.469', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 00:15:10.597', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 00:18:06.288', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 00:22:55.29', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 01:06:07.37', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 01:40:44.066', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 01:40:52.833', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 02:07:52.431', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 02:15:14.387', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 02:17:32.83', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 09:28:35.829', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 09:48:34.478', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 09:50:52.32', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 10:02:45.961', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 10:03:06.692', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 10:03:58.522', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 10:19:46.936', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 10:28:06.44', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 10:29:03.358', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 10:34:08.844', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 10:35:05.318', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 10:36:18.174', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 10:36:53.468', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 10:37:29.871', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 10:38:04.92', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 10:40:59.965', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 10:43:40.969', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 10:45:17.988', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 10:52:44.003', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 10:53:37.083', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 10:59:05.755', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 10:59:51.395', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 11:01:28.489', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 11:01:38.182', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 11:02:18.692', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 11:03:01.547', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 11:05:33.68', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 11:07:09.737', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 11:08:27.847', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 11:11:42.311', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 11:15:00.027', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 11:17:36.621', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 11:19:17.191', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 11:22:10.36', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 11:35:42.185', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 11:39:16.293', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 11:52:35.437', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 11:59:30.608', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 12:02:25.4', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 12:04:16.98', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 12:07:53.889', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 12:11:56.255', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 12:23:51.823', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 12:23:58.679', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 12:27:51.326', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 12:27:56.768', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 12:29:48.809', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 12:29:54.951', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 12:47:43.276', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 13:24:56.941', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 13:53:43.748', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 13:57:00.091', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 14:04:25.925', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 14:13:54.335', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 14:23:30.384', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 14:25:11.328', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 14:28:22.831', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 14:28:24.065', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 14:30:18.798', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 14:32:48.454', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 14:33:00.536', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 14:38:40.589', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 14:40:10.1', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 14:43:56.074', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 14:46:09.283', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 14:48:02.33', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 14:54:59.051', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 14:56:38.276', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 15:09:19.314', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 15:25:05.619', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 15:36:40.963', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 15:37:51.718', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 15:45:32.61', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 15:48:14.524', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 16:26:58.567', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 16:33:32.098', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 16:35:18.452', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 16:44:16.889', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 16:54:36.007', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 17:15:28.018', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 17:40:25.538', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 17:47:20.282', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 17:53:36.295', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-04 18:08:07.948', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-05 09:54:42.568', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-06 08:54:07.651', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-06 09:09:11.173', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-06 09:11:29.093', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-06 09:15:10.597', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-06 09:46:58.57', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-06 11:13:30.899', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-06 15:31:38.409', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-06 16:21:34.586', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-06 16:35:38.555', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-06 17:10:08.464', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-06 18:04:34.94', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-06 18:23:54.035', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-06 18:31:38.979', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-06 18:45:22.803', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-06 18:51:48.114', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-06 20:32:42.601', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-09-12 18:55:13.271', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-10-08 15:16:28.726', '219.142.247.206', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-10-20 18:41:07.397', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-10-21 09:47:49.276', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-10-21 14:38:05.07', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-10-21 15:01:57.698', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-10-21 18:52:37.436', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-10-21 21:32:02.237', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-10-22 10:06:06.898', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-10-22 10:07:01.398', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-10-22 11:30:44.996', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-10-22 14:35:29.979', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-10-22 16:26:22.105', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-10-22 19:38:09.339', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-10-26 15:17:26.432', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-10-26 19:09:00.647', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-10-27 10:44:09.722', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-10-27 10:52:15.427', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-10-27 11:04:28.426', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-10-27 11:23:53.916', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-10-27 11:34:25.022', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-10-27 12:24:05.321', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-10-27 13:07:32.21', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-10-27 14:25:00.492', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-10-27 15:21:27.055', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-10-27 15:28:16.993', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-10-27 15:57:34.929', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-10-27 17:06:46.115', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-10-27 17:55:32.952', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-10-27 17:56:31.243', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-10-27 17:56:53.958', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-10-27 17:57:54.279', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-10-27 19:54:52.118', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-10-30 14:14:21.687', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-10-30 17:09:22.143', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-03 09:34:17.496', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-03 09:38:13.993', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-03 11:02:17.26', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-03 11:02:19.224', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-03 11:03:28.391', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-03 11:05:03.356', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-03 11:07:20.801', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-03 11:44:07.916', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-03 12:20:53.183', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-03 12:39:31.055', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-03 14:55:19.001', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-03 16:25:54.842', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-03 16:25:57.927', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-03 16:31:17.901', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-03 16:47:23.047', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-03 16:55:10.802', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-03 17:04:51.317', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-03 17:06:42.635', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-03 17:14:47.021', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-03 17:16:18.768', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-03 17:18:36.428', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-03 17:19:48.075', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-03 17:32:20.618', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-03 20:19:42.985', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-03 20:24:32.448', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-03 20:29:04.627', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-03 20:31:23.682', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-04 10:22:52.144', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-04 11:00:49.242', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-04 14:43:07.07', '127.0.0.1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-04 15:02:30.759', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-04 15:31:34.896', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-04 17:30:05.311', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-04 17:33:32.71', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-04 17:36:17.362', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-04 17:49:04.589', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-04 17:51:05.825', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-04 19:34:07.574', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-05 15:13:45.614', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 10:14:12.221', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 10:14:15.444', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 10:25:12.635', '0:0:0:0:0:0:0:1', 'aaaaa');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 10:29:07.055', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 10:37:45.495', '0:0:0:0:0:0:0:1', 'aaaaa');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 10:39:05.481', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 10:39:26.537', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 10:39:31.261', '0:0:0:0:0:0:0:1', 'aaaaa');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 10:39:39.157', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 10:40:19.967', '0:0:0:0:0:0:0:1', 'aaaaa');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 10:40:32.916', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 10:41:12.894', '0:0:0:0:0:0:0:1', 'aaaaa');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 10:42:11.321', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 10:47:21.12', '0:0:0:0:0:0:0:1', 'aaaaa');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 10:47:48.617', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 11:02:24.928', '0:0:0:0:0:0:0:1', 'aaaaa');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 11:30:49.94', '0:0:0:0:0:0:0:1', 'aaaaa');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 11:34:56.008', '0:0:0:0:0:0:0:1', 'aaaaa');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 11:34:57.098', '0:0:0:0:0:0:0:1', 'aaaaa');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 11:42:52.731', '0:0:0:0:0:0:0:1', 'aaaaa');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 11:51:55.757', '0:0:0:0:0:0:0:1', 'aaaaa');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 11:56:34.091', '0:0:0:0:0:0:0:1', 'aaaaa');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 12:57:17.452', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 13:00:10.069', '0:0:0:0:0:0:0:1', 'aaaaa');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 13:06:31.901', '0:0:0:0:0:0:0:1', 'aaaaa');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 13:07:00.571', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 14:15:47.492', '0:0:0:0:0:0:0:1', 'aaaaa');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 14:15:55.062', '0:0:0:0:0:0:0:1', 'aaaaa');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 14:16:41.29', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 14:16:47.669', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 14:48:40.065', '127.0.0.1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 14:51:49.264', '0:0:0:0:0:0:0:1', 'aaaaa');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 14:52:06.122', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 14:54:03.976', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 15:09:16.681', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 15:59:47.319', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 16:33:02.142', '0:0:0:0:0:0:0:1', 'jason');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 16:34:29.356', '0:0:0:0:0:0:0:1', 'jason');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 16:38:07.663', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-06 16:48:04.709', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-07 10:19:00.396', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-07 14:35:36.997', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-07 17:42:47.07', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-10 16:53:10.539', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-11 17:24:25.469', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-11 20:59:31.068', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-11-12 09:19:37.051', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功', '', '2015-12-11 16:19:31.212', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录成功！', '', '2016-01-18 15:18:54.84', '', ' admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败超过最大次数，账户锁定！', '', '2016-01-18 15:17:52.525', '', ' admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,该用户名不存在！', '', '2015-09-04 10:58:47.338', '0:0:0:0:0:0:0:1', 'amdin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,该用户名不存在！', '', '2015-09-04 10:58:58.628', '0:0:0:0:0:0:0:1', 'amdin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,密码错误次数太多！请确认用户名和密码！', '', '2015-06-14 12:41:31', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,密码错误次数太多！请确认用户名和密码！', '', '2015-06-14 12:41:36', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,密码错误次数太多！请确认用户名和密码！', '', '2015-06-19 17:00:13', '122.235.84.66', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,密码错误次数太多！请确认用户名和密码！', '', '2015-09-04 12:27:20.41', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,密码错误次数太多！请确认用户名和密码！', '', '2015-09-04 12:27:39.488', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,密码错误次数太多！请确认用户名和密码！', '', '2015-10-27 11:24:09.627', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,密码错误次数太多！请确认用户名和密码！', '', '2015-10-27 11:24:16.417', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,密码错误次数太多！请确认用户名和密码！', '', '2016-01-04 18:37:42.58', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,密码错误次数太多！请确认用户名和密码！', '', '2016-01-04 18:39:20.21', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证失败，请重新登录！', '', '2015-10-27 11:33:28.796', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证信息不正确', '', '2015-06-08 09:59:04', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证信息不正确', '', '2015-06-08 09:59:05', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证信息不正确', '', '2015-06-12 10:48:44', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证信息不正确', '', '2015-06-14 12:41:23', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证信息不正确', '', '2015-06-14 12:41:27', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证信息不正确', '', '2015-06-14 12:48:07', '0:0:0:0:0:0:0:1', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证信息不正确', '', '2015-06-15 11:47:55', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证信息不正确', '', '2015-06-19 17:00:04', '122.235.84.66', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证信息不正确', '', '2015-06-19 17:00:12', '122.235.84.66', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证信息不正确', '', '2015-06-19 17:02:38', '122.235.84.66', 'ceshi');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证信息不正确', '', '2015-06-19 17:11:11', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证信息不正确', '', '2015-06-19 17:11:50', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证信息不正确', '', '2015-06-19 17:11:52', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证信息不正确', '', '2015-09-04 12:27:18.094', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证信息不正确', '', '2015-09-04 12:27:19.388', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证信息不正确', '', '2015-09-04 12:47:39.395', '0:0:0:0:0:0:0:1', 'test1');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证信息不正确', '', '2015-10-27 11:05:51.097', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证信息不正确', '', '2015-10-27 11:24:02.894', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证信息不正确', '', '2015-10-27 11:24:59.265', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证信息不正确', '', '2015-10-27 11:26:32.248', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证信息不正确', '', '2015-10-27 11:33:02.191', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证信息不正确', '', '2015-10-27 15:28:12.25', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证信息不正确', '', '2015-10-27 17:06:41', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证信息不正确', '', '2015-10-27 19:54:46.838', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证信息不正确', '', '2015-10-30 14:14:06.778', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证信息不正确', '', '2015-10-30 14:14:15.781', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证信息不正确', '', '2015-11-04 14:43:01.222', '127.0.0.1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证信息不正确', '', '2015-11-04 15:31:17.685', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证信息不正确', '', '2015-11-04 15:31:19.055', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证信息不正确', '', '2015-11-06 10:25:07.538', '0:0:0:0:0:0:0:1', 'aaaaa');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证信息不正确', '', '2015-11-06 10:37:41.785', '0:0:0:0:0:0:0:1', 'aaaaa');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证信息不正确', '', '2015-11-06 16:32:57.269', '0:0:0:0:0:0:0:1', 'jason');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证信息不正确', '', '2015-12-11 16:19:23.292', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证信息不正确', '', '2016-01-04 18:37:26.94', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证信息不正确', '', '2016-01-04 18:37:31.742', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证信息不正确', '', '2016-01-04 18:39:04.078', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '登录失败,认证信息不正确', '', '2016-01-04 18:39:09.349', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '用户登录成功！', '', '2016-01-18 15:32:32.032', '', ' admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '用户登录成功！', '', '2016-01-18 15:33:32.094', '', ' admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '用户登录成功！', '', '2016-01-18 15:36:31.853', '', ' admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '用户登录成功！', '', '2016-01-18 15:38:46.423', '', ' admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '用户登录成功！', '', '2016-01-18 15:41:42.509', '', ' admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '用户登录成功！', '', '2016-01-18 15:52:45.652', '', ' admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '用户登录成功！', '', '2016-01-18 16:03:37.018', '', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '用户登录成功！', '', '2016-01-18 16:04:00.625', '', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '用户[登录]系统【成功】！', '', '2016-01-18 16:24:49.95', '', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '用户[登录]系统【成功】！', '', '2016-01-18 16:43:06.449', '', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '用户[登录]系统【成功】！', '', '2016-01-18 16:43:30.147', '', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '用户[登录]系统【成功】！', '', '2016-01-18 17:12:58.78', '', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '用户[登录]系统【成功】！', '', '2016-01-18 17:13:20.768', '', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '用户[登录]系统【成功】！', '', '2016-01-18 17:17:32.174', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '用户[登录]系统【成功】！', '', '2016-01-18 17:48:43.808', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '用户[登录]系统【成功】！', '', '2016-01-19 10:04:15.326', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '用户[登录]系统【成功】！', '', '2016-01-19 10:06:53.852', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '用户[登录]系统【成功】！', '', '2016-01-19 10:07:38.862', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '用户[登录]系统【成功】！', '', '2016-01-19 10:09:10.413', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '用户[登录]系统【失败】！org.springframework.security.authentication.BadCredentialsException: 认证信息不正确', '', '2016-01-19 10:03:46.489', '0:0:0:0:0:0:0:1', ' admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '用户[登录]系统【失败】！org.springframework.security.authentication.BadCredentialsException: 认证信息不正确', '', '2016-01-19 10:07:30.489', '0:0:0:0:0:0:0:1', ' admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '用户[登录]系统【失败】！org.springframework.security.core.userdetails.UsernameNotFoundException: 用户不存在', '', '2016-01-19 10:04:48.78', '0:0:0:0:0:0:0:1', ' adsfasd');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '用户[登录]系统【失败】！org.springframework.security.core.userdetails.UsernameNotFoundException: 用户不存在', '', '2016-01-19 10:07:24.642', '0:0:0:0:0:0:0:1', ' asdf');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '用户[登录]系统【失败】！认证信息不正确', '', '2016-01-19 10:09:04.235', '0:0:0:0:0:0:0:1', ' admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '用户退出成功！', '', '2016-01-18 16:03:52.591', '', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '用户[退出]系统【成功】！', '', '2016-01-18 16:43:18.337', '', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '用户[退出]系统【成功】！', '', '2016-01-18 17:13:09.356', '', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '用户[退出]系统【成功】！', '', '2016-01-19 10:04:40.717', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '用户[退出]系统【成功】！', '', '2016-01-19 10:07:14.687', '0:0:0:0:0:0:0:1', 'admin');
INSERT INTO "public"."tg_c_log" VALUES ('登录日志', '用户[退出]系统【成功】！', '', '2016-01-19 10:08:57.305', '0:0:0:0:0:0:0:1', 'admin');

-- ----------------------------
-- Table structure for tg_c_message
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_c_message";
CREATE TABLE "public"."tg_c_message" (
"id" varchar(45) COLLATE "default" NOT NULL,
"title" varchar(45) COLLATE "default" NOT NULL,
"content" varchar(200) COLLATE "default",
"create_time" timestamp(6) NOT NULL,
"sort_order" int2 NOT NULL,
"editable" int2 NOT NULL,
"enabled" int2 NOT NULL,
"userId" varchar(45) COLLATE "default" NOT NULL,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."tg_c_message"."id" IS '系统消息';
COMMENT ON COLUMN "public"."tg_c_message"."title" IS '标题';
COMMENT ON COLUMN "public"."tg_c_message"."content" IS '内容';
COMMENT ON COLUMN "public"."tg_c_message"."create_time" IS '时间';
COMMENT ON COLUMN "public"."tg_c_message"."sort_order" IS '优先级';
COMMENT ON COLUMN "public"."tg_c_message"."editable" IS '是否可编辑';
COMMENT ON COLUMN "public"."tg_c_message"."enabled" IS '状态 2未读 1 已读';

-- ----------------------------
-- Records of tg_c_message
-- ----------------------------

-- ----------------------------
-- Table structure for tg_c_resource
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_c_resource";
CREATE TABLE "public"."tg_c_resource" (
"id" varchar(45) COLLATE "default" NOT NULL,
"icon_cls" varchar(45) COLLATE "default",
"resource_name" varchar(45) COLLATE "default" NOT NULL,
"type" int2 NOT NULL,
"code" varchar(100) COLLATE "default",
"permission" varchar(45) COLLATE "default" NOT NULL,
"perm_value" varchar(100) COLLATE "default",
"description" varchar(200) COLLATE "default",
"parent_id" varchar(45) COLLATE "default",
"sort_order" int2 NOT NULL,
"editable" int2 DEFAULT 1 NOT NULL,
"enabled" int2 DEFAULT 1 NOT NULL,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default",
"domain" int2,
"code_num" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."tg_c_resource"."id" IS '资源表';
COMMENT ON COLUMN "public"."tg_c_resource"."resource_name" IS '名称';
COMMENT ON COLUMN "public"."tg_c_resource"."type" IS '资源类型 1菜单 2按钮 3方法';
COMMENT ON COLUMN "public"."tg_c_resource"."code" IS '权限代码';
COMMENT ON COLUMN "public"."tg_c_resource"."permission" IS '权限标识';
COMMENT ON COLUMN "public"."tg_c_resource"."description" IS '描述';
COMMENT ON COLUMN "public"."tg_c_resource"."sort_order" IS '优先级';
COMMENT ON COLUMN "public"."tg_c_resource"."editable" IS '是否可编辑  1可编辑 2不可编辑';
COMMENT ON COLUMN "public"."tg_c_resource"."enabled" IS '是否可用';
COMMENT ON COLUMN "public"."tg_c_resource"."domain" IS '1 后台 2前台';

-- ----------------------------
-- Records of tg_c_resource
-- ----------------------------
INSERT INTO "public"."tg_c_resource" VALUES ('0529d9a4-effa-4b3c-9816-12babc3b1beb', null, '操作日志', '1', null, 'logOperateList', null, null, '84113afa-df07-4247-8666-f164a7acbefa', '33', '1', '1', '2015-11-06 16:15:33.774', 'admin', '2015-11-06 16:23:52.868', 'admin', null, '700001');
INSERT INTO "public"."tg_c_resource" VALUES ('0ad63955-9c6f-4541-a239-e276e302f723', null, 'TAG管理', '1', null, 'tag', null, null, '37b27cd8-1abd-4074-a2ac-e35b8434d194', '11', '1', '1', '2015-11-06 15:18:06.936', 'admin', null, null, null, '100004');
INSERT INTO "public"."tg_c_resource" VALUES ('186a9eac-855c-4c52-995c-8af38bd2453b', null, '用户管理', '1', null, 'user', null, null, '41e189b1-f4b7-4669-a4ae-2786aff6c65c', '30', '1', '1', '2015-11-06 16:22:19.989', 'admin', null, null, null, '600001');
INSERT INTO "public"."tg_c_resource" VALUES ('19f4363b-f82c-4385-8503-be8b0284a8ea', null, '模型配置', '1', null, 'model', null, null, 'e42baff4-dee1-4dad-b57a-ded0a137d2b7', '27', '1', '1', '2015-11-06 16:13:04.806', 'admin', null, null, null, '500004');
INSERT INTO "public"."tg_c_resource" VALUES ('2426b670-1238-49a3-ac51-0d844e64b063', null, '招聘管理', '1', null, 'resume', null, null, '6a04b2df-1923-4b29-8f0b-f0d748fdf52a', '23', '1', '1', '2015-11-06 15:46:44.475', 'admin', null, null, null, '400001');
INSERT INTO "public"."tg_c_resource" VALUES ('2b989ea2-a0c1-4af2-a514-54f294c4c34f', null, '友情链接类型', '1', null, 'friendlinkType', null, null, '870e7f29-22ed-450d-a591-0673765808fe', '21', '1', '1', '2015-11-06 15:28:36.324', 'admin', null, null, null, '300004');
INSERT INTO "public"."tg_c_resource" VALUES ('2d906c65-a953-440b-9fab-87f6f9ec1739', null, '广告管理', '1', null, 'ad', null, null, '37b27cd8-1abd-4074-a2ac-e35b8434d194', '14', '1', '1', '2015-11-06 15:21:20.626', 'admin', null, null, null, '100007');
INSERT INTO "public"."tg_c_resource" VALUES ('37b27cd8-1abd-4074-a2ac-e35b8434d194', null, '内容管理', '1', null, 'content', null, null, '0', '1', '1', '1', '2015-11-06 15:10:15.619', 'admin', '2015-11-06 15:11:30.061', 'admin', null, '100');
INSERT INTO "public"."tg_c_resource" VALUES ('3a2510e7-3304-4e5d-85ef-e08c732ba443', null, '发布点配置', '1', null, 'publishPoint', null, null, 'e42baff4-dee1-4dad-b57a-ded0a137d2b7', '24', '1', '1', '2015-11-06 16:01:12.786', 'admin', null, null, null, '500001');
INSERT INTO "public"."tg_c_resource" VALUES ('41e189b1-f4b7-4669-a4ae-2786aff6c65c', null, '用户权限', '1', null, 'auth', null, null, '0', '6', '1', '1', '2015-11-06 15:13:16.798', 'admin', null, null, null, '600');
INSERT INTO "public"."tg_c_resource" VALUES ('4a250108-18d9-4bc3-971b-a3a737f9f5fb', null, '缓存监控', '1', null, 'cache', null, null, '84113afa-df07-4247-8666-f164a7acbefa', '37', '1', '1', '2015-11-06 16:18:04.858', 'admin', '2015-11-06 16:24:21.694', 'admin', null, '700005');
INSERT INTO "public"."tg_c_resource" VALUES ('4b3d50fc-f507-493e-9eb6-9670173f53cf', null, '图片管理', '1', null, 'image', null, null, 'fd31bbdf-39f4-4f7c-b6e5-1096b8d474ee', '16', '1', '1', '2015-11-06 15:24:46.606', 'admin', null, null, null, '200001');
INSERT INTO "public"."tg_c_resource" VALUES ('4d497c5e-9d7a-4003-9f77-e4cd31b66ffb', null, '视频管理', '1', null, 'video', null, null, 'fd31bbdf-39f4-4f7c-b6e5-1096b8d474ee', '17', '1', '1', '2015-11-06 15:25:23.771', 'admin', null, null, null, '200002');
INSERT INTO "public"."tg_c_resource" VALUES ('543e5fb8-443a-4744-ad33-1f2af5b0c166', null, '评分组配置', '1', null, 'scoreGroup', null, null, 'e42baff4-dee1-4dad-b57a-ded0a137d2b7', '29', '1', '1', '2015-11-06 16:14:39.329', 'admin', null, null, null, '500006');
INSERT INTO "public"."tg_c_resource" VALUES ('69f54916-8243-4562-a29a-037cf3500628', null, '文章属性', '1', null, 'attr', null, null, 'e42baff4-dee1-4dad-b57a-ded0a137d2b7', '28', '1', '1', '2015-11-06 16:13:40.499', 'admin', null, null, null, '500005');
INSERT INTO "public"."tg_c_resource" VALUES ('6a04b2df-1923-4b29-8f0b-f0d748fdf52a', null, '插件管理', '1', null, 'plug', null, null, '0', '4', '1', '1', '2015-11-06 15:12:25.277', 'admin', null, null, null, '400');
INSERT INTO "public"."tg_c_resource" VALUES ('74395a8b-adaf-40b5-a469-f7ef7fdfb930', null, '全局参数', '1', null, 'global', null, null, 'e42baff4-dee1-4dad-b57a-ded0a137d2b7', '25', '1', '1', '2015-11-06 16:02:14.584', 'admin', null, null, null, '500002');
INSERT INTO "public"."tg_c_resource" VALUES ('751a3e3e-b18b-434e-9b83-9066247ed561', null, '模板配置', '1', null, 'template', null, null, 'e42baff4-dee1-4dad-b57a-ded0a137d2b7', '26', '1', '1', '2015-11-06 16:02:50.67', 'admin', '2015-11-06 16:11:08.374', 'admin', null, '500003');
INSERT INTO "public"."tg_c_resource" VALUES ('7d948f43-39dd-4796-a2fe-8dc39f7a28f1', null, '广告位管理', '1', null, 'adSlot', null, null, '870e7f29-22ed-450d-a591-0673765808fe', '22', '1', '1', '2015-11-06 15:45:18.484', 'admin', null, null, null, '300005');
INSERT INTO "public"."tg_c_resource" VALUES ('81dc1502-c2a9-4d73-a36e-3db725d4713e', null, '问卷管理', '1', null, 'question', null, null, '37b27cd8-1abd-4074-a2ac-e35b8434d194', '15', '1', '1', '2015-11-06 15:23:03.062', 'admin', null, null, null, '100008');
INSERT INTO "public"."tg_c_resource" VALUES ('84113afa-df07-4247-8666-f164a7acbefa', null, '系统监控', '1', null, 'monitor', null, null, '0', '7', '1', '1', '2015-11-06 15:13:52.681', 'admin', null, null, null, '700');
INSERT INTO "public"."tg_c_resource" VALUES ('870e7f29-22ed-450d-a591-0673765808fe', null, '站点管理', '1', null, 'siteManager', null, null, '0', '3', '1', '1', '2015-11-06 15:12:01.167', 'admin', null, null, null, '300');
INSERT INTO "public"."tg_c_resource" VALUES ('880168fb-5f91-4059-b1cd-56357ca26e2d', null, '文章管理', '1', null, 'info', null, null, '37b27cd8-1abd-4074-a2ac-e35b8434d194', '8', '1', '1', '2015-11-06 15:15:08.739', 'admin', '2015-11-07 17:43:57.401', 'admin', null, '100001');
INSERT INTO "public"."tg_c_resource" VALUES ('904ff7c5-f708-4701-944c-6f69512cd1b6', null, '登录日志', '1', null, 'logLoginList', null, null, '84113afa-df07-4247-8666-f164a7acbefa', '34', '1', '1', '2015-11-06 16:16:13.566', 'admin', '2015-11-06 16:23:59.933', 'admin', null, '700002');
INSERT INTO "public"."tg_c_resource" VALUES ('a44a01b2-d4dc-47d2-b53a-a941cae91934', null, '投票管理', '1', null, 'vote', null, null, '37b27cd8-1abd-4074-a2ac-e35b8434d194', '13', '1', '1', '2015-11-06 15:19:13.633', 'admin', null, null, null, '100006');
INSERT INTO "public"."tg_c_resource" VALUES ('a9f91a9a-f29a-4380-8751-16e1af38c31f', null, '角色管理', '1', null, 'role', null, null, '41e189b1-f4b7-4669-a4ae-2786aff6c65c', '31', '1', '1', '2015-11-06 16:22:56.479', 'admin', null, null, null, '600002');
INSERT INTO "public"."tg_c_resource" VALUES ('af69c3e3-037c-4e5e-ba23-ba04bc06ab2f', null, '资源管理', '1', null, 'resource', null, null, '41e189b1-f4b7-4669-a4ae-2786aff6c65c', '32', '1', '1', '2015-11-06 16:23:41.606', 'admin', null, null, null, '600003');
INSERT INTO "public"."tg_c_resource" VALUES ('be274da5-f052-4029-a8f8-341d8cc7e91d', null, '留言管理', '1', null, 'guestbook', null, null, '37b27cd8-1abd-4074-a2ac-e35b8434d194', '10', '1', '1', '2015-11-06 15:17:25.057', 'admin', null, null, null, '100003');
INSERT INTO "public"."tg_c_resource" VALUES ('cee96dd6-05cc-43c8-9e8e-a19ff804c23c', null, '系统信息', '1', null, 'sysinfo', null, null, '84113afa-df07-4247-8666-f164a7acbefa', '35', '1', '1', '2015-11-06 16:16:56.307', 'admin', '2015-11-06 16:24:06.868', 'admin', null, '700003');
INSERT INTO "public"."tg_c_resource" VALUES ('defe1d58-f8a3-466a-8113-25bfacfc6be9', null, '留言板类型', '1', null, 'guestbookType', null, null, '870e7f29-22ed-450d-a591-0673765808fe', '20', '1', '1', '2015-11-06 15:28:01.731', 'admin', null, null, null, '300003');
INSERT INTO "public"."tg_c_resource" VALUES ('e42baff4-dee1-4dad-b57a-ded0a137d2b7', null, '全局配置', '1', null, 'gconfig', null, null, '0', '5', '1', '1', '2015-11-06 15:12:50.443', 'admin', null, null, null, '500');
INSERT INTO "public"."tg_c_resource" VALUES ('e61c33c4-ec6a-450d-9c40-b595b8219d27', null, '专题分类', '1', null, 'specialType', null, null, '870e7f29-22ed-450d-a591-0673765808fe', '19', '1', '1', '2015-11-06 15:27:11.616', 'admin', null, null, null, '300002');
INSERT INTO "public"."tg_c_resource" VALUES ('e8d23fb4-64a9-49c5-9ed6-4836d7c2f6cd', null, '线程监控', '1', null, 'thread', null, null, '84113afa-df07-4247-8666-f164a7acbefa', '36', '1', '1', '2015-11-06 16:17:32.021', 'admin', '2015-11-06 16:24:14.787', 'admin', null, '700004');
INSERT INTO "public"."tg_c_resource" VALUES ('ed74c875-dd7d-4b55-bec1-12e00d1577c7', null, '栏目管理', '1', null, 'node', null, null, '870e7f29-22ed-450d-a591-0673765808fe', '18', '1', '1', '2015-11-06 15:26:25.642', 'admin', null, null, null, '300001');
INSERT INTO "public"."tg_c_resource" VALUES ('fa455f84-9dd1-4095-80fc-44924248a47e', null, '友情链接', '1', null, 'friendlink', null, null, '37b27cd8-1abd-4074-a2ac-e35b8434d194', '12', '1', '1', '2015-11-06 15:18:37.314', 'admin', null, null, null, '100005');
INSERT INTO "public"."tg_c_resource" VALUES ('fd31bbdf-39f4-4f7c-b6e5-1096b8d474ee', null, '素材管理', '1', null, 'material', null, null, '0', '2', '1', '1', '2015-11-06 15:11:25.504', 'admin', null, null, null, '200');
INSERT INTO "public"."tg_c_resource" VALUES ('ff767d2f-4834-426a-88da-c1962855a1db', null, '专题管理', '1', null, 'special', null, null, '37b27cd8-1abd-4074-a2ac-e35b8434d194', '9', '1', '1', '2015-11-06 15:16:42.011', 'admin', null, null, null, '100002');

-- ----------------------------
-- Table structure for tg_c_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_c_role";
CREATE TABLE "public"."tg_c_role" (
"id" varchar(45) COLLATE "default" NOT NULL,
"code_num" varchar(45) COLLATE "default" NOT NULL,
"role_name" varchar(45) COLLATE "default" NOT NULL,
"description" varchar(200) COLLATE "default",
"sort_order" int2 DEFAULT 1 NOT NULL,
"editable" int2 DEFAULT 1 NOT NULL,
"enabled" int2 DEFAULT 1 NOT NULL,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."tg_c_role"."id" IS '角色表';
COMMENT ON COLUMN "public"."tg_c_role"."code_num" IS '编码';
COMMENT ON COLUMN "public"."tg_c_role"."role_name" IS '角色名称';
COMMENT ON COLUMN "public"."tg_c_role"."description" IS '描述';
COMMENT ON COLUMN "public"."tg_c_role"."sort_order" IS '排序';
COMMENT ON COLUMN "public"."tg_c_role"."editable" IS '是否可编辑  1可编辑 2不可编辑';
COMMENT ON COLUMN "public"."tg_c_role"."enabled" IS '是否可用';

-- ----------------------------
-- Records of tg_c_role
-- ----------------------------
INSERT INTO "public"."tg_c_role" VALUES ('6d9d23f7-c2c2-43c2-8176-b4ef8470dcf2', 'test', 'test', 'test', '1', '1', '1', '2016-01-22 09:52:14.833', 'admin', null, null);
INSERT INTO "public"."tg_c_role" VALUES ('a2189154-603c-44b1-be03-ca0f3d715cbc', 'test', 'test', 'test', '1', '1', '1', '2016-01-22 10:08:26.167', 'admin', null, null);

-- ----------------------------
-- Table structure for tg_c_role_resource
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_c_role_resource";
CREATE TABLE "public"."tg_c_role_resource" (
"id" varchar(45) COLLATE "default" NOT NULL,
"resource_id" varchar(45) COLLATE "default" NOT NULL,
"role_id" varchar(45) COLLATE "default" NOT NULL,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."tg_c_role_resource"."id" IS '角色资源中间表';

-- ----------------------------
-- Records of tg_c_role_resource
-- ----------------------------

-- ----------------------------
-- Table structure for tg_c_sensitive_word
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_c_sensitive_word";
CREATE TABLE "public"."tg_c_sensitive_word" (
"id" varchar(45) COLLATE "default" NOT NULL,
"word" varchar(100) COLLATE "default" NOT NULL,
"replacement" varchar(100) COLLATE "default",
"editable" int2 DEFAULT 1 NOT NULL,
"enabled" int2 DEFAULT 1 NOT NULL,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."tg_c_sensitive_word"."id" IS '敏感词';
COMMENT ON COLUMN "public"."tg_c_sensitive_word"."editable" IS '是否可编辑  1可编辑 2不可编辑';
COMMENT ON COLUMN "public"."tg_c_sensitive_word"."enabled" IS '是否可用';

-- ----------------------------
-- Records of tg_c_sensitive_word
-- ----------------------------

-- ----------------------------
-- Table structure for tg_c_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_c_user";
CREATE TABLE "public"."tg_c_user" (
"id" varchar(45) COLLATE "default" NOT NULL,
"username" varchar(45) COLLATE "default" NOT NULL,
"realname" varchar(45) COLLATE "default",
"user_pass" varchar(100) COLLATE "default",
"gender" int2,
"birthday" timestamp(6),
"id_card_num" varchar(45) COLLATE "default",
"cellphone_number" varchar(45) COLLATE "default",
"telephone_number" varchar(45) COLLATE "default",
"email" varchar(45) COLLATE "default",
"nationality" varchar(45) COLLATE "default",
"diploma" varchar(45) COLLATE "default",
"qq" varchar(45) COLLATE "default",
"wechat" varchar(45) COLLATE "default",
"pre_login_time" timestamp(6),
"pre_login_ip" varchar(45) COLLATE "default",
"last_login_time" timestamp(6),
"last_login_ip" varchar(45) COLLATE "default" DEFAULT 2,
"last_logout_time" timestamp(6),
"accountExpireTime" timestamp(6),
"credentialsExpireTime" timestamp(6),
"editable" int2 DEFAULT 1 NOT NULL,
"enabled" int2 DEFAULT 1 NOT NULL,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."tg_c_user"."id" IS '用户表';
COMMENT ON COLUMN "public"."tg_c_user"."username" IS '用户名';
COMMENT ON COLUMN "public"."tg_c_user"."realname" IS '真实姓名';
COMMENT ON COLUMN "public"."tg_c_user"."nationality" IS '民族';
COMMENT ON COLUMN "public"."tg_c_user"."diploma" IS '最高学历';
COMMENT ON COLUMN "public"."tg_c_user"."qq" IS 'qq号';
COMMENT ON COLUMN "public"."tg_c_user"."wechat" IS '微信号';
COMMENT ON COLUMN "public"."tg_c_user"."pre_login_time" IS '上次登录时间';
COMMENT ON COLUMN "public"."tg_c_user"."pre_login_ip" IS '上次登录ip';
COMMENT ON COLUMN "public"."tg_c_user"."last_login_time" IS '最后登录时间';
COMMENT ON COLUMN "public"."tg_c_user"."last_login_ip" IS '最后登录ip';
COMMENT ON COLUMN "public"."tg_c_user"."last_logout_time" IS '最后登出时间';
COMMENT ON COLUMN "public"."tg_c_user"."accountExpireTime" IS '账户过期时间';
COMMENT ON COLUMN "public"."tg_c_user"."credentialsExpireTime" IS '凭证过期时间';
COMMENT ON COLUMN "public"."tg_c_user"."editable" IS '是否可编辑  1可编辑 2不可编辑';
COMMENT ON COLUMN "public"."tg_c_user"."enabled" IS '是否可用';

-- ----------------------------
-- Records of tg_c_user
-- ----------------------------
INSERT INTO "public"."tg_c_user" VALUES ('27f71240-dbff-4378-a5db-a526194c9917', 'jason', 'jason', '$2a$11$3XpZgmghdUZJv0hCgJiuruOsixjq1tTQWTUa1wsQnHkx3jIvPk3V2', '1', null, null, null, null, null, null, null, null, null, '2015-11-06 16:33:02.103', '0:0:0:0:0:0:0:1', '2015-11-06 16:34:29.345', '0:0:0:0:0:0:0:1', null, null, null, '1', '1', null, null, null, null);
INSERT INTO "public"."tg_c_user" VALUES ('a1498eba-536b-4c20-a612-286319468318', 'admin', 'admin', '$2a$11$zyvrkb4U5/.OWFEDtJgMlOGRmCy7UrI.zFOezjxRZ1o1qJdRA6MR6', '1', '2015-01-01 12:00:00', '', '', '', '', '', '', '', '', '2016-05-18 11:01:57.885', '0:0:0:0:0:0:0:1', '2016-05-18 22:57:02.58', '0:0:0:0:0:0:0:1', '2016-05-18 10:59:42.339', null, null, '1', '1', null, null, null, null);

-- ----------------------------
-- Table structure for tg_c_user_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_c_user_role";
CREATE TABLE "public"."tg_c_user_role" (
"id" varchar(45) COLLATE "default" NOT NULL,
"user_id" varchar(45) COLLATE "default" NOT NULL,
"role_id" varchar(45) COLLATE "default" NOT NULL,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."tg_c_user_role"."id" IS '用户角色表';

-- ----------------------------
-- Records of tg_c_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for tg_cms_m_base_attr
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_cms_m_base_attr";
CREATE TABLE "public"."tg_cms_m_base_attr" (
"id" varchar(45) COLLATE "default" NOT NULL,
"code_num" varchar(20) COLLATE "default" NOT NULL,
"att_name" varchar(50) COLLATE "default" NOT NULL,
"with_image" int2,
"img_scale" int2,
"img_exacte" int2,
"add_watermark" int2,
"img_width" int4,
"img_height" int4,
"sort_order" int2 DEFAULT 1 NOT NULL,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tg_cms_m_base_attr" IS '属性表';
COMMENT ON COLUMN "public"."tg_cms_m_base_attr"."id" IS '属性';
COMMENT ON COLUMN "public"."tg_cms_m_base_attr"."code_num" IS '代码';
COMMENT ON COLUMN "public"."tg_cms_m_base_attr"."att_name" IS '名称';
COMMENT ON COLUMN "public"."tg_cms_m_base_attr"."with_image" IS '是否包含图片';
COMMENT ON COLUMN "public"."tg_cms_m_base_attr"."img_scale" IS '是否图片压缩';
COMMENT ON COLUMN "public"."tg_cms_m_base_attr"."img_exacte" IS '是否图片拉伸';
COMMENT ON COLUMN "public"."tg_cms_m_base_attr"."add_watermark" IS '是否图片水印';
COMMENT ON COLUMN "public"."tg_cms_m_base_attr"."img_width" IS '图片宽度';
COMMENT ON COLUMN "public"."tg_cms_m_base_attr"."img_height" IS '图片高度';
COMMENT ON COLUMN "public"."tg_cms_m_base_attr"."sort_order" IS '排序';

-- ----------------------------
-- Records of tg_cms_m_base_attr
-- ----------------------------
INSERT INTO "public"."tg_cms_m_base_attr" VALUES ('1', 'carousel', '轮播', '1', '1', '1', '2', '220', '150', '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_attr" VALUES ('2', 'notice', '公告', '1', '1', '1', '2', '220', '150', '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_attr" VALUES ('3', 'marquee', '滚动', '1', '1', '1', '2', '220', '150', '2', null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_attr" VALUES ('4', 'recommend', '推荐', '1', '1', '1', '1', '220', '150', '1', null, null, null, null);

-- ----------------------------
-- Table structure for tg_cms_m_base_comment
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_cms_m_base_comment";
CREATE TABLE "public"."tg_cms_m_base_comment" (
"id" varchar(45) COLLATE "default" NOT NULL,
"creator_id" varchar(45) COLLATE "default",
"auditor_id" varchar(45) COLLATE "default",
"owner_type" varchar(50) COLLATE "default" NOT NULL,
"owner_id" int4 NOT NULL,
"content" text COLLATE "default",
"audit_time" timestamp(6),
"user_ip" varchar(100) COLLATE "default",
"score" int4 NOT NULL,
"status" int4 NOT NULL,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tg_cms_m_base_comment" IS '评论表';
COMMENT ON COLUMN "public"."tg_cms_m_base_comment"."id" IS '评论';
COMMENT ON COLUMN "public"."tg_cms_m_base_comment"."creator_id" IS '创建人';
COMMENT ON COLUMN "public"."tg_cms_m_base_comment"."auditor_id" IS '审核人';
COMMENT ON COLUMN "public"."tg_cms_m_base_comment"."owner_type" IS '外表标识';
COMMENT ON COLUMN "public"."tg_cms_m_base_comment"."owner_id" IS '外表ID';
COMMENT ON COLUMN "public"."tg_cms_m_base_comment"."content" IS '评论内容';
COMMENT ON COLUMN "public"."tg_cms_m_base_comment"."audit_time" IS '审核时间';
COMMENT ON COLUMN "public"."tg_cms_m_base_comment"."user_ip" IS 'IP地址';
COMMENT ON COLUMN "public"."tg_cms_m_base_comment"."score" IS '得分';
COMMENT ON COLUMN "public"."tg_cms_m_base_comment"."status" IS '10:未审核;1:已审核;2:推荐;3:屏蔽';

-- ----------------------------
-- Records of tg_cms_m_base_comment
-- ----------------------------

-- ----------------------------
-- Table structure for tg_cms_m_base_doc
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_cms_m_base_doc";
CREATE TABLE "public"."tg_cms_m_base_doc" (
"id" varchar(45) COLLATE "default" NOT NULL,
"format" varchar(45) COLLATE "default",
"doc_name" varchar(150) COLLATE "default" NOT NULL,
"doc_length" int8 NOT NULL,
"doc_path" varchar(255) COLLATE "default" NOT NULL,
"md5" varchar(45) COLLATE "default",
"publish_time" timestamp(6),
"description" varchar(200) COLLATE "default",
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."tg_cms_m_base_doc"."format" IS '格式';
COMMENT ON COLUMN "public"."tg_cms_m_base_doc"."doc_name" IS '文件名称';
COMMENT ON COLUMN "public"."tg_cms_m_base_doc"."doc_length" IS '文件长度';
COMMENT ON COLUMN "public"."tg_cms_m_base_doc"."doc_path" IS '文件地址';
COMMENT ON COLUMN "public"."tg_cms_m_base_doc"."description" IS '描述';

-- ----------------------------
-- Records of tg_cms_m_base_doc
-- ----------------------------
INSERT INTO "public"."tg_cms_m_base_doc" VALUES ('0370abc3-1536-496f-a408-2e407ba67bed', 'xls', 'gi_c_custom_field.xls', '15360', '/uploads//201504/20150425/0370abc3-1536-496f-a408-2e407ba67bed.xls', 'F1F4E3080BBD12DC930ABA5FFE2903FC', '2015-04-25 18:41:45', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_doc" VALUES ('24cef683-eeb3-42c7-b34e-50011a57d7cc', 'xls', 'gi_cms_m_base_attr.xls', '5120', '/uploads//201504/20150424/24cef683-eeb3-42c7-b34e-50011a57d7cc.xls', 'AE38D88107B8A72D962C151BF22D267', '2015-04-24 16:59:46', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_doc" VALUES ('4aace2c7-94e7-40d7-9311-ec81a9c12817', 'xls', 'gi_c_custom_field_value.xls', '69120', '/uploads//201504/20150424/4aace2c7-94e7-40d7-9311-ec81a9c12817.xls', '7FFE4BCA77DDDD28BA40946BCBF1BD0D', '2015-04-24 16:59:46', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_doc" VALUES ('ba6f1b73-d1d4-4544-b85b-29087a76ebd0', 'xls', 'gi_cms_m_base_file.xls', '6144', '/uploads//201504/20150424/ba6f1b73-d1d4-4544-b85b-29087a76ebd0.xls', 'EB6BF453D9BD81688614426336D47E5B', '2015-04-24 16:59:46', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_doc" VALUES ('f1bbe5b7-21f1-4617-9da6-663fc6575320', 'jpg', '20150323150003.jpg', '10047', '/uploads/201504/20150429/f1bbe5b7-21f1-4617-9da6-663fc6575320.jpg', '4BC66B563ACC822A6D989C1DB04DEEE6', '2015-04-29 15:14:45', null, null, null, null, null);

-- ----------------------------
-- Table structure for tg_cms_m_base_file
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_cms_m_base_file";
CREATE TABLE "public"."tg_cms_m_base_file" (
"id" varchar(45) COLLATE "default" NOT NULL,
"format" varchar(45) COLLATE "default",
"file_name" varchar(150) COLLATE "default" NOT NULL,
"file_length" int8 NOT NULL,
"file_path" varchar(255) COLLATE "default" NOT NULL,
"md5" varchar(45) COLLATE "default",
"publish_time" timestamp(6),
"description" varchar(200) COLLATE "default",
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tg_cms_m_base_file" IS '文档附件集表';
COMMENT ON COLUMN "public"."tg_cms_m_base_file"."id" IS '文件';
COMMENT ON COLUMN "public"."tg_cms_m_base_file"."format" IS '格式';
COMMENT ON COLUMN "public"."tg_cms_m_base_file"."file_name" IS '文件名称';
COMMENT ON COLUMN "public"."tg_cms_m_base_file"."file_length" IS '文件长度';
COMMENT ON COLUMN "public"."tg_cms_m_base_file"."file_path" IS '文件地址';
COMMENT ON COLUMN "public"."tg_cms_m_base_file"."description" IS '描述';

-- ----------------------------
-- Records of tg_cms_m_base_file
-- ----------------------------
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('029d24d9-b912-4f94-8434-e35a219e4bca', 'xls', 'CMS问题汇总.xls', '15360', '/uploads//201504/20150424/029d24d9-b912-4f94-8434-e35a219e4bca.xls', '2630DBE1439AF01BD8ED3ADF63E86B76', '2015-04-24 18:56:14', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('03348492-2cad-4202-9d9c-ffb5dbfba14e', 'txt', 'LICENSE.txt', '11596', '/uploads//201504/20150424/03348492-2cad-4202-9d9c-ffb5dbfba14e.txt', '244209814994DF3DA1A753AA59C9FC6A', '2015-04-24 18:57:04', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('05f276da-afe4-4344-aab0-fe31964718e0', 'java', 'GiCresourceC问题--aontroller.java', '5981', '/uploads//201504/20150424/05f276da-afe4-4344-aab0-fe31964718e0.java', 'E447521B933730A582AB988EC362CCDA', '2015-04-24 18:57:06', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('0607aca3-1213-4c7d-82f0-1a7d5997cbfd', 'java', 'GiCmsMbaseFileController.java', '6119', '/uploads//201504/20150424/0607aca3-1213-4c7d-82f0-1a7d5997cbfd.java', '9593152446C69C81FE683939A7045DA8', '2015-04-24 18:57:05', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('0c74a286-2e77-4c37-8b62-2692d87999fc', 'java', 'GiCmsMextVoteOptionC问题ontroller.java', '6349', '/uploads//201504/20150424/0c74a286-2e77-4c37-8b62-2692d87999fc.java', 'C31D006D567D1F16905042C35FE5AB5F', '2015-04-24 18:57:06', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('0df81dcd-4584-4617-b08c-25aebe13cb91', 'xls', 'gi_cms_m_base_info.xls问题问题', '326144', '/uploads//201504/20150424/0df81dcd-4584-4617-b08c-25aebe13cb91.xls', 'EAEE6194781DFB3810A73C82DA055C5D', '2015-04-24 18:56:14', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('111bc399-6bbb-4fe3-952f-c3a34be6a753', 'java', 'GiCmsMbaseGlobalCo问题问题ntroller.java', '6211', '/uploads//201504/20150424/111bc399-6bbb-4fe3-952f-c3a34be6a753.java', 'BE8809895025BF2251095FBABC9160E8', '2015-04-24 18:57:05', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('13fc186a-6eeb-44e2-96cb-cadb8004a261', 'java', 'GiCmsMbaseNodeRoleController.java', '6303', '/uploads//201504/20150424/13fc186a-6eeb-44e2-96cb-cadb8004a261.java', '1AB4B418A0EB1D555E9526E1AE7F4E34', '2015-04-24 18:57:05', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('16f2cab6-888c-4b68-bb89-0aec2eae458a', 'xml', 'generator.xml', '1132', '/uploads//201504/20150424/16f2cab6-888c-4b68-bb89-0aec2eae458a.xml', '2BF90E2D0B2103B9DFF0C5CFB2CFF492', '2015-04-24 18:57:04', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('18e663cd-c4ef-4bee-afb2-9ad55af4c49d', 'java', 'GiCmsMextQuestionController.java', '6257', '/uploads//201504/20150424/18e663cd-c4ef-4bee-afb2-9ad55af4c49d.java', '4F3532F94AAA24645AD0DE5F136CAB34', '2015-04-24 18:57:06', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('20de13fb-e5bf-4963-af4b-5c87eaac558b', 'java', 'GiCmsMextVote问题问题Controller.java', '6073', '/uploads//201504/20150424/20de13fb-e5bf-4963-af4b-5c87eaac558b.java', 'D3E0018B3B2EA2F9AE79595281AFEACC', '2015-04-24 18:57:06', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('21a736e1-c848-43c3-9ae2-a4184203ca1f', 'java', 'GiCmsMextQuestionOptionController.java', '6533', '/uploads//201504/20150424/21a736e1-c848-43c3-9ae2-a4184203ca1f.java', '2DC6D23CEE8EEB8ABDE6CE6F10F38AFA', '2015-04-24 18:57:06', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('21fa608d-7294-4e4b-a318-e6e5019552e3', 'java', 'GiCmsMbaseInfoAttrsController.java', '6349', '/uploads//201504/20150424/21fa608d-7294-4e4b-a318-e6e5019552e3.java', 'D43C748B0F8DF22959AF22431D421C50', '2015-04-24 18:57:05', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('22e60db6-07c5-4503-b67c-242382e1c348', 'java', 'GiCmessageController.java', '5935', '/uploads//201504/20150424/22e60db6-07c5-4503-b67c-242382e1c348.java', '75D5248EEBD50C1578C46ABB15FDFC58', '2015-04-24 18:57:05', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('248305be-169e-47f2-afe6-b7f20f9342bb', 'log', 'hs_err_pid8368.log', '19255', '/uploads//201504/20150424/248305be-169e-47f2-afe6-b7f20f9342bb.log', 'A911ED40B4C2507108472A2E48709703', '2015-04-24 18:57:04', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('25b463d6-49b6-487e-8847-bca29416226b', 'java', 'GiCmsMextGuestbookTypeController.java', '6487', '/uploads//201504/20150424/25b463d6-49b6-487e-8847-bca29416226b.java', '893B9ECB2E03F206A36D4D9FF6706102', '2015-04-24 18:57:06', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('29043535-766f-4b34-84be-478d051368f4', 'java', 'GiCmsMextFriendlinkTypeController.java', '6533', '/uploads//201504/20150424/29043535-766f-4b34-84be-478d051368f4.java', '7D9CDC69C2038DB5336742BEF5AC9E5C', '2015-04-24 18:57:06', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('2d558d4b-0ebb-43bb-96b8-7bb27c63dbce', 'java', 'GiCmsMextVoteMarkController.java', '6257', '/uploads//201504/20150424/2d558d4b-0ebb-43bb-96b8-7bb27c63dbce.java', 'F519244DB35E86D9DD2F06DEA2E50242', '2015-04-24 18:57:06', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('2e660861-240d-4249-900f-8f644ca3fe5f', 'java', 'GiCmsMbaseDocController.java', '6073', '/uploads//201504/20150424/2e660861-240d-4249-900f-8f644ca3fe5f.java', '4A7C5A6E8A4E067888BA877DFC0B7BC6', '2015-04-24 18:57:05', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('302fbbb0-e705-40dd-8ba7-b42d6f9a8b6e', 'java', 'GiCmsMextQuestionRecordController.java', '6533', '/uploads//201504/20150424/302fbbb0-e705-40dd-8ba7-b42d6f9a8b6e.java', 'BE3290CC702533187E41854DB2F256FE', '2015-04-24 18:57:06', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('3696168d-1d39-4e76-8b1a-f168b7befbd7', 'log', 'replay_pid8368.log', '240880', '/uploads//201504/20150424/3696168d-1d39-4e76-8b1a-f168b7befbd7.log', '144748933E4FB957D341302D9455E64E', '2015-04-24 18:57:04', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('396cf51c-b5c9-42d1-b241-42aefa2e422c', 'java', 'GiCuserOrgController.java', '5935', '/uploads//201504/20150424/396cf51c-b5c9-42d1-b241-42aefa2e422c.java', '97307EB783D659E5271F0BBFEEFBE95B', '2015-04-24 18:57:07', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('39b0d343-932f-46bd-868e-7fdfb5cefe91', 'java', 'CaseController.java', '5659', '/uploads//201504/20150424/39b0d343-932f-46bd-868e-7fdfb5cefe91.java', '3F90766B6BA10D9CB2A31149D3358815', '2015-04-24 18:57:04', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('43f9196b-f4d7-40e5-989b-f6226443fe73', 'java', 'GiCmsMbaseTagController.java', '6073', '/uploads//201504/20150424/43f9196b-f4d7-40e5-989b-f6226443fe73.java', 'ECF0428240D96E13FF9DBD120D1FFBAB', '2015-04-24 18:57:06', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('475de453-9e92-4e5e-b055-ca36106271b4', 'java', 'GiCorgDimensionController.java', '6165', '/uploads//201504/20150424/475de453-9e92-4e5e-b055-ca36106271b4.java', 'C377468742456B4471D21B7931E11AC0', '2015-04-24 18:57:06', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('48b4865c-edcd-4c70-be34-136d6525eae3', 'java', 'GiCuserGroupController.java', '6027', '/uploads//201504/20150424/48b4865c-edcd-4c70-be34-136d6525eae3.java', '3AE6774D0BB55EE8A6CEA1572B681596', '2015-04-24 18:57:07', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('4dff49f5-f48b-4bfe-b3dd-ad1522bfb3a2', 'java', 'GiCmsMbaseModelController.java', '6165', '/uploads//201504/20150424/4dff49f5-f48b-4bfe-b3dd-ad1522bfb3a2.java', '9D1CFE4A7C3653E3037E226BF49436EA', '2015-04-24 18:57:05', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('4f9f0914-c50b-4ecb-9bca-e0111b424d47', 'xls', 'gi_cms_m_base_model.xls', '5120', '/uploads//201504/20150424/4f9f0914-c50b-4ecb-9bca-e0111b424d47.xls', 'E38FC70B27C120B4A19D520382C25B7B', '2015-04-24 18:56:15', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('51b1927a-50ba-44d4-96fb-00bc3aecf86c', 'sql', 'gi_cms_m_base_info.sql', '492227', '/uploads//201504/20150424/51b1927a-50ba-44d4-96fb-00bc3aecf86c.sql', '7905A0220B715E574876DFA2691E4CA2', '2015-04-24 18:56:14', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('523c6245-6d2b-4780-a339-44d31aaf89fa', 'xls', 'gi_cms_m_ext_friendlink.xls', '6144', '/uploads//201504/20150424/523c6245-6d2b-4780-a339-44d31aaf89fa.xls', 'D910B2A404EABAB110292AF648CB06F4', '2015-04-24 18:56:15', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('529876ed-4c5e-470a-92fd-a9de5154f750', 'java', 'GiCmsMbaseVideoController.java', '6165', '/uploads//201504/20150424/529876ed-4c5e-470a-92fd-a9de5154f750.java', '57E0F7997148E4AC12B8E30216774A14', '2015-04-24 18:57:06', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('55c316b6-cb7c-4dd0-833a-3c81d808a5fa', 'java', 'GiCmsMbaseSiteController.java', '6119', '/uploads//201504/20150424/55c316b6-cb7c-4dd0-833a-3c81d808a5fa.java', '3229EFE066783A54AE7D6EE4DB956A6E', '2015-04-24 18:57:05', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('55c99140-22c2-481e-a9ec-77d061a924bd', 'java', 'HeadlinesElementProcessor.java', '1763', '/uploads//201504/20150424/55c99140-22c2-481e-a9ec-77d061a924bd.java', '1458C33C1D7D55529D00767518B3E067', '2015-04-24 18:56:15', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('56d8ff67-4091-47f0-823b-85defa164f28', 'java', 'GiCmsMbasePublishPointController.java', '6487', '/uploads//201504/20150424/56d8ff67-4091-47f0-823b-85defa164f28.java', '85047FBF821339C6D10C4083B2112999', '2015-04-24 18:57:05', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('56f0010c-2be8-421a-8139-5beddb9a0c70', 'java', 'GiCmsMbaseSpecialTypeController.java', '6441', '/uploads//201504/20150424/56f0010c-2be8-421a-8139-5beddb9a0c70.java', 'D65E4BBE291DBE99587BB38F6C696DC', '2015-04-24 18:57:05', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('58b63ef4-242e-4272-8976-420b28e3d7e2', 'java', 'GiCroleController.java', '5797', '/uploads//201504/20150424/58b63ef4-242e-4272-8976-420b28e3d7e2.java', '8A6F9704D3232E5CFD262C121B6E29BD', '2015-04-24 18:57:06', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('599c630c-2e96-4d2e-863b-96a6be18e5b8', 'sql', 'gi_cms_m_base_info222222.sql', '578089', '/uploads//201504/20150424/599c630c-2e96-4d2e-863b-96a6be18e5b8.sql', '5EE0DEE30D1A724CCE62F9D54298DAE9', '2015-04-24 18:56:15', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('5bb53626-5db2-4fbe-a0d9-2ad799c3d733', 'xls', 'gi_c_custom_field_value.xls', '69120', '/uploads//201504/20150424/5bb53626-5db2-4fbe-a0d9-2ad799c3d733.xls', '7FFE4BCA77DDDD28BA40946BCBF1BD0D', '2015-04-24 18:56:14', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('600bcaa4-31e5-4e24-b974-a60917fde5bf', 'bat', '运行我.bat', '165', '/uploads//201504/20150424/600bcaa4-31e5-4e24-b974-a60917fde5bf.bat', 'CA474FC8E6177456F914C6A17FD62888', '2015-04-24 18:57:04', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('62f46d99-5726-4d8f-9c70-b0554ee7d55d', 'bat', 'cpappend.bat', '28', '/uploads//201504/20150424/62f46d99-5726-4d8f-9c70-b0554ee7d55d.bat', '2CF67C0A127E99A4A52782F486CD4A58', '2015-04-24 18:57:04', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('634ea792-fed2-46a4-9893-2d82d11bff02', 'java', 'GiCdictController.java', '5797', '/uploads//201504/20150424/634ea792-fed2-46a4-9893-2d82d11bff02.java', '4D9579DF5A07CCE9EE2EA788BFC1499C', '2015-04-24 18:57:04', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('65d5f28a-82aa-4c61-8788-3e963a0e2818', 'java', 'GiCuserController.java', '5797', '/uploads//201504/20150424/65d5f28a-82aa-4c61-8788-3e963a0e2818.java', 'AE02E8C95625C2B1F6400DA92F51F341', '2015-04-24 18:57:07', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('66738dbe-b8c3-4e2f-a478-59b31535acfa', 'java', 'GiCmsMbaseTemplateController.java', '6303', '/uploads//201504/20150424/66738dbe-b8c3-4e2f-a478-59b31535acfa.java', '85D4DA1F980003D4B72D96F7BD817FE3', '2015-04-24 18:57:06', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('68d9c88b-0339-4ad6-9616-a9e7d348eea3', 'java', 'CourtController.java', '5705', '/uploads//201504/20150424/68d9c88b-0339-4ad6-9616-a9e7d348eea3.java', '8DC866BBB389DBBF5BB9A40FAB4B0EE2', '2015-04-24 18:57:04', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('68edaa81-0392-4654-90b2-efc7bd824d34', 'xls', 'gi_cms_m_base_file.xls', '6144', '/uploads//201504/20150424/68edaa81-0392-4654-90b2-efc7bd824d34.xls', 'EB6BF453D9BD81688614426336D47E5B', '2015-04-24 18:56:14', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('6ae505a0-f474-475d-b757-871947fef7fd', 'java', 'GiCmsMbaseImageController.java', '6165', '/uploads//201504/20150424/6ae505a0-f474-475d-b757-871947fef7fd.java', 'CF646A8C3B5BCFE762A143CA76E71FA5', '2015-04-24 18:57:05', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('6d8b0452-d81b-45e0-b035-c1b65c08b649', 'xls', 'gi_cms_m_base_template.xls', '4096', '/uploads//201504/20150424/6d8b0452-d81b-45e0-b035-c1b65c08b649.xls', '4148F7EED029C61F8A7B5F10C580D7E', '2015-04-24 18:56:15', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('6ff4f000-6f2c-43c9-98ed-eca740625c66', 'java', 'GiClogVisitController.java', '5981', '/uploads//201504/20150424/6ff4f000-6f2c-43c9-98ed-eca740625c66.java', '85D63D1AA80B6FEBEE9819CAE2201FA0', '2015-04-24 18:57:05', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('718188b9-3354-4cd1-8a50-9b4e5d6e048f', 'sql', 'gi_cms_m_base_info_attrs.sql', '2349', '/uploads//201504/20150424/718188b9-3354-4cd1-8a50-9b4e5d6e048f.sql', '5B9AEFF9FBD2A96F2121DAE6E12044EA', '2015-04-24 18:56:14', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('73c367e6-ec83-467e-9fbd-08534b055fe6', 'java', 'GiCmsMextScoreItemController.java', '6303', '/uploads//201504/20150424/73c367e6-ec83-467e-9fbd-08534b055fe6.java', 'D04FE5CF41D18FFECC983862C15ECFF8', '2015-04-24 18:57:06', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('74ec2da8-ca9d-4360-a611-381a52d6a543', 'java', 'GiCcustomFieldValueController.java', '6349', '/uploads//201504/20150424/74ec2da8-ca9d-4360-a611-381a52d6a543.java', '36C9BF537FD78E0E52F025CD234A2374', '2015-04-24 18:57:04', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('77195365-447a-490b-a57a-a66dede7b1d6', 'css', 'demo.css', '7662', '/uploads//201504/20150424/77195365-447a-490b-a57a-a66dede7b1d6.css', 'C8F0C3B3713AC1AF59957DEC139EE261', '2015-04-24 18:56:14', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('77923996-251e-4ac9-9c44-31626d3226b0', 'java', 'GiCroleResourceController.java', '6165', '/uploads//201504/20150424/77923996-251e-4ac9-9c44-31626d3226b0.java', 'E7C07789D36C7BA3C6A09869FA063416', '2015-04-24 18:57:06', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('8099298c-b29e-4881-9691-bc0513e3cd71', 'java', 'GiCkeyValueController.java', '5981', '/uploads//201504/20150424/8099298c-b29e-4881-9691-bc0513e3cd71.java', 'CDF71D8DE4D4C833F2BD15FE53278673', '2015-04-24 18:57:05', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('80eff950-1233-4ef8-9f29-6a7efe5ee862', 'xls', 'gi_c_custom_field.xls', '15360', '/uploads//201504/20150424/80eff950-1233-4ef8-9f29-6a7efe5ee862.xls', 'F1F4E3080BBD12DC930ABA5FFE2903FC', '2015-04-24 18:56:14', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('830da0ad-2515-4b3d-80dc-16c0ff05b999', 'java', 'GiCmsMextQuestionItemController.java', '6441', '/uploads//201504/20150424/830da0ad-2515-4b3d-80dc-16c0ff05b999.java', '6D0A847D6A331A8FB4F0CA8BA33B8EA2', '2015-04-24 18:57:06', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('83d4b79a-c657-4872-9936-9f853163f051', 'java', 'GiCmsMbaseCommentController.java', '6257', '/uploads//201504/20150424/83d4b79a-c657-4872-9936-9f853163f051.java', '56F92C725A7B75A1B67AF59EA9F0350', '2015-04-24 18:57:05', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('8451099d-59be-42ae-8b59-9d7a676308ae', 'java', 'GiCorgTypeController.java', '5935', '/uploads//201504/20150424/8451099d-59be-42ae-8b59-9d7a676308ae.java', 'AF9C1349F7FC46130F555904E806D460', '2015-04-24 18:57:06', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('865592f4-f420-46a3-9a3c-0bcc86a45621', 'java', 'GiCcustomFieldController.java', '6119', '/uploads//201504/20150424/865592f4-f420-46a3-9a3c-0bcc86a45621.java', 'B5A01E8A17261F6C73BB57180C95FAE4', '2015-04-24 18:57:04', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('87c16497-d53f-49dd-ab11-ba459b8d91f5', 'ico', 'fenxuelin.ico', '4286', '/uploads//201504/20150424/87c16497-d53f-49dd-ab11-ba459b8d91f5.ico', '9FD863DF8C541BD51907E3D59A2BB087', '2015-04-24 18:56:14', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('8c50cd82-ddd6-477c-9927-1b6b7bebcfac', 'xls', 'gi_cms_m_base_node.xls', '21504', '/uploads//201504/20150424/8c50cd82-ddd6-477c-9927-1b6b7bebcfac.xls', '2CB600D3D9FCAF6BA6FF3EEC484EE489', '2015-04-24 18:56:15', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('8dc6b750-d197-4566-81e9-e0aecd7a85d3', 'java', 'GiCsensitiveWordController.java', '6211', '/uploads//201504/20150424/8dc6b750-d197-4566-81e9-e0aecd7a85d3.java', '93D8972BA40253FE26D704A16461D160', '2015-04-24 18:57:07', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('93acf470-63e4-42d6-af62-b4fce4596d83', 'java', 'GiCmsMbaseNodeController.java', '6119', '/uploads//201504/20150424/93acf470-63e4-42d6-af62-b4fce4596d83.java', '5EFFA627D8A0BAC26370B727212EA814', '2015-04-24 18:57:05', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('96870fe8-c233-415c-9f4f-329d81c4d0aa', 'java', 'GiCmsMextScoreRecordController.java', '6395', '/uploads//201504/20150424/96870fe8-c233-415c-9f4f-329d81c4d0aa.java', 'AB453ED769D4C5906A5902D207A1D7B3', '2015-04-24 18:57:06', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('98e1de5e-174c-4b1a-ab81-66145a67ea0f', 'bat', 'rapid-gen.bat', '698', '/uploads//201504/20150424/98e1de5e-174c-4b1a-ab81-66145a67ea0f.bat', '95ED51848EE4CFA2566CBCB7AB85EAA3', '2015-04-24 18:57:04', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('9ad1e8a0-107a-4a16-8d7f-1a84c31c957b', 'java', 'GiClogOperationController.java', '6165', '/uploads//201504/20150424/9ad1e8a0-107a-4a16-8d7f-1a84c31c957b.java', '1C4D77D568B3E2623BFC4EFDE26BAC21', '2015-04-24 18:57:05', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('9f4563de-0d9c-4818-b392-7532ce3f91a7', 'java', 'CourthouseController.java', '5935', '/uploads//201504/20150424/9f4563de-0d9c-4818-b392-7532ce3f91a7.java', 'D92103DA7F445034502F51AF8C6131A6', '2015-04-24 18:57:04', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('a4d16a28-e723-46b7-bc2a-fea34af843ae', 'java', 'GiCdbBackupController.java', '5981', '/uploads//201504/20150424/a4d16a28-e723-46b7-bc2a-fea34af843ae.java', '14F0F20EFDB33852A6B2759B7C5E38F6', '2015-04-24 18:57:04', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('a934723a-e566-44f6-8b9b-2e27c3d8f825', 'jar', 'NutMoleGUI.jar', '122904', '/uploads//201504/20150424/a934723a-e566-44f6-8b9b-2e27c3d8f825.jar', '7FD36BE00A7C02EDD371707A07C0B987', '2015-04-24 18:57:04', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('abafccfc-2b12-4765-a27e-2586a9f85f20', 'xls', 'gi_cms_m_base_site.xls', '5120', '/uploads//201504/20150424/abafccfc-2b12-4765-a27e-2586a9f85f20.xls', '8C3E2287D840A0E35EBD1B7F7E4E5CB2', '2015-04-24 18:56:15', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('ad356529-392c-4ad2-b644-feb8d13a6086', 'java', 'GiCmsMbaseInfoController.java', '6119', '/uploads//201504/20150424/ad356529-392c-4ad2-b644-feb8d13a6086.java', '6541C5963580A1FAE776B13FFA2B73CA', '2015-04-24 18:57:05', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('af0872f4-fe7a-4a52-966d-0970fd6621bf', 'java', 'GiCattachmentController.java', '6073', '/uploads//201504/20150424/af0872f4-fe7a-4a52-966d-0970fd6621bf.java', '8E7F8A9205379001A67FB601CD5F55D3', '2015-04-24 18:57:04', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('bb9c7649-a9ca-4b50-8e65-386c0c0ddabb', 'java', 'GiCmsMbaseInfoSpecialController.java', '6441', '/uploads//201504/20150424/bb9c7649-a9ca-4b50-8e65-386c0c0ddabb.java', '9462EAB434B74E16A60758D1F656A248', '2015-04-24 18:57:05', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('bf04a9d5-1fb2-4aeb-a786-aed14d3fb7de', 'java', 'GiCuserRoleController.java', '5981', '/uploads//201504/20150424/bf04a9d5-1fb2-4aeb-a786-aed14d3fb7de.java', '13D17F07E82D9A30EC9B5A4E1A24A108', '2015-04-24 18:57:07', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('bfe3bace-fb08-4b2d-83bd-8453a78c5026', 'js', 'formBuilder.js', '8523', '/uploads//201504/20150424/bfe3bace-fb08-4b2d-83bd-8453a78c5026.js', '133CFBA3F60B8112D2D8D65E38FB402B', '2015-04-24 18:56:14', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('c1dcc7ee-a921-4cfb-a3ec-ede44a81d5ac', 'java', 'GiCmsMextFriendlinkController.java', '6349', '/uploads//201504/20150424/c1dcc7ee-a921-4cfb-a3ec-ede44a81d5ac.java', 'C22FECF644A565AC931736E629B08D8C', '2015-04-24 18:57:06', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('c3494a38-2a46-4a25-8b0a-682d5f5d1f08', 'java', 'GiCmsMbaseSpecialController.java', '6257', '/uploads//201504/20150424/c3494a38-2a46-4a25-8b0a-682d5f5d1f08.java', '6B865E30398A17A8B7A7D36CF6FC934A', '2015-04-24 18:57:05', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('c4a0d0be-fb28-455c-b3b5-9aa46666483e', 'java', 'GiCmsMextGuestbookController.java', '6303', '/uploads//201504/20150424/c4a0d0be-fb28-455c-b3b5-9aa46666483e.java', 'B2EF5CCD8F703E8B7486FFFE68CAA4A6', '2015-04-24 18:57:06', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('c6646079-d56c-41bf-9ffa-be3e1203e620', 'java', 'GiCmsMbaseCollectLogController.java', '6395', '/uploads//201504/20150424/c6646079-d56c-41bf-9ffa-be3e1203e620.java', 'F73C7DA4A20D0F61F364D124FD5B4E3F', '2015-04-24 18:57:05', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('c7dc86de-1403-4ed1-bad5-5f115a40b4d7', 'java', 'GiCmsMbaseCollectController.java', '6257', '/uploads//201504/20150424/c7dc86de-1403-4ed1-bad5-5f115a40b4d7.java', 'DD8CE813D788440F57B30D95741664CD', '2015-04-24 18:57:05', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('cbf0dd3e-e198-4d4b-978c-73d1ae271743', 'xls', 'gi_cms_m_base_attr.xls', '5120', '/uploads//201504/20150424/cbf0dd3e-e198-4d4b-978c-73d1ae271743.xls', 'AE38D88107B8A72D962C151BF22D267', '2015-04-24 18:56:14', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('d08c4c5c-12bf-45a3-9823-463dfdaccc0d', 'java', 'GiCorgController.java', '5751', '/uploads//201504/20150424/d08c4c5c-12bf-45a3-9823-463dfdaccc0d.java', 'CEE755811B9D92FC807A9CAB6BEB889E', '2015-04-24 18:57:06', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('d461aff5-ed20-4a78-bc47-d47645c82a56', 'java', 'GiCmsMbaseInfoTagsController.java', '6303', '/uploads//201504/20150424/d461aff5-ed20-4a78-bc47-d47645c82a56.java', 'F9AC20693F4E332E90D66AC6E1A900C2', '2015-04-24 18:57:05', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('d799a775-8a59-4c41-b171-b3d024f8beff', 'xls', 'gi_cms_m_base_image.xls', '133632', '/uploads//201504/20150424/d799a775-8a59-4c41-b171-b3d024f8beff.xls', '551A8EADF104B85C8F25A81BF0D06BCF', '2015-04-24 18:56:14', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('d82db6d8-0a3b-4d39-95c4-4cfdf8852d42', 'java', 'GiCgroupController.java', '5843', '/uploads//201504/20150424/d82db6d8-0a3b-4d39-95c4-4cfdf8852d42.java', 'DDA17A774B04DA840AB8136077EEF3A6', '2015-04-24 18:57:05', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('d9ba0e21-c2ff-4f3a-ad5c-a836d30afa93', 'java', 'GiCcountryController.java', '5935', '/uploads//201504/20150424/d9ba0e21-c2ff-4f3a-ad5c-a836d30afa93.java', '1201F788EBBEC2D05D1E696B33EF9498', '2015-04-24 18:57:04', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('ddf820c6-beb7-410d-9bd8-d0b3b56d82b6', 'java', 'GiCmsMbaseNodeGroupController.java', '6349', '/uploads//201504/20150424/ddf820c6-beb7-410d-9bd8-d0b3b56d82b6.java', '69F20036D4EE4629AC76D631480BC517', '2015-04-24 18:57:05', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('e68228f9-298f-4b02-94ea-61d202f6dfa1', 'java', 'GiCmsMextScoreGroupController.java', '6349', '/uploads//201504/20150424/e68228f9-298f-4b02-94ea-61d202f6dfa1.java', 'EE9A86AD8447F9BD2449CC01B86914BA', '2015-04-24 18:57:06', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('e8a5a318-919c-4e96-9bbe-8642a250c63e', 'xls', 'gi_cms_m_base_global.xls', '4096', '/uploads//201504/20150424/e8a5a318-919c-4e96-9bbe-8642a250c63e.xls', '637835AB5FE59DEFB0B3FC0759433341', '2015-04-24 18:56:14', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('eac67901-208c-4509-b545-e37008120e6e', 'java', 'GiCmsMbaseAttrController.java', '6119', '/uploads//201504/20150424/eac67901-208c-4509-b545-e37008120e6e.java', '29210E06304587489DACD159261D21D2', '2015-04-24 18:57:05', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('f09da748-5dbc-489f-9a6e-f41417222822', 'java', 'GiCmsMextAdSlotController.java', '6165', '/uploads//201504/20150424/f09da748-5dbc-489f-9a6e-f41417222822.java', '52BE887F7EC8DA45DB59D9D9E0906212', '2015-04-24 18:57:06', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('f52f29ac-fefc-4f87-a149-9172c3ad8012', 'java', 'GiClogController.java', '5751', '/uploads//201504/20150424/f52f29ac-fefc-4f87-a149-9172c3ad8012.java', '6666DD9EA9348E61C03CB77DC4BEC923', '2015-04-24 18:57:05', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('f5348f99-9362-4a41-bb43-9fc372253971', 'java', 'ResumeController.java', '5751', '/uploads//201504/20150424/f5348f99-9362-4a41-bb43-9fc372253971.java', 'FA626694C4444EABFC0E1FB2F7D2F95B', '2015-04-24 18:57:07', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('f5fd6516-1745-452b-8cb4-f0dec433d0ec', 'xls', 'gi_cms_m_base_info_attrs.xls', '5120', '/uploads//201504/20150424/f5fd6516-1745-452b-8cb4-f0dec433d0ec.xls', 'D37D403D89A14520E7162407AC8F2A15', '2015-04-24 18:56:15', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('f9272aa7-e94d-44a4-aa90-2b6aa85b9b97', 'java', 'GiCmsMextAdController.java', '5981', '/uploads//201504/20150424/f9272aa7-e94d-44a4-aa90-2b6aa85b9b97.java', 'E4B9DD1134767C41D2CAC974385977B5', '2015-04-24 18:57:06', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('fc6597ae-7e7d-4087-ac64-febd29185424', 'java', 'GiCareasController.java', '5843', '/uploads//201504/20150424/fc6597ae-7e7d-4087-ac64-febd29185424.java', '19E99BFD8306D9F799822633D61FBF46', '2015-04-24 18:57:04', null, null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_file" VALUES ('feb5c180-19d4-4e00-983c-7ebf12d355b1', 'xls', 'gi_cms_m_ext_friendlink_type.xls', '4096', '/uploads//201504/20150424/feb5c180-19d4-4e00-983c-7ebf12d355b1.xls', '2AF649C67B6059AF3DD89D063A4AA37D', '2015-04-24 18:56:15', null, null, null, null, null);

-- ----------------------------
-- Table structure for tg_cms_m_base_global
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_cms_m_base_global";
CREATE TABLE "public"."tg_cms_m_base_global" (
"id" varchar(45) COLLATE "default" NOT NULL,
"sys_protocol" varchar(50) COLLATE "default" NOT NULL,
"sys_port" int4,
"context_path" varchar(255) COLLATE "default",
"with_domain" int2 NOT NULL,
"uploads_publishpoint_id" int4,
"sys_version" varchar(50) COLLATE "default" NOT NULL,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tg_cms_m_base_global" IS '全局表';
COMMENT ON COLUMN "public"."tg_cms_m_base_global"."id" IS '全局';
COMMENT ON COLUMN "public"."tg_cms_m_base_global"."sys_protocol" IS '协议';
COMMENT ON COLUMN "public"."tg_cms_m_base_global"."sys_port" IS '服务端口号';
COMMENT ON COLUMN "public"."tg_cms_m_base_global"."context_path" IS '上下文路径';
COMMENT ON COLUMN "public"."tg_cms_m_base_global"."with_domain" IS '是否URL包含域名';
COMMENT ON COLUMN "public"."tg_cms_m_base_global"."uploads_publishpoint_id" IS '附件发布点';
COMMENT ON COLUMN "public"."tg_cms_m_base_global"."sys_version" IS '版本号';

-- ----------------------------
-- Records of tg_cms_m_base_global
-- ----------------------------
INSERT INTO "public"."tg_cms_m_base_global" VALUES ('1', 'http', '80', '/tg-cms', '1', '1', '1.1', null, null, null, null);

-- ----------------------------
-- Table structure for tg_cms_m_base_image
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_cms_m_base_image";
CREATE TABLE "public"."tg_cms_m_base_image" (
"id" varchar(45) COLLATE "default" NOT NULL,
"format" varchar(45) COLLATE "default",
"img_name" varchar(150) COLLATE "default",
"img_length" int8 NOT NULL,
"img_path" varchar(255) COLLATE "default",
"md5" varchar(45) COLLATE "default",
"img_width" int4,
"img_height" int4,
"publish_time" timestamp(6),
"description" varchar(200) COLLATE "default",
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tg_cms_m_base_image" IS '文档图片集表';
COMMENT ON COLUMN "public"."tg_cms_m_base_image"."format" IS '格式';
COMMENT ON COLUMN "public"."tg_cms_m_base_image"."img_name" IS '图片名称';
COMMENT ON COLUMN "public"."tg_cms_m_base_image"."img_length" IS '文件长度';
COMMENT ON COLUMN "public"."tg_cms_m_base_image"."img_path" IS '图片地址';
COMMENT ON COLUMN "public"."tg_cms_m_base_image"."img_width" IS '宽度';
COMMENT ON COLUMN "public"."tg_cms_m_base_image"."img_height" IS '高度';
COMMENT ON COLUMN "public"."tg_cms_m_base_image"."description" IS '描述';

-- ----------------------------
-- Records of tg_cms_m_base_image
-- ----------------------------
INSERT INTO "public"."tg_cms_m_base_image" VALUES ('3d11d74e-3d72-4e1f-ac80-abd97d1a37cd', 'jpg', 's3.jpg', '11868', '/uploads/image/201511/20151104/3d11d74e-3d72-4e1f-ac80-abd97d1a37cd.jpg', '40029B853ABF7C2E144F78A9BAF6BFB9', null, null, '2015-11-04 17:37:18.956', null, '2015-11-04 17:37:18.944', null, null, null);
INSERT INTO "public"."tg_cms_m_base_image" VALUES ('730774fd-5a6c-447c-87ed-a97a57ff222b', 'jpg', 's1.jpg', '28708', '/uploads/image/201511/20151104/730774fd-5a6c-447c-87ed-a97a57ff222b.jpg', 'EE78FC14C8ED0B043B7D0BA4EA230712', null, null, '2015-11-04 17:35:25.465', null, '2015-11-04 17:35:25.306', null, null, null);
INSERT INTO "public"."tg_cms_m_base_image" VALUES ('8a21acc4-34e7-48ba-9095-5175a8facf59', 'jpg', 's4.jpg', '25802', '/uploads/image/201511/20151104/8a21acc4-34e7-48ba-9095-5175a8facf59.jpg', '178C0EA2DB430ABE4779D614BAD2A9B', null, null, '2015-11-04 17:37:31.609', null, '2015-11-04 17:37:31.587', null, null, null);
INSERT INTO "public"."tg_cms_m_base_image" VALUES ('94932566-27e4-47d9-b481-c0bf3ce78525', 'jpg', 's5.jpg', '17747', '/uploads/image/201511/20151104/94932566-27e4-47d9-b481-c0bf3ce78525.jpg', '35B99DC0029FFBDA4A97D161E2FDB7BF', null, null, '2015-11-04 17:37:45.814', null, '2015-11-04 17:37:45.795', null, null, null);
INSERT INTO "public"."tg_cms_m_base_image" VALUES ('b3d0c9fd-a994-4342-893b-75a2ccb73db9', 'jpg', 's2.jpg', '16149', '/uploads/image/201511/20151104/b3d0c9fd-a994-4342-893b-75a2ccb73db9.jpg', '59715480A915F3A74C00CCEAB0F640BC', null, null, '2015-11-04 17:37:07.49', null, '2015-11-04 17:37:07.467', null, null, null);
INSERT INTO "public"."tg_cms_m_base_image" VALUES ('bd365916-11c2-4246-a903-3c2c91b2e08b', 'jpg', 's6.jpg', '22250', '/uploads/image/201511/20151104/bd365916-11c2-4246-a903-3c2c91b2e08b.jpg', 'AC3F319A83B9794EA341401A87E1A5CF', null, null, '2015-11-04 17:37:58.717', null, '2015-11-04 17:37:58.7', null, null, null);

-- ----------------------------
-- Table structure for tg_cms_m_base_info
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_cms_m_base_info";
CREATE TABLE "public"."tg_cms_m_base_info" (
"id" varchar(45) COLLATE "default" NOT NULL,
"node_id" varchar(45) COLLATE "default",
"publish_time" timestamp(6),
"last_update_time" timestamp(6),
"off_time" timestamp(6),
"sort_order" int2 DEFAULT 1,
"with_image" int2 DEFAULT 2,
"views_count" int4 DEFAULT 0,
"downloads_count" int4 DEFAULT 0,
"comments_count" int4 DEFAULT 0,
"diggs" int4 DEFAULT 0,
"score" int4 DEFAULT 0,
"html_state" int2,
"html_path" varchar(255) COLLATE "default",
"title" varchar(150) COLLATE "default",
"subtitle" varchar(150) COLLATE "default",
"full_title" varchar(150) COLLATE "default",
"link_path" varchar(255) COLLATE "default",
"new_window" char(1) COLLATE "default" DEFAULT 2,
"title_color" varchar(50) COLLATE "default",
"title_strong" int2 DEFAULT 2,
"title_em" int2 DEFAULT 2,
"info_path" varchar(255) COLLATE "default",
"info_template" varchar(255) COLLATE "default",
"meta_keywords" varchar(45) COLLATE "default",
"meta_description" varchar(255) COLLATE "default",
"source" varchar(50) COLLATE "default",
"source_url" varchar(255) COLLATE "default",
"author" varchar(50) COLLATE "default",
"info_text" text COLLATE "default",
"image" varchar(45) COLLATE "default",
"video" varchar(45) COLLATE "default",
"doc" varchar(45) COLLATE "default",
"allow_comment" int2,
"state" int2 DEFAULT 1,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tg_cms_m_base_info" IS '文档表';
COMMENT ON COLUMN "public"."tg_cms_m_base_info"."id" IS '文档';
COMMENT ON COLUMN "public"."tg_cms_m_base_info"."node_id" IS '栏目';
COMMENT ON COLUMN "public"."tg_cms_m_base_info"."publish_time" IS '发布日期';
COMMENT ON COLUMN "public"."tg_cms_m_base_info"."off_time" IS '关闭日期';
COMMENT ON COLUMN "public"."tg_cms_m_base_info"."sort_order" IS '排序';
COMMENT ON COLUMN "public"."tg_cms_m_base_info"."with_image" IS '是否包含图片';
COMMENT ON COLUMN "public"."tg_cms_m_base_info"."views_count" IS '浏览总数';
COMMENT ON COLUMN "public"."tg_cms_m_base_info"."downloads_count" IS '下载总数';
COMMENT ON COLUMN "public"."tg_cms_m_base_info"."comments_count" IS '评论总数';
COMMENT ON COLUMN "public"."tg_cms_m_base_info"."diggs" IS '顶';
COMMENT ON COLUMN "public"."tg_cms_m_base_info"."score" IS '得分';
COMMENT ON COLUMN "public"."tg_cms_m_base_info"."html_path" IS 'HTML页面';
COMMENT ON COLUMN "public"."tg_cms_m_base_info"."title" IS '主标题';
COMMENT ON COLUMN "public"."tg_cms_m_base_info"."subtitle" IS '副标题';
COMMENT ON COLUMN "public"."tg_cms_m_base_info"."full_title" IS '完整标题';
COMMENT ON COLUMN "public"."tg_cms_m_base_info"."link_path" IS '转向链接';
COMMENT ON COLUMN "public"."tg_cms_m_base_info"."new_window" IS '是否在新窗口打开';
COMMENT ON COLUMN "public"."tg_cms_m_base_info"."title_color" IS '颜色';
COMMENT ON COLUMN "public"."tg_cms_m_base_info"."title_strong" IS '是否粗体';
COMMENT ON COLUMN "public"."tg_cms_m_base_info"."title_em" IS '是否斜体';
COMMENT ON COLUMN "public"."tg_cms_m_base_info"."info_path" IS '文档路径';
COMMENT ON COLUMN "public"."tg_cms_m_base_info"."info_template" IS '文档模板';
COMMENT ON COLUMN "public"."tg_cms_m_base_info"."meta_description" IS '描述';
COMMENT ON COLUMN "public"."tg_cms_m_base_info"."source" IS '来源名称';
COMMENT ON COLUMN "public"."tg_cms_m_base_info"."source_url" IS '来源url';
COMMENT ON COLUMN "public"."tg_cms_m_base_info"."author" IS '作者';
COMMENT ON COLUMN "public"."tg_cms_m_base_info"."image" IS '大图';
COMMENT ON COLUMN "public"."tg_cms_m_base_info"."video" IS '视频';
COMMENT ON COLUMN "public"."tg_cms_m_base_info"."doc" IS '文库';
COMMENT ON COLUMN "public"."tg_cms_m_base_info"."allow_comment" IS '是否允许评论';

-- ----------------------------
-- Records of tg_cms_m_base_info
-- ----------------------------
INSERT INTO "public"."tg_cms_m_base_info" VALUES ('0615bc0b-5e26-460e-8442-171504a4fa8d', '8f59a63d-62da-455e-b907-a5c1aca9c9bb', '2015-11-01 00:00:00', '2015-11-03 17:25:49.136', null, '3', '2', '0', '0', '0', '0', '0', null, null, '在线教育平台', null, null, null, null, null, '2', '2', null, null, null, '图灵谷在线教育平台为客户提供了一个简单易用的在线教育服务平台，客户可以基于图灵谷在线教育平台为用户提供各行业的在线教育服务。', null, null, null, null, '0ac7c7cd-c3b7-4a49-ab0a-3071369fb2b5', null, null, null, '1', '2015-11-03 16:03:44.803', 'admin', '2015-11-03 17:25:49.133', 'admin');
INSERT INTO "public"."tg_cms_m_base_info" VALUES ('310d5a92-eb3d-467a-ae97-3da8b3a04697', 'e5c0a198-c8ac-4a69-8b3c-a13479f64191', '2016-02-04 00:00:00', '2016-02-04 09:20:13.736', null, '1', '2', '0', '0', '0', '0', '0', null, null, '基于微信公众号的webapp产品时间沙漏正式上线', null, null, null, null, null, '2', '2', null, null, null, '基于微信公众号的webapp产品时间沙漏正式上线，敬请关注微信公众号： 时间沙漏   turingoal-time', null, null, null, null, null, null, null, null, '1', '2016-02-03 04:13:45.385', 'admin', '2016-02-04 09:20:13.733', 'admin');
INSERT INTO "public"."tg_cms_m_base_info" VALUES ('48b6d899-f4b7-4b59-b597-42dfa9fcbf7c', '8f59a63d-62da-455e-b907-a5c1aca9c9bb', '2015-11-01 00:00:00', '2015-11-03 17:25:58.501', null, '4', '2', '0', '0', '0', '0', '0', null, null, '图灵谷统一业务服务平台', null, null, null, null, null, '2', '2', null, null, null, '图灵谷统一业务服务平台，代号“奠基”，是图灵谷的基础平台，实现了系统的统一用户认证，统一权限管理，统一任务调度，统一系统监控等常见系统服务。', null, null, null, null, '4aaaf450-92e7-44e8-9fe1-988706fd8f62', null, null, null, '1', '2015-11-03 16:09:00.405', 'admin', '2015-11-03 17:25:58.5', 'admin');
INSERT INTO "public"."tg_cms_m_base_info" VALUES ('5f9810aa-e3e3-4520-a315-57ebb4062284', '8f59a63d-62da-455e-b907-a5c1aca9c9bb', '2015-11-01 00:00:00', '2015-11-03 17:25:24.414', null, '1', '2', '0', '0', '0', '0', '0', null, null, '全媒体内容管理发布平台', null, null, null, null, null, '2', '2', null, null, null, '图灵谷全媒体内容管理发布平台整合了图、文、音视频等媒体资源，实现了全媒体的内容管理与发布的统一平台。', null, null, null, null, '2a575829-f41d-4b89-8f68-5d057487315f', null, null, null, '1', '2015-11-03 16:01:43.081', 'admin', '2015-11-03 17:25:24.411', 'admin');
INSERT INTO "public"."tg_cms_m_base_info" VALUES ('6ce5e5d9-62e5-47bc-9c84-4a12d671c80c', 'e5c0a198-c8ac-4a69-8b3c-a13479f64191', '2015-07-25 00:00:00', '2016-01-31 20:37:27.307', null, '1', '2', '0', '0', '0', '0', '0', null, null, '与北京中平科学技术院签署项目协议', null, null, null, null, null, '2', '2', null, null, null, '图灵谷与北京中平科学技术院正式签署项目开发协议。该项目对图灵谷未来的发展方向有着重要意义', null, null, null, null, null, null, null, null, '1', '2016-01-31 20:36:51.404', 'admin', '2016-01-31 20:37:27.301', 'admin');
INSERT INTO "public"."tg_cms_m_base_info" VALUES ('6d40826d-e2d7-4841-8ccb-89e20bdec54d', '8f59a63d-62da-455e-b907-a5c1aca9c9bb', '2015-11-01 00:00:00', '2015-11-03 17:25:37.021', null, '2', '2', '0', '0', '0', '0', '0', null, null, '互联网直播点播平台', null, null, null, null, null, '2', '2', null, null, null, '图灵谷互联网直播点播平台通过流媒体技术实现了PC、手机等多终端音视频的直播点播功能。', null, null, null, null, '873994bd-d3a7-4d52-a8c8-6426100a8b01', null, null, null, '1', '2015-11-03 16:02:27.151', 'admin', '2015-11-03 17:25:37.02', 'admin');
INSERT INTO "public"."tg_cms_m_base_info" VALUES ('6f40bed6-705d-4f8c-96d6-8afce9a8f2d9', 'e5c0a198-c8ac-4a69-8b3c-a13479f64191', '2015-10-27 00:00:00', '2016-01-31 20:38:14.067', null, '1', '2', '0', '0', '0', '0', '0', null, null, '图灵谷发布开源项目 — 糖果cms', null, null, null, null, null, '2', '2', null, null, null, '图灵谷在目前中国最大的开源技术社区oschina上发布开源项目糖果cms，这是一个java开发的cms，一个免费开源的cms，一个简单易用的cms。相信在广大技术爱好者的共同努力下她会一步步成长起来', null, null, null, null, null, null, null, null, '1', '2016-01-31 20:38:14.067', 'admin', null, null);
INSERT INTO "public"."tg_cms_m_base_info" VALUES ('711ace7c-9cc0-44c0-b435-6b275a18ff3e', '4ef84122-5605-45af-bfea-a3c2e315b898', '2015-11-04 00:00:00', '2015-11-04 17:37:10.153', null, '2', '2', '0', '0', '0', '0', '0', null, null, '交通行业', null, null, null, null, null, '2', '2', null, null, null, null, null, null, null, null, 'b3d0c9fd-a994-4342-893b-75a2ccb73db9', null, null, null, '1', '2015-11-03 21:33:48.382', 'admin', '2015-11-04 17:37:10.152', 'admin');
INSERT INTO "public"."tg_cms_m_base_info" VALUES ('8a1c54ec-63ad-4d94-9543-581442caa63b', '4ef84122-5605-45af-bfea-a3c2e315b898', '2015-11-04 00:00:00', '2015-11-04 17:36:58.633', null, '1', '2', '0', '0', '0', '0', '0', null, null, '广电行业', null, null, null, null, null, '2', '2', null, null, null, null, null, null, null, null, '730774fd-5a6c-447c-87ed-a97a57ff222b', null, null, null, '1', '2015-11-03 21:32:44.965', 'admin', '2015-11-04 17:36:58.49', 'admin');
INSERT INTO "public"."tg_cms_m_base_info" VALUES ('98054b10-4b0e-4ccd-a411-0033e5fb3822', '4ef84122-5605-45af-bfea-a3c2e315b898', '2015-11-04 00:00:00', '2015-11-04 17:38:01.635', null, '6', '2', '0', '0', '0', '0', '0', null, null, '法务系统', null, null, null, null, null, '2', '2', null, null, null, null, null, null, null, null, 'bd365916-11c2-4246-a903-3c2c91b2e08b', null, null, null, '1', '2015-11-03 21:36:37.678', 'admin', '2015-11-04 17:38:01.634', 'admin');
INSERT INTO "public"."tg_cms_m_base_info" VALUES ('9eb31849-e3a7-4a80-bd7b-86339546b1be', 'e5c0a198-c8ac-4a69-8b3c-a13479f64191', '2015-11-10 00:00:00', '2016-01-31 20:38:59.561', null, '1', '2', '0', '0', '0', '0', '0', null, null, '公司组织员工前往香山观赏红叶', null, null, null, null, null, '2', '2', null, null, null, '公司组织员工前往香山观赏红叶
为了丰富企业员工的业余文化生活，激发员工的工作热情和动力，增强公司各部门之间的团队意识、互助意识，增强企业的凝聚力，充分展示企业精神面貌和企业形象，十一月九日，公司组织前往北

京香山观看漫山红叶。此次活动增强了整个团队的凝聚力、荣誉感和归属感，体现了公司以人为本的理念。', null, null, null, null, null, null, null, null, '1', '2016-01-31 20:38:59.561', 'admin', null, null);
INSERT INTO "public"."tg_cms_m_base_info" VALUES ('a01bf9b7-622d-4c38-b08a-b7618f485673', '4ef84122-5605-45af-bfea-a3c2e315b898', '2015-11-04 00:00:00', '2015-11-04 17:37:22.059', null, '3', '2', '0', '0', '0', '0', '0', null, null, '教育行业', null, null, null, null, null, '2', '2', null, null, null, null, null, null, null, null, '3d11d74e-3d72-4e1f-ac80-abd97d1a37cd', null, null, null, '1', '2015-11-03 21:34:16.347', 'admin', '2015-11-04 17:37:22.058', 'admin');
INSERT INTO "public"."tg_cms_m_base_info" VALUES ('a55cece8-5e7e-4384-99c7-c69295a7e6c3', '4ef84122-5605-45af-bfea-a3c2e315b898', '2015-11-04 00:00:00', '2015-11-04 17:37:34.015', null, '4', '2', '0', '0', '0', '0', '0', null, null, '移动互联', null, null, null, null, null, '2', '2', null, null, null, null, null, null, null, null, '8a21acc4-34e7-48ba-9095-5175a8facf59', null, null, null, '1', '2015-11-03 21:35:16.811', 'admin', '2015-11-04 17:37:34.014', 'admin');
INSERT INTO "public"."tg_cms_m_base_info" VALUES ('a6c35b39-7df5-427f-86b5-3681e1a3cf26', '4ef84122-5605-45af-bfea-a3c2e315b898', '2015-11-04 00:00:00', '2015-11-04 17:37:48.76', null, '5', '2', '0', '0', '0', '0', '0', null, null, '政务系统', null, null, null, null, null, '2', '2', null, null, null, null, null, null, null, null, '94932566-27e4-47d9-b481-c0bf3ce78525', null, null, null, '1', '2015-11-03 21:36:12.83', 'admin', '2015-11-04 17:37:48.76', 'admin');
INSERT INTO "public"."tg_cms_m_base_info" VALUES ('b97fac12-aadc-4f51-8fff-3cde5a98c358', 'e5c0a198-c8ac-4a69-8b3c-a13479f64191', '2015-07-20 00:00:00', '2015-11-03 15:46:01.972', null, '2', '2', '0', '0', '0', '0', '0', null, null, '与北京天地极峰达成合作意向', null, null, null, null, null, '2', '2', null, null, null, '图灵谷与北京天地极峰达成长期战略合作意向。长期稳定合作，共同谋求发展。', null, null, null, null, null, null, null, null, '1', '2015-11-03 15:44:31.404', 'admin', '2015-11-03 15:46:01.971', 'admin');
INSERT INTO "public"."tg_cms_m_base_info" VALUES ('d98e113d-b092-4440-bb0f-f77d86d51388', 'e5c0a198-c8ac-4a69-8b3c-a13479f64191', '2015-07-17 00:00:00', '2015-11-03 15:45:30.39', null, '3', '2', '0', '0', '0', '0', '0', null, null, '与北京星橙科技公司和深圳生活智造公司达成长期战略合作意向', null, null, null, null, null, '2', '2', null, null, null, '图灵谷与北京星橙科技公司和深圳生活智造公司达成长期战略合作意向。团结协力共铸辉煌，展望未来蓝图宏伟！', null, null, null, null, null, null, null, null, '1', '2015-11-03 15:45:30.39', 'admin', null, null);

-- ----------------------------
-- Table structure for tg_cms_m_base_info_attrs
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_cms_m_base_info_attrs";
CREATE TABLE "public"."tg_cms_m_base_info_attrs" (
"id" varchar(45) COLLATE "default" NOT NULL,
"info_id" varchar(45) COLLATE "default" NOT NULL,
"attribute_id" varchar(45) COLLATE "default" NOT NULL,
"image" varchar(255) COLLATE "default",
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tg_cms_m_base_info_attrs" IS '文档与属性关联表';
COMMENT ON COLUMN "public"."tg_cms_m_base_info_attrs"."id" IS '文档与属性关联';
COMMENT ON COLUMN "public"."tg_cms_m_base_info_attrs"."info_id" IS '文档';
COMMENT ON COLUMN "public"."tg_cms_m_base_info_attrs"."attribute_id" IS '属性';
COMMENT ON COLUMN "public"."tg_cms_m_base_info_attrs"."image" IS '属性图片';

-- ----------------------------
-- Records of tg_cms_m_base_info_attrs
-- ----------------------------
INSERT INTO "public"."tg_cms_m_base_info_attrs" VALUES ('0473edfe-b7b5-4591-8dab-343e4d4852b1', '6322e6ec-53b2-4e82-9400-7ecd700a7af5', '1', null, null, null, null, null);

-- ----------------------------
-- Table structure for tg_cms_m_base_info_special
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_cms_m_base_info_special";
CREATE TABLE "public"."tg_cms_m_base_info_special" (
"id" varchar(45) COLLATE "default" NOT NULL,
"info_id" varchar(45) COLLATE "default" NOT NULL,
"special_id" varchar(45) COLLATE "default" NOT NULL,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tg_cms_m_base_info_special" IS '文档与专题关联表';
COMMENT ON COLUMN "public"."tg_cms_m_base_info_special"."id" IS '文档专题关联';
COMMENT ON COLUMN "public"."tg_cms_m_base_info_special"."info_id" IS '文档';
COMMENT ON COLUMN "public"."tg_cms_m_base_info_special"."special_id" IS '专题';

-- ----------------------------
-- Records of tg_cms_m_base_info_special
-- ----------------------------
INSERT INTO "public"."tg_cms_m_base_info_special" VALUES ('27ffb5e4-f5cd-489d-b7dc-98cc71391f13', '4ecb4e32-8e85-4be0-9678-044e49b0b2db', 'a2e7f55a-42f7-44a8-bc90-08208bb68f4a', null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_info_special" VALUES ('58c3ef0b-d0d6-4c8b-ba36-f0044724af6f', 'dda07e4c-e6af-4360-963f-385634c998b9', 'a7577c05-6612-4059-ab4d-2ce5103b2fe6', null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_info_special" VALUES ('b4552776-1612-46fe-9d1e-b8ec7807a83d', 'dda07e4c-e6af-4360-963f-385634c998b9', 'a2e7f55a-42f7-44a8-bc90-08208bb68f4a', null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_info_special" VALUES ('c27bde1c-e37a-4eec-8be3-01b511caeace', '6322e6ec-53b2-4e82-9400-7ecd700a7af5', '236781b1-fad2-41e1-b7b4-582afd8d24f2', null, null, null, null);

-- ----------------------------
-- Table structure for tg_cms_m_base_info_tags
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_cms_m_base_info_tags";
CREATE TABLE "public"."tg_cms_m_base_info_tags" (
"id" varchar(45) COLLATE "default" NOT NULL,
"info_id" varchar(45) COLLATE "default" NOT NULL,
"tag_id" varchar(45) COLLATE "default" NOT NULL,
"priority" int2 DEFAULT 1 NOT NULL,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tg_cms_m_base_info_tags" IS '文档与tag关联表';
COMMENT ON COLUMN "public"."tg_cms_m_base_info_tags"."id" IS '文档标签关联';
COMMENT ON COLUMN "public"."tg_cms_m_base_info_tags"."info_id" IS '文档';
COMMENT ON COLUMN "public"."tg_cms_m_base_info_tags"."tag_id" IS 'tag';
COMMENT ON COLUMN "public"."tg_cms_m_base_info_tags"."priority" IS 'tag序号';

-- ----------------------------
-- Records of tg_cms_m_base_info_tags
-- ----------------------------
INSERT INTO "public"."tg_cms_m_base_info_tags" VALUES ('338ad5fd-7368-489d-8cf9-f934698bcfd7', '1ac3bcab-e82b-4788-8608-e4a31358c6d2', '338ad5fd-7368-489d-8cf9-f934698bcfd7', '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_info_tags" VALUES ('338ad5fd-7368-489d-8cf9-f934698bcfd7', '89161d2a-9251-46b6-af18-3c032ebc57b2', '338ad5fd-7368-489d-8cf9-f934698bcfd7', '1', null, null, null, null);

-- ----------------------------
-- Table structure for tg_cms_m_base_model
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_cms_m_base_model";
CREATE TABLE "public"."tg_cms_m_base_model" (
"id" varchar(45) COLLATE "default" NOT NULL,
"type" varchar(100) COLLATE "default" NOT NULL,
"model_name" varchar(50) COLLATE "default" NOT NULL,
"code_num" varchar(100) COLLATE "default",
"description" varchar(200) COLLATE "default",
"sort_order" int2 DEFAULT 1 NOT NULL,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tg_cms_m_base_model" IS '模型表';
COMMENT ON COLUMN "public"."tg_cms_m_base_model"."id" IS '模型';
COMMENT ON COLUMN "public"."tg_cms_m_base_model"."type" IS '类型(info:文档,node:栏目,home:首页;special:专题)';
COMMENT ON COLUMN "public"."tg_cms_m_base_model"."model_name" IS '名称';
COMMENT ON COLUMN "public"."tg_cms_m_base_model"."code_num" IS '代码';
COMMENT ON COLUMN "public"."tg_cms_m_base_model"."description" IS '描述';
COMMENT ON COLUMN "public"."tg_cms_m_base_model"."sort_order" IS '顺序';

-- ----------------------------
-- Records of tg_cms_m_base_model
-- ----------------------------
INSERT INTO "public"."tg_cms_m_base_model" VALUES ('0b1459e3-66a2-42d5-8a19-f5e2d8e606a2', 'node', '解决方案', null, null, '3', null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_model" VALUES ('25fb6951-0819-423e-88b8-b9f1c8b59406', 'info', '默认', null, null, '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_model" VALUES ('57056b0d-cbeb-407c-94bd-0ead61811f13', 'node', '首页', null, null, '2', null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_model" VALUES ('5bbd4645-d434-45ae-ab05-18161964aa5c', 'node', '产品服务', null, null, '2', null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_model" VALUES ('a1dda5ec-98a9-47a3-a255-2705168d1ada', 'node', '关于我们', null, null, '2', null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_model" VALUES ('d6580d68-bec3-45de-bc65-b62555d5f804', 'node', '联系我们', null, null, '4', null, null, null, null);

-- ----------------------------
-- Table structure for tg_cms_m_base_node
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_cms_m_base_node";
CREATE TABLE "public"."tg_cms_m_base_node" (
"id" varchar(45) COLLATE "default" NOT NULL,
"parent_id" varchar(45) COLLATE "default",
"node_model_id" varchar(45) COLLATE "default",
"info_model_id" varchar(45) COLLATE "default",
"node_template" varchar(255) COLLATE "default",
"info_template" varchar(255) COLLATE "default",
"code_num" varchar(100) COLLATE "default",
"nodd_name" varchar(150) COLLATE "default" NOT NULL,
"refers_count" int4 NOT NULL,
"views_count" int4 NOT NULL,
"real_node" int2 NOT NULL,
"hidden" int2 NOT NULL,
"html_state" int2 NOT NULL,
"node_link" varchar(255) COLLATE "default",
"html_link" varchar(255) COLLATE "default",
"meta_keywords" varchar(150) COLLATE "default",
"meta_description" varchar(255) COLLATE "default",
"new_window" int2,
"generate_node" int2,
"generate_info" int2,
"node_path" varchar(100) COLLATE "default",
"info_path" varchar(100) COLLATE "default",
"static_method" int2,
"static_pages" int4,
"image" varchar(45) COLLATE "default",
"single_page" int2 DEFAULT 2,
"enabled" int2 DEFAULT 1,
"sort_order" int2 DEFAULT 1,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tg_cms_m_base_node" IS '栏目表';
COMMENT ON COLUMN "public"."tg_cms_m_base_node"."id" IS '栏目';
COMMENT ON COLUMN "public"."tg_cms_m_base_node"."parent_id" IS '父栏目';
COMMENT ON COLUMN "public"."tg_cms_m_base_node"."node_model_id" IS '栏目模型';
COMMENT ON COLUMN "public"."tg_cms_m_base_node"."info_model_id" IS '文档模型';
COMMENT ON COLUMN "public"."tg_cms_m_base_node"."node_template" IS '栏目模板';
COMMENT ON COLUMN "public"."tg_cms_m_base_node"."info_template" IS '文档模板';
COMMENT ON COLUMN "public"."tg_cms_m_base_node"."code_num" IS '代码';
COMMENT ON COLUMN "public"."tg_cms_m_base_node"."nodd_name" IS '名称';
COMMENT ON COLUMN "public"."tg_cms_m_base_node"."refers_count" IS '文档数量';
COMMENT ON COLUMN "public"."tg_cms_m_base_node"."views_count" IS '浏览总数';
COMMENT ON COLUMN "public"."tg_cms_m_base_node"."real_node" IS '是否真实栏目';
COMMENT ON COLUMN "public"."tg_cms_m_base_node"."hidden" IS '是否隐藏';
COMMENT ON COLUMN "public"."tg_cms_m_base_node"."node_link" IS '转向链接';
COMMENT ON COLUMN "public"."tg_cms_m_base_node"."html_link" IS 'HTML页面';
COMMENT ON COLUMN "public"."tg_cms_m_base_node"."meta_keywords" IS '关键字';
COMMENT ON COLUMN "public"."tg_cms_m_base_node"."meta_description" IS '描述';
COMMENT ON COLUMN "public"."tg_cms_m_base_node"."new_window" IS '是否在新窗口打开';
COMMENT ON COLUMN "public"."tg_cms_m_base_node"."generate_node" IS '是否生成栏目页';
COMMENT ON COLUMN "public"."tg_cms_m_base_node"."generate_info" IS '是否生成文档页';
COMMENT ON COLUMN "public"."tg_cms_m_base_node"."node_path" IS '栏目路径';
COMMENT ON COLUMN "public"."tg_cms_m_base_node"."info_path" IS '文档路径';
COMMENT ON COLUMN "public"."tg_cms_m_base_node"."static_method" IS '静态页生成方式(1:手动生成;2:自动生成栏目页;3:自动生成文档页及栏目页;4:自动生成文档页、栏目页、父栏目页、首页)';
COMMENT ON COLUMN "public"."tg_cms_m_base_node"."static_pages" IS '栏目列表静态化页数';
COMMENT ON COLUMN "public"."tg_cms_m_base_node"."image" IS '大图';
COMMENT ON COLUMN "public"."tg_cms_m_base_node"."single_page" IS '单页面栏目';
COMMENT ON COLUMN "public"."tg_cms_m_base_node"."enabled" IS '是否可用';
COMMENT ON COLUMN "public"."tg_cms_m_base_node"."sort_order" IS '排序';

-- ----------------------------
-- Records of tg_cms_m_base_node
-- ----------------------------
INSERT INTO "public"."tg_cms_m_base_node" VALUES ('0bae1118-477c-4f98-9ea5-989c7adc066c', '0', '57056b0d-cbeb-407c-94bd-0ead61811f13', '25fb6951-0819-423e-88b8-b9f1c8b59406', 'default/index', 'default/index', 'index', '首页', '0', '0', '1', '2', '2', null, null, null, null, '2', null, null, null, null, null, null, null, null, '1', '1', '2015-11-03 14:59:20.517', null, null, null);
INSERT INTO "public"."tg_cms_m_base_node" VALUES ('4ef84122-5605-45af-bfea-a3c2e315b898', '0', '0b1459e3-66a2-42d5-8a19-f5e2d8e606a2', '25fb6951-0819-423e-88b8-b9f1c8b59406', 'default/solutions', 'default/solutions', 'solutions', '解决方案', '0', '0', '1', '2', '2', null, null, null, null, '2', null, null, null, null, null, null, null, null, '1', '4', '2015-11-03 15:03:41.581', null, null, null);
INSERT INTO "public"."tg_cms_m_base_node" VALUES ('8f59a63d-62da-455e-b907-a5c1aca9c9bb', '0', '5bbd4645-d434-45ae-ab05-18161964aa5c', '25fb6951-0819-423e-88b8-b9f1c8b59406', 'default/services', 'default/services', 'services', '产品服务', '0', '0', '1', '2', '2', null, null, null, null, '2', null, null, null, null, null, null, null, null, '1', '3', '2015-11-03 15:03:37.534', null, null, null);
INSERT INTO "public"."tg_cms_m_base_node" VALUES ('c08697fb-4655-41fd-8cbb-567ed31d92f1', '0', 'd6580d68-bec3-45de-bc65-b62555d5f804', '25fb6951-0819-423e-88b8-b9f1c8b59406', 'default/contact', 'default/contact', 'contact', '联系我们', '0', '0', '1', '2', '2', null, null, null, null, '2', null, null, null, null, null, null, null, null, '1', '6', '2015-11-04 16:35:59.236', null, null, null);
INSERT INTO "public"."tg_cms_m_base_node" VALUES ('e5c0a198-c8ac-4a69-8b3c-a13479f64191', '0', '57056b0d-cbeb-407c-94bd-0ead61811f13', '25fb6951-0819-423e-88b8-b9f1c8b59406', 'default/index', 'default/index', 'news', '公司动态', '0', '0', '1', '1', '2', null, null, null, null, '2', null, null, null, null, null, null, null, null, '1', '2', '2015-11-03 15:04:39.004', null, null, null);
INSERT INTO "public"."tg_cms_m_base_node" VALUES ('f1b54eff-f129-4eba-be08-0e2be9586d28', '0', 'a1dda5ec-98a9-47a3-a255-2705168d1ada', '25fb6951-0819-423e-88b8-b9f1c8b59406', 'default/about', 'default/about', 'about', '关于我们', '0', '0', '1', '2', '2', null, null, null, null, '2', null, null, null, null, null, null, null, null, '1', '5', '2015-11-03 15:04:28.663', null, null, null);

-- ----------------------------
-- Table structure for tg_cms_m_base_node_group
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_cms_m_base_node_group";
CREATE TABLE "public"."tg_cms_m_base_node_group" (
"id" varchar(45) COLLATE "default" NOT NULL,
"node_id" varchar(45) COLLATE "default" NOT NULL,
"group_id" varchar(45) COLLATE "default" NOT NULL,
"view_perm" int2 NOT NULL,
"contri_perm" int2 NOT NULL,
"comment_perm" int2 NOT NULL,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tg_cms_m_base_node_group" IS '栏目与用户组权限表';
COMMENT ON COLUMN "public"."tg_cms_m_base_node_group"."id" IS '栏目与用户组权限';
COMMENT ON COLUMN "public"."tg_cms_m_base_node_group"."node_id" IS '栏目';
COMMENT ON COLUMN "public"."tg_cms_m_base_node_group"."group_id" IS '用户组';
COMMENT ON COLUMN "public"."tg_cms_m_base_node_group"."view_perm" IS '是否有浏览权限';
COMMENT ON COLUMN "public"."tg_cms_m_base_node_group"."contri_perm" IS '是否有投稿权限';
COMMENT ON COLUMN "public"."tg_cms_m_base_node_group"."comment_perm" IS '是否有评论权限';

-- ----------------------------
-- Records of tg_cms_m_base_node_group
-- ----------------------------

-- ----------------------------
-- Table structure for tg_cms_m_base_node_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_cms_m_base_node_role";
CREATE TABLE "public"."tg_cms_m_base_node_role" (
"id" varchar(45) COLLATE "default" NOT NULL,
"role_id" varchar(45) COLLATE "default" NOT NULL,
"node_id" varchar(45) COLLATE "default" NOT NULL,
"node_perm" int2 NOT NULL,
"info_perm" int2 NOT NULL,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tg_cms_m_base_node_role" IS '栏目与角色权限表';
COMMENT ON COLUMN "public"."tg_cms_m_base_node_role"."id" IS '文档角色关联';
COMMENT ON COLUMN "public"."tg_cms_m_base_node_role"."node_perm" IS '栏目权限';
COMMENT ON COLUMN "public"."tg_cms_m_base_node_role"."info_perm" IS '文档权限';

-- ----------------------------
-- Records of tg_cms_m_base_node_role
-- ----------------------------

-- ----------------------------
-- Table structure for tg_cms_m_base_publish_point
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_cms_m_base_publish_point";
CREATE TABLE "public"."tg_cms_m_base_publish_point" (
"id" varchar(45) COLLATE "default" NOT NULL,
"p_name" varchar(100) COLLATE "default" NOT NULL,
"description" varchar(255) COLLATE "default",
"store_path" varchar(255) COLLATE "default",
"display_path" varchar(255) COLLATE "default",
"ftp_hostname" varchar(100) COLLATE "default",
"ftp_port" int4,
"ftp_username" varchar(100) COLLATE "default",
"ftp_password" varchar(100) COLLATE "default",
"p_method" int2 NOT NULL,
"p_type" int4 NOT NULL,
"sort_order" int2 DEFAULT 1 NOT NULL,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tg_cms_m_base_publish_point" IS '发布点表';
COMMENT ON COLUMN "public"."tg_cms_m_base_publish_point"."id" IS '发布点';
COMMENT ON COLUMN "public"."tg_cms_m_base_publish_point"."p_name" IS '名称';
COMMENT ON COLUMN "public"."tg_cms_m_base_publish_point"."description" IS '描述';
COMMENT ON COLUMN "public"."tg_cms_m_base_publish_point"."store_path" IS '保存路径';
COMMENT ON COLUMN "public"."tg_cms_m_base_publish_point"."display_path" IS '显示路径';
COMMENT ON COLUMN "public"."tg_cms_m_base_publish_point"."ftp_hostname" IS 'ftp服务器';
COMMENT ON COLUMN "public"."tg_cms_m_base_publish_point"."ftp_port" IS 'ftp端口';
COMMENT ON COLUMN "public"."tg_cms_m_base_publish_point"."ftp_username" IS 'ftp用户名';
COMMENT ON COLUMN "public"."tg_cms_m_base_publish_point"."ftp_password" IS 'ftp密码';
COMMENT ON COLUMN "public"."tg_cms_m_base_publish_point"."p_method" IS '方式(1:文件系统,2:FTP)';
COMMENT ON COLUMN "public"."tg_cms_m_base_publish_point"."p_type" IS '类型(1:HTML发布,2:附件发布)';
COMMENT ON COLUMN "public"."tg_cms_m_base_publish_point"."sort_order" IS '排列顺序';

-- ----------------------------
-- Records of tg_cms_m_base_publish_point
-- ----------------------------

-- ----------------------------
-- Table structure for tg_cms_m_base_special
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_cms_m_base_special";
CREATE TABLE "public"."tg_cms_m_base_special" (
"id" varchar(45) COLLATE "default" NOT NULL,
"model_id" varchar(45) COLLATE "default" NOT NULL,
"type_id" varchar(45) COLLATE "default" NOT NULL,
"title" varchar(150) COLLATE "default" NOT NULL,
"meta_keywords" varchar(150) COLLATE "default",
"meta_description" varchar(255) COLLATE "default",
"special_template" varchar(255) COLLATE "default",
"image" int4,
"video" int4,
"refers_count" int4 NOT NULL,
"views_count" int4 NOT NULL,
"with_image" int2 NOT NULL,
"recommend" int2 NOT NULL,
"enabled" int2,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tg_cms_m_base_special" IS '专题表';
COMMENT ON COLUMN "public"."tg_cms_m_base_special"."id" IS '专题';
COMMENT ON COLUMN "public"."tg_cms_m_base_special"."model_id" IS '模型';
COMMENT ON COLUMN "public"."tg_cms_m_base_special"."type_id" IS '专题类别';
COMMENT ON COLUMN "public"."tg_cms_m_base_special"."title" IS '标题';
COMMENT ON COLUMN "public"."tg_cms_m_base_special"."meta_keywords" IS '关键字';
COMMENT ON COLUMN "public"."tg_cms_m_base_special"."meta_description" IS '描述';
COMMENT ON COLUMN "public"."tg_cms_m_base_special"."special_template" IS '专题模板';
COMMENT ON COLUMN "public"."tg_cms_m_base_special"."image" IS '大图';
COMMENT ON COLUMN "public"."tg_cms_m_base_special"."video" IS '视频';
COMMENT ON COLUMN "public"."tg_cms_m_base_special"."refers_count" IS '文档数量';
COMMENT ON COLUMN "public"."tg_cms_m_base_special"."views_count" IS '浏览总数';
COMMENT ON COLUMN "public"."tg_cms_m_base_special"."with_image" IS '是否有图片';
COMMENT ON COLUMN "public"."tg_cms_m_base_special"."recommend" IS '是否推荐';
COMMENT ON COLUMN "public"."tg_cms_m_base_special"."enabled" IS '1';

-- ----------------------------
-- Records of tg_cms_m_base_special
-- ----------------------------

-- ----------------------------
-- Table structure for tg_cms_m_base_special_type
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_cms_m_base_special_type";
CREATE TABLE "public"."tg_cms_m_base_special_type" (
"id" varchar(45) COLLATE "default" NOT NULL,
"type_name" varchar(50) COLLATE "default" NOT NULL,
"views_count" int4,
"meta_keywords" varchar(150) COLLATE "default",
"meta_description" varchar(255) COLLATE "default",
"sort_order" int2 NOT NULL,
"enabled" int2 DEFAULT 1 NOT NULL,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tg_cms_m_base_special_type" IS '专题类别表';
COMMENT ON COLUMN "public"."tg_cms_m_base_special_type"."id" IS '专题类别';
COMMENT ON COLUMN "public"."tg_cms_m_base_special_type"."type_name" IS '名称';
COMMENT ON COLUMN "public"."tg_cms_m_base_special_type"."views_count" IS '浏览总数';
COMMENT ON COLUMN "public"."tg_cms_m_base_special_type"."meta_keywords" IS '关键字';
COMMENT ON COLUMN "public"."tg_cms_m_base_special_type"."meta_description" IS '描述';
COMMENT ON COLUMN "public"."tg_cms_m_base_special_type"."sort_order" IS '排序';
COMMENT ON COLUMN "public"."tg_cms_m_base_special_type"."enabled" IS '是否可用';

-- ----------------------------
-- Records of tg_cms_m_base_special_type
-- ----------------------------
INSERT INTO "public"."tg_cms_m_base_special_type" VALUES ('1', '国内专题', null, '国内专题', '国内', '1', '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_special_type" VALUES ('2', '国外专题', '0', '国外专题，国外', '国外专题 国外相关', '1', '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_special_type" VALUES ('6ec7b11e-68fd-43e2-af0b-f4001d980bc5', '文化专题', '0', '文化', '文化相关的内容', '3', '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_special_type" VALUES ('dcafd242-86e8-4427-8377-68eba081125f', '出兵美国', '0', '出兵美国', '解救受苦受难的美国人民', '2', '1', null, null, null, null);

-- ----------------------------
-- Table structure for tg_cms_m_base_tag
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_cms_m_base_tag";
CREATE TABLE "public"."tg_cms_m_base_tag" (
"id" varchar(45) COLLATE "default" NOT NULL,
"tag_name" varchar(50) COLLATE "default" NOT NULL,
"refers" int4 NOT NULL,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tg_cms_m_base_tag" IS 'TAG表';
COMMENT ON COLUMN "public"."tg_cms_m_base_tag"."id" IS 'TAG';
COMMENT ON COLUMN "public"."tg_cms_m_base_tag"."tag_name" IS '名称';
COMMENT ON COLUMN "public"."tg_cms_m_base_tag"."refers" IS '文档数量';

-- ----------------------------
-- Records of tg_cms_m_base_tag
-- ----------------------------
INSERT INTO "public"."tg_cms_m_base_tag" VALUES ('11', '今年夏天', '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_tag" VALUES ('14', '转型', '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_tag" VALUES ('15', '国平', '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_tag" VALUES ('16', '新闻 中国123123123', '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_tag" VALUES ('17', '美国生活', '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_tag" VALUES ('18', '美', '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_tag" VALUES ('19', '解放军', '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_tag" VALUES ('20', '灰机部队123123', '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_tag" VALUES ('21', '解放军 灰机', '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_tag" VALUES ('22', '公司简介111', '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_tag" VALUES ('23', 'en公司简介', '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_tag" VALUES ('24', '2013年中国', '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_tag" VALUES ('338ad5fd-7368-489d-8cf9-f934698bcfd7', '2', '1', '2015-09-02 22:42:13.966', 'admin', null, null);
INSERT INTO "public"."tg_cms_m_base_tag" VALUES ('338ca3be-f0e2-43ac-a235-b75df8cbece1', '123456', '0', '2015-09-04 11:57:45.385', 'admin', null, null);
INSERT INTO "public"."tg_cms_m_base_tag" VALUES ('35ae36f3-d3b6-4f97-a6bb-519c55003208', '奋进', '-1', '2015-09-04 14:50:20.9', 'admin', null, null);
INSERT INTO "public"."tg_cms_m_base_tag" VALUES ('369c8d09-67bf-4529-bc81-0790f86ab74e', '22', '-1', '2015-09-04 13:57:54.826', 'admin', null, null);
INSERT INTO "public"."tg_cms_m_base_tag" VALUES ('3939d76f-3d1f-4c80-be70-ea3036b16604', '天气', '-1', '2015-11-04 15:39:20.863', 'admin', null, null);
INSERT INTO "public"."tg_cms_m_base_tag" VALUES ('4', 'A', '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_tag" VALUES ('4c0c5cb1-20fc-4a41-a94e-4fd5c46180bf', '张晓东、试试，调度', '-1', '2015-10-20 18:54:02.423', 'admin', null, null);
INSERT INTO "public"."tg_cms_m_base_tag" VALUES ('5', '董事长致辞', '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_tag" VALUES ('5c9e8c94-2cdc-4611-a122-91f48b9b24fc', '12312', '0', null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_tag" VALUES ('7', '中国', '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_tag" VALUES ('8', '中国2010', '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_tag" VALUES ('9', '中国2011', '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_base_tag" VALUES ('9df6196f-06d4-42bd-9397-ac5e8e147344', '111', '0', '2015-09-04 11:36:16.788', 'admin', null, null);

-- ----------------------------
-- Table structure for tg_cms_m_base_template
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_cms_m_base_template";
CREATE TABLE "public"."tg_cms_m_base_template" (
"id" varchar(45) COLLATE "default" NOT NULL,
"template_name" varchar(45) COLLATE "default" NOT NULL,
"code_num" varchar(45) COLLATE "default",
"description" varchar(200) COLLATE "default",
"sort_order" int2 DEFAULT 1,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."tg_cms_m_base_template"."id" IS '模板';
COMMENT ON COLUMN "public"."tg_cms_m_base_template"."template_name" IS '模板名称';
COMMENT ON COLUMN "public"."tg_cms_m_base_template"."code_num" IS '模板代码';
COMMENT ON COLUMN "public"."tg_cms_m_base_template"."description" IS '描述';
COMMENT ON COLUMN "public"."tg_cms_m_base_template"."sort_order" IS '排序';

-- ----------------------------
-- Records of tg_cms_m_base_template
-- ----------------------------
INSERT INTO "public"."tg_cms_m_base_template" VALUES ('8115b2dd-80c0-4f44-b43e-dc09bf5e2f88', 'default', 'default', null, null, '2015-11-03 17:20:10.875', 'admin', '2015-11-03 17:20:17.936', 'admin');

-- ----------------------------
-- Table structure for tg_cms_m_base_video
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_cms_m_base_video";
CREATE TABLE "public"."tg_cms_m_base_video" (
"id" varchar(45) COLLATE "default" NOT NULL,
"format" varchar(45) COLLATE "default",
"video_name" varchar(150) COLLATE "default",
"video_path" varchar(255) COLLATE "default",
"md5" varchar(45) COLLATE "default",
"video_length" int8,
"video_time" varchar(20) COLLATE "default",
"publish_time" timestamp(6),
"description" varchar(200) COLLATE "default",
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."tg_cms_m_base_video"."id" IS '视频';
COMMENT ON COLUMN "public"."tg_cms_m_base_video"."format" IS '格式';
COMMENT ON COLUMN "public"."tg_cms_m_base_video"."video_name" IS '视频名称';
COMMENT ON COLUMN "public"."tg_cms_m_base_video"."video_path" IS '视频地址';
COMMENT ON COLUMN "public"."tg_cms_m_base_video"."video_length" IS '视频大小';
COMMENT ON COLUMN "public"."tg_cms_m_base_video"."video_time" IS '视频长度';
COMMENT ON COLUMN "public"."tg_cms_m_base_video"."description" IS '描述';

-- ----------------------------
-- Records of tg_cms_m_base_video
-- ----------------------------
INSERT INTO "public"."tg_cms_m_base_video" VALUES ('15036124-6457-4ed6-aa6a-ade18f946ff4', 'swf', '有用.swf', '/uploads/201511/20151111/15036124-6457-4ed6-aa6a-ade18f946ff4.swf', '75D0D2A2479AFDB5EF5C8E6BE207F1B0', '829949', null, '2015-11-11 18:10:54.687', null, '2015-11-11 18:10:54.685', null, null, null);
INSERT INTO "public"."tg_cms_m_base_video" VALUES ('2d626a02-520e-418b-857e-ab20b5195c52', 'flv', '领略真正的团队精英.flv', '/uploads/201511/20151111/2d626a02-520e-418b-857e-ab20b5195c52.flv', '962C9550299B9003BBA8D0A48DFCD992', '9205087', null, '2015-11-11 18:01:41.609', null, '2015-11-11 18:01:41.606', null, null, null);
INSERT INTO "public"."tg_cms_m_base_video" VALUES ('53949c6b-9d68-4402-b29f-26edb399d028', 'swf', 'aa', '/uploads/201511/20151111/53949c6b-9d68-4402-b29f-26edb399d028.swf', 'C370070AF42D8E49193D4B092DBAEAB1', '57878', null, '2015-11-11 17:24:44.624', null, '2015-11-11 17:24:44.583', null, null, null);

-- ----------------------------
-- Table structure for tg_cms_m_ext_ad
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_cms_m_ext_ad";
CREATE TABLE "public"."tg_cms_m_ext_ad" (
"id" varchar(45) COLLATE "default" NOT NULL,
"ad_slot_id" varchar(45) COLLATE "default" NOT NULL,
"ad_name" varchar(150) COLLATE "default" NOT NULL,
"begin_time" timestamp(6),
"end_time" timestamp(6),
"ad_url" varchar(255) COLLATE "default",
"ad_text" varchar(255) COLLATE "default",
"ad_script" text COLLATE "default",
"ad_iimage" varchar(255) COLLATE "default",
"ad_flash" varchar(255) COLLATE "default",
"sort_order" int2 DEFAULT 1,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tg_cms_m_ext_ad" IS '广告表';
COMMENT ON COLUMN "public"."tg_cms_m_ext_ad"."id" IS '广告';
COMMENT ON COLUMN "public"."tg_cms_m_ext_ad"."ad_slot_id" IS '广告板id';
COMMENT ON COLUMN "public"."tg_cms_m_ext_ad"."ad_name" IS '名称';
COMMENT ON COLUMN "public"."tg_cms_m_ext_ad"."begin_time" IS '开始时间';
COMMENT ON COLUMN "public"."tg_cms_m_ext_ad"."end_time" IS '结束时间';
COMMENT ON COLUMN "public"."tg_cms_m_ext_ad"."ad_url" IS '广告url';
COMMENT ON COLUMN "public"."tg_cms_m_ext_ad"."ad_text" IS '文字';
COMMENT ON COLUMN "public"."tg_cms_m_ext_ad"."ad_script" IS '代码';
COMMENT ON COLUMN "public"."tg_cms_m_ext_ad"."ad_iimage" IS '图片';
COMMENT ON COLUMN "public"."tg_cms_m_ext_ad"."ad_flash" IS 'flash';
COMMENT ON COLUMN "public"."tg_cms_m_ext_ad"."sort_order" IS '排序';

-- ----------------------------
-- Records of tg_cms_m_ext_ad
-- ----------------------------
INSERT INTO "public"."tg_cms_m_ext_ad" VALUES ('26bb641b-bb67-49ef-b1ef-d68e161f8247', '2', '百雀羚', '2015-09-02 00:00:00', '2015-10-01 00:00:00', 'http://www.baidu.com', '天然无刺激1', '454646', null, null, '1', '2015-09-04 10:11:02.865', 'admin', '2015-09-04 10:12:40.412', 'admin');
INSERT INTO "public"."tg_cms_m_ext_ad" VALUES ('2d61627b-057c-4210-9a82-2d1ce0f47eb9', '3', '加多宝', '2015-09-01 00:00:00', '2015-09-17 00:00:00', 'http://www.baidu.com', '还是以撒旦发射的5日4', '4646', null, null, '1', '2015-09-04 10:25:45.759', 'admin', '2015-09-04 10:32:57.6', 'admin');
INSERT INTO "public"."tg_cms_m_ext_ad" VALUES ('4597b217-f91c-4c2f-8c26-c98fbe49634b', '3', '加多宝', '2015-09-01 00:00:00', '2015-09-16 00:00:00', 'http://www.baidu.com', '还是原来的味道', '45646', null, null, '1', '2015-09-04 10:24:50.414', 'admin', null, null);
INSERT INTO "public"."tg_cms_m_ext_ad" VALUES ('66852d42-5feb-4e81-a138-b28032a7fa02', '2', '阿斯蒂芬', '2015-08-31 00:00:00', '2015-09-30 00:00:00', 'http://www.baidu.com', '阿斯蒂芬示范点', 'asdf', null, null, '1', '2015-09-04 10:26:37.632', 'admin', null, null);
INSERT INTO "public"."tg_cms_m_ext_ad" VALUES ('7a93e460-0c75-45d6-bb02-5631e2e743a3', '3', '讨厌讨厌', '2015-09-03 00:00:00', '2015-09-11 00:00:00', 'http://www.baidu.com', 'as发生', 'asdfsa', null, null, '1', '2015-09-04 10:28:02.007', 'admin', null, null);
INSERT INTO "public"."tg_cms_m_ext_ad" VALUES ('85853cfe-3901-4ddd-b4b1-0832cdd5b85e', '2', '王老吉', '2015-09-01 00:00:00', '2015-09-16 00:00:00', 'http://www.baidu.com', '还是原来的配方', 'asdfsdf', null, null, '1', '2015-09-04 10:07:18.554', 'admin', null, null);
INSERT INTO "public"."tg_cms_m_ext_ad" VALUES ('9b310b4f-090e-42c3-b970-d34382723005', '3', '三个傻瓜', '2015-09-01 00:00:00', '2015-09-02 00:00:00', 'http://www.baidu.com', '豆腐干', 'dgdg', null, null, '1', '2015-09-04 10:29:36.243', 'admin', null, null);
INSERT INTO "public"."tg_cms_m_ext_ad" VALUES ('a9b37446-6799-40dd-af11-60896a52885f', '2', '222', null, null, 'http://www.baidu.com', null, 'aas', 'd44cdce4-8352-4df1-ab90-91cbe9553dfd', 'b6033ad6-1977-42b4-aa96-47317402ea83', '1', '2015-09-06 18:58:25.931', 'admin', '2015-09-06 18:58:56.983', 'admin');
INSERT INTO "public"."tg_cms_m_ext_ad" VALUES ('ead787ed-705b-4be2-a62c-d94aec833724', '3', '根深蒂固', '2015-09-30 00:00:00', '2015-10-09 00:00:00', 'http://www.baidu.com', '豆腐干', 'sdfgd', null, null, '1', '2015-09-04 10:30:25.321', 'admin', null, null);

-- ----------------------------
-- Table structure for tg_cms_m_ext_ad_slot
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_cms_m_ext_ad_slot";
CREATE TABLE "public"."tg_cms_m_ext_ad_slot" (
"id" varchar(45) COLLATE "default" NOT NULL,
"slot_name" varchar(100) COLLATE "default" NOT NULL,
"code_num" varchar(100) COLLATE "default",
"slot_type" int2 NOT NULL,
"slot_template" varchar(255) COLLATE "default" NOT NULL,
"width" int4 NOT NULL,
"height" int4 NOT NULL,
"description" varchar(255) COLLATE "default",
"sort_order" int2 DEFAULT 1 NOT NULL,
"enabled" int2 DEFAULT 1 NOT NULL,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tg_cms_m_ext_ad_slot" IS '广告版位表';
COMMENT ON COLUMN "public"."tg_cms_m_ext_ad_slot"."id" IS '广告位';
COMMENT ON COLUMN "public"."tg_cms_m_ext_ad_slot"."slot_name" IS '名称';
COMMENT ON COLUMN "public"."tg_cms_m_ext_ad_slot"."code_num" IS '编码';
COMMENT ON COLUMN "public"."tg_cms_m_ext_ad_slot"."slot_type" IS '类型(1:文字,2:图片,3:FLASH,4:代码)';
COMMENT ON COLUMN "public"."tg_cms_m_ext_ad_slot"."slot_template" IS '模板';
COMMENT ON COLUMN "public"."tg_cms_m_ext_ad_slot"."width" IS '宽度';
COMMENT ON COLUMN "public"."tg_cms_m_ext_ad_slot"."height" IS '高度';
COMMENT ON COLUMN "public"."tg_cms_m_ext_ad_slot"."description" IS '描述';
COMMENT ON COLUMN "public"."tg_cms_m_ext_ad_slot"."sort_order" IS '排序';
COMMENT ON COLUMN "public"."tg_cms_m_ext_ad_slot"."enabled" IS '是否可用';

-- ----------------------------
-- Records of tg_cms_m_ext_ad_slot
-- ----------------------------
INSERT INTO "public"."tg_cms_m_ext_ad_slot" VALUES ('2', '顶部广告', 'top', '2', 'top', '200', '200', '顶部广告', '1', '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_ext_ad_slot" VALUES ('3', '底部广告', 'aa', '2', 'aa', '200', '200', '底部广告', '1', '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_ext_ad_slot" VALUES ('cc53bb61-e13d-4ee7-a58e-2601460e5151', '12312', '12', '4', '12', '12', '12', '12', '3', '1', null, null, '2016-05-17 18:00:27.42', 'admin');
INSERT INTO "public"."tg_cms_m_ext_ad_slot" VALUES ('f2f0438a-cc4d-4254-8357-9d19aaa26676', '123213', '12', '1', '12', '12', '12', '12', '1', '1', null, null, null, null);

-- ----------------------------
-- Table structure for tg_cms_m_ext_friendlink
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_cms_m_ext_friendlink";
CREATE TABLE "public"."tg_cms_m_ext_friendlink" (
"id" varchar(45) COLLATE "default" NOT NULL,
"type_id" varchar(45) COLLATE "default" NOT NULL,
"fl_name" varchar(100) COLLATE "default" NOT NULL,
"fl_url" varchar(255) COLLATE "default",
"fl_logo" varchar(255) COLLATE "default",
"fl_email" varchar(100) COLLATE "default",
"recommend" int2 NOT NULL,
"sort_order" int2 DEFAULT 1 NOT NULL,
"description" varchar(255) COLLATE "default",
"enabled" int2 DEFAULT 1 NOT NULL,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tg_cms_m_ext_friendlink" IS '友情链接表';
COMMENT ON COLUMN "public"."tg_cms_m_ext_friendlink"."id" IS '友情链接';
COMMENT ON COLUMN "public"."tg_cms_m_ext_friendlink"."type_id" IS '类型';
COMMENT ON COLUMN "public"."tg_cms_m_ext_friendlink"."fl_name" IS '网站名称';
COMMENT ON COLUMN "public"."tg_cms_m_ext_friendlink"."fl_url" IS '网站地址';
COMMENT ON COLUMN "public"."tg_cms_m_ext_friendlink"."fl_logo" IS '网站Logo';
COMMENT ON COLUMN "public"."tg_cms_m_ext_friendlink"."fl_email" IS '站长Email';
COMMENT ON COLUMN "public"."tg_cms_m_ext_friendlink"."recommend" IS '是否推荐';
COMMENT ON COLUMN "public"."tg_cms_m_ext_friendlink"."sort_order" IS '排序';
COMMENT ON COLUMN "public"."tg_cms_m_ext_friendlink"."description" IS '网站描述';
COMMENT ON COLUMN "public"."tg_cms_m_ext_friendlink"."enabled" IS '状态 1启用 2停用';

-- ----------------------------
-- Records of tg_cms_m_ext_friendlink
-- ----------------------------
INSERT INTO "public"."tg_cms_m_ext_friendlink" VALUES ('02df1f47-c03d-4483-8e3f-9c8c8aa63051', '5', '21', 'http://www.fengye.com', null, null, '2', '23', null, '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_ext_friendlink" VALUES ('0955290c-83a5-4d4b-9d04-db68e51c12e5', '6', '123', '123', '123', '123', '1', '13', '123', '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_ext_friendlink" VALUES ('1', 'dac4f264-18e8-4fb3-9e1d-067fceebd4b0', '搜狐网络2121', 'http://www.bugs.com', null, '111@qq.com', '2', '1', '编辑修改拉萨放松点发来打扫房间阿斯蒂芬垃圾阿斯蒂芬了接撒代理费121', '1', null, null, '2015-08-12 09:37:51.215', 'admin');
INSERT INTO "public"."tg_cms_m_ext_friendlink" VALUES ('10', '5', '项目合作2', 'http://www.renren.com', '2341e685-a180-4265-b7dc-8a4231f8d188', '123@qq.com', '2', '10', null, '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_ext_friendlink" VALUES ('20dcf9dc-b925-451b-8ed8-fed3b347b26b', '5', '百度', 'http://www.baidu.com', '3db98de0-0133-4f59-9e57-32a0c3ec428d', 'baidu@qq.com', '1', '27', null, '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_ext_friendlink" VALUES ('3a9b0ef1-4cdd-44cb-a5cc-ae2e65c13bf8', 'dac4f264-18e8-4fb3-9e1d-067fceebd4b0', '333', 'http://www.b', null, '123@qq.com', '2', '30', '333333', '2', null, null, '2015-09-04 11:01:35.767', 'admin');
INSERT INTO "public"."tg_cms_m_ext_friendlink" VALUES ('54f25fb0-27a7-499b-8ec7-c6fdf3e16368', 'dac4f264-18e8-4fb3-9e1d-067fceebd4b0', '撒旦发射的', 'www.baidu.com', null, 'asdfsf@qq.cm', '1', '2', 'sfsafsdfsffsfsdfsdf', '1', '2015-08-12 09:18:42.302', 'admin', null, null);
INSERT INTO "public"."tg_cms_m_ext_friendlink" VALUES ('5bd8725f-ab68-46f9-96ca-ad6ec7dfc424', 'dac4f264-18e8-4fb3-9e1d-067fceebd4b0', 'sd', null, '72af963d-8202-4741-86c7-da6e765b1110', null, '1', '1', null, '1', '2015-09-06 18:49:24.27', 'admin', '2015-09-06 18:49:57.759', 'admin');
INSERT INTO "public"."tg_cms_m_ext_friendlink" VALUES ('660b9dc1-ff2b-4e13-bec0-ee399825ea2e', 'dac4f264-18e8-4fb3-9e1d-067fceebd4b0', '优衣库', 'http://www.baidu.com', null, '4565@qq.com', '1', '5', 'ad抒发抒发抒发刮大风', '1', '2015-08-12 09:33:06.696', 'admin', null, null);
INSERT INTO "public"."tg_cms_m_ext_friendlink" VALUES ('6b84f3ca-181f-4321-af69-1710bb3efe7a', 'dac4f264-18e8-4fb3-9e1d-067fceebd4b0', '33', 'http://qq.com', null, null, '1', '2', null, '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_ext_friendlink" VALUES ('8c3a86fe-7ed6-41e5-a1a5-94e6be896d6f', 'dac4f264-18e8-4fb3-9e1d-067fceebd4b0', '优衣库111', 'www.baidu.com', null, '4565@qq.com', '1', '5', '地方萨嘎短发发生', '1', '2015-08-12 09:29:34.04', 'admin', null, null);
INSERT INTO "public"."tg_cms_m_ext_friendlink" VALUES ('a241b02c-9a53-4042-a589-b33366ab314c', '6', '天堂鸟', 'www.baidu.com', null, '4646@ss.com', '1', '2', '卡死地方咯额的方法', '1', '2015-08-12 09:17:15.623', 'admin', null, null);
INSERT INTO "public"."tg_cms_m_ext_friendlink" VALUES ('a85e7cc0-74bc-491a-b967-36ae18655fcd', '5', 'aaaaaa', 'http://www.baidu.com', null, '111@qq.com', '2', '29', '123123', '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_ext_friendlink" VALUES ('cdffbe83-3883-4aff-a6d8-7ed8fe3b139c', '5', '123', '123', null, '123', '1', '28', '123', '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_ext_friendlink" VALUES ('ff0f0bc5-6ee1-4bd2-8e2b-b01211539b73', '5', '312', '3213', '123', '123', '2', '26', '123', '2', null, null, null, null);

-- ----------------------------
-- Table structure for tg_cms_m_ext_friendlink_type
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_cms_m_ext_friendlink_type";
CREATE TABLE "public"."tg_cms_m_ext_friendlink_type" (
"id" varchar(45) COLLATE "default" NOT NULL,
"type_name" varchar(100) COLLATE "default" NOT NULL,
"code_num" varchar(100) COLLATE "default",
"description" varchar(255) COLLATE "default",
"sort_order" int2 DEFAULT 1 NOT NULL,
"enabled" int2 DEFAULT 1 NOT NULL,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."tg_cms_m_ext_friendlink_type"."id" IS '友情链接类型';
COMMENT ON COLUMN "public"."tg_cms_m_ext_friendlink_type"."type_name" IS '名称';
COMMENT ON COLUMN "public"."tg_cms_m_ext_friendlink_type"."code_num" IS '编码';
COMMENT ON COLUMN "public"."tg_cms_m_ext_friendlink_type"."description" IS '描述';
COMMENT ON COLUMN "public"."tg_cms_m_ext_friendlink_type"."sort_order" IS '排序';
COMMENT ON COLUMN "public"."tg_cms_m_ext_friendlink_type"."enabled" IS '是否可用';

-- ----------------------------
-- Records of tg_cms_m_ext_friendlink_type
-- ----------------------------
INSERT INTO "public"."tg_cms_m_ext_friendlink_type" VALUES ('630e885f47f947f79febae74cd7eafca', '合作企业', 'hezuo', '合作企业', '1', '1', null, null, '2016-05-17 15:18:49.281', 'admin');
INSERT INTO "public"."tg_cms_m_ext_friendlink_type" VALUES ('dc6a03e85cc34608a12843a74246a3bf', '重要客户', 'kehu', '重要客户', '2', '1', null, null, '2016-05-17 15:21:49.553', 'admin');

-- ----------------------------
-- Table structure for tg_cms_m_ext_guestbook
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_cms_m_ext_guestbook";
CREATE TABLE "public"."tg_cms_m_ext_guestbook" (
"id" varchar(45) COLLATE "default" NOT NULL,
"type_id" varchar(45) COLLATE "default" NOT NULL,
"replyer_id" varchar(45) COLLATE "default",
"title" varchar(150) COLLATE "default",
"gb_content" text COLLATE "default",
"create_ip" varchar(100) COLLATE "default" NOT NULL,
"reply_content" text COLLATE "default",
"reply_time" timestamp(6),
"reply_ip" varchar(100) COLLATE "default",
"replyed" int2 NOT NULL,
"recommend" int2 NOT NULL,
"username" varchar(100) COLLATE "default",
"gender" int2,
"telephone_num" varchar(100) COLLATE "default",
"cellphone_num" varchar(100) COLLATE "default",
"qq" varchar(100) COLLATE "default",
"email" varchar(100) COLLATE "default",
"state" int2 NOT NULL,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default",
"gb_date" timestamp(6)
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tg_cms_m_ext_guestbook" IS '留言板表';
COMMENT ON COLUMN "public"."tg_cms_m_ext_guestbook"."id" IS '留言板';
COMMENT ON COLUMN "public"."tg_cms_m_ext_guestbook"."type_id" IS '留言类型';
COMMENT ON COLUMN "public"."tg_cms_m_ext_guestbook"."replyer_id" IS '回复者';
COMMENT ON COLUMN "public"."tg_cms_m_ext_guestbook"."title" IS '留言标题';
COMMENT ON COLUMN "public"."tg_cms_m_ext_guestbook"."gb_content" IS '留言内容';
COMMENT ON COLUMN "public"."tg_cms_m_ext_guestbook"."create_ip" IS '留言IP';
COMMENT ON COLUMN "public"."tg_cms_m_ext_guestbook"."reply_content" IS '回复内容';
COMMENT ON COLUMN "public"."tg_cms_m_ext_guestbook"."reply_time" IS '回复日期';
COMMENT ON COLUMN "public"."tg_cms_m_ext_guestbook"."reply_ip" IS '回复IP';
COMMENT ON COLUMN "public"."tg_cms_m_ext_guestbook"."replyed" IS '是否回复';
COMMENT ON COLUMN "public"."tg_cms_m_ext_guestbook"."recommend" IS '是否推荐';
COMMENT ON COLUMN "public"."tg_cms_m_ext_guestbook"."username" IS '用户名';
COMMENT ON COLUMN "public"."tg_cms_m_ext_guestbook"."gender" IS '性别';
COMMENT ON COLUMN "public"."tg_cms_m_ext_guestbook"."telephone_num" IS '电话';
COMMENT ON COLUMN "public"."tg_cms_m_ext_guestbook"."cellphone_num" IS '手机';
COMMENT ON COLUMN "public"."tg_cms_m_ext_guestbook"."qq" IS 'QQ号码';
COMMENT ON COLUMN "public"."tg_cms_m_ext_guestbook"."email" IS '电子邮箱';
COMMENT ON COLUMN "public"."tg_cms_m_ext_guestbook"."state" IS '状态(1:已审核,2:屏蔽,10:未审核)';

-- ----------------------------
-- Records of tg_cms_m_ext_guestbook
-- ----------------------------
INSERT INTO "public"."tg_cms_m_ext_guestbook" VALUES ('2', '2', 'a1498eba-536b-4c20-a612-286319468318', '测试', '测试', '1', '您已通过审核', '2015-09-02 00:00:00', '192.168.1.111', '1', '2', '测试name', '0', '1', '1', '1', '1', '1', '2015-09-03 10:40:29', null, '2015-09-04 15:47:21.564', 'admin', '2015-09-01 10:40:37');

-- ----------------------------
-- Table structure for tg_cms_m_ext_guestbook_type
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_cms_m_ext_guestbook_type";
CREATE TABLE "public"."tg_cms_m_ext_guestbook_type" (
"id" varchar(45) COLLATE "default" NOT NULL,
"type_name" varchar(100) COLLATE "default" NOT NULL,
"code_num" varchar(100) COLLATE "default",
"description" varchar(255) COLLATE "default",
"sort_order" int2 DEFAULT 1 NOT NULL,
"open_type" int2 DEFAULT 1 NOT NULL,
"verify_type" int2 DEFAULT 1 NOT NULL,
"captcha_type" int2 DEFAULT 1 NOT NULL,
"max_length" int4 NOT NULL,
"enabled" int2 DEFAULT 1 NOT NULL,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tg_cms_m_ext_guestbook_type" IS '留言板类型表';
COMMENT ON COLUMN "public"."tg_cms_m_ext_guestbook_type"."id" IS '留言板';
COMMENT ON COLUMN "public"."tg_cms_m_ext_guestbook_type"."type_name" IS '名称';
COMMENT ON COLUMN "public"."tg_cms_m_ext_guestbook_type"."code_num" IS '编码';
COMMENT ON COLUMN "public"."tg_cms_m_ext_guestbook_type"."description" IS '描述';
COMMENT ON COLUMN "public"."tg_cms_m_ext_guestbook_type"."sort_order" IS '排序';
COMMENT ON COLUMN "public"."tg_cms_m_ext_guestbook_type"."open_type" IS '开放模式';
COMMENT ON COLUMN "public"."tg_cms_m_ext_guestbook_type"."verify_type" IS '审核模式';
COMMENT ON COLUMN "public"."tg_cms_m_ext_guestbook_type"."captcha_type" IS '验证码模式';
COMMENT ON COLUMN "public"."tg_cms_m_ext_guestbook_type"."max_length" IS '最大长度';
COMMENT ON COLUMN "public"."tg_cms_m_ext_guestbook_type"."enabled" IS '是否可用';

-- ----------------------------
-- Records of tg_cms_m_ext_guestbook_type
-- ----------------------------
INSERT INTO "public"."tg_cms_m_ext_guestbook_type" VALUES ('2', '问题反馈', 'fankui1', 'ddd', '2', '3', '1', '1', '500', '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_ext_guestbook_type" VALUES ('955e475b-f2b9-4f99-b483-9b17dfd6607a', '1235', '123', '123', '1', '1', '2', '1', '12', '1', null, null, null, null);

-- ----------------------------
-- Table structure for tg_cms_m_ext_question
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_cms_m_ext_question";
CREATE TABLE "public"."tg_cms_m_ext_question" (
"id" varchar(45) COLLATE "default" NOT NULL,
"code_num" varchar(100) COLLATE "default",
"title" varchar(150) COLLATE "default" NOT NULL,
"description" varchar(255) COLLATE "default",
"start_time" timestamp(6),
"end_time" timestamp(6),
"mode" int2 NOT NULL,
"total_count" int4 NOT NULL,
"enabled" int2 NOT NULL,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tg_cms_m_ext_question" IS '调查问卷表';
COMMENT ON COLUMN "public"."tg_cms_m_ext_question"."id" IS '调查问卷';
COMMENT ON COLUMN "public"."tg_cms_m_ext_question"."code_num" IS '代码';
COMMENT ON COLUMN "public"."tg_cms_m_ext_question"."title" IS '标题';
COMMENT ON COLUMN "public"."tg_cms_m_ext_question"."description" IS '描述';
COMMENT ON COLUMN "public"."tg_cms_m_ext_question"."start_time" IS '开始日期';
COMMENT ON COLUMN "public"."tg_cms_m_ext_question"."end_time" IS '结束日期';
COMMENT ON COLUMN "public"."tg_cms_m_ext_question"."mode" IS '模式(1:独立访客,2:独立IP,3:独立用户)';
COMMENT ON COLUMN "public"."tg_cms_m_ext_question"."total_count" IS '总票数';
COMMENT ON COLUMN "public"."tg_cms_m_ext_question"."enabled" IS '状态';

-- ----------------------------
-- Records of tg_cms_m_ext_question
-- ----------------------------
INSERT INTO "public"."tg_cms_m_ext_question" VALUES ('07d62e57-0df4-44e4-8327-4b10f8d42652', '123', '啊实打实', null, '2015-06-02 00:00:00', null, '1', '12', '1', null, null, '2015-09-04 16:28:03.459', 'admin');
INSERT INTO "public"."tg_cms_m_ext_question" VALUES ('8a0832b5-f36b-4609-afc1-6966dc560a0e', '3', '3', null, '2015-09-16 00:00:00', '2015-09-02 00:00:00', '1', '0', '1', '2015-09-04 16:04:35.764', 'admin', '2015-09-04 16:04:54.058', 'admin');

-- ----------------------------
-- Table structure for tg_cms_m_ext_question_item
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_cms_m_ext_question_item";
CREATE TABLE "public"."tg_cms_m_ext_question_item" (
"id" varchar(45) COLLATE "default" NOT NULL,
"question_id" varchar(45) COLLATE "default" NOT NULL,
"title" varchar(150) COLLATE "default" NOT NULL,
"type" int2 DEFAULT 1,
"max_selected" int2 NOT NULL,
"sort_order" int2 NOT NULL,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tg_cms_m_ext_question_item" IS '调查问卷项表';
COMMENT ON COLUMN "public"."tg_cms_m_ext_question_item"."id" IS '调查问卷项';
COMMENT ON COLUMN "public"."tg_cms_m_ext_question_item"."title" IS '标题';
COMMENT ON COLUMN "public"."tg_cms_m_ext_question_item"."type" IS '类型 1选择 2问答';
COMMENT ON COLUMN "public"."tg_cms_m_ext_question_item"."max_selected" IS '最多可选几项(0不限制)';
COMMENT ON COLUMN "public"."tg_cms_m_ext_question_item"."sort_order" IS '排序';

-- ----------------------------
-- Records of tg_cms_m_ext_question_item
-- ----------------------------
INSERT INTO "public"."tg_cms_m_ext_question_item" VALUES ('3cb17271-fb6c-4e48-a05e-705111495b41', '07d62e57-0df4-44e4-8327-4b10f8d42652', '1', '1', '0', '1', '2015-09-06 09:51:47.007', null, null, null);
INSERT INTO "public"."tg_cms_m_ext_question_item" VALUES ('570b1241-08ca-4f11-9536-668ca3dc59a0', '07d62e57-0df4-44e4-8327-4b10f8d42652', '2', '1', '0', '1', '2015-09-06 09:55:49.43', null, null, null);

-- ----------------------------
-- Table structure for tg_cms_m_ext_question_option
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_cms_m_ext_question_option";
CREATE TABLE "public"."tg_cms_m_ext_question_option" (
"id" varchar(45) COLLATE "default" NOT NULL,
"item_id" varchar(45) COLLATE "default" NOT NULL,
"title" varchar(150) COLLATE "default",
"input_field" char(1) COLLATE "default" NOT NULL,
"select_count" int4 DEFAULT 0 NOT NULL,
"sort_order" int2 DEFAULT 1 NOT NULL,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tg_cms_m_ext_question_option" IS '调查问卷选项表';
COMMENT ON COLUMN "public"."tg_cms_m_ext_question_option"."id" IS '调查问卷选项';
COMMENT ON COLUMN "public"."tg_cms_m_ext_question_option"."title" IS '标题';
COMMENT ON COLUMN "public"."tg_cms_m_ext_question_option"."input_field" IS '是否输入框';
COMMENT ON COLUMN "public"."tg_cms_m_ext_question_option"."select_count" IS '得票数';
COMMENT ON COLUMN "public"."tg_cms_m_ext_question_option"."sort_order" IS '排序';

-- ----------------------------
-- Records of tg_cms_m_ext_question_option
-- ----------------------------
INSERT INTO "public"."tg_cms_m_ext_question_option" VALUES ('547f3869-5ff3-4f05-8d28-6c362243c0f8', '3cb17271-fb6c-4e48-a05e-705111495b41', '1', '1', '0', '1', '2015-09-06 10:50:42.509', null, null, null);

-- ----------------------------
-- Table structure for tg_cms_m_ext_question_record
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_cms_m_ext_question_record";
CREATE TABLE "public"."tg_cms_m_ext_question_record" (
"id" varchar(45) COLLATE "default" NOT NULL,
"ip" varchar(100) COLLATE "default" NOT NULL,
"cookie" varchar(100) COLLATE "default" NOT NULL,
"content" varchar(200) COLLATE "default",
"user_id" varchar(45) COLLATE "default",
"question_id" varchar(45) COLLATE "default" NOT NULL,
"option_id" varchar(45) COLLATE "default",
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tg_cms_m_ext_question_record" IS '调查问卷记录表';
COMMENT ON COLUMN "public"."tg_cms_m_ext_question_record"."id" IS '问卷调查记录';
COMMENT ON COLUMN "public"."tg_cms_m_ext_question_record"."ip" IS 'IP';
COMMENT ON COLUMN "public"."tg_cms_m_ext_question_record"."cookie" IS 'Cookie';
COMMENT ON COLUMN "public"."tg_cms_m_ext_question_record"."content" IS '内容';

-- ----------------------------
-- Records of tg_cms_m_ext_question_record
-- ----------------------------

-- ----------------------------
-- Table structure for tg_cms_m_ext_score_group
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_cms_m_ext_score_group";
CREATE TABLE "public"."tg_cms_m_ext_score_group" (
"id" varchar(45) COLLATE "default" NOT NULL,
"group_name" varchar(100) COLLATE "default" NOT NULL,
"code_num" varchar(100) COLLATE "default",
"description" varchar(255) COLLATE "default",
"sort_order" int2 DEFAULT 1 NOT NULL,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tg_cms_m_ext_score_group" IS '计分组表';
COMMENT ON COLUMN "public"."tg_cms_m_ext_score_group"."id" IS '计分组';
COMMENT ON COLUMN "public"."tg_cms_m_ext_score_group"."group_name" IS '名称';
COMMENT ON COLUMN "public"."tg_cms_m_ext_score_group"."code_num" IS '代码';
COMMENT ON COLUMN "public"."tg_cms_m_ext_score_group"."description" IS '描述';
COMMENT ON COLUMN "public"."tg_cms_m_ext_score_group"."sort_order" IS '排序';

-- ----------------------------
-- Records of tg_cms_m_ext_score_group
-- ----------------------------
INSERT INTO "public"."tg_cms_m_ext_score_group" VALUES ('a0b68702-c140-426a-a6c8-b6bd0628febb', '2', '2', '2', '1', '2015-09-06 18:55:16.833', 'admin', null, null);

-- ----------------------------
-- Table structure for tg_cms_m_ext_score_item
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_cms_m_ext_score_item";
CREATE TABLE "public"."tg_cms_m_ext_score_item" (
"id" varchar(45) COLLATE "default" NOT NULL,
"group_id" varchar(45) COLLATE "default" NOT NULL,
"item_name" varchar(100) COLLATE "default" NOT NULL,
"score" int4 DEFAULT 0 NOT NULL,
"icon" varchar(255) COLLATE "default",
"sort_order" int2 DEFAULT 1 NOT NULL,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tg_cms_m_ext_score_item" IS '计分项表';
COMMENT ON COLUMN "public"."tg_cms_m_ext_score_item"."id" IS '计分项';
COMMENT ON COLUMN "public"."tg_cms_m_ext_score_item"."group_id" IS '计分组';
COMMENT ON COLUMN "public"."tg_cms_m_ext_score_item"."item_name" IS '名称';
COMMENT ON COLUMN "public"."tg_cms_m_ext_score_item"."score" IS '分值';
COMMENT ON COLUMN "public"."tg_cms_m_ext_score_item"."icon" IS '图标';
COMMENT ON COLUMN "public"."tg_cms_m_ext_score_item"."sort_order" IS '排序';

-- ----------------------------
-- Records of tg_cms_m_ext_score_item
-- ----------------------------
INSERT INTO "public"."tg_cms_m_ext_score_item" VALUES ('1', '1', '1111', '1', null, '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_ext_score_item" VALUES ('6ef4cc66-09cf-4851-abfa-35e5fff05861', 'a0b68702-c140-426a-a6c8-b6bd0628febb', '22', '3', 'f0a9942c-c7ab-4a62-bf1b-826fa3b9bb69', '1', '2015-09-06 18:55:32.98', null, '2015-10-27 15:27:09.137', null);
INSERT INTO "public"."tg_cms_m_ext_score_item" VALUES ('9b082f30-615e-46aa-a9bb-789be8c0553d', '1', '12', '12', null, '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_ext_score_item" VALUES ('a3f0264f-a0aa-4bb7-90a2-f9f3fa7308e7', 'f480bce9-b795-4e80-9af3-78ce6fadb04d', 'c3', '33', null, '1', '2015-09-04 15:17:39.462', null, '2015-09-04 15:27:22.237', null);
INSERT INTO "public"."tg_cms_m_ext_score_item" VALUES ('c49d61cd-fd90-4db6-83a9-25aa29a6cc2b', 'f480bce9-b795-4e80-9af3-78ce6fadb04d', '123', '1', null, '1', null, null, '2015-09-04 15:27:15.965', null);

-- ----------------------------
-- Table structure for tg_cms_m_ext_score_record
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_cms_m_ext_score_record";
CREATE TABLE "public"."tg_cms_m_ext_score_record" (
"id" varchar(45) COLLATE "default" NOT NULL,
"score_item_id" varchar(45) COLLATE "default" NOT NULL,
"votes_count" int4 NOT NULL,
"owner_type" varchar(50) COLLATE "default" NOT NULL,
"owner_id" int4 NOT NULL,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tg_cms_m_ext_score_record" IS '计分牌表';
COMMENT ON COLUMN "public"."tg_cms_m_ext_score_record"."id" IS '计分牌';
COMMENT ON COLUMN "public"."tg_cms_m_ext_score_record"."score_item_id" IS '记分项';
COMMENT ON COLUMN "public"."tg_cms_m_ext_score_record"."votes_count" IS '投票次数';
COMMENT ON COLUMN "public"."tg_cms_m_ext_score_record"."owner_type" IS '外表标识';
COMMENT ON COLUMN "public"."tg_cms_m_ext_score_record"."owner_id" IS '外表ID';

-- ----------------------------
-- Records of tg_cms_m_ext_score_record
-- ----------------------------

-- ----------------------------
-- Table structure for tg_cms_m_ext_vote
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_cms_m_ext_vote";
CREATE TABLE "public"."tg_cms_m_ext_vote" (
"id" varchar(45) COLLATE "default" NOT NULL,
"title" varchar(150) COLLATE "default" NOT NULL,
"code_num" varchar(100) COLLATE "default",
"start_time" timestamp(6),
"end_time" timestamp(6),
"interval_days" int4 NOT NULL,
"max_selected" int2 DEFAULT 0 NOT NULL,
"vote_mode" int2 NOT NULL,
"total_count" int4 DEFAULT 0 NOT NULL,
"description" varchar(255) COLLATE "default",
"sort_order" int2 DEFAULT 1 NOT NULL,
"enabled" int2 DEFAULT 1 NOT NULL,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tg_cms_m_ext_vote" IS '投票表';
COMMENT ON COLUMN "public"."tg_cms_m_ext_vote"."id" IS '投票';
COMMENT ON COLUMN "public"."tg_cms_m_ext_vote"."title" IS '标题';
COMMENT ON COLUMN "public"."tg_cms_m_ext_vote"."code_num" IS '编码';
COMMENT ON COLUMN "public"."tg_cms_m_ext_vote"."start_time" IS '开始日期';
COMMENT ON COLUMN "public"."tg_cms_m_ext_vote"."end_time" IS '结束日期';
COMMENT ON COLUMN "public"."tg_cms_m_ext_vote"."interval_days" IS '间隔时间（天）';
COMMENT ON COLUMN "public"."tg_cms_m_ext_vote"."max_selected" IS '最多可选几项(0不限制)';
COMMENT ON COLUMN "public"."tg_cms_m_ext_vote"."vote_mode" IS '模式(1:独立访客,2:独立IP,3:独立用户)';
COMMENT ON COLUMN "public"."tg_cms_m_ext_vote"."total_count" IS '总票数';
COMMENT ON COLUMN "public"."tg_cms_m_ext_vote"."description" IS '描述';
COMMENT ON COLUMN "public"."tg_cms_m_ext_vote"."sort_order" IS '排序';
COMMENT ON COLUMN "public"."tg_cms_m_ext_vote"."enabled" IS '状态(1:启用,2:禁用)';

-- ----------------------------
-- Records of tg_cms_m_ext_vote
-- ----------------------------
INSERT INTO "public"."tg_cms_m_ext_vote" VALUES ('1cdc5c29-8694-443d-9d0c-d74502517f9c', '11', '11', '2015-10-06 00:00:00', '2015-07-06 00:00:00', '11', '11', '1', '0', '111', '1', '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_ext_vote" VALUES ('260a9657-06f7-4fe9-877d-3beb0e501fb8', '321', '321', null, null, '3', '3', '1', '0', '3', '1', '1', null, null, '2015-09-04 16:36:26.323', 'admin');
INSERT INTO "public"."tg_cms_m_ext_vote" VALUES ('396bae86-8a76-4a33-8d2d-efb464dbb8a6', '1111111111111111111', '11', '2015-05-13 00:00:00', null, '1', '1', '1', '0', '1212', '8', '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_ext_vote" VALUES ('7cd23a59-df5a-4609-bdfd-4f3eb746fb82', '12311', '12312', '2015-03-31 00:00:00', '2015-04-15 00:00:00', '12', '12', '2', '0', '123123', '1', '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_ext_vote" VALUES ('829a93f5-7755-4895-955b-8c2f81e046d1', '44444444444444', '444', null, null, '444', '4', '1', '0', '444', '6', '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_ext_vote" VALUES ('8eeccb2b-94ea-430e-9423-7be12e04f62e', '今天天气好吗', '10010', null, null, '0', '1', '1', '0', null, '1', '1', '2015-09-04 11:55:22.303', 'admin', '2015-09-04 12:13:44.288', 'admin');
INSERT INTO "public"."tg_cms_m_ext_vote" VALUES ('9c0a278e-8fd4-4eaa-bb00-757062a3ce8e', '33332', '333', null, '2015-04-14 00:00:00', '3', '3', '1', '0', '3', '1', '1', null, null, null, null);

-- ----------------------------
-- Table structure for tg_cms_m_ext_vote_mark
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_cms_m_ext_vote_mark";
CREATE TABLE "public"."tg_cms_m_ext_vote_mark" (
"id" varchar(45) COLLATE "default" NOT NULL,
"create_time" timestamp(6) NOT NULL,
"vote_opention_id" varchar(45) COLLATE "default" NOT NULL,
"user_id" varchar(45) COLLATE "default",
"user_ip" varchar(100) COLLATE "default",
"user_cookie" varchar(255) COLLATE "default",
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tg_cms_m_ext_vote_mark" IS '投票标记表';
COMMENT ON COLUMN "public"."tg_cms_m_ext_vote_mark"."id" IS '投票标记';
COMMENT ON COLUMN "public"."tg_cms_m_ext_vote_mark"."create_time" IS '日期';
COMMENT ON COLUMN "public"."tg_cms_m_ext_vote_mark"."user_id" IS '用户';
COMMENT ON COLUMN "public"."tg_cms_m_ext_vote_mark"."user_ip" IS 'IP';
COMMENT ON COLUMN "public"."tg_cms_m_ext_vote_mark"."user_cookie" IS 'Cookie';

-- ----------------------------
-- Records of tg_cms_m_ext_vote_mark
-- ----------------------------

-- ----------------------------
-- Table structure for tg_cms_m_ext_vote_option
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_cms_m_ext_vote_option";
CREATE TABLE "public"."tg_cms_m_ext_vote_option" (
"id" varchar(45) COLLATE "default" NOT NULL,
"vote_id" varchar(45) COLLATE "default" NOT NULL,
"title" varchar(150) COLLATE "default" NOT NULL,
"vote_count" int4 NOT NULL,
"description" varchar(255) COLLATE "default",
"sort_order" int2 NOT NULL,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tg_cms_m_ext_vote_option" IS '投票项表';
COMMENT ON COLUMN "public"."tg_cms_m_ext_vote_option"."id" IS '投票项表';
COMMENT ON COLUMN "public"."tg_cms_m_ext_vote_option"."title" IS '标题';
COMMENT ON COLUMN "public"."tg_cms_m_ext_vote_option"."vote_count" IS '得票数';
COMMENT ON COLUMN "public"."tg_cms_m_ext_vote_option"."description" IS '描述';
COMMENT ON COLUMN "public"."tg_cms_m_ext_vote_option"."sort_order" IS '排序';

-- ----------------------------
-- Records of tg_cms_m_ext_vote_option
-- ----------------------------
INSERT INTO "public"."tg_cms_m_ext_vote_option" VALUES ('036f3050-1c38-4278-a33d-9d58ad34b9da', '5c3fc24a-b989-47fa-8855-afa05708dcd2', '123', '1231', '23123', '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_ext_vote_option" VALUES ('1', '5c3fc24a-b989-47fa-8855-afa05708dcd2', '123', '10', '123123', '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_ext_vote_option" VALUES ('239c569e-7973-4188-98e0-eb32263c69be', '7cd23a59-df5a-4609-bdfd-4f3eb746fb82', 'aaaaa', '15', '123', '1', null, null, '2015-09-04 16:39:30.328', null);
INSERT INTO "public"."tg_cms_m_ext_vote_option" VALUES ('a1162e38-89f2-47e1-8ce9-f13699add49f', '7cd23a59-df5a-4609-bdfd-4f3eb746fb82', 'bbbbbbbb', '12', null, '1', '2015-09-04 16:39:41.637', null, null, null);
INSERT INTO "public"."tg_cms_m_ext_vote_option" VALUES ('d190026e-ac02-4e2d-80e5-370c7c899148', '260a9657-06f7-4fe9-877d-3beb0e501fb8', '实得分公司', '241', '的分公司', '1', null, null, null, null);
INSERT INTO "public"."tg_cms_m_ext_vote_option" VALUES ('d434d0be-1e15-4a43-8731-f42c93d7e63c', '5c3fc24a-b989-47fa-8855-afa05708dcd2', '123', '312', '123', '1', null, null, null, null);

-- ----------------------------
-- Table structure for tg_cms_m_plug_resume
-- ----------------------------
DROP TABLE IF EXISTS "public"."tg_cms_m_plug_resume";
CREATE TABLE "public"."tg_cms_m_plug_resume" (
"id" varchar(45) COLLATE "default" NOT NULL,
"username" varchar(100) COLLATE "default" NOT NULL,
"apply_post" varchar(100) COLLATE "default" NOT NULL,
"gender" int2 NOT NULL,
"birthday" timestamp(6),
"cellphone_num" varchar(100) COLLATE "default",
"email" varchar(100) COLLATE "default",
"expected_salary" int4,
"education_experience" text COLLATE "default",
"work_experience" text COLLATE "default",
"remarks" text COLLATE "default",
"state" int2,
"create_data_time" timestamp(6),
"create_data_username" varchar(45) COLLATE "default",
"update_data_time" timestamp(6),
"update_data_username" varchar(45) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tg_cms_m_plug_resume" IS '简历表';
COMMENT ON COLUMN "public"."tg_cms_m_plug_resume"."id" IS '招聘';
COMMENT ON COLUMN "public"."tg_cms_m_plug_resume"."username" IS '姓名';
COMMENT ON COLUMN "public"."tg_cms_m_plug_resume"."apply_post" IS '应聘职位';
COMMENT ON COLUMN "public"."tg_cms_m_plug_resume"."gender" IS '性别';
COMMENT ON COLUMN "public"."tg_cms_m_plug_resume"."birthday" IS '出生日期';
COMMENT ON COLUMN "public"."tg_cms_m_plug_resume"."cellphone_num" IS '手机';
COMMENT ON COLUMN "public"."tg_cms_m_plug_resume"."email" IS '邮箱';
COMMENT ON COLUMN "public"."tg_cms_m_plug_resume"."expected_salary" IS '期望薪水';
COMMENT ON COLUMN "public"."tg_cms_m_plug_resume"."education_experience" IS '教育经历';
COMMENT ON COLUMN "public"."tg_cms_m_plug_resume"."work_experience" IS '工作经历';
COMMENT ON COLUMN "public"."tg_cms_m_plug_resume"."remarks" IS '备注';
COMMENT ON COLUMN "public"."tg_cms_m_plug_resume"."state" IS '1通过，2不通过10待审批';

-- ----------------------------
-- Records of tg_cms_m_plug_resume
-- ----------------------------

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table tg_c_attachment
-- ----------------------------
ALTER TABLE "public"."tg_c_attachment" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table tg_c_dict
-- ----------------------------
CREATE UNIQUE INDEX "id_UNIQUE" ON "public"."tg_c_dict" USING btree ("id");

-- ----------------------------
-- Primary Key structure for table tg_c_dict
-- ----------------------------
ALTER TABLE "public"."tg_c_dict" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table tg_c_resource
-- ----------------------------
ALTER TABLE "public"."tg_c_resource" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table tg_c_role
-- ----------------------------
ALTER TABLE "public"."tg_c_role" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table tg_c_role_resource
-- ----------------------------
ALTER TABLE "public"."tg_c_role_resource" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table tg_cms_m_ext_friendlink_type
-- ----------------------------
ALTER TABLE "public"."tg_cms_m_ext_friendlink_type" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table tg_cms_m_ext_guestbook_type
-- ----------------------------
ALTER TABLE "public"."tg_cms_m_ext_guestbook_type" ADD PRIMARY KEY ("id");
