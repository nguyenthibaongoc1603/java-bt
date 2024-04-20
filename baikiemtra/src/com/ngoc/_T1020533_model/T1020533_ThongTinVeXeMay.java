package com.ngoc._T1020533_model;

public class T1020533_ThongTinVeXeMay extends T1020533_ThongTinVe {
	public String bienSo;
	public String getBienSo() {
		return bienSo;
	}
	
	public void setBienSo(String bienSo) {
		this.bienSo = bienSo;
	}

	@Override
	public String getBienSoHoacSoVe() {
		// TODO Auto-generated method stub
		return this.getBienSo();
	}

	@Override
	public String getLoaiXe() {
		// TODO Auto-generated method stub
		return "2";
	}

	@Override
	public String getTinhTrang1() {
		// TODO Auto-generated method stub
		return "-";
	}

	@Override
	public String getTinhTrang2() {
		// TODO Auto-generated method stub
		return "-";
	}

	public T1020533_ThongTinVeXeMay() {
		super();
	}
	@Override
	public Double getGia() {
		var soMsguixe = 24*60*60*1000;
		var soThoiGian = this.getThoiDiemRa().getTime() - this.getThoiDiemVao().getTime();
		var price = 3000;
		var soTien = Math.ceil(soThoiGian / soMsguixe) * price;
		return soTien;
	}
	
}
