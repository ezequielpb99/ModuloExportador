package estrategias.exportacion.excel;

import estrategias.exportacion.EstrategiaDeExportacion;
import exportables.Exportable;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExportarAExcel implements EstrategiaDeExportacion {

    public String exportar(Exportable exportable) {
        Map<String, List<String>> datos = exportable.datos();


        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Sample sheet");
        Set<String> keyset = datos.keySet();
        int rownum = 0;
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = datos.get(key).toArray();
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++); if (obj instanceof Boolean) {
                    cell.setCellValue((Boolean) obj);
                } else if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Double) {
                    cell.setCellValue((Double) obj);
                }
            }
        }
        try {
            FileOutputStream out
                    = new FileOutputStream(new File("C:\\Users\\Z0041RZH\\Desktop\\ExcelsTest\\Test.xls"));
            workbook.write(out);
            out.close();
            System.out.println("Excel written successfully..");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



}
