package com.spring.base.common.excel;

import java.util.List;

public class Sheet<T> {
private Integer sheetIndex;
private List<T> vale;

public Integer getSheetIndex() {
	return sheetIndex;
}
public void setSheetIndex(Integer sheetIndex) {
	this.sheetIndex = sheetIndex;
}
public List<T> getVale() {
	return vale;
}
public void setVale(List<T> vale) {
	this.vale = vale;
}

}
