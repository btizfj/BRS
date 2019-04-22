package cn.yznu.brs.bean;

import java.sql.Date;

/**
 * 用户实体类
 */
public class Order implements java.io.Serializable {

    private int id;
    private Integer user_id;
    private Integer barber_id;
    private String b_name;
    private Integer r_time;
    private Date time;
    private Integer r_price;
    private Integer isProcess;

    public int getId() {
        return id;
    }

    public String getB_name() {
        return b_name;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getBarber_id() {
        return barber_id;
    }

    public void setBarber_id(Integer barber_id) {
        this.barber_id = barber_id;
    }

    public Integer getR_time() {
        return r_time;
    }

    public void setR_time(Integer r_time) {
        this.r_time = r_time;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getR_price() {
        return r_price;
    }

    public void setR_price(Integer r_price) {
        this.r_price = r_price;
    }

    public Integer getIsProcess() {
        return isProcess;
    }

    public void setIsProcess(Integer isProcess) {
        this.isProcess = isProcess;
    }
}
