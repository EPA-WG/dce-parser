# HTML5 namespace handling
## foreign elements
Is done only for [foreign elements](https://www.w3.org/TR/2011/WD-html5-20110525/syntax.html#foreign-elements) 
which is limited to `MathML` and `SVG`. 

Those namespaces are fused with main namespace by 

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

`custom-element` as **foreign element** would have 
* own namespace to be associated with own schema/DTD
* set of namespaced attributes, in particular `xmlns:xsl`, `xmlns:xhtml`
* mixin of own tags with namespace associated either with `dce:` or `xslt` 

# XHTML as namespace for normalized HTML 