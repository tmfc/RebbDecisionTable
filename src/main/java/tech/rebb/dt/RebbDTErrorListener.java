package tech.rebb.dt;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.util.Objects;

public class RebbDTErrorListener extends BaseErrorListener {
    private String error = "";

    public static final RebbDTErrorListener INSTANCE = new RebbDTErrorListener();

    public RebbDTErrorListener() {
    }

    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        this.error = "line " + line + ":" + charPositionInLine + " " + msg;
    }

    public String getError()
    {
        return this.error;
    }

    public void clearError() { this.error = ""; }

    public boolean hasError()
    {
        return !Objects.equals(this.error, "");
    }
}
