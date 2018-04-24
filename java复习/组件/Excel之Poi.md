&emsp;poi-3.9-20121203.jar
#### Demo1
```java
//创建一个xls，在第一行中写入几个数据
public class Demo01 {

	public static void main(String[] args) {
		Workbook workbook = new HSSFWorkbook();//定义一个新的工作簿
		Sheet sheet = workbook.createSheet("第一个sheet页");//创建一个sheet页
		Row row = sheet.createRow(0);//创建一列
		Cell cell = row.createCell(0);//创建一个单元格
		cell.setCellValue(1);//设置单元格的值

		row.createCell(1).setCellValue("nihao");//第二列
		row.createCell(2).setCellValue(1.2);//第三列
		row.createCell(3).setCellValue(true);//第四列
		row.createCell(4).setCellValue("xxx");//第五列
		row.createCell(5).setCellValue(1.222);//第六列

		FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream("d:\\test.xls");
			workbook.write(fileOutputStream);
			fileOutputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
```
