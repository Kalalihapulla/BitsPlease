/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Izymi
 */
@XmlRootElement
public class TestMdel {
    private String ulu;
    private String kana;

    public TestMdel(String ulu, String kana) {
        this.ulu = ulu;
        this.kana = kana;
    }

    public String getUlu() {
        return ulu;
    }

    public void setUlu(String ulu) {
        this.ulu = ulu;
    }

    public String getKana() {
        return kana;
    }

    public void setKana(String kana) {
        this.kana = kana;
    }
}
