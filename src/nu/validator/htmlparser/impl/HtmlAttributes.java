/*
 * Copyright (c) 2007 Henri Sivonen
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

package nu.validator.htmlparser.impl;

import nu.validator.htmlparser.annotation.IdType;
import nu.validator.htmlparser.annotation.Local;
import nu.validator.htmlparser.annotation.NsUri;
import nu.validator.htmlparser.annotation.QName;

import org.xml.sax.Attributes;

/**
 * Be careful with this class. QName is the name in from HTML tokenization.
 * Otherwise, please refer to the interface doc.
 * 
 * @version $Id: AttributesImpl.java 206 2008-03-20 14:09:29Z hsivonen $
 * @author hsivonen
 */
public final class HtmlAttributes implements Attributes {

    // [NOCPP[

    private static final AttributeName[] EMPTY_ATTRIBUTENAMES = new AttributeName[0];

    private static final String[] EMPTY_STRINGS = new String[0];
    
    // ]NOCPP]
    
    public static final HtmlAttributes EMPTY_ATTRIBUTES = new HtmlAttributes(AttributeName.HTML);
    
    private int mode;

    private int length;

    private AttributeName[] names;

    private String[] values;

    // [NOCPP[

    private String idValue;

    private int xmlnsLength;

    private AttributeName[] xmlnsNames;

    private String[] xmlnsValues;

    // ]NOCPP]

    public HtmlAttributes(int mode) {
        this.mode = mode;
        this.length = 0;
        this.names = new AttributeName[5]; // covers 98.3% of elements according to
        // Hixie
        this.values = new String[5];
        
        // [NOCPP[
        
        this.idValue = null;
        
        this.xmlnsLength = 0;
        
        this.xmlnsNames = EMPTY_ATTRIBUTENAMES;
        
        this.xmlnsValues = EMPTY_STRINGS;
        
        // ]NOCPP]
    }

    public int getIndex(@QName String qName) {
        for (int i = 0; i < length; i++) {
            if (names[i].getQName(mode).equals(qName)) {
                return i;
            }
        }
        return -1;
    }

    public int getIndex(@NsUri String uri, @Local String localName) {
        for (int i = 0; i < length; i++) {
            if (names[i].getLocal(mode).equals(localName)
                    && names[i].getUri(mode).equals(uri)) {
                return i;
            }
        }
        return -1;
    }

    public int getLength() {
        return length;
    }

    public @Local String getLocalName(int index) {
        if (index < length) {
            return names[index].getLocal(mode);
        } else {
            return null;
        }
    }

    public @QName String getQName(int index) {
        if (index < length) {
            return names[index].getQName(mode);
        } else {
            return null;
        }
    }

    public @IdType String getType(int index) {
        if (index < length) {
            return names[index].getType(mode);
        } else {
            return null;
        }
    }

    public @IdType String getType(String qName) {
        int index = getIndex(qName);
        if (index == -1) {
            return null;
        } else {
            return getType(index);
        }
    }

    public @IdType String getType(String uri, String localName) {
        int index = getIndex(uri, localName);
        if (index == -1) {
            return null;
        } else {
            return getType(index);
        }
    }

    public @NsUri String getURI(int index) {
        if (index < length) {
            return names[index].getUri(mode);
        } else {
            return null;
        }
    }

    public String getValue(int index) {
        if (index < length) {
            return values[index];
        } else {
            return null;
        }
    }

    public String getValue(String qName) {
        int index = getIndex(qName);
        if (index == -1) {
            return null;
        } else {
            return getValue(index);
        }
    }

    public String getValue(String uri, String localName) {
        int index = getIndex(uri, localName);
        if (index == -1) {
            return null;
        } else {
            return getValue(index);
        }
    }

    // [NOCPP[

    public String getId() {
        return idValue;
    }

    public int getXmlnsLength() {
        return xmlnsLength;
    }
    
    public @Local String getXmlnsLocalName(int index) {
        if (index < xmlnsLength) {
            return xmlnsNames[index].getLocal(mode);
        } else {
            return null;
        }
    }
    
    public @NsUri String getXmlnsURI(int index) {
        if (index < xmlnsLength) {
            return xmlnsNames[index].getUri(mode);
        } else {
            return null;
        }
    }    
    
    public String getXmlnsValue(int index) {
        if (index < xmlnsLength) {
            return xmlnsValues[index];
        } else {
            return null;
        }
    }
    
    // ]NOCPP]

    void addAttribute(AttributeName name, String value) {
        // [NOCPP[
        if (name == AttributeName.ID) {
            idValue = value;
        }
        
        if (name.isXmlns()) {
            if (xmlnsNames.length == xmlnsLength) {
                int newLen = xmlnsNames.length + 2;
                AttributeName[] newNames = new AttributeName[newLen];
                System.arraycopy(xmlnsNames, 0, newNames, 0, names.length);
                xmlnsNames = newNames;
                String[] newValues = new String[newLen];
                System.arraycopy(xmlnsValues, 0, newValues, 0, values.length);
                xmlnsValues = newValues;
            }
            xmlnsNames[xmlnsLength] = name;
            xmlnsValues[xmlnsLength] = value;
            xmlnsLength++;
            return;
        }
        
        // ]NOCPP]
        
        if (names.length == length) {
            int newLen = names.length + 10; // The first growth covers virtually
            // 100% of elements according to
            // Hixie
            AttributeName[] newNames = new AttributeName[newLen];
            System.arraycopy(names, 0, newNames, 0, names.length);
            names = newNames;
            String[] newValues = new String[newLen];
            System.arraycopy(values, 0, newValues, 0, values.length);
            values = newValues;
        }
        names[length] = name;
        values[length] = value;
        length++;
    }

    void clear() {
        for (int i = 0; i < length; i++) {
            names[i] = null;
            values[i] = null;
        }
        length = 0;
        idValue = null;
    }

    public void adjustForMath() {
        mode = AttributeName.MATHML;
    }

    public void adjustForSvg() {
        mode = AttributeName.SVG;
    }
}