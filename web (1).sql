-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.27-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.4.0.6659
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping data for table project.author: ~4 rows (approximately)
CREATE TABLE `author` (
	`authorCode` VARCHAR(255) NOT NULL COLLATE 'utf8mb4_general_ci',
	`authorNames` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`dateOfBirth` DATETIME(6) NULL DEFAULT NULL,
	`sex` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`story` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	PRIMARY KEY (`authorCode`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;

INSERT INTO `author` (`authorCode`, `authorNames`, `dateOfBirth`, `sex`, `story`) VALUES
	('1', 'Nguyễn Xuân Hòa', '2004-05-24 00:00:00.000000', 'Nam', 'Là 1 chàng trai ok'),
	('2', 'Nguyễn Văn A', '2023-05-02 23:46:44.000000', 'Nam', 'Là 1 dev bần'),
	('3', 'Alexandre Dumas', '1843-05-24 00:00:00.000000', 'Nam', 'Là nhà tiểu thuyết và viết kịch nổi tiếng của Pháp. Trà hoa nữ được viết khi ông hai mươi tư tuổi, là tác phẩm đầu tiên khẳng định tài năng và đã đem lại vinh quang rực rỡ cho Alexandre Dumas con.'),
	('4', 'R. L. Stine', '1943-05-24 00:00:00.000000', 'Nam', 'Là 1 chàng trai ok');


CREATE TABLE `category` (
	`categoryCode` VARCHAR(255) NOT NULL COLLATE 'utf8mb4_general_ci',
	`categoryName` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	PRIMARY KEY (`categoryCode`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;
-- Dumping data for table project.category: ~2 rows (approximately)
INSERT INTO `category` (`categoryCode`, `categoryName`) VALUES
	('cate1', 'sách'),
	('cate2', 'truyện');
CREATE TABLE `client` (
	`clientCode` VARCHAR(255) NOT NULL COLLATE 'utf8mb4_general_ci',
	`userName` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`password` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`fullName` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`sex` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`address` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`receiverAddress` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`dateOfBirth` DATETIME(6) NULL DEFAULT NULL,
	`phoneNumber` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`emailAddress` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`verificationCodes` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`TimeOfSpecify` DATETIME(6) NULL DEFAULT NULL,
	`authenticationStatus` BIT(1) NOT NULL,
	`url_` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	PRIMARY KEY (`clientCode`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;
-- Dumping data for table project.client: ~5 rows (approximately)
INSERT INTO `client` (`clientCode`, `userName`, `password`, `fullName`, `sex`, `address`, `receiverAddress`, `dateOfBirth`, `phoneNumber`, `emailAddress`, `verificationCodes`, `TimeOfSpecify`, `authenticationStatus`, `url_`) VALUES
	('1', 'nhóc_dev', '6IyxYWBXYrNvNuAPxDtFiKHG0mE=', 'Nguyễn Xuân Hòa', 'Nam', 'Lại thượng', 'Lại thượng', '2004-05-24 00:00:00.000000', '0343199493', 'nguyenxuanhoa8b@gmail.com', NULL, NULL, b'0', NULL),
	('2', 'xuanhoa2', 'Pihz7VtB5TJe2ii3QJUuTz1fh28=', 'Nguyễn Xuân Hòa', 'Nam', 'Lại thượng', 'Lại thượng', '2004-05-24 00:00:00.000000', '0343199493', 'nguyenxuanhoa8b@gmail.com', '702863', '2023-05-09 22:51:21.000000', b'1', NULL),
	('C4D722FCD21C533D8F39B159B920CDB2', 'xuanhoa1', '5V8PE6uxcnJ1zegQ5Afr1vFV8vg=', 'Nguyễn Xuân Hòa', 'Nam', 'Lại thượng', 'Lại thượng', '2004-05-24 00:00:00.000000', '0343199493', 'nguyenxuanhoa8b@gmail.com', '931257', '2023-05-04 22:03:15.000000', b'1', NULL),
	('CA730CF9FA398141AB72F05393F9F66A', 'admin123', 'Pihz7VtB5TJe2ii3QJUuTz1fh28=', 'Nguyễn Xuân Hòa', 'Nam', 'Lại thượng', 'Lại thượng', '2004-05-24 00:00:00.000000', '0343199493', 'nguyenxuanhoa8b@gmail.com', '071847', '2023-05-09 14:25:23.000000', b'1', NULL),
	('KH11', 'nhóc_dev3', '5V8PE6uxcnJ1zegQ5Afr1vFV8vg=', 'hòa', 'Nam', 'lt', 'lt', '2004-05-24 00:00:00.000000', '034319943', NULL, NULL, NULL, b'0', NULL);
CREATE TABLE `orderdetails` (
	`orderDetailsCode` VARCHAR(255) NOT NULL COLLATE 'utf8mb4_general_ci',
	`count_` INT(11) NOT NULL DEFAULT '0',
	`price` INT(11) NOT NULL DEFAULT '0',
	`totalMoney` INT(11) NOT NULL DEFAULT '0',
	`voucher` INT(11) NOT NULL DEFAULT '0',
	`sanpham` MEDIUMTEXT NOT NULL DEFAULT 'null' COLLATE 'utf8mb4_general_ci',
	PRIMARY KEY (`orderDetailsCode`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;
CREATE TABLE `orderr` (
	`orderCode` VARCHAR(255) NOT NULL COLLATE 'utf8mb4_general_ci',
	`amountPaid` DOUBLE NOT NULL DEFAULT '0',
	`missingAmount` DOUBLE NOT NULL DEFAULT '0',
	`paymentStatus` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`payments` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`purchaseAddress` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`receiverAddress` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`personReceiver` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`status_` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`orderdetails_id` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	PRIMARY KEY (`orderCode`) USING BTREE,
	INDEX `FK39t7fd54deh6r2eo0688asstg` (`orderdetails_id`) USING BTREE,
	CONSTRAINT `FK39t7fd54deh6r2eo0688asstg` FOREIGN KEY (`orderdetails_id`) REFERENCES `orderdetails` (`orderDetailsCode`) ON UPDATE RESTRICT ON DELETE RESTRICT
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;

CREATE TABLE `order_client` (
	`id_client` VARCHAR(255) NOT NULL COLLATE 'utf8mb4_general_ci',
	`id_order` VARCHAR(255) NOT NULL COLLATE 'utf8mb4_general_ci',
	PRIMARY KEY (`id_client`, `id_order`) USING BTREE,
	INDEX `FK8iuxfggm5nuws5lm6b5ethcfq` (`id_order`) USING BTREE,
	CONSTRAINT `FK8iuxfggm5nuws5lm6b5ethcfq` FOREIGN KEY (`id_order`) REFERENCES `orderr` (`orderCode`) ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT `FKi376ohmc9wyvncl2wvrcgnu60` FOREIGN KEY (`id_client`) REFERENCES `client` (`clientCode`) ON UPDATE RESTRICT ON DELETE RESTRICT
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;
-- Dumping data for table project.order_client: ~4 rows (approximately)
REPLACE INTO `order_client` (`id_client`, `id_order`) VALUES
	('C4D722FCD21C533D8F39B159B920CDB2', 'o10'),
	('C4D722FCD21C533D8F39B159B920CDB2', 'o11'),
	('C4D722FCD21C533D8F39B159B920CDB2', 'o8'),
	('CA730CF9FA398141AB72F05393F9F66A', 'o9');
CREATE TABLE `book` (
	`bookCode` VARCHAR(255) NOT NULL COLLATE 'utf8mb4_general_ci',
	`bookName` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`count_` INT(11) NOT NULL,
	`describe_` MEDIUMTEXT NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`language_` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`price` DOUBLE NOT NULL DEFAULT '0',
	`publishingYear` INT(11) NOT NULL,
	`author_id` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`category_id` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	PRIMARY KEY (`bookCode`) USING BTREE,
	INDEX `FKklnrv3weler2ftkweewlky958` (`author_id`) USING BTREE,
	INDEX `FKam9riv8y6rjwkua1gapdfew4j` (`category_id`) USING BTREE,
	CONSTRAINT `FKam9riv8y6rjwkua1gapdfew4j` FOREIGN KEY (`category_id`) REFERENCES `category` (`categoryCode`) ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT `FKklnrv3weler2ftkweewlky958` FOREIGN KEY (`author_id`) REFERENCES `author` (`authorCode`) ON UPDATE RESTRICT ON DELETE RESTRICT
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;
-- Dumping data for table project.book: ~18 rows (approximately)
INSERT INTO `book` (`bookCode`, `bookName`, `count_`, `describe_`, `language_`, `price`, `publishingYear`, `author_id`, `category_id`) VALUES
	('b1', 'Java', 0, 'Dùng cho coder muốn tìm hiểu về java core,OOP', 'tiếng việt', 50000, 2020, '1', 'cate1'),
	('b10', 'GOTH - Những Kẻ Hắc Ám',0, 'Truyện ma quái được lồng vào rất nhiều hình thức sinh hoạt hè, như kịch kabuki, tấu nói rakugo, trò chơi gọi ma bách vật ngữ. Và đơn giản nhất, là ngồi quây quần với nhau, mỗi người kể một câu chuyện thật rùng rợn, sao cho sống lưng lạnh toát, mồ hôi dầm dề, cứ tự làm mát như thế đến khuya, tiết trời dịu đi là có thể ngủ được.', 'tiếng việt', 50000, 2020, '4', 'cate2'),
	('b11', 'Bạch Dạ Hành', 0, 'Kosuke, chủ một tiệm cầm đồ bị sát hại tại một ngôi nhà chưa hoàn công, một triệu yên mang theo người cũng bị cướp mất.\r\n\r\nSau đó một tháng, nghi can Fumiyo được cho rằng có quan hệ tình ái với nạn nhân và đã sát hại ông để cướp một triệu yên, cũng chết tại nhà riêng vì ngộ độc khí ga. Vụ án mạng ông chủ tiệm cầm đồ rơi vào bế tắc và bị bỏ xó.\r\n\r\nNhưng với hai đứa trẻ mười một tuổi, con trai nạn nhân và con gái nghi can, vụ án mạng năm ấy chưa bao giờ kết thúc. Sinh tồn và trưởng thành dưới bóng đen cái chết của bố mẹ, cho đến cuối đời, Ryoji vẫn luôn khao khát được một lần đi dưới ánh mặt trời, còn Yukiho cứ ra sức vẫy vùng rồi mãi mãi chìm vào đêm trắng.', 'tiếng việt', 50000, 2020, '4', 'cate2'),
	('b12', 'Mùi Hương', 0, 'Mùi hương là một cuốn tiểu thuyết ly kỳ về một tên tội phạm đặc biệt.\r\n\r\nNhân vật chính của tác phẩm là Jean-Baptise Grenouille, một số phận khác người từ khi mới sinh. Mẹ hắn đã cố tình để mặc hắn chết sặc trông đống ruột cá với mùi máu tanh tưởi. Thế rồi bà ta bị kết án tử hình, còn hắn thì vẫn lớn lên.\r\n\r\nHắn có hình dong kỳ dị, và tâm hồn cũng bệnh hoạn. Mọi người ghẻ lạnh, khinh miệt hắn. Hắn đã từng phải sống trong cô độc và đói rét. Nhưng một biệt tài đã giúp cho hắn tìm một con đường sống. Hắn có khả năng khứu giác đặc biệt. Hắn có thể nhận biết, phân biệt và hơn thế, ghi nhớ các mùi hương. Nhờ vào đó, hắn trở thành một thiên tài trong giới sản xuất nước hoa Pháp.\r\n\r\nVới một đầu óc dị hợm, hắn mơ ước sẽ tạo ra được một hương thơm độc đáo cho riêng mình, một loại nước hoa gợi tình vô song. Và để thoả mãn dục vọng đó, hắn đã săn đuổi mùi hương từ hai mươi lăm trinh nữ…', 'tiếng việt', 50000, 2020, '4', 'cate2'),
	('b13', 'Trà Hoa Nữ', 0, 'Trà hoa nữ là câu chuyện đau thương về cuộc đời nàng kỹ nữ yêu hoa trà có tên là Marguerite Gautier. Nội dung kể về mối tình bất thành của anh nhà giàu Duval với cô kỹ nữ Marguerite, một đề tài tưởng đâu là quen thuộc, nhưng bằng ngòi bút sắc sảo cộng với tình cảm bao dung mà tác giả muốn truyền tải, truyện được độc giả đón nhận không ngần ngại, dù là giới quý tộc. Mặc dù Marguerite sống bằng nghề kỹ nữ nhưng trái với nghề của mình, Marguerite là người có tâm hồn và cá tính; nàng có lòng vị tha, biết hi sinh bản thân mình cho người mình yêu. Marguerite Gautier trong chuyện được viết dựa trên hình mẫu của Marie Duplessis, người yêu của chính tác giả.', 'tiếng việt', 50000, 2020, '3', 'cate2'),
	('b14', 'Tại Sao Đàn Ông Thích Tình Dục Và Phụ Nữ Cần Tình Yêu', 0, 'Đây là một quyển sách hài hước, thiết thực và dễ đọc. Trong quyển sách này, Allan cùng Barbara Pease đã tiết lộ một sự thật về hai phái, đồng thời bằng tài năng của mình, họ đã làm cho các kiến thức khoa học trở nên thú vị, lôi cuốn, qua đó hướng dẫn chúng ta cách vận dụng những kiến thức đó.\r\n\r\nQuyển sách có thể giúp những người độc thân tìm kiếm tình yêu hay giúp độc giả giải quyết các rắc rối trong chuyện tình cảm. Ngoài ra, sách cũng hướng dẫn bạn cách mang lại hạnh phúc cho người bạn đời để chính bạn cũng hạnh phúc hơn về sau.', 'tiếng việt', 50000, 2020, '3', 'cate2'),
	('b15', 'Rừng Na Uy', 0, 'Xuất bản lần đầu ở Nhật Bản năm 1987, Truyện Tiểu Thuyết Rừng Na Uy thực sự là một hiện tượng kỳ lạ với 4 triệu bản sách được bán ra, và theo thống kê hiện tại, cứ 7 người Nhật thì có 1 người đã đọc Rừng Na Uy. Tại Trung Quốc, Rừng Na Uy đã trở thành một hiện tượng văn hoá với hơn 1 triệu bản sách được tiêu thụ và được đánh giá là 1 trong 10 cuốn sách có ảnh hưởng lớn nhất ở đại lục trong thế kỷ 20.', 'tiếng việt', 50000, 2020, '3', 'cate2'),
	('b16', 'Tâm Lý Học Và Chuyện Yêu: Vì Sao Đàn Ông Thích Phụ Nữ Trẻ, Phụ Nữ Thích Đàn Ông Giàu?',0, 'Mọi cố gắng của cô rồi cũng được đền đáp, khi Adam xuất hiện. Một người đàn ông đáng để cô yêu, và cô cố gắng nghĩ thực ra cũng chẳng vi phạm vào lời tuyên bố Xin cạch đàn ông, bởi vì Adam chẳng giống những người đàn ông khác.', 'tiếng việt', 50000, 2020, '3', 'cate2'),
	('b17', 'Xin Cạch Đàn Ông!', 10, 'Tập trung vào những khía cạnh tâm sinh lý học, cũng như dựa vào lý thuyết về “tiến hóa theo chọn lọc tự nhiên”, tác giả sẽ đưa ra được những lời giải đáp vô cùng đơn giản cho những câu hỏi tưởng chừng như phức tạp này. Mỗi chương sách sẽ là một mảnh chìa khóa để hé mở những bí mật trong mối quan hệ giữa hai nửa của thế giới. \r\n\r\nCho dù bạn có đang băn khoăn không biết làm thế nào để thoát khỏi kiếp FA hay muốn hàn gắn sau một cuộc tình đổ vỡ, hoặc chỉ đơn giản là đang cần manh mối để kiếm một món quà thích hợp tặng crush, thì đây cũng là cuốn sách dành cho bạn.', 'tiếng việt', 50000, 2020, '3', 'cate2'),
	('b18', '10 Bí Mật Của Tình Yêu', 0, 'Thông qua chuyện kể về chàng trai trên con đường khám phá bí mật tình yêu, tác giả không chỉ cung cấp những kiến thức về tâm lý học, những lý giải chân thực về các vấn đề thường gặp trong cuộc sống hôn nhân; mà còn nêu lên những triết lý nhân văn, cách hành xử đúng đắn vừa sâu sắc vừa mang tính nhân bản.', 'tiếng việt', 50000, 2020, '3', 'cate2'),
	('b2', 'C', 0, 'Là ngôn ngữ cơ bản dễ học nhất cho người mới bắt đầu vào học lập trình', 'tiếng việt', 50000, 2020, '1', 'cate1'),
	('b3', 'JS', 0, 'Khá đa dạng,nhiều luồng nghề', 'tiếng việt', 50000, 2020, '1', 'cate1'),
	('b4', 'Python',0, 'Ngôn ngữ phổ biến với việc code ngắn,hiệu quả dùng để làm về AI', 'tiếng việt', 50000, 2020, '2', 'cate1'),
	('b5', 'Golang', 0, 'Ngôn ngữ cổ nhưng mạnh', 'tiếng việt', 50000, 2020, '2', 'cate1'),
	('b6', 'Php', 90, 'thường sử dụng PHP trong việc xây dựng và phát triển các ứng dụng website chạy trên máy chủ. Mã lệnh PHP có thể nhúng được vào trang HTML bằng cách sử dụng cặp thẻ PHP', 'tiếng việt', 50000, 2020, '1', 'cate1'),
	('b7', 'Zoo', 0, 'Hơi lạnh phà ra từ khắp cuốn sách kinh dị này…\r\n\r\nPhà ra từ hầm ngầm, nơi các nạn nhân bị chặt thành từng mảnh nhỏ để trôi vừa qua lưới chắn cống xối,\r\n\r\nPhà ra từ bộ ảnh chụp lần lượt từng bước phân hủy xác một cô gái: đổi màu, ứa nước, rữa nát đến khô quắt dòi bọ chán nản bỏ đi,\r\n\r\nPhà ra từ người đàn ông tỉnh dậy với máu me đầm đìa và lê lết chấm phẩy chạy mãi mà không hề hay biết chân mình đã gãy…\r\n\r\nCũng như phà ra từ không thiếu một câu chuyện nào bởi sự miêu tả tỉ mỉ và gần như bàng quan của tác giả trước những cảnh chết khác nhau của con người.', 'tiếng việt', 50000, 2020, '4', 'cate2'),
	('b8', 'Ác Quỷ Nam Kinh', 3, 'Hãy thưởng thức Ring, vòng tròn ác nghiệt của Koji Suzuki, tác phẩm kinh dị kinh điển đã làm mưa làm gió bằng những thành công khổng lồ ở đất nước Phù Tang trong hàng thập kỷ, trước khi bước lên màn ảnh với hai bộ phim nổi tiếng Ringu của Nhật Bản và The ring của Holywood. Xuất khẩu nỗi sợ đặc trưng Nhật Bản ra toàn thế giới, Ring thỏa mãn những ai đang tìm kiếm khoái cảm trong nỗi rùng mình, cùng những triết lý cao sang và sâu sắc của một trong những kiệt tác của thể loại.', 'tiếng việt', 50000, 2020, '4', 'cate2'),
	('b9', 'Ring - Vòng Tròn Ác Nghiệt', 0, 'Một cuốn sổ ghi chép quá trình giết người.Chiếc tủ lạnh chứa đầy bàn tay. Lũ chó bị bắt cóc.Vụ treo cổ kỳ quái.Đứa trẻ bị chôn sống. Cuốn băng thu âm giọng nói của người chết…\r\n\r\nHai học sinh cấp ba cùng nhau điều tra những vụ án kỳ lạ ở địa phương. Nhưng thay vì cố gắng ngăn chặn tội ác, nỗi ám ảnh với cái chết và sự giết chóc đã dẫn dắt chúng tiến vào bóng tối điên cuồng, nơi những cơn ác mộng trở thành sự thực.\r\n\r\nKhông chỉ là một cuốn tiểu thuyết kinh dị rùng rợn, GOTH còn ẩn chứa nỗi buồn và những chiêm nghiệm về cuộc sống, về bản chất con người và sự giác ngộ. Tác phẩm đã mang về cho Otsuichi giải thưởng Honkaku Mystery, được chuyển thể thành manga và phim điện ảnh.', 'tiếng việt', 50000, 2020, '4', 'cate2');


/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
