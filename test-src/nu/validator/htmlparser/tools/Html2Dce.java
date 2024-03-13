/*
 * Copyright (c) 2008 Mozilla Foundation
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package nu.validator.htmlparser.tools;

import nu.validator.htmlparser.common.XmlViolationPolicy;
import nu.validator.htmlparser.sax.HtmlParser;
import nu.validator.htmlparser.sax.HtmlSerializer;
import nu.validator.htmlparser.test.SystemErrErrorHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.net.MalformedURLException;

public class Html2Dce {

    /**
     * @param args
     */
        public static void
    main(String[] args)
            throws SAXException, ParserConfigurationException, IOException, TransformerException {
        InputStream in;
        OutputStream out;
        String filePath = "";
        switch (args.length) {
            case 0:
                in = System.in;
                out = System.out;
                break;
            case 1:
                in = new FileInputStream(filePath = args[0]);
                out = System.out;
                break;
            case 2:
                in = new FileInputStream(filePath = args[0]);
                out = new FileOutputStream(args[1]);
                break;
            default:
                System.err.println("Too many arguments. No arguments to use stdin/stdout. One argument to reading from file and write to stdout. Two arguments to read from first file and write to second.");
                System.exit(1);
                return;
        }

        Html2DceParser.analyze(filePath.replaceAll("\\\\","/"), in, out);
    }
}
