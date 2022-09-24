package com.example.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class DanhMuc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "danhMuc")
    private Set<TinTuc> tinTucs;

    public DanhMuc() {
    }

    public DanhMuc(int id, String name, Set<TinTuc> tinTucs) {
        this.id = id;
        this.name = name;
        this.tinTucs = tinTucs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<TinTuc> getTinTucs() {
        return tinTucs;
    }

    public void setTinTucs(Set<TinTuc> tinTucs) {
        this.tinTucs = tinTucs;
    }
}
