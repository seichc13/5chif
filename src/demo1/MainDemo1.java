package demo1;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class MainDemo1 {

    public static void main(String[] args) {
        try {
            Student student = new Student("Max", "12.03.1999", "5CHIF");
            
            //binding, marshalling
            JAXBContext context = JAXBContext.newInstance(Student.class);
            Marshaller marsh = context.createMarshaller();
            marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //marsh.marshal(student, System.out);
            File file = new File("D:src\\demo1\\student.xml");
            marsh.marshal(student, file);
            
            //unbinding, unmarshalling
            Unmarshaller unmarsh = context.createUnmarshaller();
            Student s = (Student) unmarsh.unmarshal(file);
            //System.out.println("s: " + s.toString());
            
            //Kurzform
            File file1 = new File("D:src\\demo1\\student1.xml");
            JAXB.marshal(student, file1);
            Student s1 = JAXB.unmarshal(file1, Student.class);
            //System.out.println("s1: " + s1.toString());
            
            //StringWriter & StringReader
            StringWriter strw = new StringWriter();
            JAXB.marshal(student, strw);
            System.out.println(strw.toString());
            Student s2 = JAXB.unmarshal(new StringReader(strw.toString()), Student.class);
            System.out.println("s2: " + s2.toString());
            
            
        } catch (Exception e) {
            System.err.println("Main: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
}
