package com._520it.crm.util;

/**
 * Created by Administrator on 2017/10/16.
 */

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Excel {

    /**
     * 导出数据为XLS格式
     * @param fileName        文件的名称，可以设为绝对路径，也可以设为相对路径
     * @param content        数据的内容
     */
        public static void exportExcel(String fileName, Vector<ExcelMV> content) {
        WritableWorkbook wwb;
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(fileName);
            wwb = Workbook.createWorkbook(fos);
            WritableSheet ws = wwb.createSheet("入库、出库明细", 10);        // 创建一个工作表

            //    设置单元格的文字格式
            WritableFont wf = new WritableFont(WritableFont.ARIAL,12,WritableFont.NO_BOLD,false,
                    UnderlineStyle.NO_UNDERLINE,Colour.BLUE);
            WritableCellFormat wcf = new WritableCellFormat(wf);
            wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
            wcf.setAlignment(Alignment.CENTRE);
            ws.setRowView(1, 500);
            List<String> title = new ArrayList<>();
            title.add("商品名称"); title.add("商品价格");
            title.add("进货价/发货价");title.add("会员价");
            title.add("数量");title.add("入库方式");
            title.add("库存单号");title.add("原有规格");
            title.add("数量");title.add("拆零规格");  title.add("生产日期");
            title.add("保质期");title.add("预警日期");
            title.add("预警数量");title.add("操作");
             for (int i = 1; i <=title.size(); i++){
                ws.addCell(new Label(i ,1 , title.get(i-1), wcf));
             }

            //    填充数据的内容
            ExcelMV[] p = new ExcelMV[content.size()];
            for (int i = 0; i < content.size(); i++){
                p[i] = (ExcelMV)content.get(i);
                ws.addCell(new Label(1, i + 2, p[i].getProductInfoId(), wcf));
           /*     ws.addCell(new Label(2, i + 2, p[i].getProductStockSn(), wcf));*/
                ws.addCell(new Label(2, i + 2, p[i].getProductionPrice(), wcf));
                ws.addCell(new Label(3, i + 2, p[i].getCostPrice(), wcf));
                ws.addCell(new Label(4, i + 2, p[i].getMemberPrice(), wcf));
                ws.addCell(new Label(5, i + 2, p[i].getNumber(), wcf));
                ws.addCell(new Label(6, i + 2, p[i].getStockIncomeId(), wcf));
               ws.addCell(new Label(7, i + 2, p[i].getProductStockSn(), wcf));
               ws.addCell(new Label(8, i + 2, p[i].getSpecificId(), wcf));
                ws.addCell(new Label(9, i + 2, p[i].getSpecificNumber(),wcf));
                ws.addCell(new Label(10, i + 2, p[i].getOpenStockId(), wcf));
               ws.addCell(new Label(11, i + 2, p[i].getInputTime(), wcf));
               ws.addCell(new Label(12, i + 2, p[i].getSurvivalTime(), wcf));
               ws.addCell(new Label(13, i + 2, p[i].getWarnDate(), wcf));
               ws.addCell(new Label(14, i + 2, p[i].getWarnNumber(), wcf));
               ws.addCell(new Label(15, i + 2, p[i].getOperation(), wcf));

                if(i == 0)
                    wcf = new WritableCellFormat();
            }
/*            'productInfo.name': $("#product_name").combobox("getText"),
                    'productionPrice': $("#code").textbox("getText"),
                    'costPrice': $("#costPrice").numberbox("getText"),
                    'memberPrice': $("#memberPrice").numberbox("getValue"),
                    'number': $("#number").numberbox("getValue"),
                    'stockIncome.id': $("#stockIncome").combobox("getText"),
                    'productStock.sn': $("#sn").textbox("getText"),
                    'specific.number': $("#specific_number").numberbox("getValue"),
                    'specific.id': $("#before_specific").combobox("getText"),
                    'specific.stockSpecific': $("#stock_specific").combobox("getText"),
                    'inputTime': $("#product_date").datebox("getValue"),
                    'survivalTime': $("#survival_time").datebox("getValue"),
                    'warnDate': $("#input_survival").datebox("getValue"),
                    'warnNumber': $("#warn_number").numberbox("getValue"),
                    'operation': $("#warn_operation").textbox("getText")*/

            wwb.write();
            fos.flush();
            wwb.close();
        } catch (IOException e){
        } catch (RowsExceededException e){
        } catch (WriteException e){}
    }

    /**
     * 从Excel文件里读取数据保存到Vector里
     * @param fileName        Excel文件的名称
     * @return                Vector对象,里面包含从Excel文件里获取到的数据
     */
    public static Vector<ExcelMV> importExcel(String fileName){
        Vector<ExcelMV> v = new Vector<ExcelMV>();
        try {
            Workbook book = Workbook.getWorkbook(new File(fileName));
            Sheet sheet = book.getSheet(0);        // 获得第一个工作表对象
            int rows = sheet.getRows();

            for(int i = 2; i < rows; i++) {
                Cell [] cell = sheet.getRow(i);
                if(cell.length == 0)
                    continue;
                ExcelMV p = new ExcelMV();
               p.setProductInfoId(sheet.getCell(1, i).getContents());
                p.setProductionPrice(sheet.getCell(2, i).getContents());
                p.setCostPrice(sheet.getCell(3, i).getContents());
                p.setMemberPrice(sheet.getCell(4, i).getContents());
                p.setNumber(sheet.getCell(5, i).getContents());
                p.setStockIncomeId(sheet.getCell(6, i).getContents());
                p.setProductStockSn(sheet.getCell(7, i).getContents());
                p.setSpecificId(sheet.getCell(8, i).getContents());
                p.setSpecificNumber(sheet.getCell(9, i).getContents());
                p.setOpenStockId(sheet.getCell(10, i).getContents());
                p.setInputTime(sheet.getCell(11, i).getContents());
                p.setSurvivalTime(sheet.getCell(12, i).getContents());
                p.setWarnDate(sheet.getCell(13, i).getContents());
                p.setWarnNumber(sheet.getCell(14, i).getContents());
                p.setOperation(sheet.getCell(15, i).getContents());

                v.add(p);
            }

            book.close();
        }catch(Exception e) {}
        return v;
    }

    public static void main(String [] args){
        String fileName = "test.xls";
        String fileNameNew = "testNew.xls";

        ExcelMV p0 = new ExcelMV();
        p0.setOperation("姓名");
        p0.setSurvivalTime("字");
    /*    ExcelMV p1 = new ExcelMV("赵云","子龙","98","84","83","87","单骑救主!!!");
        ExcelMV p2 = new ExcelMV("马超","孟起","98","62","40","88","杀得曹操割须弃袍!!!");
        ExcelMV p3 = new ExcelMV("诸葛亮","孔明","55","100","92","93","死后木偶退兵，锦囊杀魏延!!!");*/

        Vector<ExcelMV> v = new Vector<ExcelMV>();
        v.add(p0);
   /*     v.add(p1);
        v.add(p2);
        v.add(p3);*/

   /*     exportExcel(fileName, v);
        System.out.println("成功导出数据到Excel文件(" + fileName + ")了!!!");*/

        Vector<ExcelMV> vector = importExcel(fileName);
        System.out.println(vector);
        System.out.println("成功从Excel文件(" + fileName + ")导入数据!!!");
/*
        exportExcel(fileNameNew, vector);
        System.out.println("成功将" + fileName + "里的数据手复制到" + fileNameNew + "中!!!");*/
    }
}