package jp.co.sss.practice.p08.q01.form;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public class BodyTempForm {

	@NotNull
	@DecimalMin(value = "30.0")
	@DecimalMax(value = "45.0")
	
	private Double bodyTemp;
	
	@NotNull
	private java.util.Date inputDate;

	/**
	 * @return bodyTemp
	 */
	public Double getBodyTemp() {
		return bodyTemp;
	}

	/**
	 * @param bodyTemp セットする bodyTemp
	 */
	public void setBodyTemp(Double bodyTemp) {
		this.bodyTemp = bodyTemp;
	}

	/**
	 * @return inputDate
	 */
	public java.util.Date getInputDate() {
		return inputDate;
	}

	/**
	 * @param inputDate セットする inputDate
	 */
	public void setInputDate(java.util.Date inputDate) {
		this.inputDate = inputDate;
	}
	
}
