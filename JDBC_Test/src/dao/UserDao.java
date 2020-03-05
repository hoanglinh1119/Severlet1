package dao;

import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IUserDao {
    private  String jdbcURL="jdbc:mysql://localhost:3306/demo";
    private  String jdbcUser="root";
    private String jdbcPassword="hoanglinh";

    private static final String Insert_User_Sql="insert into users"+"(userName,email,country)values"+"(?,?,?)";
    private static final String Insert_User_By_Id="select id,userName,email,country from users where id=?";
    private static final String Search_User_By_Country="select*from users where country=?";
    private static final String Select_All_Users="select*from users";
    private static final String Delete_Users="delete from users where id=?";
    private static final String Update_Users="update users set userName=?,email=?,country=? where id=?";
    private static final String Sort_By_Name="select * from users order by userName";

    public UserDao(){}
    protected Connection getConnection(){
        Connection connection=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(jdbcURL,jdbcUser,jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insertUser(User user) {
        System.out.println(Insert_User_Sql);
        try{
           Connection connection=getConnection();
            PreparedStatement ps=connection.prepareStatement(Insert_User_Sql);
            ps.setString(1,user.getName());
            ps.setString(2,user.getEmail());
            ps.setString(3,user.getCountry());
            System.out.println(ps);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User selectUser(int id) {
        User user=null;
        try{
            Connection connection=getConnection();
            PreparedStatement ps=connection.prepareStatement(Insert_User_By_Id);
            ps.setInt(1,id);
            System.out.println(ps);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                String name=rs.getString("name");
                String email=rs.getString("email");
                String country=rs.getString("country");
                user=new User(id,name,email,country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> selectAllUser() {
        List<User> users=new ArrayList<User>();
        try {
            Connection connection=getConnection();
            PreparedStatement ps=connection.prepareStatement(Select_All_Users);
            System.out.println(ps);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("userName");
                String email=rs.getString("email");
                String country=rs.getString("country");
                users.add(new User(id,name,email,country));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<User> searchUserFollowCountry(String country)  {
            List<User> listSearch=new ArrayList<>();
            try {
                Connection connection=getConnection();
                PreparedStatement ps=connection.prepareStatement(Search_User_By_Country);
                ps.setString(1,country);
                ResultSet rs=ps.executeQuery();
                while (rs.next()){
                    int id=rs.getInt("id");
                    String name=rs.getString("userName");
                    String email=rs.getString("email");
                    listSearch.add(new User(id,name,email,country));
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        return listSearch;
    }

    @Override
    public List<User> sortByName() {
        List<User> userList = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(Sort_By_Name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("userName");
                String email = rs.getString("email");
                String country = rs.getString("country");
                userList.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

        @Override
    public boolean deleteUser(int id) {
        boolean rowDelete = false;
        try{
            Connection connection=getConnection();
            PreparedStatement ps=connection.prepareStatement(Delete_Users);
            ps.setInt(1,id);
            rowDelete=ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }

    @Override
    public boolean updateUser(User user) {
        boolean rowUpdate = false;
        try (Connection connection=getConnection(); PreparedStatement ps=connection.prepareStatement(Update_Users)){
           ps.setString(1,user.getName());
           ps.setString(2,user.getEmail());
           ps.setString(3,user.getCountry());
           ps.setInt(4,user.getId());
           rowUpdate=ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }
    private void printSQLException(SQLException sex){
        for (Throwable throwable: sex){
            if(throwable instanceof SQLException){
                sex.printStackTrace(System.err);
                System.err.println("SQL State:" +((SQLException)sex).getSQLState());
                System.err.println("Error Code:"+((SQLException)sex).getErrorCode());
                System.err.println("Message:"+((SQLException)sex).getMessage());
                Throwable t=sex.getCause();
                while (t!=null){
                    System.out.println("Cause"+t);
                    t=t.getCause();
                }
            }
        }
    }
}
