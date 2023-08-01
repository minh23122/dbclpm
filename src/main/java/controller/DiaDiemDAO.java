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
import model.DiaDiem;

/**
 *
 * @author AD
 */
public class DiaDiemDAO {
    DAO dao=new DAO();
    public DiaDiem getDiaDiemById(int id) throws SQLException, ClassNotFoundException{
        String sql ="SELECT * FROM diadiem where id=?";
        Connection con=dao.getConnection();
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
                String name=rs.getString(2);
                String mota=rs.getString(3);
                DiaDiem d=new DiaDiem(id, name, mota);
                return d;
        }
        return null;
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DiaDiemDAO dddao=new DiaDiemDAO();
        DiaDiem d=dddao.getDiaDiemById(2);
            System.out.println(d);
    }
}
