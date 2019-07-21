package com.spring.base.common.excel;

import java.util.List;

public class Sheet<T> {
private Integer sheet;
private List<T> vale;
public Integer getSheet() {
	return sheet;
}
public void setSheet(Integer sheet) {
	this.sheet = sheet;
}
public List<T> getVale() {
	return vale;
}
public void setVale(List<T> vale) {
	this.vale = vale;
}

}
