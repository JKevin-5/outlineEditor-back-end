package com.example.templateengine.util;

import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import java.math.BigInteger;

public class TableStyle {

    /*
    * 功能说明：设置单元格内容
    * */
    public static void setCellText(XWPFTableCell cell, String text, String bgColor, ParagraphAlignment align,XWPFTableCell.XWPFVertAlign Halign, int fontSize, Boolean isBold) {
        //设置单元格背景色
//        if(bgColor != "" || !"".equals(bgColor)){
//            CTTc cttc = cell.getCTTc();
//            CTTcPr ctPr = cttc.addNewTcPr();
//            CTShd ctshd = ctPr.addNewShd();
//            ctshd.setFill(bgColor);
//        }
        CTP ctp = CTP.Factory.newInstance();


        if(text!=null&&text.contains("\n")){
            String[] a=text.split("\n");
            for (int i=0;i<a.length;i++){
                XWPFParagraph p = new XWPFParagraph(ctp, cell);
                p.setSpacingBetween(1.25);
                //设置单元格水平位置
                p.setAlignment(align);
                //System.out.println(a[i]);
                XWPFRun run = p.createRun();
                run.setColor("000000");
                run.setFontSize(fontSize);
                run.setText(a[i]);
                run.setBold(isBold);
                run.addBreak();
                CTRPr rpr = run.getCTR().isSetRPr() ? run.getCTR().getRPr() : run.getCTR().addNewRPr();
                CTFonts fonts = rpr.isSetRFonts() ? rpr.getRFonts() : rpr.addNewRFonts();
                fonts.setAscii("宋体");
                fonts.setEastAsia("宋体");
                fonts.setHAnsi("宋体");

                cell.setParagraph(p);
            }
        }else {
            XWPFParagraph p = new XWPFParagraph(ctp, cell);
            p.setSpacingBetween(1.25);
            //设置单元格水平位置
            p.setAlignment(align);
            XWPFRun run = p.createRun();
            run.setColor("000000");
            run.setFontSize(fontSize);
            run.setText(text);
            run.setBold(isBold);
            CTRPr rpr = run.getCTR().isSetRPr() ? run.getCTR().getRPr() : run.getCTR().addNewRPr();
            CTFonts fonts = rpr.isSetRFonts() ? rpr.getRFonts() : rpr.addNewRFonts();
            fonts.setAscii("宋体");
            fonts.setEastAsia("宋体");
            fonts.setHAnsi("宋体");
            cell.setParagraph(p);
        }





        //设置单元格长度,
        //cell.setWidth("25%");
        cell.setWidth("auto");

        //设置单元格垂直居中
        cell.setVerticalAlignment(Halign);

    }

    /*
    * 功能说明：word跨列合并单元格
    * */
    public static void mergeCellsHorizontal(XWPFTable table, int row, int fromCell, int toCell) {
        for (int cellIndex = fromCell; cellIndex <= toCell; cellIndex++) {
            XWPFTableCell cell = table.getRow(row).getCell(cellIndex);
            if ( cellIndex == fromCell ) {
                // The first merged cell is set with RESTART merge value
                cell.getCTTc().addNewTcPr().addNewHMerge().setVal(STMerge.RESTART);
            } else {
                // Cells which join (merge) the first one, are set with CONTINUE
                cell.getCTTc().addNewTcPr().addNewHMerge().setVal(STMerge.CONTINUE);
            }
        }
    }

    /*
    * 功能说明：word跨行并单元格
    * @param: XWPFTable
    * @param: col
    * @param: fromRow
    * @param: toRow
    * */
    public static  void mergeCellsVertically(XWPFTable table, int col, int fromRow, int toRow) {
        for (int rowIndex = fromRow; rowIndex <= toRow; rowIndex++) {
            XWPFTableCell cell = table.getRow(rowIndex).getCell(col);
            if ( rowIndex == fromRow ) {
                // The first merged cell is set with RESTART merge value
                cell.getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.RESTART);
            } else {
                // Cells which join (merge) the first one, are set with CONTINUE
                cell.getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.CONTINUE);
            }
        }
    }



}
