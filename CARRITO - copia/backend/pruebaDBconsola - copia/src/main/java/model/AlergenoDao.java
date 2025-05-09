package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlergenoDao implements  iDao{
private final String SQL_FIND ="SELECT * from ALLERGENS WHERE 1=1 ";
private IMotorSql motorSql;
public  AlergenoDao()
{
    motorSql= new MotorSql();

}
    @Override
    public int add(Object bean) {
        return 0;
    }

    @Override
    public int delete(Object e) {

        return 0;
}

    @Override
    public int update(Object bean) {
        return 0;
    }

    @Override
    public ArrayList FindAll(Object bean) {
       ArrayList<Alergeno> alergenos= new ArrayList<Alergeno>();
       String sql = SQL_FIND;
       try {
           motorSql.connect();

           if (bean !=null ){
               Alergeno alergeno =(Alergeno)bean;
               if (alergeno.getID() >=0){
                   sql += " AND ALLERGEN_ID =' "+ alergeno.getID()+"'";
               }
               if (alergeno.getName()!=""){
                   sql += " AND NAME =' "+ alergeno.getName()+"'";

               }
               if ((alergeno.getDescription()!="")){
                   sql += " AND DESCRIPTION =' "+ alergeno.getDescription()+"'";
               }
               alergeno.toSqlWhereString();
           }
           ResultSet rs=motorSql.executeQuery(sql);
           while (rs.next()){
               Alergeno alergenoBd = new Alergeno(
                        rs.getInt("ALLERGEN_ID"),
                        rs.getString("Name")
               );
                alergenoBd.setDescription(rs.getString("Description"));
                alergenos.add((alergenoBd));
           }
       }
      catch (SQLException e){
          System.out.println(e);
      }

        return alergenos;
    }

}
