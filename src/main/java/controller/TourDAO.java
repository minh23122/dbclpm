/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Tour;

/**
 *
 * @author AD
 */
public class TourDAO {
    DAO dao=new DAO();
    Connection connection=null;
    public Tour getTourbyId(int id) throws SQLException, ClassNotFoundException{
        connection=dao.getConnection();
        String sql="select * from tour where id=?";
        PreparedStatement ps=connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            return new Tour(id,rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5));
        }
        return null;
    }
    public List<Tour> getTourLTs() throws SQLException, ClassNotFoundException{
        connection=dao.getConnection();
        List<Tour> list=new ArrayList<>();
        String sql="select t.id,t.ten, t.noiden, t.noixuatphat, t.mota from tour t left join lichtrinh l on t.id=l.tour_id";
        PreparedStatement ps=connection.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        while (rs.next()) {            
            list.add(new Tour(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5)));
        }
        return list;
    }
}
