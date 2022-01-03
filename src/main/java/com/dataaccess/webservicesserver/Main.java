package com.dataaccess.webservicesserver;

import javax.naming.spi.ObjectFactory;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;

import static java.lang.String.format;

public class Main {

    public static void main(final String[] args) throws Exception {

            final String endpoint = "https://www.dataaccess.com/webservicesserver/NumberConversion.wso";

            final URL url = URI.create(endpoint).toURL();

            final NumberConversion service = new NumberConversion(url);

            final NumberConversionSoapType soap = service.getNumberConversionSoap();

            final BigInteger number1 = BigInteger.valueOf(1734);
            final BigDecimal number2 = BigDecimal.valueOf(1583725.99);

            final String words = soap.numberToWords(number1);
            final String dollars = soap.numberToDollars(number2);

            System.out.println(format("\n%s => %s", number1, words));
            System.out.println(format("%s => %s\n", number2, dollars));

    }
}
