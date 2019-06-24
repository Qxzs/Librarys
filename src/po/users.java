package po;

import java.util.List;

public class users {
	private int id;
	private String username;
	private String pwd;
	private String statue;
	private String sex;
	private String classs;
	private String tel;
	private List<lendbook> lendbooks;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getStatue() {
		return statue;
	}

	public void setStatue(String statue) {
		this.statue = statue;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getClasss() {
		return classs;
	}

	public void setClasss(String classs) {
		this.classs = classs;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public List<lendbook> getLendbooks() {
		return lendbooks;
	}

	public void setLendbooks(List<lendbook> lendbooks) {
		this.lendbooks = lendbooks;
	}

	@Override
	public String toString() {
		return "users{" +
				"id=" + id +
				", username='" + username + '\'' +
				", pwd='" + pwd + '\'' +
				", statue='" + statue + '\'' +
				", sex='" + sex + '\'' +
				", classs='" + classs + '\'' +
				", tel='" + tel + '\'' +
				", lendbooks=" + lendbooks +
				'}';
	}
}
