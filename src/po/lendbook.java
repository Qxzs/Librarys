package po;



public class lendbook {
    private int id;
    private int userid;
    private String bookname;
    private String lendtime;
    private String backtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getLendtime() {
        return lendtime;
    }

    public void setLendtime(String lendtime) {
        this.lendtime = lendtime;
    }

    public String getBacktime() {
        return backtime;
    }

    public void setBacktime(String backtime) {
        this.backtime = backtime;
    }

    @Override
    public String toString() {
        return "lendbook{" +
                "id=" + id +
                ", userid=" + userid +
                ", bookname='" + bookname + '\'' +
                ", lendtime=" + lendtime +
                ", backtime=" + backtime +
                '}';
    }
}
