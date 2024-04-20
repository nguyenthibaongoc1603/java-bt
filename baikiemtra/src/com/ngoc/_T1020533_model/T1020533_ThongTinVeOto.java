package com.ngoc._T1020533_model;

public class T1020533_ThongTinVeOto extends T1020533_ThongTinVe {
	public String bienSo;
	public String tinhTrangVao;
	public String tinhTrangRa;
	public String getBienSo() {
		return bienSo;
	}
	@Override
	public String getBienSoHoacSoVe() {
		// TODO Auto-generated method stub
		return this.getBienSo();
	}

	public void setTinhTrangVao(String tinhTrangVao) {
		this.tinhTrangVao = tinhTrangVao;
	}
	public void setTinhTrangRa(String tinhTrangRa) {
		this.tinhTrangRa = tinhTrangRa;
	}
	public void setBienSo(String bienSo) {
		this.bienSo = bienSo;
	}
	@Override
	public String getLoaiXe() {
		// TODO Auto-generated method stub
		return "4";
	}

	@Override
	public String getTinhTrang1() {
		// TODO Auto-generated method stub
		return this.tinhTrangVao;
	}

	@Override
	public String getTinhTrang2() {
		// TODO Auto-generated method stub
		return this.tinhTrangRa;
	}

	@Override
	public Double getGia() {
		var soMsguixe = 30*60*1000;
		var soThoiGian = this.getThoiDiemRa().getTime() - this.getThoiDiemVao().getTime();
		var price = 5000;
		var soTien = Math.ceil(soThoiGian / soMsguixe) * price;
		return soTien;
	}
	public T1020533_ThongTinVeOto() {
		super();
	}
	
	
}
