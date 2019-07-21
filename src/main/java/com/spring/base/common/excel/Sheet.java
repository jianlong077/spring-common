package com.spring.base.common.excel;

import java.util.List;

public class Sheet<T> {
private String sheetIndex;
private List<T> vale;

public String getSheetIndex() {
	return sheetIndex;
}
public void setSheetIndex(String sheetIndex) {
	this.sheetIndex = sheetIndex;
}
public List<T> getVale() {
	return vale;
}
public void setVale(List<T> vale) {
	this.vale = vale;
}

}
