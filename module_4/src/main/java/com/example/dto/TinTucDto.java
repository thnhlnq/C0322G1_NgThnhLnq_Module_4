package com.example.dto;

import com.example.model.DanhMuc;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class TinTucDto {

    private int id;
    @Size(max = 50, message = "Không quá 50 Kí tự !")
    private String tieuDe;

    @Size(max = 500, message = "Không quá 500 kí tự !")
    private String noiDung;

    @NotBlank
    private String ngayDang;

    @NotBlank
    private String phongVien;

    private DanhMuc danhMuc;

    public TinTucDto() {
    }

    public TinTucDto(int id, String tieuDe, String noiDung, String ngayDang, String phongVien, DanhMuc danhMuc) {
        this.id = id;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.ngayDang = ngayDang;
        this.phongVien = phongVien;
        this.danhMuc = danhMuc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getNgayDang() {
        return ngayDang;
    }

    public void setNgayDang(String ngayDang) {
        this.ngayDang = ngayDang;
    }

    public String getPhongVien() {
        return phongVien;
    }

    public void setPhongVien(String phongVien) {
        this.phongVien = phongVien;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }
}
