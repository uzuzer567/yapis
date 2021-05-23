import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

import java.io.File;
import java.io.FileReader;

import antlr4.*;
import translator.Translator;


public class Main {
    public static void main(String[] args) throws Exception {
        File file = new File("/home/lera/Projects/University/compilers/yapis/src/main/tl/test.tl");

        GrammarSimpleLexer testLexer = new GrammarSimpleLexer(new ANTLRInputStream(new FileReader(file)));
        TokenStream tokenStream = new CommonTokenStream(testLexer);
        GrammarSimpleParser parser = new GrammarSimpleParser(tokenStream);
        parser.program();

        try {
            Node ast = new Node(tokenStream);
            System.out.println("Finished tokenizing");

            Translator translator = new Translator(ast);
            translator.saveTranslation();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
