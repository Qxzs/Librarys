package serviceImpl;

import mapper.bookMapper;
import mapper.userMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import po.book;
import po.lendbook;
import po.pageBean;
import po.users;
import service.services;

import java.util.HashMap;
import java.util.List;

public class servicesImpl implements services{
    @Autowired
	private bookMapper bookMapper;
	@Autowired
	private userMapper userMapper;


	public users loginusers(users users) {
		
		return this.bookMapper.loginusers(users);
	}
	@Override
	public List<book> findbooksByName(String name) {
		// TODO Auto-generated method stub
		return this.bookMapper.findbooksByName(name);
	}
	@Override
	public List<book> findbooksByAuthor(String name) {
		
		return this.bookMapper.findbooksByAuthor(name);
	}

	@Override
	public List<book> findbooksByPress(String name) {
		return this.bookMapper.findbooksByPress(name);
	}

	@Override
	//插入书本信息
	public int insertBook(book book) {

		return this.bookMapper.insertBook(book);
	}

	@Override
	//删除书本
	public int delBook(int id) {

		return this.bookMapper.delBook(id);
	}

	@Override
	public int lendBook(lendbook lendbook) {
		return this.bookMapper.lendBook(lendbook);
	}

	@Override
	public int subNum(String bookname) {
		return this.bookMapper.subNum(bookname);
	}

    @Override
    public List<users> checkLend(int id) {
        return this.bookMapper.checkLend(id);
    }

    @Override
	//更新书本信息
	public int updateBook(book book) {
		return this.bookMapper.updateBook(book);
	}

	@Override
	//查所有的书
	public List<book> findAllBook() {

		return this.bookMapper.findAllBook();
	}

	@Override
	public book findBooksById(int i) {

		return this.bookMapper.findBooksById(i);
	}

	@Override
	public int selectCount() {
		return bookMapper.selectCount();
	}

	@Override
	public pageBean<book> findByPage(int currentPage,int x) {

			HashMap<String, Object> map = new HashMap<String, Object>();
			pageBean<book> pageBean = new pageBean<book>();

			//封装当前页数
			pageBean.setCurrPage(currentPage);

			//每页显示的数据
			int pageSize = x;
			pageBean.setPageSize(pageSize);

			//封装总记录数
			int totalCount = bookMapper.selectCount();
			pageBean.setTotalCount(totalCount);

			//封装总页数
			double tc = totalCount;
			Double num = Math.ceil(tc / pageSize);//向上取整
			pageBean.setTotalPage(num.intValue());

			map.put("start", (currentPage - 1) * pageSize);
			map.put("size", pageBean.getPageSize());
			//封装每页显示的数据
			List<book> lists = bookMapper.findByPage(map);
			pageBean.setLists(lists);
			return pageBean;

	}

	@Override
	public List<users> findAllUsers() {
		return this.userMapper.findAllUsers();
	}

	@Override
	public users findUserById(int i) {
		return this.userMapper.findUserById(i);
	}

	@Override
	public int updateDefine(int id) {
		return this.userMapper.updateDefine(id);
	}

	@Override
	public int insertUsers(users users) {
		return this.userMapper.insertUsers(users);
	}

	@Override
	public int delUsers(int id) {

		return this.userMapper.delUsers(id);
	}

	@Override
	public int updateUsers(users users) {
		return this.userMapper.updateUsers(users);
	}
    public List<users> findUserByName(@Param("username")String name){
	    return this.userMapper.findUserByName(name);
    }
	@Override
	public int selectCounts() {
		return this.userMapper.selectCounts();
	}

	@Override
	public pageBean<users> findByPages(int currentPage,int x) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		pageBean<users> pageBean = new pageBean<users>();

		//封装当前页数
		pageBean.setCurrPage(currentPage);

		//每页显示的数据
		int pageSize = x;
		pageBean.setPageSize(pageSize);

		//封装总记录数
		int totalCount = userMapper.selectCounts();
		pageBean.setTotalCount(totalCount);

		//封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);//向上取整
		pageBean.setTotalPage(num.intValue());

		map.put("start", (currentPage - 1) * pageSize);
		map.put("size", pageBean.getPageSize());
		//封装每页显示的数据
		List<users> lists = userMapper.findByPages(map);
		pageBean.setLists(lists);
		return pageBean;
	}

}
