package estrategias.exportacion.pdf;

import exportables.Exportable;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AdapterApachePDFBox implements AdapterExportadorAPDF {

    public String exportar(Exportable exportable) {
        Map<String, List<String>> datos = exportable.datos();
        Set<String> keyset = datos.keySet();
        try (PDDocument doc = new PDDocument()) {

            PDPage myPage = new PDPage();
            doc.addPage(myPage);

            try (PDPageContentStream cont = new PDPageContentStream(doc, myPage)) {
                for (String key : keyset) {
                    Object[] objArr = datos.get(key).toArray();
                    for (Object obj : objArr) {

                        cont.beginText();

                        cont.setFont(PDType1Font.TIMES_ROMAN, 12);
                        cont.setLeading(14.5f);

                        cont.newLineAtOffset(25, 700);
                        cont.showText(obj.toString());

                        cont.newLine();
                    }
                }



                cont.endText();
            }

            doc.save("C:\\Users\\Z0041RZH\\Desktop\\PDFTest\\Test.pdf");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
