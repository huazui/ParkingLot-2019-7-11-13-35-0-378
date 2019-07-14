package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    List<Car> allCar = new ArrayList<Car>();
    private int limit;
  public ParkingLot(int limit){
      this.limit=limit;
  }
    public void getPark(Car car) {
        allCar.add(car);
        this.limit += 1;
    }

    public List<Car> getAllCar() {
        return allCar;
    }

    public int getLimit() {
        return limit;
    }

    public void setAllCar(List<Car> allCar) {
        this.allCar = allCar;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public boolean fetchCar(Ticket ticket) {

        for (int i = 0; i < allCar.size(); i++) {
            if (allCar.get(i).getCarId() == ticket.getCar().getCarId()) {
                allCar.remove(i);
                this.limit -= 1;
                return true;
            }
        }
        return false;
    }
}
