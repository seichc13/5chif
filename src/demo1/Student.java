package demo1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/*
Todo:
1. Reihenfolge der Klassen-Attribute für XML festlegen
2. Ausgabe/Einlesen mit StringWriter/StringReader machen
3. Datumsformat: dd.mm.yyyy (SimpleDateFormat)
4. XmlAccessorType: Public, Private usw. Unterschiede
*/

@XmlRootElement
@XmlType(propOrder = {"name", "klasse", "dateOfBirth"})
public class Student {
    
    @XmlAttribute
    private String name;
    @XmlElement
    private Date dateOfBirth;
    @XmlElement
    private String klasse;
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public Student() {
    }

    public Student(String name, String dateOfBirth, String klasse) throws ParseException {
        this.name = name;
        this.dateOfBirth = sdf.parse(dateOfBirth);
        this.klasse = klasse;
    }

    public String getKlasse() {
        return klasse;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", dateOfBirth=" + sdf.format(dateOfBirth) + ", klasse=" + klasse + '}';
    }


    
}
