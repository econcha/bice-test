package cl.bice.indicators.fixture;

import cl.bice.indicators.domain.LastIndicatorsResponse;
import cl.bice.indicators.domain.valoresKey.RsValoresKey;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class LastFixture {

    public static LastIndicatorsResponse getRsMetales() {
        LastIndicatorsResponse lastIndicatorsResponse = new LastIndicatorsResponse();
        try {
            ObjectMapper mapper = new ObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            lastIndicatorsResponse = mapper.readValue(bodyRsLast, LastIndicatorsResponse.class);
        } catch (IOException e) {
            new Throwable(e);
        }
        return lastIndicatorsResponse;
    }

    public static RsValoresKey getRsMetalesForKey() {
        RsValoresKey key = new RsValoresKey();
        try {
            ObjectMapper mapper = new ObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            key = mapper.readValue(bodyRsForKey, RsValoresKey.class);
        } catch (IOException e) {
            new Throwable(e);
        }
        return key;
    }

    public static String bodyRsForKey = "{\n" +
            "    \"key\": \"cobre\",\n" +
            "    \"name\": \"Precio del Cobre, dólares por libra\",\n" +
            "    \"unit\": \"dolar\",\n" +
            "    \"values\": {\n" +
            "        \"1546387200\": 2.71,\n" +
            "        \"1546473600\": 2.7,\n" +
            "        \"1546560000\": 2.64,\n" +
            "        \"1546819200\": 2.59,\n" +
            "        \"1546905600\": 2.68,\n" +
            "        \"1546992000\": 2.68,\n" +
            "        \"1547078400\": 2.67,\n" +
            "        \"1547164800\": 2.69,\n" +
            "        \"1547424000\": 2.68,\n" +
            "        \"1547510400\": 2.69,\n" +
            "        \"1547596800\": 2.66,\n" +
            "        \"1547683200\": 2.67,\n" +
            "        \"1547769600\": 2.69,\n" +
            "        \"1548028800\": 2.71,\n" +
            "        \"1548115200\": 2.74,\n" +
            "        \"1548201600\": 2.7,\n" +
            "        \"1548288000\": 2.68,\n" +
            "        \"1548374400\": 2.69,\n" +
            "        \"1548633600\": 2.67,\n" +
            "        \"1548720000\": 2.74,\n" +
            "        \"1548806400\": 2.71,\n" +
            "        \"1548892800\": 2.74,\n" +
            "        \"1548979200\": 2.78,\n" +
            "        \"1549238400\": 2.79,\n" +
            "        \"1549324800\": 2.77,\n" +
            "        \"1549411200\": 2.79,\n" +
            "        \"1549497600\": 2.82,\n" +
            "        \"1549584000\": 2.84,\n" +
            "        \"1549843200\": 2.83,\n" +
            "        \"1549929600\": 2.81,\n" +
            "        \"1550016000\": 2.78,\n" +
            "        \"1550102400\": 2.76,\n" +
            "        \"1550188800\": 2.78,\n" +
            "        \"1550448000\": 2.78,\n" +
            "        \"1550534400\": 2.81,\n" +
            "        \"1550620800\": 2.87,\n" +
            "        \"1550707200\": 2.88,\n" +
            "        \"1550793600\": 2.92,\n" +
            "        \"1551052800\": 2.9,\n" +
            "        \"1551139200\": 2.96,\n" +
            "        \"1551225600\": 2.96,\n" +
            "        \"1551312000\": 2.96,\n" +
            "        \"1551398400\": 2.97,\n" +
            "        \"1551657600\": 2.97,\n" +
            "        \"1551744000\": 2.96,\n" +
            "        \"1551830400\": 2.93,\n" +
            "        \"1551916800\": 2.97,\n" +
            "        \"1552003200\": 2.95,\n" +
            "        \"1552262400\": 2.93,\n" +
            "        \"1552348800\": 2.91,\n" +
            "        \"1552435200\": 2.92,\n" +
            "        \"1552521600\": 2.95,\n" +
            "        \"1552608000\": 2.95,\n" +
            "        \"1552867200\": 2.91,\n" +
            "        \"1552953600\": 2.92,\n" +
            "        \"1553040000\": 2.93,\n" +
            "        \"1553126400\": 2.93,\n" +
            "        \"1553212800\": 2.94,\n" +
            "        \"1553472000\": 2.92,\n" +
            "        \"1553558400\": 2.86,\n" +
            "        \"1553644800\": 2.87,\n" +
            "        \"1553731200\": 2.87,\n" +
            "        \"1553817600\": 2.87,\n" +
            "        \"1554076800\": 2.88,\n" +
            "        \"1554163200\": 2.94,\n" +
            "        \"1554249600\": 2.93,\n" +
            "        \"1554336000\": 2.91,\n" +
            "        \"1554422400\": 2.94,\n" +
            "        \"1554681600\": 2.92,\n" +
            "        \"1554768000\": 2.9,\n" +
            "        \"1554854400\": 2.93,\n" +
            "        \"1554940800\": 2.94,\n" +
            "        \"1555027200\": 2.93,\n" +
            "        \"1555286400\": 2.9,\n" +
            "        \"1555372800\": 2.93,\n" +
            "        \"1555459200\": 2.93,\n" +
            "        \"1555545600\": 2.93,\n" +
            "        \"1555891200\": 2.97,\n" +
            "        \"1555977600\": 2.93,\n" +
            "        \"1556064000\": 2.93,\n" +
            "        \"1556150400\": 2.9,\n" +
            "        \"1556236800\": 2.92,\n" +
            "        \"1556496000\": 2.88,\n" +
            "        \"1556582400\": 2.9,\n" +
            "        \"1556755200\": 2.9,\n" +
            "        \"1556841600\": 2.82,\n" +
            "        \"1557100800\": 2.8,\n" +
            "        \"1557187200\": 2.83,\n" +
            "        \"1557273600\": 2.83,\n" +
            "        \"1557360000\": 2.8,\n" +
            "        \"1557446400\": 2.78,\n" +
            "        \"1557705600\": 2.76,\n" +
            "        \"1557792000\": 2.77,\n" +
            "        \"1557878400\": 2.72,\n" +
            "        \"1557964800\": 2.72,\n" +
            "        \"1558051200\": 2.75,\n" +
            "        \"1558310400\": 2.75,\n" +
            "        \"1558483200\": 2.74,\n" +
            "        \"1558569600\": 2.71,\n" +
            "        \"1558656000\": 2.67,\n" +
            "        \"1558915200\": 2.68,\n" +
            "        \"1559001600\": 2.69,\n" +
            "        \"1559088000\": 2.69,\n" +
            "        \"1559174400\": 2.69,\n" +
            "        \"1559260800\": 2.66,\n" +
            "        \"1559520000\": 2.64,\n" +
            "        \"1559606400\": 2.63,\n" +
            "        \"1559692800\": 2.64,\n" +
            "        \"1559779200\": 2.66,\n" +
            "        \"1559865600\": 2.62,\n" +
            "        \"1560124800\": 2.63,\n" +
            "        \"1560211200\": 2.62,\n" +
            "        \"1560297600\": 2.66,\n" +
            "        \"1560384000\": 2.66,\n" +
            "        \"1560470400\": 2.64,\n" +
            "        \"1560729600\": 2.64,\n" +
            "        \"1560816000\": 2.63,\n" +
            "        \"1560902400\": 2.64,\n" +
            "        \"1560988800\": 2.69,\n" +
            "        \"1561075200\": 2.67,\n" +
            "        \"1561334400\": 2.7,\n" +
            "        \"1561420800\": 2.7,\n" +
            "        \"1561507200\": 2.69,\n" +
            "        \"1561593600\": 2.73,\n" +
            "        \"1561680000\": 2.71,\n" +
            "        \"1561939200\": 2.71,\n" +
            "        \"1562025600\": 2.71,\n" +
            "        \"1562112000\": 2.69,\n" +
            "        \"1562198400\": 2.66,\n" +
            "        \"1562284800\": 2.68,\n" +
            "        \"1562544000\": 2.68,\n" +
            "        \"1562630400\": 2.67,\n" +
            "        \"1562716800\": 2.66,\n" +
            "        \"1562803200\": 2.63,\n" +
            "        \"1562889600\": 2.69,\n" +
            "        \"1563148800\": 2.7,\n" +
            "        \"1563321600\": 2.69,\n" +
            "        \"1563408000\": 2.72,\n" +
            "        \"1563494400\": 2.71,\n" +
            "        \"1563753600\": 2.71,\n" +
            "        \"1563840000\": 2.75,\n" +
            "        \"1563926400\": 2.72,\n" +
            "        \"1564012800\": 2.7,\n" +
            "        \"1564099200\": 2.71,\n" +
            "        \"1564358400\": 2.72,\n" +
            "        \"1564444800\": 2.69,\n" +
            "        \"1564531200\": 2.72,\n" +
            "        \"1564617600\": 2.69,\n" +
            "        \"1564704000\": 2.68,\n" +
            "        \"1564963200\": 2.66,\n" +
            "        \"1565049600\": 2.59,\n" +
            "        \"1565136000\": 2.57,\n" +
            "        \"1565222400\": 2.57,\n" +
            "        \"1565308800\": 2.58,\n" +
            "        \"1565568000\": 2.62,\n" +
            "        \"1565654400\": 2.6,\n" +
            "        \"1565740800\": 2.59,\n" +
            "        \"1565913600\": 2.63,\n" +
            "        \"1566172800\": 2.6,\n" +
            "        \"1566259200\": 2.59,\n" +
            "        \"1566345600\": 2.61,\n" +
            "        \"1566432000\": 2.58,\n" +
            "        \"1566518400\": 2.59,\n" +
            "        \"1566777600\": 2.57,\n" +
            "        \"1566864000\": 2.55,\n" +
            "        \"1566950400\": 2.55,\n" +
            "        \"1567036800\": 2.57,\n" +
            "        \"1567123200\": 2.57,\n" +
            "        \"1567382400\": 2.59,\n" +
            "        \"1567468800\": 2.57,\n" +
            "        \"1567555200\": 2.54,\n" +
            "        \"1567641600\": 2.53,\n" +
            "        \"1567728000\": 2.6,\n" +
            "        \"1567987200\": 2.64,\n" +
            "        \"1568073600\": 2.64,\n" +
            "        \"1568160000\": 2.63,\n" +
            "        \"1568246400\": 2.63,\n" +
            "        \"1568332800\": 2.6,\n" +
            "        \"1568592000\": 2.63,\n" +
            "        \"1568678400\": 2.7,\n" +
            "        \"1569196800\": 2.65,\n" +
            "        \"1569283200\": 2.62,\n" +
            "        \"1569369600\": 2.61,\n" +
            "        \"1569456000\": 2.61,\n" +
            "        \"1569542400\": 2.61,\n" +
            "        \"1569801600\": 2.58,\n" +
            "        \"1569888000\": 2.6,\n" +
            "        \"1569974400\": 2.58,\n" +
            "        \"1570060800\": 2.57,\n" +
            "        \"1570147200\": 2.56,\n" +
            "        \"1570406400\": 2.55,\n" +
            "        \"1570492800\": 2.54,\n" +
            "        \"1570579200\": 2.58,\n" +
            "        \"1570665600\": 2.56,\n" +
            "        \"1570752000\": 2.56,\n" +
            "        \"1571011200\": 2.61,\n" +
            "        \"1571097600\": 2.61,\n" +
            "        \"1571184000\": 2.62,\n" +
            "        \"1571270400\": 2.6,\n" +
            "        \"1571356800\": 2.59,\n" +
            "        \"1571616000\": 2.59,\n" +
            "        \"1571702400\": 2.62,\n" +
            "        \"1571788800\": 2.63,\n" +
            "        \"1571875200\": 2.63,\n" +
            "        \"1571961600\": 2.66,\n" +
            "        \"1572220800\": 2.66,\n" +
            "        \"1572307200\": 2.68,\n" +
            "        \"1572393600\": 2.67,\n" +
            "        \"1572825600\": 2.68,\n" +
            "        \"1572912000\": 2.64,\n" +
            "        \"1572998400\": 2.66,\n" +
            "        \"1573084800\": 2.68,\n" +
            "        \"1573171200\": 2.67,\n" +
            "        \"1573430400\": 2.71,\n" +
            "        \"1573516800\": 2.68,\n" +
            "        \"1573603200\": 2.66,\n" +
            "        \"1573689600\": 2.65,\n" +
            "        \"1573776000\": 2.64,\n" +
            "        \"1574035200\": 2.63,\n" +
            "        \"1574121600\": 2.64,\n" +
            "        \"1574208000\": 2.64,\n" +
            "        \"1574294400\": 2.66,\n" +
            "        \"1574380800\": 2.66,\n" +
            "        \"1574640000\": 2.64,\n" +
            "        \"1574726400\": 2.65,\n" +
            "        \"1574812800\": 2.65,\n" +
            "        \"1574899200\": 2.68,\n" +
            "        \"1574985600\": 2.69,\n" +
            "        \"1575244800\": 2.66,\n" +
            "        \"1575331200\": 2.65,\n" +
            "        \"1575417600\": 2.66,\n" +
            "        \"1575504000\": 2.63,\n" +
            "        \"1575590400\": 2.66,\n" +
            "        \"1575849600\": 2.66,\n" +
            "        \"1575936000\": 2.7,\n" +
            "        \"1576022400\": 2.74,\n" +
            "        \"1576108800\": 2.75,\n" +
            "        \"1576195200\": 2.78,\n" +
            "        \"1576454400\": 2.78,\n" +
            "        \"1576540800\": 2.77,\n" +
            "        \"1576627200\": 2.81,\n" +
            "        \"1576713600\": 2.8,\n" +
            "        \"1576800000\": 2.79,\n" +
            "        \"1577059200\": 2.81,\n" +
            "        \"1577145600\": 2.79,\n" +
            "        \"1577318400\": 2.79,\n" +
            "        \"1577404800\": 2.81,\n" +
            "        \"1577664000\": 2.81,\n" +
            "        \"1577923200\": 2.81,\n" +
            "        \"1578009600\": 2.79,\n" +
            "        \"1578268800\": 2.8,\n" +
            "        \"1578355200\": 2.77,\n" +
            "        \"1578441600\": 2.77,\n" +
            "        \"1578528000\": 2.78,\n" +
            "        \"1578614400\": 2.79,\n" +
            "        \"1578873600\": 2.79,\n" +
            "        \"1578960000\": 2.8,\n" +
            "        \"1579046400\": 2.84,\n" +
            "        \"1579132800\": 2.84,\n" +
            "        \"1579219200\": 2.84,\n" +
            "        \"1579478400\": 2.84,\n" +
            "        \"1579564800\": 2.83,\n" +
            "        \"1579651200\": 2.83,\n" +
            "        \"1579737600\": 2.78,\n" +
            "        \"1579824000\": 2.76,\n" +
            "        \"1580083200\": 2.7,\n" +
            "        \"1580169600\": 2.68,\n" +
            "        \"1580256000\": 2.59,\n" +
            "        \"1580342400\": 2.57,\n" +
            "        \"1580428800\": 2.55,\n" +
            "        \"1580688000\": 2.53,\n" +
            "        \"1580774400\": 2.52,\n" +
            "        \"1580860800\": 2.5,\n" +
            "        \"1580947200\": 2.54,\n" +
            "        \"1581033600\": 2.59,\n" +
            "        \"1581292800\": 2.6,\n" +
            "        \"1581379200\": 2.56,\n" +
            "        \"1581465600\": 2.56,\n" +
            "        \"1581552000\": 2.6,\n" +
            "        \"1581638400\": 2.61,\n" +
            "        \"1581897600\": 2.62,\n" +
            "        \"1581984000\": 2.61,\n" +
            "        \"1582070400\": 2.63,\n" +
            "        \"1582156800\": 2.61,\n" +
            "        \"1582243200\": 2.61,\n" +
            "        \"1582502400\": 2.59,\n" +
            "        \"1582588800\": 2.61,\n" +
            "        \"1582675200\": 2.57,\n" +
            "        \"1582761600\": 2.57,\n" +
            "        \"1582848000\": 2.56,\n" +
            "        \"1583107200\": 2.54,\n" +
            "        \"1583193600\": 2.55,\n" +
            "        \"1583280000\": 2.58,\n" +
            "        \"1583366400\": 2.56,\n" +
            "        \"1583452800\": 2.57,\n" +
            "        \"1583712000\": 2.57,\n" +
            "        \"1583798400\": 2.54,\n" +
            "        \"1583884800\": 2.5,\n" +
            "        \"1583971200\": 2.52,\n" +
            "        \"1584057600\": 2.5,\n" +
            "        \"1584316800\": 2.46,\n" +
            "        \"1584403200\": 2.47,\n" +
            "        \"1584489600\": 2.39\n" +
            "    }\n" +
            "}";

    public static String bodyRsLast = "{\n" +
            "    \"cobre\": {\n" +
            "        \"key\": \"cobre\",\n" +
            "        \"name\": \"Precio del Cobre, dólares por libra\",\n" +
            "        \"unit\": \"dolar\",\n" +
            "        \"date\": 1584489600,\n" +
            "        \"value\": 2.39\n" +
            "    },\n" +
            "    \"dolar\": {\n" +
            "        \"key\": \"dolar\",\n" +
            "        \"name\": \"Dólar observado\",\n" +
            "        \"unit\": \"pesos\",\n" +
            "        \"date\": 1584489600,\n" +
            "        \"value\": 855.09\n" +
            "    },\n" +
            "    \"euro\": {\n" +
            "        \"key\": \"euro\",\n" +
            "        \"name\": \"Euro\",\n" +
            "        \"unit\": \"pesos\",\n" +
            "        \"date\": 1584489600,\n" +
            "        \"value\": 938.42\n" +
            "    },\n" +
            "    \"ipc\": {\n" +
            "        \"key\": \"ipc\",\n" +
            "        \"name\": \"Indice de Precios al Consumidor (Var. c/r al período anterior)\",\n" +
            "        \"unit\": \"porcentual\",\n" +
            "        \"date\": 1577836800,\n" +
            "        \"value\": 1.1\n" +
            "    },\n" +
            "    \"ivp\": {\n" +
            "        \"key\": \"ivp\",\n" +
            "        \"name\": \"Indice de valor promedio\",\n" +
            "        \"unit\": \"pesos\",\n" +
            "        \"date\": 1586390400,\n" +
            "        \"value\": 29706.22\n" +
            "    },\n" +
            "    \"oro\": {\n" +
            "        \"key\": \"oro\",\n" +
            "        \"name\": \"Precio del Oro, dólares por onza\",\n" +
            "        \"unit\": \"dolar\",\n" +
            "        \"date\": 1584576000,\n" +
            "        \"value\": 1473.2\n" +
            "    },\n" +
            "    \"plata\": {\n" +
            "        \"key\": \"plata\",\n" +
            "        \"name\": \"Precio de la Plata, dólares por onza\",\n" +
            "        \"unit\": \"dolar\",\n" +
            "        \"date\": 1584576000,\n" +
            "        \"value\": 11.69\n" +
            "    },\n" +
            "    \"uf\": {\n" +
            "        \"key\": \"uf\",\n" +
            "        \"name\": \"Unidad de fomento\",\n" +
            "        \"unit\": \"pesos\",\n" +
            "        \"date\": 1586390400,\n" +
            "        \"value\": 28630.63\n" +
            "    },\n" +
            "    \"utm\": {\n" +
            "        \"key\": \"utm\",\n" +
            "        \"name\": \"Unidad tributaria mensual\",\n" +
            "        \"unit\": \"pesos\",\n" +
            "        \"date\": 1583020800,\n" +
            "        \"value\": 50021.0\n" +
            "    },\n" +
            "    \"yen\": {\n" +
            "        \"key\": \"yen\",\n" +
            "        \"name\": \"Yen\",\n" +
            "        \"unit\": \"dolar\",\n" +
            "        \"date\": 1584489600,\n" +
            "        \"value\": 107.33\n" +
            "    }\n" +
            "}";
}