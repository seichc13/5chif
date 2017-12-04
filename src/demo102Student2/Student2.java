package demo102Student2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/*
Todo:
1. Reihenfolge der Klassen-Attribute für XML festlegen
2. Ausgabe/Einlesen mit StringWriter/StringReader machen
3. Datumsformat: dd.mm.yyyy (SimpleDateFormat)
4. XmlAccessorType: Public, Private usw. Unterschiede
*/

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"name", "klasse", "dateOfBirth"})
public class Student2 {
    
    @XmlAttribute
    private String name;
    @XmlTransient //nicht field sondern property mit Formatierung
    private Date dateOfBirth;
    @XmlElement
    private String klasse;
    
    //
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public Student2() {
    }

    public Student2(String name, String dateOfBirth, String klasse) throws ParseException {
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

    @XmlElement
    public String getDateOfBirth() {
        return sdf.format(dateOfBirth);
    }

    public void setDateOfBirth(String dateOfBirth) {
        try {
            this.dateOfBirth = sdf.parse(dateOfBirth);
        } catch (ParseException ex) {
            System.err.println("Student parse dateOfBirth!\n" + ex.getMessage());
        }
    }

    
    
    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", dateOfBirth=" + sdf.format(dateOfBirth) + ", klasse=" + klasse + '}';
    }      
    
}
