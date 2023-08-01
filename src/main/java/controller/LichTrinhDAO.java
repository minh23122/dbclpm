/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.mysql.cj.xdevapi.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.LichTrinh;

/**
 *
 * @author AD
 */
public class LichTrinhDAO {

    DAO dao = new DAO();
    Connection connection = null;

    public List<LichTrinh> getAllLTTours() throws SQLException, ClassNotFoundException {
        connection = dao.getConnection();
        String sql = "select * from tour left join lichtrinh on tour.id=lichtrinh.tour_id";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<LichTrinh> l=new ArrayList<>();
        while (rs.next()) {
            l.add(new LichTrinh(rs.getInt(6),rs.getInt(1)));
        }
        return l;
    }
    public List<LichTrinh> getAllLichTrinhs() throws SQLException, ClassNotFoundException{
        connection=dao.getConnection();
        String sqlString="select * from lichtrinh";
        PreparedStatement ps=connection.prepareStatement(sqlString);
        List<LichTrinh> list=new ArrayList<>();
        ResultSet rs=ps.executeQuery();
        while (rs.next()) {            
            list.add(new LichTrinh(rs.getInt(1),rs.getInt(2)));
        }
        return list;
    }
    public void themLT() throws SQLException, ClassNotFoundException{
        connection=dao.getConnection();
        String sql="insert into lichtrinh(id) values (?)";
        PreparedStatement ps=connection.prepareStatement(sql);
        List<LichTrinh> list=getAllLichTrinhs();
        ps.setInt(1, list.size()+1);
        ps.executeUpdate();
    }
}   
