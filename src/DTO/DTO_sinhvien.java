package DTO;

import java.util.Calendar;
import java.util.Date;

public class DTO_sinhvien {
	public String idcard,masv,tensv;
	public String ngayvaora;
	public String giovaora;
	public String trangthai;
	public String giovao,giora;
	public int solanvao,solanra;
	
	
	public DTO_sinhvien() {
	}
	public DTO_sinhvien(String idcard,String masv,String tensv,String trangthai, String giovaora,String ngayvaora,String giovao,String giora) {
		idcard=this.idcard;
		masv=this.masv;
		tensv=this.tensv;
		trangthai=this.trangthai;
		giovaora=this.giovaora;
		ngayvaora=this.ngayvaora;
		giovao=this.giovao;
		giora=this.giora;
		
	}
	
	public String getGiovao() {
		return giovao;
	}
	public void setGiovao(String giovao) {
		this.giovao = giovao;
	}
	public String getGiora() {
		return giora;
	}
	public void setGiora(String giora) {
		this.giora = giora;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getMasv() {
		return masv;
	}
	public void setMasv(String masv) {
		this.masv = masv;
	}
	public String getTensv() {
		return tensv;
	}
	public void setTensv(String tensv) {
		this.tensv = tensv;
	}
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	public String getNgayvaora() {
		return ngayvaora;
	}
	public void setNgayvaora(String ngayvaora) {
		this.ngayvaora = ngayvaora;
	}
	public String getGiovaora() {
		return giovaora;
	}
	public void setGiovaora(String giovaora) {
		this.giovaora = giovaora;
	}

	
}
