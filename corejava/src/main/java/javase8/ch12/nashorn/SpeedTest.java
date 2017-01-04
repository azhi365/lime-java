package javase8.ch12.nashorn;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by benhail on 2014/5/27.
 */
public class SpeedTest {


    static final int RUNS = 30;

    static String readFile(String fileName) throws IOException {

        return new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
    }

    static void rhino(String parser, String code) {
        String source = "speedtest";
        int line = 1;
        Context context = Context.enter();
        context.setOptimizationLevel(9);
        try {
            Scriptable scope = context.initStandardObjects();
            context.evaluateString(scope, parser, source, line, null);
            ScriptableObject.putProperty(scope, "$code", Context.javaToJS(code, scope));

            Object tree = new Object();
            Object tokens = new Object();
            for (int i = 0; i < RUNS; ++i) {
                long start = System.nanoTime();
                tree = context.evaluateString(scope, "esprima.parse($code)", source, line, null);
                tokens = context.evaluateString(scope, "esprima.tokenize($code)", source, line, null);
                long stop = System.nanoTime();
                System.out.println("Run #" + (i + 1) + ": " + Math.round((stop - start) / 1e6) + " ms");
            }
        } finally {
            Context.exit();
            System.gc();
        }
    }

    static void nashorn(String parser, String code) throws ScriptException, NoSuchMethodException {
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("javafx8");

        engine.eval(parser);
        Invocable inv = (Invocable) engine;
        Object esprima = engine.get("esprima");

        Object tree = new Object();
        Object tokens = new Object();
        for (int i = 0; i < RUNS; ++i) {
            long start = System.nanoTime();
            tree = inv.invokeMethod(esprima, "parse", code);
            tokens = inv.invokeMethod(esprima, "tokenize", code);
            long stop = System.nanoTime();
            System.out.println("Run #" + (i + 1) + ": " + Math.round((stop - start) / 1e6) + " ms");
        }
        // System.out.println("Data is " + tokens.toString() + " and " + tree.toString());
    }

    public static void main(String[] args) {
        try {
            String parser = readFile("D:\\Workspaces\\Study\\corejava\\src\\main\\resources\\javase8sample\\chapter12\\javafx8\\esprima.js");
            String code = readFile("D:\\Workspaces\\Study\\corejava\\src\\main\\resources\\javase8sample\\chapter12\\javafx8\\jquery.js");
            System.out.println("Test code: " + code.length() + " bytes.");
            System.out.println();
            System.out.println("== Rhino ==");
            rhino(parser, code);
            System.out.println();
            System.out.println("== Nashorn ==");
            nashorn(parser, code);
            System.out.println();
        } catch (Exception e) {
            System.err.println("Trouble: " + e.toString());
        }
    }
}
