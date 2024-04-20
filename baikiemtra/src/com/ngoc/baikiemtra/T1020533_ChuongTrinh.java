package com.ngoc.baikiemtra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.ngoc._T1020533_model.T1020533_ThongTinVe;
import com.ngoc._T1020533_model.T1020533_ThongTinVeOto;
import com.ngoc._T1020533_model.T1020533_ThongTinVeXeDap;
import com.ngoc._T1020533_model.T1020533_ThongTinVeXeMay;

public class T1020533_ChuongTrinh {
	static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd/MM/yyyy");
	public static void main(String[] args) {
//		test();
		try {
			var list = readFile("E:\\Java\\baikiemtra\\src\\vao.txt");
			xuLyThongTinRa("E:\\Java\\baikiemtra\\src\\ra.txt", list);
			inDanhSáchGiữXe(list);
			inDanhSachXeConTrongBai(list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	static void test() {
		System.out.println("test");
	}
	static List<T1020533_ThongTinVe> readFile(String filename) throws IOException, ParseException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		
		var list = new ArrayList<T1020533_ThongTinVe>();
		while(true) {
			String line = br.readLine();
			if(line == null) break;
			var info = line.split(";");
			var loaixe = info[0];
			var bienso = info[1];
			var sove = info[2];
			var thoidiemvao = sdf.parse(info[3]);
			var tinhtrang1 = info[4];
			
			if(loaixe.equals("0")) {
				var x = new T1020533_ThongTinVeXeDap();		
				x.setSoVe(sove);
				x.setThoiDiemVao(thoidiemvao);
				list.add(x);
			}else if(loaixe.equals("2")) {
				var x = new T1020533_ThongTinVeXeMay();	
				x.setBienSo(bienso);
				x.setThoiDiemVao(thoidiemvao);
				list.add(x);
			}else if(loaixe.equals("4")) {
				var x = new T1020533_ThongTinVeOto();
				x.setBienSo(bienso);
				x.setThoiDiemVao(thoidiemvao);
				x.setTinhTrangVao(tinhtrang1);
				list.add(x);
			}
			
		}
		br.close();
		return list;
	}
	
	static void xuLyThongTinRa(String filename, List<T1020533_ThongTinVe> lst) throws IOException, ParseException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		
		while(true) {
			String line = br.readLine();
			if(line == null) break;
			var info = line.split(";");
			var loaixe = info[0];
			var bienso = info[1];
			var sove = info[2];
			var thoidiemra = sdf.parse(info[3]);
			var tinhtrang2 = info[4];
			
			for(T1020533_ThongTinVe x : lst) {				
				if(loaixe.equals("0")) {
					if(x.getBienSoHoacSoVe().equals(sove)) {
						x.setThoiDiemRa(thoidiemra);	
					}
				}else if(loaixe.equals("2")) {
					if(x.getBienSoHoacSoVe().equals(bienso)) {
						x.setThoiDiemRa(thoidiemra);	
					}
				}else if(loaixe.equals("4")) {
					if(x.getBienSoHoacSoVe().equals(bienso)) {
						T1020533_ThongTinVeOto oto = (T1020533_ThongTinVeOto) x;
						oto.setThoiDiemRa(thoidiemra);
						oto.setTinhTrangRa(tinhtrang2);
					}
				}
			}
		}
		br.close();
	}
	static void inDanhSáchGiữXe(List<T1020533_ThongTinVe> lst) {
		int stt = 0;
		for (T1020533_ThongTinVe x: lst) {
			if (x.getGia() != null) {
				stt++;
				System.out.printf("%-5d %-5s %-15s %-15s %-10s %-20s %-20s %-15s\n",stt, x.getLoaiXe(), sdf.format(x.getThoiDiemVao()), sdf.format(x.getThoiDiemRa()), x.getBienSoHoacSoVe(), x.getTinhTrang1(), x.getTinhTrang2(), x.getGia());
			}
		}
	}
	static void inDanhSachXeConTrongBai(List<T1020533_ThongTinVe> lst) {
		int stt = 0;
		for (T1020533_ThongTinVe x: lst) {
			if (x.getGia() == null) {
				stt++;
				System.out.printf("%-5d %-5s %-15s %-15s %-10s %-20s %-20s %-15s\n",stt, x.getLoaiXe(), sdf.format(x.getThoiDiemVao()), x.getBienSoHoacSoVe(), x.getTinhTrang1());
			}
		}
	}

}
