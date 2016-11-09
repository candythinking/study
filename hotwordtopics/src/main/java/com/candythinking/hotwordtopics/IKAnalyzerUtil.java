package com.candythinking.hotwordtopics;

/**
 * Created by Administrator on 2016/11/9.
 */
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;

public class IKAnalyzerUtil {
    public static void main(String[] args) throws IOException {

//        String text="基于java语言开发的轻量级的中文分词工具包";
        String text="我爱中华人民共和国";
        StringReader sr=new StringReader(text);
        IKSegmenter ik=new IKSegmenter(sr, true);

        Lexeme lex=null;
        while((lex=ik.next())!=null){
            System.out.print(lex.getLexemeText()+"|");
        }
    }
}
