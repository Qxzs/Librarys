package po;

public class users {
	private String username;
	  private String pwd;
	  private String statue;
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
	@Override
	public String toString() {
		return "users [username=" + username + ", pwd=" + pwd + ", statue=" + statue + "]";
	}
}
