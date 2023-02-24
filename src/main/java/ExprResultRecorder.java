import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.control.IExecutionListener;

import java.util.Stack;

public class ExprResultRecorder implements IExecutionListener {
    Stack<Object> record ;
    public ExprResultRecorder() {
        record = new Stack<>();
    }

    @Override
    public void aboutToExecute(ModuleElement moduleElement, IEolContext iEolContext) {

    }

    @Override
    public void finishedExecuting(ModuleElement moduleElement, Object o, IEolContext iEolContext) {
        if (o == null) return;

        record.push(o);
    }

    @Override
    public void finishedExecutingWithException(ModuleElement moduleElement, EolRuntimeException e, IEolContext iEolContext) {

    }

    public boolean valuesAvailable() {
        return !record.empty();
    }

    public Object lastValue() {
        return record.peek();
    }
    public void forgetAll() {
        record.clear();
    }
}
