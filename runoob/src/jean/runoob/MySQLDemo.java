package jean.runoob;

import java.sql.*;

public class MySQLDemo {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    static final String USER = "root";
    static final String PASS = "admin";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connect database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Instance an object");
            stmt = conn.createStatement();
            String sql = "select id, name, url from websites";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String url = rs.getString("url");

                System.out.println("ID: " + id);
                System.out.println("website: " + name);
                System.out.println("url: " +url);
            }
            rs.close();
            stmt.close();
            conn.close();;;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}


/**
 CREATE TABLE `websites` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `name` char(20) NOT NULL DEFAULT '' COMMENT '站点名称',
 `url` varchar(255) NOT NULL DEFAULT '',
 `alexa` int(11) NOT NULL DEFAULT '0' COMMENT 'Alexa 排名',
 `country` char(10) NOT NULL DEFAULT '' COMMENT '国家',
 PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

 INSERT INTO `websites` VALUES ('1', 'Google', 'https://www.google.cm/', '1', 'USA'), ('2', '淘宝', 'https://www.taobao.com/', '13', 'CN'), ('3', '菜鸟教程', 'http://www.runoob.com', '5892', ''), ('4', '微博', 'http://weibo.com/', '20', 'CN'), ('5', 'Facebook', 'https://www.facebook.com/', '3', 'USA');
 */