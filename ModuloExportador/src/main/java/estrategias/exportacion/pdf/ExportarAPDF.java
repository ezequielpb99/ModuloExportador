package estrategias.exportacion.pdf;

import estrategias.exportacion.EstrategiaDeExportacion;
import exportables.Exportable;

public class ExportarAPDF implements EstrategiaDeExportacion {
    private AdapterExportadorAPDF adapter;

    public ExportarAPDF(AdapterExportadorAPDF adapter){
        this.adapter = adapter;
    }

    public String exportar(Exportable exportable) {
        return this.adapter.exportar(exportable);
    }
}
