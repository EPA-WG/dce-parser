# HTML5 namespace handling
## foreign elements
Is done only for [foreign elements](https://www.w3.org/TR/2011/WD-html5-20110525/syntax.html#foreign-elements) 
which is limited to `MathML` and `SVG`. 

Those namespaces are fused with main namespace by ...?

## XSL 
XSL tags to be added as `custom-elemnt` foreign element parts.  

all XSL tags to follow SVG tags convention like

    public static final ElementName DESC = new ElementName("desc", "desc",
    // CPPONLY: NS_NewHTMLUnknownElement,
    // CPPONLY: NS_NewSVGDescElement,
    TreeBuilder.FOREIGNOBJECT_OR_DESC | SCOPING_AS_SVG);


## namespaced attributes
[8.1.2.3 Attributes](https://www.w3.org/TR/2011/WD-html5-20110525/syntax.html#attributes-0)
in local name form are mapped to their namespaced version by parser.

| foreign el attribute | replaced by   |
|----------------------|---------------|
| actuate              | xlink:actuate |
| href                 | xlink:href    |
| xmlns                | xmlns         |

# XSL namespaces elements parse changes
XSL has to be treated either as 
* embedded syntax island, which is not a part of HTML parser as of now (?)
* foreign element

http://www.w3.org/1999/XSL/Transform

`custom-element` as **foreign element** would have 
* own namespace to be associated with own schema/DTD
* set of namespaced attributes, in particular `xmlns:xsl`, `xmlns:xhtml`
* mixin of own tags with namespace associated either with `dce:` or `xslt` 

# XHTML as namespace for normalized HTML 