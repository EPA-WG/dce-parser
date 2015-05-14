/*
 * Copyright (c) 2013-2015 Mozilla Foundation
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

/*
 * THIS IS A GENERATED FILE. PLEASE DO NOT EDIT.
 * Instead, please regenerate using generate-encoding-data.py
 */

package nu.validator.encoding;

import java.nio.charset.CharsetDecoder;

class Windows1251 extends Encoding {

    private static final char[] TABLE = {
        '\u0402',
        '\u0403',
        '\u201a',
        '\u0453',
        '\u201e',
        '\u2026',
        '\u2020',
        '\u2021',
        '\u20ac',
        '\u2030',
        '\u0409',
        '\u2039',
        '\u040a',
        '\u040c',
        '\u040b',
        '\u040f',
        '\u0452',
        '\u2018',
        '\u2019',
        '\u201c',
        '\u201d',
        '\u2022',
        '\u2013',
        '\u2014',
        '\u0098',
        '\u2122',
        '\u0459',
        '\u203a',
        '\u045a',
        '\u045c',
        '\u045b',
        '\u045f',
        '\u00a0',
        '\u040e',
        '\u045e',
        '\u0408',
        '\u00a4',
        '\u0490',
        '\u00a6',
        '\u00a7',
        '\u0401',
        '\u00a9',
        '\u0404',
        '\u00ab',
        '\u00ac',
        '\u00ad',
        '\u00ae',
        '\u0407',
        '\u00b0',
        '\u00b1',
        '\u0406',
        '\u0456',
        '\u0491',
        '\u00b5',
        '\u00b6',
        '\u00b7',
        '\u0451',
        '\u2116',
        '\u0454',
        '\u00bb',
        '\u0458',
        '\u0405',
        '\u0455',
        '\u0457',
        '\u0410',
        '\u0411',
        '\u0412',
        '\u0413',
        '\u0414',
        '\u0415',
        '\u0416',
        '\u0417',
        '\u0418',
        '\u0419',
        '\u041a',
        '\u041b',
        '\u041c',
        '\u041d',
        '\u041e',
        '\u041f',
        '\u0420',
        '\u0421',
        '\u0422',
        '\u0423',
        '\u0424',
        '\u0425',
        '\u0426',
        '\u0427',
        '\u0428',
        '\u0429',
        '\u042a',
        '\u042b',
        '\u042c',
        '\u042d',
        '\u042e',
        '\u042f',
        '\u0430',
        '\u0431',
        '\u0432',
        '\u0433',
        '\u0434',
        '\u0435',
        '\u0436',
        '\u0437',
        '\u0438',
        '\u0439',
        '\u043a',
        '\u043b',
        '\u043c',
        '\u043d',
        '\u043e',
        '\u043f',
        '\u0440',
        '\u0441',
        '\u0442',
        '\u0443',
        '\u0444',
        '\u0445',
        '\u0446',
        '\u0447',
        '\u0448',
        '\u0449',
        '\u044a',
        '\u044b',
        '\u044c',
        '\u044d',
        '\u044e',
        '\u044f'
    };
    
    private static final String[] LABELS = {
        "cp1251",
        "windows-1251",
        "x-cp1251"
    };
    
    private static final String NAME = "windows-1251";
    
    static final Encoding INSTANCE = new Windows1251();
    
    private Windows1251() {
        super(NAME, LABELS);
    }

    @Override public CharsetDecoder newDecoder() {
        return new InfallibleSingleByteDecoder(this, TABLE);
    }

}
