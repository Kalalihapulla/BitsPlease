/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Izymi
 */
public enum Urgency {
    LOW(0),
    MEDIUM(1),
    HIGH(2);
    private final int number;

    private Urgency(int number) {
        this.number = number;
    }

   public int returnValue() {
        return this.number;
    }

}
