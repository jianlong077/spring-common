package com.spring.base.common.excel;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletResponse;

import com.spring.base.common.io.IoUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
public class  Excel {
	private String path = "Excel/ole.xlsx";
	private Map<String, Object> sheets = new HashMap<String, Object>();
	/**
	 * 
	 * @param fileName 文件名
	 * @param response HttpServletResponse；
	 */
	public void downLoadExcel(String fileName,HttpServletResponse response) {
		// 利用了java运行时的系统属性来得到jar文件位置，也是/xxx/xxx.jar这种形式。
		String tempPath = IoUtil.convertResourceTemplatePath(path);
		TemplateExportParams params = new TemplateExportParams(tempPath, true);
		Workbook workbook = ExcelExportUtil.exportExcel(params, sheets);
		downLoadExcel(fileName, response, workbook);
	}
	public <T> List<T>  ImportExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass) throws IOException, Exception {
		    ImportParams params = new ImportParams();
	        params.setTitleRows(titleRows);
	        params.setHeadRows(headerRows);	   
	        List<T> list=ExcelImportUtil.importExcel(file.getInputStream(), pojoClass, params);
	        return list;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	public <T> void buildSheetValue(Sheet<T> sheet) {
		sheets.put(sheet.getSheetIndex()+"", sheet.getVale());
	}
	//控制层输出调用此方法
	public static void downLoadExcel(String fileName, HttpServletResponse response, Workbook workbook) {
        try {
        	fileName = new String(fileName.getBytes(), "ISO-8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" +fileName+".xlsx");
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
