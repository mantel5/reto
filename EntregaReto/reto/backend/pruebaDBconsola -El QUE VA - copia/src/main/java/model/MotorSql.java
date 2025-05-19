package model;

import java.sql.*;

public class
MotorSql implements IMotorSql{
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

    public static final String MYSQL_URL = "jdbc:mysql://localhost:3306/reto";
    public static final String MYSQL_USER = "root";
    public static final String MYSQL_PASS = "Cambiame2024";
    private Connection  m_Connection;
    private Statement m_Statement;
    private ResultSet m_Resulset;



    @Override
    public void connect() {
        try
        {
            Class.forName(DRIVER_NAME);
            m_Connection = DriverManager.getConnection(MYSQL_URL,MYSQL_USER, MYSQL_PASS);
m_Statement = m_Connection.createStatement();
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        catch (SQLException sqlEx)
        {
            System.out.println(sqlEx.getMessage());
        }

    }

    @Override
    public int execute(String sql) {
        return 0;
    }

    @Override
    public ResultSet executeQuery(String sql) {
        try
        {
             m_Resulset = m_Statement.executeQuery(sql);
        }
        catch (SQLException ex)
        {
        }
        return m_Resulset;
    }

    @Override
    public void disconnected() {

    }

    @Override
    public int executeUpdate(String sql) {
        return 0;
    }
}
