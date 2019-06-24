package mapper;

import org.apache.ibatis.annotations.Param;
import po.users;

import java.util.HashMap;
import java.util.List;

public interface userMapper {
    public int insertUsers(users users);//添加用户
    public int delUsers(int id);//删除用户
    public int updateUsers(users users);//修改用户信息
    public List<users> findAllUsers();//查找所有用户
    public users findUserById(int i);
    public int updateDefine(@Param("id")int id);
    public List<users> findUserByName(@Param("username")String name);
    //分页
    public int selectCounts();//查数据总数
    List<users> findByPages(HashMap<String,Object> map);
}
