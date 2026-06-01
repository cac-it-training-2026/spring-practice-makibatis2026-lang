package jp.co.sss.practice.p06.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "area")
public class Area {

	@Id
	@GeneratedValue()
	@SequenceGenerator()
	private Integer areaId;
	
	@Column
	private String areaName;
	
	@Column
	private String detail;
}
