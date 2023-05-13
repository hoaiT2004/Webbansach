package database;
import java.util.List;

public interface DAOInterface<T>{
public List<T> selectAll();
public T selectById(String id);
public int insert(T t);
public int insertAll(List<T> t);
public int delete(T t);
public int deleteAll(List<T> t);
public int update(T t,T t2);
}
