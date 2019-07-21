package com.spring.base.common.excel;

import java.util.Date;

import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import cn.afterturn.easypoi.excel.annotation.Excel;
@ExcelTarget("oleAcceptVo")
public class ExampEntity {
	 @Excel(name = "VSS接收时间", exportFormat = "yyyy-MM-dd")
	 private Date releasedate;
	 @Excel(name = "商品编码")
	 private String goodsid;
}
