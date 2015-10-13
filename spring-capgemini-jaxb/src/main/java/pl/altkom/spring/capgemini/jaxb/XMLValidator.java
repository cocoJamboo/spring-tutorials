/*
 * Copyright 2012-04-17 the original author or authors.
 */


package pl.altkom.spring.capgemini.jaxb;

import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.apache.log4j.Logger;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class XMLValidator {

    private static Logger logger = Logger.getLogger(XMLValidator.class);

    /**
     * Sprawdza składnie XML w przekazanym dokumencie
     *
     * @param reader - Reader do dokumentu XML
     * @param errors - zainicjowana kolekcja, w której zostaną˝ zwrócone błędy.
     * Kolekcja zostanie wyzerowana.
     * @return
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws java.io.IOException
     */
    public static boolean checkSyntax(Reader reader, Collection<SAXParseException> errors) throws ParserConfigurationException, IOException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(false);
        dbf.setNamespaceAware(true);

        DocumentBuilder builder = dbf.newDocumentBuilder();
        builder.setErrorHandler(new XMLErrorHandler(errors));

        //InputSource is = new InputSource(filename);
        InputSource source = new InputSource(reader);
        try {
            builder.parse(source);
        } catch (SAXException ignore) {
        }

        return errors.isEmpty();
    }

    /**
     * Validuje XML względem XML Schemy
     *
     * @param reader - Reader do dokumentu XML
     * @param schemaLocation - url do shcemy XML, jeżli jest null to zostanie
     * użyta schema wskazana w atrybucie schemaLocation z dokumentu XML
     * @param errors - zainicjowana kolekcja, w ktďż˝rej zostanďż˝ zwrďż˝cone
     * bďż˝ďż˝dy. Kolekcja zostanie wyzerowana.
     * @return - true jeďż˝li dokument validuje siďż˝
     * @throws org.xml.sax.SAXException - jeďż˝li nie moďż˝na zainicjowaďż˝
     * parsera
     * @throws java.io.IOException - jeďż˝li nie moďż˝na czytaďż˝ z Readera
     */
    public static boolean validate(Reader reader, URL schemaLocation, Collection<SAXParseException> errors) throws SAXException, IOException {
        //List<SAXParseException> errors = new LinkedList<SAXParseException>();

        errors.clear();

        // 1. Lookup a factory for the W3C XML Schema language
        SchemaFactory factory
                = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

        // 2. Compile the schema.
        Schema schema = null;
        //schema = factory.newSchema(new URL("http://www.dmh.pl/schema/dsml/dsml-1_2_14/dsml.xsd"));
        //schema = factory.newSchema(new File("D:/realizacje/CharSource/svn-nowy/dsml/dsml-core/src/main/xsd/dsml.xsd"));
        if (schemaLocation == null) {
            schema = factory.newSchema();
        } else {
            schema = factory.newSchema(schemaLocation);
        }

        // 3. Get a validator from the schema.
        Validator validator = schema.newValidator();

        // 4. Parse the document you want to check.
        Source source = new StreamSource(reader);

        // 5. Check the document
        validator.setErrorHandler(new XMLErrorHandler(errors));
        validator.validate(source);

        return errors.isEmpty();
    }

    /**
     * Validuje XML względem XML Schemy, lokalizacja schemy będzie pobrana z
     * atrybutu schemaLocation z dokumentu XML
     *
     * @param reader - Reader do dokumentu XML
     * @param errors - zainicjowana kolekcja, w której zostaną zwrócone błędy.
     * Kolekcja zostanie wyzerowana.
     * @return - true jeśli dokument validuje się
     * @throws org.xml.sax.SAXException - jeśli nie można zainicjować parsera
     * @throws java.io.IOException - jeďż˝li nie moďż˝na czytaďż˝ z Readera
     */
    public static boolean validate(Reader reader, Collection<SAXParseException> errors) throws SAXException, IOException {

        return validate(reader, null, errors);
    }

    /**
     * Validuje XML względem XML Schemy, lokalizacja schemy będzie pobrana z
     * atrybutu schemaLocation z dokumentu XML Metoda z założenia, nigdy nie
     * rzuca wyąkami. Gdy walidacje nie przejdzie zwraca po prostu "false".
     *
     * @param <T>
     * @param dsml - dokument który powstał‚ w wyniku wywołania metody
     * "unmarshal". Np. DsmlDocument lub DomainsDocument.
     * @param xsdFileName - nazwa pliku xsd, jeśli jest null to zostanie użyta
     * schema wskazana w atrybucie schemaLocation z dokumentu XML.
     * @param exceptions - kolekcja, w której zostaną zwrócone błędy.
     * @return - true jeśli dokument przechodzi poprawnie walidację.
     */
    public static <T> boolean validate(T dsml, String xsdFileName, List<SAXParseException> exceptions) {
        try {
            Schema schema = null;

            String contextPath = dsml.getClass().getPackage().getName();
            JAXBContext jc = JAXBContext.newInstance(contextPath);

            JAXBSource source = new JAXBSource(jc, dsml);

            SchemaFactory factory = SchemaFactory.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI);

            if (xsdFileName == null) {
                schema = factory.newSchema();
            } else {
                URL schemaLocation = XMLValidator.class.getClassLoader().getResource(xsdFileName);
                schema = factory.newSchema(schemaLocation);
            }

            Validator validator = schema.newValidator();

            if (exceptions == null) {
                exceptions = new ArrayList<SAXParseException>();
            }

            validator.setErrorHandler(new XMLValidator.XMLErrorExtensionHandler(exceptions));
            validator.validate(source);

            return exceptions.isEmpty();

        } catch (SAXException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch (JAXBException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }

    public static class XMLErrorHandler implements ErrorHandler {

        public XMLErrorHandler(Collection<SAXParseException> errors) {
            this.errors = errors;
        }

        private Collection<SAXParseException> errors;

        @Override
        public void warning(SAXParseException exception) throws SAXException {
            errors.add(exception);
        }

        @Override
        public void error(SAXParseException exception) throws SAXException {
            errors.add(exception);
        }

        @Override
        public void fatalError(SAXParseException exception) throws SAXException {
            errors.add(exception);
        }
    }

    public static class XMLErrorExtensionHandler extends XMLErrorHandler {

        public XMLErrorExtensionHandler(List<SAXParseException> exceptions) {
            super(exceptions);
        }

        @Override
        public void warning(SAXParseException exception) throws SAXException {
            String message = exception.getMessage() != null ? exception.getMessage() : "";
            logger.warn(message, exception);
        }
    }
}
