package com.ngoc._T1020533_model;

import java.util.Date;

public abstract class T1020533_ThongTinVe {
	public Date thoiDiemVao;
	public Date thoiDiemRa;
	
	public T1020533_ThongTinVe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Date getThoiDiemRa() {
		return thoiDiemRa;
	}
	public Date getThoiDiemVao() {
		return thoiDiemVao;
	}

	public void setThoiDiemVao(Date thoiDiemVao) {
		this.thoiDiemVao = thoiDiemVao;
	}
	public void setThoiDiemRa(Date thoiDiemRa) {
		this.thoiDiemRa = thoiDiemRa;
	}
	public abstract String getBienSoHoacSoVe();
	public abstract String getLoaiXe();		
	public abstract String getTinhTrang1();
	public abstract String getTinhTrang2();
	public abstract Double getGia();
}
