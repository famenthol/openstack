package com.it.demo.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestVO {

	
	public static void main(String[] args) throws InvalidFormatException, IOException{
		List<List<Object>> list = new ArrayList<>();
		List<Object> list1 = new ArrayList<Object>();
		list1.add("瑞昌市");
		list1.add("九江市");
		list1.add("鹰潭市");
		list1.add("南昌市");
		list1.add("上饶市");
		list.add(list1);
		List<String> list2 = new ArrayList<String>();
		for (int i=0; i<30; i++) {
			List<Object> temp = new ArrayList<Object>();
			for (int z=1;z<6; z++) {
				temp.add(i);
			}
			list.add(temp);
		}
		export(list);
	} 
	
	
	public static void export(List<List<Object>> excelList) throws IOException{
		Workbook[] wbs = new Workbook[] {  new XSSFWorkbook() };
        for (int i = 0; i < wbs.length; i++) {
            Workbook workbook = wbs[i];
            // 得到一个POI的工具类
            CreationHelper createHelper = workbook.getCreationHelper();

            // 在Excel工作簿中建一工作表，其名为缺省值, 也可以指定Sheet名称
            Sheet sheet = workbook.createSheet("成环率");
            // Sheet sheet = workbook.createSheet("SheetName");

            // 用于格式化单元格的数据
            DataFormat format = workbook.createDataFormat();

            // 设置字体
            Font font = workbook.createFont();
            font.setFontHeightInPoints((short) 20); // 字体高度
            font.setFontName("黑体"); // 字体
            font.setBoldweight(Font.BOLDWEIGHT_BOLD); // 宽度
            font.setItalic(true); // 是否使用斜体
            // font.setStrikeout(true); //是否使用划线

            // 设置单元格类型
            CellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setAlignment(CellStyle.ALIGN_CENTER); // 水平布局：居中
            cellStyle.setWrapText(true);

            CellStyle cellStyle2 = workbook.createCellStyle();
            cellStyle2.setDataFormat(format.getFormat("＃, ## 0.0"));

            CellStyle cellStyle3 = workbook.createCellStyle();
            cellStyle3.setDataFormat(format.getFormat("yyyy-MM-dd HH:mm:ss"));

            // 添加单元格注释
            // 创建Drawing对象,Drawing是所有注释的容器.
            Drawing drawing = sheet.createDrawingPatriarch();
            // ClientAnchor是附属在WorkSheet上的一个对象， 其固定在一个单元格的左上角和右下角.
            ClientAnchor anchor = createHelper.createClientAnchor();
            // 设置注释位子
            anchor.setRow1(0);
            anchor.setRow2(2);
            anchor.setCol1(0);
            anchor.setCol2(2);
            // 定义注释的大小和位置,详见文档
            Comment comment = drawing.createCellComment(anchor);
            // 设置注释内容
            RichTextString str = createHelper.createRichTextString("Hello, World!");
            comment.setString(str);
            // 设置注释作者. 当鼠标移动到单元格上是可以在状态栏中看到该内容.
            comment.setAuthor("H__D");
            
            int a = 0;
            for (List<Object> rows : excelList) {
            	Row row = sheet.createRow(a);
                if (rows.size() > 0) {
                	int b = 0;
                	for(Object content : rows) {
                		 Cell cell = row.createCell((short) b);
                		 System.out.println(content);
                		 if (content instanceof Integer) {
                			 cell.setCellValue(String.valueOf(content));
                		 }else {
                			 cell.setCellValue(content.toString());
                		 }
                		 // 设置单元格内容
                		 sheet.autoSizeColumn((short) b);
                		 b++;
                	}
                }
                a ++;
            	
            }
            String filename = "D:/workbook.xls";
            if (workbook instanceof XSSFWorkbook) {
                filename = filename + "x";
            }

            FileOutputStream out = new FileOutputStream(filename);
            workbook.write(out);
            out.close();
            // 定义几行
            /*\\for (int rownum = 0; rownum < 30; rownum++) {
                // 创建行
                Row row = sheet.createRow(rownum);
                // 创建单元格
                Cell cell = row.createCell((short) 0);
                cell.setCellValue(createHelper.createRichTextString("Hello！" + rownum));// 设置单元格内容
//                cell.setCellStyle(cellStyle);// 设置单元格样式
                cell.setCellType(Cell.CELL_TYPE_STRING);// 指定单元格格式：数值、公式或字符串
                cell.setCellComment(comment);// 添加注释

                // 格式化数据
                Cell cell2 = row.createCell((short) 1);
                cell2.setCellValue(11111.25);
//                cell2.setCellStyle(cellStyle2);

                Cell cell3 = row.createCell((short) 3);
                cell3.setCellValue(new Date());
//                cell3.setCellStyle(cellStyle3);

                sheet.autoSizeColumn((short) 0); // 调整第一列宽度
                sheet.autoSizeColumn((short) 1); // 调整第二列宽度
                sheet.autoSizeColumn((short) 2); // 调整第三列宽度
                sheet.autoSizeColumn((short) 3); // 调整第四列宽度

            }

            // 合并单元格
            sheet.addMergedRegion(new CellRangeAddress(1, // 第一行（0）
                    2, // last row（0-based）
                    1, // 第一列（基于0）
                    2 // 最后一列（基于0）
            ));

            // 保存
            String filename = "D:/workbook.xls";
            if (workbook instanceof XSSFWorkbook) {
                filename = filename + "x";
            }

            FileOutputStream out = new FileOutputStream(filename);
            workbook.write(out);
            out.close();*/
        }
	}
  }