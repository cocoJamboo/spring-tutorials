/*
 * Copyright 2012-06-05 the original author or authors.
 */
package pl.altkom.spring.capgemini.jaxb;

import pl.com.softproject.commons.model.invoice.Invoice;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class InvoiceSerializer extends BaseXMLSerializer<Invoice> {

    public InvoiceSerializer() {
        super("pl.com.softproject.commons.model.invoice",
                "invoice.xsd",
                "http://www.softproject.com.pl/commons/model/invoice http://schema.softproject.com.pl/commons/invoice.xsd");
    }

}
