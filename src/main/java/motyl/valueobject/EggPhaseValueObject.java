package motyl.valueobject;

import java.sql.Date;
import java.time.*;

public class EggPhaseValueObject {
	
	private int id;
	private int recolectedEggs;
	private Date initDate;
	private Date endDate;
	private int realDays;
	private int finalLarvs;
	private int idSpecie;
	private String commonNameSpecie;
	private String imgSpecie;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRecolectedEggs() {
		return recolectedEggs;
	}
	public void setRecolectedEggs(int recolectedEggs) {
		this.recolectedEggs = recolectedEggs;
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
	public int getRealDays() {
		return realDays;
	}
	public void setRealDays(int realDays) {
		this.realDays = realDays;
	}
	public int getFinalLarvs() {
		return finalLarvs;
	}
	public void setFinalLarvs(int finalLarvs) {
		this.finalLarvs = finalLarvs;
	}
	public int getIdSpecie() {
		return idSpecie;
	}
	public void setIdSpecie(int idSpecie) {
		this.idSpecie = idSpecie;
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
