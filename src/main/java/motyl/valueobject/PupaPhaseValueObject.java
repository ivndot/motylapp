package motyl.valueobject;

import java.sql.Date;

public class PupaPhaseValueObject {
	
	private int id;
	private int initPupas;
	private Date initDate;
	private Date endDate;
	private int endAdults;
	private int idLoteLarva;
	private String commonNameSpecie;
	private String imgSpecie;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getInitPupas() {
		return initPupas;
	}
	public void setInitPupas(int initPupas) {
		this.initPupas = initPupas;
	}
	public Date getInitDate() {
		return initDate;
	}
	public void setInitDate(Date initDate) {
		this.initDate = initDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getEndAdults() {
		return endAdults;
	}
	public void setEndAdults(int endAdults) {
		this.endAdults = endAdults;
	}
	public int getIdLoteLarva() {
		return idLoteLarva;
	}
	public void setIdLoteLarva(int idLoteLarva) {
		this.idLoteLarva = idLoteLarva;
	}
	public String getCommonNameSpecie() {
		return commonNameSpecie;
	}
	public void setCommonNameSpecie(String commonNameSpecie) {
		this.commonNameSpecie = commonNameSpecie;
	}
	public String getImgSpecie() {
		return imgSpecie;
	}
	public void setImgSpecie(String imgSpecie) {
		this.imgSpecie = imgSpecie;
	}
	
	
}
