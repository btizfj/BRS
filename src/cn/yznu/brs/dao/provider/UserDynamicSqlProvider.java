package cn.yznu.brs.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import java.sql.Date;
import java.util.Map;

import static cn.yznu.brs.util.constants.Constant.*;

public class UserDynamicSqlProvider {

    public String insertBarberToDB(String username, String password, String b_name, String b_description, String phonenumber){
        String sql =  new SQL(){
            {
                INSERT_INTO(USERTABLE);
                VALUES("username","'"+username+"'");
                VALUES("password","'"+password+"'");
                VALUES("b_name","'"+b_name+"'");
                VALUES("usertype",""+1+"");
                VALUES("b_description","'"+b_description+"'");
                VALUES("phonenumber",""+phonenumber+"");
            }
        }.toString();
        return sql;
    }

    public String insertAcceptOrderMessageById(Integer user_id, Date date){
        String sql =  new SQL(){
            {
                INSERT_INTO(MESSAGETABLE);
                VALUES("user_id",""+user_id+"");
                VALUES("isread",""+0+"");
                VALUES("time","'"+date+"'");
                VALUES("content","'"+"您预约的理发师已经接受了您的预约！"+"'");
            }
        }.toString();
        return sql;
    }

    public String insertCancelOrderMessageById(Integer user_id, Date date){
        String sql =  new SQL(){
            {
                INSERT_INTO(MESSAGETABLE);
                VALUES("user_id",""+user_id+"");
                VALUES("isread",""+0+"");
                VALUES("time","'"+date+"'");
                VALUES("content","'"+"您预约的理发师取消了您的预约，请重新预约！"+"'");
            }
        }.toString();
        return sql;
    }

    public String insertOrder(int id, Integer barber_id, Integer r_time, Integer r_price, Date time){
        String sql =  new SQL(){
            {
                INSERT_INTO(ORDERTABLE);
                VALUES("user_id",""+id+"");
                VALUES("barber_id",""+barber_id+"");
                VALUES("r_time",""+r_time+"");
                VALUES("time","'"+time+"'");
                VALUES("r_price",""+r_price+"");
                VALUES("isProcess",""+0+"");
            }
        }.toString();
        return sql;
    }

    public String insertMessage(Integer barber_id, String s, Date time){
        String sql =  new SQL(){
            {
                INSERT_INTO(MESSAGETABLE);
                VALUES("user_id",""+barber_id+"");
                VALUES("isread",""+0+"");
                VALUES("content","'"+s+"'");
                VALUES("time","'"+time+"'");
            }
        }.toString();
        return sql;
    }

    public String selectOrderByPage(Map<String, Object> params){
        String sql =  new SQL(){
            {
                SELECT("*");
                FROM(ORDERTABLE);
                WHERE(" user_id=#{id}");
            }
        }.toString();
        if(params.get("pageModel") != null){
            sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize} ";
        }
        return sql;
    }

    public String selectBarberOrderByPage(Map<String, Object> params){
        String sql =  new SQL(){
            {
                SELECT("*");
                FROM(ORDERTABLE);
                WHERE(" barber_id=#{id}");
            }
        }.toString();
        if(params.get("pageModel") != null){
            sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize} ";
        }
        return sql;
    }

    public String selectAllUserByPage(Map<String, Object> params){
        String sql =  new SQL(){
            {
                SELECT("*");
                FROM(USERTABLE);
                WHERE(" usertype=0 ");
            }
        }.toString();
        if(params.get("pageModel") != null){
            sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize} ";
        }
        return sql;
    }

    public String selectAllBarberByPage(Map<String, Object> params){
        String sql =  new SQL(){
            {
                SELECT("*");
                FROM(USERTABLE);
                WHERE(" usertype=1 ");
            }
        }.toString();
        if(params.get("pageModel") != null){
            sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize} ";
        }
        return sql;
    }

    public String selectAllOrderByPage(Map<String, Object> params){
        String sql =  new SQL(){
            {
                SELECT("*");
                FROM(ORDERTABLE);
            }
        }.toString();
        if(params.get("pageModel") != null){
            sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize} ";
        }
        return sql;
    }

    public String selectMessageByPage(Map<String, Object> params){
        String sql =  new SQL(){
            {
                SELECT("*");
                FROM(MESSAGETABLE);
                WHERE(" user_id=#{id}");
            }
        }.toString();
        if(params.get("pageModel") != null){
            sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize} ";
        }
        return sql;
    }

    public String selectUserByAccount(String username, String password){
        String sql =  new SQL(){
            {
                SELECT("*");
                FROM(USERTABLE);
                WHERE(" username= '"+username+"'");
                WHERE(" password= '"+password+"'");
            }
        }.toString();
        return sql;
    }


}
