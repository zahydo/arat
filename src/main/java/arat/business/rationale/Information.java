/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arat.business.rationale;

/**
 *
 * @author sahydo
 */
public class Information {

    private String path;
    private String name;
    private String type;

    public Information(String path, String name, String type) {
        this.path = path;
        this.name = name;
        this.type = type;
    }

    public Information() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
