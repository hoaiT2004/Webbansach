package database;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Author;
import model.Book;
import model.Category;
public class BookDAO {
	List<Book> data = new ArrayList<>();

	public List<Book> selectAll() {
		try {
			SessionFactory sessionFactory = ConnectHib.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					String hql = "from Book";
					data = session.createQuery(hql).getResultList();
					transaction.commit();
					session.close();
				} catch (Exception e) {
					////ConnectHib.shutdown();
					e.printStackTrace();
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	public Book selectById(Book t) {
		Book a = null;
		try {
			SessionFactory sessionFactory = ConnectHib.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					a = session.get(Book.class, t.getBookCode());
					transaction.commit();
					session.close();
				} catch (Exception e) {
					////ConnectHib.shutdown();
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	public int insert(Book a) {
		try {
			SessionFactory sessionFactory = ConnectHib.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					session.save(a);
					transaction.commit();
					session.close();
				} catch (Exception e) {
					////ConnectHib.shutdown();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BookDAO dao = new BookDAO();
		Book b = dao.selectById(a);
		if(b != null) {
			return 1;
		}
		return 0;
	}

	public int insertAll(List<Book> a) {
		int dem = 0;
		for (Book Book : a) {
			dem += insert(Book);
		}
		return dem;
	}

	public int delete(Book a) {
		try {
			SessionFactory sessionFactory = ConnectHib.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					 session.delete(a);
					 
					transaction.commit();
					session.close();
					return 1;
				} catch (Exception e) {
					//ConnectHib.shutdown();
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int deleteAll(List<Book> a) {
		int dem = 0;
		for (Book Book : a) {
			dem += delete(Book);
		}
		return dem;
	}

	public int update(Book a, Book b) {
		try {
			SessionFactory sessionFactory = ConnectHib.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					 session.update(b);//thằng a để lấy id
					transaction.commit();
					session.close();
					return 1;
				} catch (Exception e) {
					//ConnectHib.shutdown();
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public Book searchName(String name) {
		Book b = null;
		try {
			SessionFactory sessionFactory = ConnectHib.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					 String hql = "from Book b where b.bookName =: name";
					 Query query= session.createQuery(hql);
					 query.setParameter("name", name);
					 Object obj = query.getSingleResult();
					 b = (Book) obj;
					transaction.commit();
					session.close();
					
				} catch (Exception e) {
					//ConnectHib.shutdown();
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	public static void main(String[] args) {
		BookDAO dao = new BookDAO();
		Date d = new Date(1843-1900, 5-1, 24);
		Author auth = new Author("3", "Alexandre Dumas", "Nam", d, "Là nhà tiểu thuyết và viết kịch nổi tiếng của Pháp. Trà hoa nữ được viết khi ông hai mươi tư tuổi, là tác phẩm đầu tiên khẳng định tài năng và đã đem lại vinh quang rực rỡ cho Alexandre Dumas con.");
		Date d2 = new Date(1943-1900, 5-1, 24);
		Author auth2 = new Author("4", "R. L. Stine", "Nam", d2, "Là 1 chàng trai ok");
		Category cate1 = new Category("cate2", "truyện");
		
		Book book = new Book("b13", "Trà Hoa Nữ", auth, 2020, 50000, 100,cate1,"tiếng việt", "Trà hoa nữ là câu chuyện đau thương về cuộc đời nàng kỹ nữ yêu hoa trà có tên là Marguerite Gautier. Nội dung kể về mối tình bất thành của anh nhà giàu Duval với cô kỹ nữ Marguerite, một đề tài tưởng đâu là quen thuộc, nhưng bằng ngòi bút sắc sảo cộng với tình cảm bao dung mà tác giả muốn truyền tải, truyện được độc giả đón nhận không ngần ngại, dù là giới quý tộc. Mặc dù Marguerite sống bằng nghề kỹ nữ nhưng trái với nghề của mình, Marguerite là người có tâm hồn và cá tính; nàng có lòng vị tha, biết hi sinh bản thân mình cho người mình yêu. Marguerite Gautier trong chuyện được viết dựa trên hình mẫu của Marie Duplessis, người yêu của chính tác giả.");
		Book book1 = new Book("b14", "Tại Sao Đàn Ông Thích Tình Dục Và Phụ Nữ Cần Tình Yêu", auth, 2020, 50000, 100,cate1,"tiếng việt", "Đây là một quyển sách hài hước, thiết thực và dễ đọc. Trong quyển sách này, Allan cùng Barbara Pease đã tiết lộ một sự thật về hai phái, đồng thời bằng tài năng của mình, họ đã làm cho các kiến thức khoa học trở nên thú vị, lôi cuốn, qua đó hướng dẫn chúng ta cách vận dụng những kiến thức đó.\r\n"
				+ "\r\n"
				+ "Quyển sách có thể giúp những người độc thân tìm kiếm tình yêu hay giúp độc giả giải quyết các rắc rối trong chuyện tình cảm. Ngoài ra, sách cũng hướng dẫn bạn cách mang lại hạnh phúc cho người bạn đời để chính bạn cũng hạnh phúc hơn về sau.");
		Book book2 = new Book("b15", "Rừng Na Uy", auth, 2020, 50000, 100,cate1,"tiếng việt", "Xuất bản lần đầu ở Nhật Bản năm 1987, Truyện Tiểu Thuyết Rừng Na Uy thực sự là một hiện tượng kỳ lạ với 4 triệu bản sách được bán ra, và theo thống kê hiện tại, cứ 7 người Nhật thì có 1 người đã đọc Rừng Na Uy. Tại Trung Quốc, Rừng Na Uy đã trở thành một hiện tượng văn hoá với hơn 1 triệu bản sách được tiêu thụ và được đánh giá là 1 trong 10 cuốn sách có ảnh hưởng lớn nhất ở đại lục trong thế kỷ 20.");
		Book book3 = new Book("b16", "Tâm Lý Học Và Chuyện Yêu: Vì Sao Đàn Ông Thích Phụ Nữ Trẻ, Phụ Nữ Thích Đàn Ông Giàu?", auth, 2020, 50000, 100,cate1,"tiếng việt", "Sách cho coder");
		Book book4 = new Book("b17", "Xin Cạch Đàn Ông!", auth, 2020, 50000, 100,cate1,"tiếng việt", "Tập trung vào những khía cạnh tâm sinh lý học, cũng như dựa vào lý thuyết về “tiến hóa theo chọn lọc tự nhiên”, tác giả sẽ đưa ra được những lời giải đáp vô cùng đơn giản cho những câu hỏi tưởng chừng như phức tạp này. Mỗi chương sách sẽ là một mảnh chìa khóa để hé mở những bí mật trong mối quan hệ giữa hai nửa của thế giới. \r\n"
				+ "\r\n"
				+ "Cho dù bạn có đang băn khoăn không biết làm thế nào để thoát khỏi kiếp FA hay muốn hàn gắn sau một cuộc tình đổ vỡ, hoặc chỉ đơn giản là đang cần manh mối để kiếm một món quà thích hợp tặng crush, thì đây cũng là cuốn sách dành cho bạn.");
		Book book5 = new Book("b18", "10 Bí Mật Của Tình Yêu", auth, 2020, 50000, 100,cate1,"tiếng việt", "Thông qua chuyện kể về chàng trai trên con đường khám phá bí mật tình yêu, tác giả không chỉ cung cấp những kiến thức về tâm lý học, những lý giải chân thực về các vấn đề thường gặp trong cuộc sống hôn nhân; mà còn nêu lên những triết lý nhân văn, cách hành xử đúng đắn vừa sâu sắc vừa mang tính nhân bản.");
	//Kinh dị
//		Book book6 = new Book("b7", "Zoo", auth2, 2020, 50000, 100,cate1,"tiếng việt", "Hơi lạnh phà ra từ khắp cuốn sách kinh dị này…\r\n"
//				+ "\r\n"
//				+ "Phà ra từ hầm ngầm, nơi các nạn nhân bị chặt thành từng mảnh nhỏ để trôi vừa qua lưới chắn cống xối,\r\n"
//				+ "\r\n"
//				+ "Phà ra từ bộ ảnh chụp lần lượt từng bước phân hủy xác một cô gái: đổi màu, ứa nước, rữa nát đến khô quắt dòi bọ chán nản bỏ đi,\r\n"
//				+ "\r\n"
//				+ "Phà ra từ người đàn ông tỉnh dậy với máu me đầm đìa và lê lết chấm phẩy chạy mãi mà không hề hay biết chân mình đã gãy…\r\n"
//				+ "\r\n"
//				+ "Cũng như phà ra từ không thiếu một câu chuyện nào bởi sự miêu tả tỉ mỉ và gần như bàng quan của tác giả trước những cảnh chết khác nhau của con người.");
//		Book book7 = new Book("b8", "Ác Quỷ Nam Kinh", auth2, 2020, 50000, 100,cate1,"tiếng việt", "Hãy thưởng thức Ring, vòng tròn ác nghiệt của Koji Suzuki, tác phẩm kinh dị kinh điển đã làm mưa làm gió bằng những thành công khổng lồ ở đất nước Phù Tang trong hàng thập kỷ, trước khi bước lên màn ảnh với hai bộ phim nổi tiếng Ringu của Nhật Bản và The ring của Holywood. Xuất khẩu nỗi sợ đặc trưng Nhật Bản ra toàn thế giới, Ring thỏa mãn những ai đang tìm kiếm khoái cảm trong nỗi rùng mình, cùng những triết lý cao sang và sâu sắc của một trong những kiệt tác của thể loại.");
//		Book book8 = new Book("b9", "Ring – Vòng Tròn Ác Nghiệt", auth2, 2020, 50000, 100,cate1,"tiếng việt", "Một cuốn sổ ghi chép quá trình giết người.Chiếc tủ lạnh chứa đầy bàn tay. Lũ chó bị bắt cóc.Vụ treo cổ kỳ quái.Đứa trẻ bị chôn sống. Cuốn băng thu âm giọng nói của người chết…\r\n"
//				+ "\r\n"
//				+ "Hai học sinh cấp ba cùng nhau điều tra những vụ án kỳ lạ ở địa phương. Nhưng thay vì cố gắng ngăn chặn tội ác, nỗi ám ảnh với cái chết và sự giết chóc đã dẫn dắt chúng tiến vào bóng tối điên cuồng, nơi những cơn ác mộng trở thành sự thực.\r\n"
//				+ "\r\n"
//				+ "Không chỉ là một cuốn tiểu thuyết kinh dị rùng rợn, GOTH còn ẩn chứa nỗi buồn và những chiêm nghiệm về cuộc sống, về bản chất con người và sự giác ngộ. Tác phẩm đã mang về cho Otsuichi giải thưởng Honkaku Mystery, được chuyển thể thành manga và phim điện ảnh.");
//		Book book9 = new Book("b10", "GOTH – Những Kẻ Hắc Ám", auth2, 2020, 50000, 100,cate1,"tiếng việt", "Truyện ma quái được lồng vào rất nhiều hình thức sinh hoạt hè, như kịch kabuki, tấu nói rakugo, trò chơi gọi ma bách vật ngữ. Và đơn giản nhất, là ngồi quây quần với nhau, mỗi người kể một câu chuyện thật rùng rợn, sao cho sống lưng lạnh toát, mồ hôi dầm dề, cứ tự làm mát như thế đến khuya, tiết trời dịu đi là có thể ngủ được.");
//		Book book10 = new Book("b11", "Bạch Dạ Hành", auth2, 2020, 50000, 100,cate1,"tiếng việt", "Kosuke, chủ một tiệm cầm đồ bị sát hại tại một ngôi nhà chưa hoàn công, một triệu yên mang theo người cũng bị cướp mất.\r\n"
//				+ "\r\n"
//				+ "Sau đó một tháng, nghi can Fumiyo được cho rằng có quan hệ tình ái với nạn nhân và đã sát hại ông để cướp một triệu yên, cũng chết tại nhà riêng vì ngộ độc khí ga. Vụ án mạng ông chủ tiệm cầm đồ rơi vào bế tắc và bị bỏ xó.\r\n"
//				+ "\r\n"
//				+ "Nhưng với hai đứa trẻ mười một tuổi, con trai nạn nhân và con gái nghi can, vụ án mạng năm ấy chưa bao giờ kết thúc. Sinh tồn và trưởng thành dưới bóng đen cái chết của bố mẹ, cho đến cuối đời, Ryoji vẫn luôn khao khát được một lần đi dưới ánh mặt trời, còn Yukiho cứ ra sức vẫy vùng rồi mãi mãi chìm vào đêm trắng.");
//		Book book11 = new Book("b12", "Mùi Hương", auth2, 2020, 50000, 100,cate1,"tiếng việt", "Mùi hương là một cuốn tiểu thuyết ly kỳ về một tên tội phạm đặc biệt.\r\n"
//				+ "\r\n"
//				+ "Nhân vật chính của tác phẩm là Jean-Baptise Grenouille, một số phận khác người từ khi mới sinh. Mẹ hắn đã cố tình để mặc hắn chết sặc trông đống ruột cá với mùi máu tanh tưởi. Thế rồi bà ta bị kết án tử hình, còn hắn thì vẫn lớn lên.\r\n"
//				+ "\r\n"
//				+ "Hắn có hình dong kỳ dị, và tâm hồn cũng bệnh hoạn. Mọi người ghẻ lạnh, khinh miệt hắn. Hắn đã từng phải sống trong cô độc và đói rét. Nhưng một biệt tài đã giúp cho hắn tìm một con đường sống. Hắn có khả năng khứu giác đặc biệt. Hắn có thể nhận biết, phân biệt và hơn thế, ghi nhớ các mùi hương. Nhờ vào đó, hắn trở thành một thiên tài trong giới sản xuất nước hoa Pháp.\r\n"
//				+ "\r\n"
//				+ "Với một đầu óc dị hợm, hắn mơ ước sẽ tạo ra được một hương thơm độc đáo cho riêng mình, một loại nước hoa gợi tình vô song. Và để thoả mãn dục vọng đó, hắn đã săn đuổi mùi hương từ hai mươi lăm trinh nữ…");
	System.out.println(dao.insert(book));
	System.out.println(dao.insert(book1));
	System.out.println(dao.insert(book2));
	System.out.println(dao.insert(book3));
	System.out.println(dao.insert(book4));
	System.out.println(dao.insert(book5));
//	System.out.println(dao.insert(book6));
//	System.out.println(dao.insert(book7));
//	System.out.println(dao.insert(book8));
//	System.out.println(dao.insert(book9));
//	System.out.println(dao.insert(book10));
//	System.out.println(dao.insert(book11));
		}
}