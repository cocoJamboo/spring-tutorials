/*
 * Copyright 2012-06-05 the original author or authors.
 */
package pl.altkom.spring.capgemini.jaxb;

import java.io.*;
import java.net.URL;

import javax.xml.bind.*;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.apache.log4j.Logger;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class BaseXMLSerializer<T> {

    private JAXBContext jc;
    private SchemaFactory sf;
    private Schema schema;
    private boolean noNameSpace;
    Logger logger = Logger.getLogger(getClass());

    public String schemaLoaction;//= "http://www.uke.gov.pl/euro http://schema.softproject.com.pl/uke/uke-euro.xsd";

    public BaseXMLSerializer(String contextPath, String xsdFileName, String schemaLocation) {
        this(contextPath, xsdFileName, schemaLocation, false);
    }

    public BaseXMLSerializer(String contextPath, String xsdFileName, String schemaLocation, boolean noNameSpace) {
        this.schemaLoaction = schemaLocation;
        this.noNameSpace = noNameSpace;

        try {
            jc = JAXBContext.newInstance(contextPath);

            sf = SchemaFactory.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI);
            URL url = getClass().getClassLoader().getResource(xsdFileName);
            schema = sf.newSchema(url);
        } catch (SAXException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch (JAXBException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }

    public T fromFile(File file) {
        return fromFile(file, true);
    }

    public T fromFile(File file, boolean validate) {
        try {
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            if (validate) {
                unmarshaller.setSchema(schema);
            }
            T document = (T) unmarshaller.unmarshal(file);

            return document;

        } catch (JAXBException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }

    }

    public T fromStream(InputStream stream) {
        return fromStream(stream, true);
    }

    public T fromStream(InputStream stream, boolean validate) {
        try {
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            if (validate) {
                unmarshaller.setSchema(schema);
            }
            T document = (T) unmarshaller.unmarshal(stream);

            return document;

        } catch (JAXBException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }

    }

    public T fromReader(Reader reader) {
        return fromReader(reader, true);
    }

    public T fromReader(Reader reader, boolean validate) {
        try {
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            if (validate) {
                unmarshaller.setSchema(schema);
            }
            T document = (T) unmarshaller.unmarshal(reader);

            return document;

        } catch (JAXBException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }

    }

    public T fromString(String xml) {
        return fromString(xml, true);
    }

    public T fromString(String xml, boolean validate) {
        try {
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            if (validate) {
                unmarshaller.setSchema(schema);
            }
            T wniosek = (T) unmarshaller.unmarshal(new StringReader(xml));
            return wniosek;
        } catch (JAXBException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }

    public void toStream(T order, OutputStream os) {
        toStream(order, os, false);
    }

    public void toStream(T order, OutputStream os, boolean validate) {
        try {
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            if (validate) {
                marshaller.setSchema(schema);
            }

            marshaller.marshal(order, os);

        } catch (JAXBException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }

    public void toFile(T dictionarys, String fileName) {
        toFile(dictionarys, fileName, true);
    }

    public void toFile(T document, String fileName, boolean validate) {

        OutputStream out = null;

        try {
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            if (noNameSpace) {
                marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, schemaLoaction);
            } else {
                marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, schemaLoaction);
            }

            if (validate) {
                marshaller.setSchema(schema);
            }
            out = new FileOutputStream(fileName);
            marshaller.marshal(document, out);

        } catch (JAXBException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } finally {
            quietlyClose(out);
        }
    }

    public void toFile(T document, String fileName, String encoding) {
        toFile(document, fileName, encoding, true);
    }

    public void toFile(T document, String fileName, String encoding, boolean validate) {

        OutputStream out = null;

        try {
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);

            if (noNameSpace) {
                marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, schemaLoaction);
            } else {
                marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, schemaLoaction);
            }

            if (validate) {
                marshaller.setSchema(schema);
            }
            out = new FileOutputStream(fileName);
            marshaller.marshal(document, out);

        } catch (JAXBException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } finally {
            quietlyClose(out);
        }
    }

    public String toString(T document) {
        return toString(document, true);
    }

    public String toString(T document, boolean validate) {
        try {
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

            if (noNameSpace) {
                marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, schemaLoaction);
            } else {
                marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, schemaLoaction);
            }

            if (validate) {
                marshaller.setSchema(schema);
            }
            StringWriter sw = new StringWriter();
            marshaller.marshal(document, sw);

            return sw.toString();

        } catch (JAXBException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }

    }

    public JAXBElement convertFromDomNode(Node domNode, Class jaxbType) {
        try {
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            return unmarshaller.unmarshal(domNode, jaxbType);

        } catch (JAXBException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }

    private void quietlyClose(OutputStream out) {
        if (out != null) {
            try {
                out.close();
            } catch (IOException ex) {
                logger.warn(ex.getMessage());
            }
        }
    }

}
