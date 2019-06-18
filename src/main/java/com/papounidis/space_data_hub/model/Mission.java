package com.papounidis.space_data_hub.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/*
The specification of Mission as a data type that will be created in the tables of the database
 */

@Entity
public class Mission {

    @Id
    @GeneratedValue
    private int id;
    private String name = "";
    private ImageType type;
    private Date start;
    private Date end;

    public Mission() {
    }

    public Mission(String name, ImageType type, Date start, Date end) {

        this.name = name;
        this.type = type;
        this.start = start;
        this.end = end;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ImageType getType() {
        return this.type;
    }

    public Date getStart() {
        return  start;
    }

    public Date getEnd() {
        return end;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(ImageType type) {
        this.type = type;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

}
