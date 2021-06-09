package motyl.valueobject;

import java.sql.Date;

public class LarvaPhaseValueObject {
	
	private int id;
	private int initLarvas;
	private Date initDate;
	private Date changeDate;
	private Date endDate;
	private int endPupas;
	private int idLoteEgg;
	private String commonNameSpecie;
	private String imgSpecie;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getInitLarvas() {
		return initLarvas;
	}
	public void setInitLarvas(int initLarvas) {
		this.initLarvas = initLarvas;
	}
	public Date getInitDate() {
		return initDate;
	}
	public void setInitDate(Date initDate) {
		this.initDate = initDate;
	}
	public Date getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getEndPupas() {
		return endPupas;
	}
	public void setEndPupas(int endPupas) {
		this.endPupas = endPupas;
	}
	public int getIdLoteEgg() {
		return idLoteEgg;
	}
	public void setIdLoteEgg(int idLoteEgg) {
		this.idLoteEgg = idLoteEgg;
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
