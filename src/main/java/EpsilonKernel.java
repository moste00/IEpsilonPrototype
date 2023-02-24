import io.github.spencerpark.jupyter.kernel.BaseKernel;
import io.github.spencerpark.jupyter.kernel.LanguageInfo;
import io.github.spencerpark.jupyter.kernel.display.DisplayData;
import org.eclipse.epsilon.eol.EolModule;

public class EpsilonKernel extends BaseKernel {
    private static final LanguageInfo
            info = new LanguageInfo.Builder("Epsilon")
                                   .mimetype("text/ecode")
                                   .fileExtension(".eol")
                                   .build();
    EolModule eol;
    StringStream out;
    ExprResultRecorder rec;
    public EpsilonKernel() {
        eol = new EolModule();
        out = new StringStream();
        rec = new ExprResultRecorder();

        eol.getContext().setOutputStream(out);
        eol.getContext().getExecutorFactory().addExecutionListener(rec);
    }
    @Override
    public DisplayData eval(String expr) throws Exception {
        boolean isValidEOL = eol.parse(expr);
        if (!isValidEOL) {
            isValidEOL = eol.parse(expr + ";");
            if(!isValidEOL) return new DisplayData("Syntax Error : \n\t"+ eol.getParseProblems());
        }

        rec.forgetAll();
        eol.execute();

        if (out.objectsAvailable()) return new DisplayData(out.allPrintedObjects());

        if (rec.valuesAvailable()) return new DisplayData(rec.lastValue().toString());

        return new DisplayData("");
    }

    @Override
    public LanguageInfo getLanguageInfo() {
        return info ;
    }
}
