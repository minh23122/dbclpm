/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.TourDAO;
import java.sql.SQLException;

/**
 *
 * @author AD
 */
public class LichTrinh {
    private int id;
    private Tour tour;

    public LichTrinh() {
    }
    TourDAO tourDAO=new TourDAO();

    public LichTrinh(int id, int tourId) throws SQLException, ClassNotFoundException {
        this.id = id;
        this.tour=tourDAO.getTourbyId(tourId);
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }
    
    
    
}
